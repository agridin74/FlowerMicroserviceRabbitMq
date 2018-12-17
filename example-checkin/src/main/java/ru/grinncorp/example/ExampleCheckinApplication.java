package ru.grinncorp.example;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.grinncorp.example.entity.CheckInRecord;
import ru.grinncorp.example.repository.CheckInRecordRepository;

@SpringBootApplication
public class ExampleCheckinApplication implements CommandLineRunner{
	private static Logger logger = LoggerFactory.getLogger(ExampleCheckinApplication.class);
	@Autowired
	CheckInRecordRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleCheckinApplication.class, args);
	}
	@Override 
	public void run(String...strings) throws Exception {
		CheckInRecord record = new CheckInRecord("ABCD", "EFG", "999A", new Date(), "ABS001", "11-DEC-18", 1);
		CheckInRecord result = repository.save(record);
		logger.info("проверка прошла ....." + result);
		logger.info("Ищем checkedin....");
		logger.info("result: "+ repository.findById(result.getId()).orElse(null));
	}
}
