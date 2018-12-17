package ru.grinncorp.example;
import java.util.Date;



public class CheckInRecord {
	
	long id;
	
	String lastName;
	String firstName;
	String seatNumber;
	Date   checkInTime;
	String plantingArticle;
	String plantingDate;
	long   bookingId;
	
	public CheckInRecord()
	{}

	public CheckInRecord(String lastName, String firstName, String seatNumber, Date checkInTime, String plantingArticle,
			String plantingDate, long bookingId) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.seatNumber = seatNumber;
		this.checkInTime = checkInTime;
		this.plantingArticle = plantingArticle;
		this.plantingDate = plantingDate;
		this.bookingId = bookingId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
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

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "CheckInRecord [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber="
				+ seatNumber + ", checkInTime=" + checkInTime + ", plantingArticle=" + plantingArticle
				+ ", plantingDate=" + plantingDate + ", bookingId=" + bookingId + "]";
	}

	
	
}
