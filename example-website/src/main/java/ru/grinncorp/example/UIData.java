package ru.grinncorp.example;

import java.util.List;

public class UIData {
	
	private SearchQuery searchQuery;
	private List<Delivery> deliverys;
	private Delivery selectedDelivery;
	private Customer customer;

	private String bookingid;

	public SearchQuery getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(SearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public Delivery getSelectedDelivery() {
		return selectedDelivery;
	}

	public void setSelectedDelivery(Delivery selectedDelivery) {
		this.selectedDelivery = selectedDelivery;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	
	
}
