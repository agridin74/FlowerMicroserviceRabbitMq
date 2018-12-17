package ru.grinncorp.example.component;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	private static Logger logger = LoggerFactory.getLogger(Receiver.class);
	
	SearchComponent searchComponent;
	
	@Autowired
	public Receiver(SearchComponent searchComponent) {
		this.searchComponent = searchComponent;
	}
	
	@Bean
	Queue queue() {
		return new Queue("SearchQ", false);
	}
	
	@RabbitListener(queues="SearchQ")
	public void processMessage(Map<String, Object> delivery) {
		logger.info("==>>> "+delivery);
		searchComponent.updateInventory((String) delivery.get("DELIVERY_NUMBER") ,
										(String) delivery.get("DELIVERY_DATE"), 
										(int) delivery.get("NEW_INVENTORY"));
	}

}
