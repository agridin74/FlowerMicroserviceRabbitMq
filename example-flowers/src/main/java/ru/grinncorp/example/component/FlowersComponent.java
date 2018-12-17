package ru.grinncorp.example.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.grinncorp.example.entity.Flower;
import ru.grinncorp.example.repository.FlowersRepository;

@Component
public class FlowersComponent {
	private static final Logger logger = LoggerFactory.getLogger(FlowersComponent.class);
	
	FlowersRepository flowersRepository;
	
	public FlowersComponent() {
		
	}
	
	@Autowired
	public FlowersComponent(FlowersRepository flowersRepository) {
		this.flowersRepository = flowersRepository;
	}
	
	public Flower getFlower(String plantingArticle, String plantingDate) {
		logger.info("Поиск Flower параметры  plantingArticle: "+plantingArticle +" plantingDate: "+plantingDate );
		return flowersRepository.getFlowerByPlantingArticleAndPlantingDate(plantingArticle, plantingDate);
	}
	

}
