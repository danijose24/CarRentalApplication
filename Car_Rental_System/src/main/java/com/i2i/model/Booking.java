/**
 * 
 */
package com.i2i.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sudhakar
 *
 */
@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="pickupDate")
	private Date pickupDate;
	
	@Column(name="dropDate")
	private Date dropDate;
	
	@Column(name="amount")
	private int amount;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="carId")
	private Car car;
	
	@Column(name="address")
	private String address;
	/**
	 * @param id
	 * @param userId
	 * @param carId
	 * @param pickupDate
	 * @param dropDate
	 * @param amount
	 */
	public Booking() {}
	
	public Booking(Date pickupDate,
			Date dropDate, int amount,String address) {
		this.pickupDate = pickupDate;
		this.dropDate = dropDate;
		this.amount = amount;
		this.address = address;
	}
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
	 * @return the pickupDate
	 */
	public Date getPickupDate() {
		return pickupDate;
	}
	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	/**
	 * @return the dropDate
	 */
	public Date getDropDate() {
		return dropDate;
	}
	/**
	 * @param dropDate the dropDate to set
	 */
	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
