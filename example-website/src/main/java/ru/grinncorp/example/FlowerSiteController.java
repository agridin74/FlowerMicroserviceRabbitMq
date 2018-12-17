package ru.grinncorp.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class FlowerSiteController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlowerSiteController.class);
	
	RestTemplate searchClient = new RestTemplate();
	RestTemplate bookingClient = new RestTemplate();
	RestTemplate checkInClient = new RestTemplate();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String greetingForm(Model model) {
		SearchQuery query = new SearchQuery("KURSK","MOSKOV", "11-DEC-18");
		UIData uiData = new UIData();
		uiData.setSearchQuery(query);
		model.addAttribute("uidata",uiData);
		return "search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute UIData uiData, Model model) {
		Delivery[] deliverys = searchClient.postForObject("http://localhost:8090/search/get", uiData.getSearchQuery(), 
				Delivery[].class);
		uiData.setDeliverys(Arrays.asList(deliverys));
		model.addAttribute("uidata",uiData);
		return "result";
		
	}
	
	@RequestMapping(value="/book/{deliveryNumber}/{origin}/{destination}/{deliveryDate}/{flower}", method=RequestMethod.GET)
	   public String bookQuery(@PathVariable String deliveryNumber, 
			   @PathVariable String origin, 
			   @PathVariable String destination, 
			   @PathVariable String deliveryDate, 
			   @PathVariable String flower, 
			   Model model) {
	   		UIData uiData = new UIData();
	   		Delivery delivery = new Delivery(deliveryNumber, origin,destination,deliveryDate,new Flowers(flower,"ABS001"));
	   		uiData.setSelectedDelivery(delivery);
	   		uiData.setCustomer(new Customer());
		   model.addAttribute("uidata",uiData);
	       return "book"; 
	   }
	   @RequestMapping(value="/confirm", method=RequestMethod.POST)
	   public String ConfirmBooking(@ModelAttribute UIData uiData, Model model) {
		   Delivery delivery= uiData.getSelectedDelivery();
			BookingRecord booking = new BookingRecord(delivery.getDeliveryNumber(),delivery.getOrigin(),
					delivery.getDestination(), delivery.getDeliveryDate(),null,
					delivery.getFlowers().getFlower(), null, null);
			Set<Customer> customers = new HashSet<Customer>();
			Customer cus = uiData.getCustomer();
			cus.setBookingRecord(booking);
			customers.add(uiData.getCustomer());
		 		booking.setCustomers(customers);
			long bookingId =0;
			try { 
				
				 bookingId = bookingClient.postForObject("http://localhost:8060/booking/create", booking, long.class); 
				logger.info("Booking created "+ bookingId);
			}catch (Exception e){
				logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
			}
			model.addAttribute("message", "Your Booking is confirmed. Reference Number is "+ bookingId);
			return "confirm";
	   }
	   @RequestMapping(value="/search-booking", method=RequestMethod.GET)
	   public String searchBookingForm(Model model) {
	   		UIData uiData = new UIData();
	   		uiData.setBookingid("5");
	   		model.addAttribute("uidata",uiData );
	   		return "bookingsearch";
	   }   

		@RequestMapping(value="/search-booking-get", method=RequestMethod.POST)
		public String searchBookingSubmit(@ModelAttribute UIData uiData, Model model) {
			Long id = Long.getLong(uiData.getBookingid());
	 		BookingRecord booking = bookingClient.getForObject("http://localhost:8060/booking/get/"+id, BookingRecord.class);
	 		Delivery delivery = new Delivery(booking.getDeliveryNumber(), booking.getOrigin(),booking.getDestination()
					,booking.getDeliveryDate(),new Flowers(booking.getFlower(),"ABS001"));
	 		Customer cus = booking.getCustomers().iterator().next();
	 		Customer cusUI = new Customer(cus.getFirstName(),cus.getLastName(),cus.getGender(),null);
			uiData.setCustomer(cusUI);
			uiData.setSelectedDelivery(delivery);
			uiData.setBookingid(id.toString()); 
			model.addAttribute("uidata", uiData);
		   return "bookingsearch";
		}
		
		@RequestMapping(value="/checkin/{deliveryNumber}/{origin}/{destination}/{deliveryDate}/{flower}/{firstName}/{lastName}/{gender}/{bookingid}", method=RequestMethod.GET)
		public String bookQuery(@PathVariable String deliveryNumber, 
				   @PathVariable String origin, 
				   @PathVariable String destination, 
				   @PathVariable String deliveryDate, 
				   @PathVariable String flower, 
				   @PathVariable String firstName, 
				   @PathVariable String lastName, 
				   @PathVariable String gender, 
				   @PathVariable String bookingid, 
				   Model model) {
			
	 
				CheckInRecord checkIn = new CheckInRecord(firstName, lastName, "28C", null,
						deliveryDate,deliveryDate,  Long.valueOf(bookingid).longValue());

				long checkinId = checkInClient.postForObject("http://localhost:8070/checkin/create", checkIn, long.class); 
		   		model.addAttribute("message","Checked In, Seat Number is 28c , checkin id is "+ checkinId);
		       return "checkinconfirm"; 
	} 

}
