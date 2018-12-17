package ru.grinncorp.example.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * Доставка
 * @author agridin74
 *
 */
@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String deliveryNumber;
	String origin;
	String destination;
	String deliveryDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flower_id")
	Flowers flowers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inv_id")
	Inventory inventory;

	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(String deliveryNumber, String origin, String destination, String deliveryDate, Flowers flowers,
			Inventory inventory) {
		super();
		this.deliveryNumber = deliveryNumber;
		this.origin = origin;
		this.destination = destination;
		this.deliveryDate = deliveryDate;
		this.flowers = flowers;
		this.inventory = inventory;
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", deliveryNumber=" + deliveryNumber + ", origin=" + origin + ", destination="
				+ destination + ", deliveryDate=" + deliveryDate + ", flowers=" + flowers + ", inventory=" + inventory
				+ "]";
	}
	
	

}
