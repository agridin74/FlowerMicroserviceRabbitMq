package ru.grinncorp.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.grinncorp.example.component.SearchComponent;
import ru.grinncorp.example.entity.Delivery;

@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {
	
	private static Logger logger = LoggerFactory.getLogger(SearchRestController.class);

	private SearchComponent searchComponent;
	
	@Autowired
	public SearchRestController(SearchComponent searchComponent) {
		this.searchComponent=  searchComponent;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.POST)
	List<Delivery> search(@RequestBody SearchQuery query){
		logger.info("===>>> Input : "+query);
		return searchComponent.search(query);
	}
}
