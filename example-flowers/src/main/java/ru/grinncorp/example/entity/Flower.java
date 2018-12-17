package ru.grinncorp.example.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flower {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String plantingArticle;
	String plantingDate;
	String price;
	
	public Flower() {
		super();
	}

	public Flower( String plantingArticle, String plantingDate, String price) {
		super();
		
		this.plantingArticle = plantingArticle;
		this.plantingDate = plantingDate;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlantingArticle() {
		return plantingArticle;
	}

	public void setPlantingArticle(String plantingArticle) {
		this.plantingArticle = plantingArticle;
	}

	public String getPlantingDate() {
		return plantingDate;
	}

	public void setPlantingDate(String plantingDate) {
		this.plantingDate = plantingDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", plantingArticle=" + plantingArticle + ", plantingDate=" + plantingDate
				+ ", price=" + price + "]";
	}
	
	

}
