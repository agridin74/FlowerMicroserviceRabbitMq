package ru.grinncorp.example.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookingRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	private String deliveryNumber;
	private String origin;
	private String destination;
	private String deliveryDate;
	private Date   bookingDate;
	private String flower;
	private String status;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="bookingRecord")
	Set<Customer> customers;

	public BookingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingRecord(String deliveryNumber, String origin, String destination, String deliveryDate,
			Date bookingDate, String flower, String status, Set<Customer> customers) {
		super();
		this.deliveryNumber = deliveryNumber;
		this.origin = origin;
		this.destination = destination;
		this.deliveryDate = deliveryDate;
		this.bookingDate = bookingDate;
		this.flower = flower;
		this.status = status;
		this.customers = customers;
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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getFlower() {
		return flower;
	}

	public void setFlower(String flower) {
		this.flower = flower;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "BookingRecord [id=" + id + ", deliveryNumber=" + deliveryNumber + ", origin=" + origin
				+ ", destination=" + destination + ", deliveryDate=" + deliveryDate + ", bookingDate=" + bookingDate
				+ ", flower=" + flower + ", status=" + status + ", customers=" + customers + "]";
	}
	

}
