package ru.grinncorp.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ExampleWebsiteApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ExampleWebsiteApplication.class);

   	RestTemplate searchClient = new RestTemplate();
	
  	 RestTemplate bookingClient = new RestTemplate();
	
   	RestTemplate checkInClient = new RestTemplate();
	
RestTemplate restClient= new RestTemplate();
	public static void main(String[] args) {
		SpringApplication.run(ExampleWebsiteApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//Search for a flight
		SearchQuery searchQuery = new SearchQuery("KURSK",
				"MOSKOV", "11-DEC-18");
 		//Flight[] flights = searchClient.postForObject("http://search-service/search/get", searchQuery, Flight[].class); 
		Delivery[] deliverys = searchClient.postForObject("http://localhost:8090/search/get", searchQuery, Delivery[].class); 
 		
		Arrays.asList(deliverys).forEach(delivery -> logger.info(" delivery >"+ delivery));
  		
		//create a booking only if there are flights.
 		if(deliverys == null || deliverys.length == 0){
 			return;
 		}
 		Delivery delivery = deliverys[0];
		BookingRecord booking = new BookingRecord(delivery.getDeliveryNumber(),delivery.getOrigin(),
				delivery.getDestination(), delivery.getDeliveryDate(),null,
				delivery.getFlowers().getFlower(), null, null);
		Set<Customer> customers = new HashSet<Customer>();
		customers.add(new Customer("Customer","Customer1","Male", booking));
		booking.setCustomers(customers);
		long bookingId =0;
		try { 
			//long bookingId = bookingClient.postForObject("http://book-service/booking/create", booking, long.class); 
			 bookingId = bookingClient.postForObject("http://localhost:8060/booking/create", booking, long.class); 
			logger.info("Booking created "+ bookingId);
		}catch (Exception e){
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
		}
		
		//check in passenger
		if(bookingId == 0) return;
		try {
			CheckInRecord checkIn = new CheckInRecord("Customer","Customer1", "28C", null, "ABS001","11-DEC-18", bookingId);
			long checkinId = checkInClient.postForObject("http://localhost:8070/checkin/create", checkIn, long.class); 
			logger.info("Checked IN "+ checkinId);
		}catch (Exception e){
			logger.error("CHECK IN SERVICE NOT AVAILABLE...!!!"); 
		}
	}
		 
}

