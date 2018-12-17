package ru.grinncorp.example.component;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.grinncorp.example.controller.SearchQuery;
import ru.grinncorp.example.entity.Delivery;
import ru.grinncorp.example.entity.Inventory;
import ru.grinncorp.example.repository.DeliveryRepository;


@Component
public class SearchComponent {
	private DeliveryRepository deliveryRepository;
	private static Logger logger = LoggerFactory.getLogger(SearchComponent.class);
	
	@Autowired
	public SearchComponent(DeliveryRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}
	
	public List<Delivery> search(SearchQuery query) {
		List<Delivery> delivers =  deliveryRepository.findByOriginAndDestinationAndDeliveryDate(query.getOrigin(),
				query.getDestination(), query.getDeliveryDate());
		List<Delivery> searchResult = new ArrayList<>();
		searchResult.addAll(delivers);
		delivers.forEach(deliver -> {
			deliver.getFlowers();
			int inv = deliver.getInventory().getCount();
			if(inv < 0) {
				searchResult.remove(deliver);
			}
		});
		return searchResult;
	}
	
	public void updateInventory(String deliveryNumber, String deliveryDate, int inventory) {
		logger.info("Обновление inventory для delivery "+deliveryNumber+" inventory " +inventory);
		Delivery delivery = deliveryRepository.findByDeliveryNumberAndDeliveryDate(deliveryNumber, deliveryDate);
		Inventory inv = delivery.getInventory();
		inv.setCount(inventory);
		deliveryRepository.save(delivery);
	}

}
