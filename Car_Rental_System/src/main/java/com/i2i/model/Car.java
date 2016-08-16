/**
 * 
 */
package com.i2i.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.i2i.model.Booking;
/**
 * @author sudhakar
 *
 */

@Entity
@Table(name = "Car")
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name="carType")
	private int carType;
	
	@Column(name="carNumber")
	private String carNumber;
	
	@ManyToOne
	@JoinColumn(name="makeId")
	private Make make;
	
	@Column(name="imageUrl")
	private String imageUrl;
	
	@Column(name="createdAt")
    private Time createdAt;
	
	@OneToMany(mappedBy="car")
    private Set<Booking> bookings = new HashSet<Booking>();

	/**
	 * @param id
	 * @param makeId
	 * @param carType
	 * @param carNumber
	 */
	public Car(int carType, String carNumber,String imageUrl) {
		this.carType = carType;
		this.carNumber = carNumber;
		this.imageUrl = imageUrl;
	}
	
	public Car() {}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the carType
	 */
	public int getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(int carType) {
		this.carType = carType;
	}
	/**
	 * @return the carNumber
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * @param carNumber the carNumber to set
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	/**
	 * @return the bookings
	 */
	public Set<Booking> getBookings() {
		return bookings;
	}
	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	/**
	 * @return the make
	 */
	public Make getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(Make make) {
		this.make = make;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	/**
	 * @return the createdAt
	 */
	public Time getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + id + ", carType=" + carType + ", carNumber=" + carNumber + ", imageUrl=" + imageUrl + "]";
	}


	
}
