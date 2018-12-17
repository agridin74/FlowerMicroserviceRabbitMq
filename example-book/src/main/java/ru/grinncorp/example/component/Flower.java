package ru.grinncorp.example.component;

import java.util.Date;

public class Flower {
	private String deliveryNumber;
	private String deliveryDate;
	private String flower;
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
	public String getFlower() {
		return flower;
	}
	public void setFlower(String flower) {
		this.flower = flower;
	}
	@Override
	public String toString() {
		return "Flower [deliveryNumber=" + deliveryNumber + ", deliveryDate=" + deliveryDate + ", flower=" + flower
				+ "]";
	}
	
	

}
