package ru.grinncorp.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.example.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{
	List<Delivery> findByOriginAndDestinationAndDeliveryDate(String origin,
						String destination,	String deliveryDate);
	Delivery findByDeliveryNumberAndDeliveryDate(String deliveryNumber, String deliveryDate);

}
