package ru.grinncorp.example.component;

import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ru.grinncorp.example.entity.BookingRecord;
import ru.grinncorp.example.entity.Customer;
import ru.grinncorp.example.entity.Inventory;
import ru.grinncorp.example.repository.BookingRepository;
import ru.grinncorp.example.repository.InventoryRepository;

@Component
public class BookingComponent {
	private static final Logger logger = LoggerFactory.getLogger(BookingComponent.class);
	private static final String FlowerURL = "http://localhost:8080/flowers";
	BookingRepository bookingRepository;
	InventoryRepository inventoryRepository;
	
	private RestTemplate restTemplate;
	Sender sender;
	
	@Autowired
	public BookingComponent(BookingRepository bookingRepository,
	InventoryRepository inventoryRepository,Sender sender) {
		this.bookingRepository = bookingRepository;
		this.restTemplate = new RestTemplate();
		this.sender = sender;
		this.inventoryRepository = inventoryRepository;
	}
	
	public long book(BookingRecord record) {
		logger.info("вызов flowers для получения flower");
		Flower flower = restTemplate.getForObject(FlowerURL+"/get?plantingArticle=" + record.getDeliveryNumber()+
				"&plantingDate"+ record.getDeliveryDate(),Flower.class);
		logger.info("вызов flowers для получения flower " + flower);
		if(!record.getFlower().equals(flower.getFlower()))
			throw new BookingException("flower подделан");
		logger.info("вызов inventory для получения inventory");
		Inventory inventory = inventoryRepository.findByDeliveryNumberAndDeliveryDate(record.getDeliveryNumber(), 
				record.getDeliveryDate());
		if(!inventory.isAvailable(record.getCustomers().size())) {
			throw new BookingException("No more seats avaialble");
		}
		logger.info("успешная проверка inventory"+inventory);
		logger.info("вызов inventory для обновления inventory");
		inventory.setAvailable(inventory.getAvailable() - record.getCustomers().size());
		inventoryRepository.saveAndFlush(inventory);
		logger.info("успешное обновление inventory");
		record.setStatus(BookingStatus.BOOKING_CONFIRMED);
		Set<Customer> customers = record.getCustomers();
		customers.forEach(customer -> customer.setBookingRecord(record));
		record.setBookingDate(new Date());
		long id = bookingRepository.save(record).getId();
		logger.info("Сохранено booking");
		logger.info("отсылаем событие booking");
		Map<String, Object> bookingDetails = new HashMap<String, Object>();
		bookingDetails.put("DELIVERY_NUMBER", record.getDeliveryNumber());
		bookingDetails.put("DELIVERY_DATE", record.getDeliveryDate());
		bookingDetails.put("NEW_INVENTORY", inventory.getBookableInventory());
		sender.send(bookingDetails);
		logger.info("booking event successfuly delivered " + bookingDetails);
		return id;

	}

	public BookingRecord getBooking(long id) {
		return bookingRepository.findById(id).orElse(null);
	}
	
	public void updateStatus(String status, long bookingId) {
		BookingRecord record = bookingRepository.findById(bookingId).orElse(null);
		record.setStatus(status);
	}
}
