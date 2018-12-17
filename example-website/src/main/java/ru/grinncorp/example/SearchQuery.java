package ru.grinncorp.example;

public class SearchQuery {
	String origin;
	String destination;
	String deliveryDate;
	public SearchQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchQuery(String origin, String destination, String deliveryDate) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.deliveryDate = deliveryDate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "SearchQuery [origin=" + origin + ", destination=" + destination + ", deliveryDate=" + deliveryDate
				+ "]";
	}
	

}
