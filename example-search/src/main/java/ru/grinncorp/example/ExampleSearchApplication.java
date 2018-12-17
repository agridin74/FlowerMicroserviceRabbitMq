package ru.grinncorp.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.grinncorp.example.entity.Delivery;
import ru.grinncorp.example.entity.Flowers;
import ru.grinncorp.example.entity.Inventory;
import ru.grinncorp.example.repository.DeliveryRepository;

@SpringBootApplication
public class ExampleSearchApplication implements CommandLineRunner {
	
	private static Logger  logger = LoggerFactory.getLogger(ExampleSearchApplication.class);
	
	@Autowired
	DeliveryRepository deliveryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleSearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Delivery> delivers = new ArrayList<>();
		delivers.add(new Delivery("ABS001","KURSK","MOSKOV","11-DEC-18",new Flowers("200","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS002","BELGOROD","MOSKOV","11-DEC-18",new Flowers("200","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS003","KURSK","MOSKOV","11-DEC-18",new Flowers("250","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS004","KURSK","MOSKOV","11-DEC-18",new Flowers("260","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS005","LIPECK","MOSKOV","11-DEC-18",new Flowers("270","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS006","KURSK","MOSKOV","11-DEC-18",new Flowers("280","RUR"), new Inventory(100)));
		delivers.add(new Delivery("ABS007","OREL","MOSKOV","11-DEC-18",new Flowers("290","RUR"), new Inventory(100)));
		deliveryRepository.saveAll(delivers);
		logger.info("Проверим загрузку ....");
		for (Delivery delivery : deliveryRepository.findByOriginAndDestinationAndDeliveryDate("KURSK",
				"MOSKOV", "11-DEC-18")) {
			logger.info(delivery.toString());
		}
		
	}
}
