package ru.grinncorp.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Flowers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="flower_id")
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
