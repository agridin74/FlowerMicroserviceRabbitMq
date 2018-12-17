package ru.grinncorp.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String deliveryNumber;
	private String deliveryDate;
	int available;
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(String deliveryNumber, String deliveryDate, int available) {
		super();
		this.deliveryNumber = deliveryNumber;
		this.deliveryDate = deliveryDate;
		this.available = available;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	public boolean isAvailable(int count) {
		return ((available-count)>5);
	}
	
	public int getBookableInventory() {
		return available -5;
	}

}
