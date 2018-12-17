package ru.grinncorp.example;

public class Delivery {
	
	
	long id;
	
	String deliveryNumber;
	String origin;
	String destination;
	String deliveryDate;
	
	
	Flowers flowers;
	
	
	

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(String deliveryNumber, String origin, String destination, String deliveryDate, Flowers flowers) {
		super();
		this.deliveryNumber = deliveryNumber;
		this.origin = origin;
		this.destination = destination;
		this.deliveryDate = deliveryDate;
		this.flowers = flowers;
		
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

	public Flowers getFlowers() {
		return flowers;
	}

	public void setFlowers(Flowers flowers) {
		this.flowers = flowers;
	}



	@Override
	public String toString() {
		return "Delivery [id=" + id + ", deliveryNumber=" + deliveryNumber + ", origin=" + origin + ", destination="
				+ destination + ", deliveryDate=" + deliveryDate + ", flowers=" + flowers 
				+ "]";
	}
	
	

}
