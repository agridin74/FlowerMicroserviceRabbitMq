package ru.grinncorp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.example.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	Inventory findByDeliveryNumberAndDeliveryDate(String deliveryNumber, String deliveryDate);

}
