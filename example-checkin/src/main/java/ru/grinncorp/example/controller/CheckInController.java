package ru.grinncorp.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.grinncorp.example.component.CheckinComponent;
import ru.grinncorp.example.entity.CheckInRecord;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {
	
	CheckinComponent checkinComponent;
	
	@Autowired
	public CheckInController(CheckinComponent checkinComponent) {
		this.checkinComponent=checkinComponent;
	}
	
	@RequestMapping("/get/{id}")
	CheckInRecord getCheckIn(@PathVariable long id) {
		return checkinComponent.getCheckInRecord(id);
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	long checkIn(@RequestBody CheckInRecord checkIn) {
		return checkinComponent.checkIn(checkIn);
		
	}

}
