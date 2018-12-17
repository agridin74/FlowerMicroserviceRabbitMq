package ru.grinncorp.example.component;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.grinncorp.example.entity.CheckInRecord;
import ru.grinncorp.example.repository.CheckInRecordRepository;

@Component
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);
	
	CheckInRecordRepository checkInRecordRepository;
	Sender sender;
	
	@Autowired
	CheckinComponent(CheckInRecordRepository checkInRecordRepository, Sender sender){
		this.checkInRecordRepository = checkInRecordRepository;
		this.sender = sender;
	}
	
	public long checkIn(CheckInRecord checkIn) {
		checkIn.setCheckInTime(new Date());
		logger.info("Запись chrckin");
		long id = checkInRecordRepository.save(checkIn).getId();
		logger.info("Успешная запись checkin");
		logger.info("Посылаем booking id "+id);
		sender.send(id);
		return id;
	}
	
	public CheckInRecord getCheckInRecord(long id) {
		return checkInRecordRepository.findById(id).orElse(null);
	}

}
