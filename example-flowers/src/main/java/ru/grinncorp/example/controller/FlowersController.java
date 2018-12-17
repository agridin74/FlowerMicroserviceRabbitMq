package ru.grinncorp.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.grinncorp.example.component.FlowersComponent;
import ru.grinncorp.example.entity.Flower;


@RestController
@CrossOrigin
@RequestMapping("/flowers")
public class FlowersController {
	FlowersComponent flowersComponent;
	
	@Autowired
	public FlowersController(FlowersComponent flowersComponent) {
		this.flowersComponent = flowersComponent;
	}
	
	@RequestMapping("/get")
	Flower getFlower(@RequestParam(value="plantingArticle") String plantingArticle,
			@RequestParam(value="plantingDate") String plantingDate) {
		return flowersComponent.getFlower(plantingArticle, plantingDate);
	}

}
