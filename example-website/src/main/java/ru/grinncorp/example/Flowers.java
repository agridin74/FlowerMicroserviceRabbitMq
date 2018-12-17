package ru.grinncorp.example;




public class Flowers {
	
	long id;
	
	String flower;
	String currency;
	public Flowers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flowers(String flower, String currency) {
		super();
		this.flower = flower;
		this.currency = currency;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlower() {
		return flower;
	}
	public void setFlower(String flower) {
		this.flower = flower;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Flowers [id=" + id + ", flower=" + flower + ", currency=" + currency + "]";
	}
	
}
