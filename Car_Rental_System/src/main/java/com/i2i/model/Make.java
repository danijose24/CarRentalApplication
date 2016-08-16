/**
 * 
 */
package com.i2i.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.i2i.model.Car;

/**
 * @author sudhakar
 *
 */
@Entity
@Table(name="Make")
public class Make {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="rate")
	private int rate;
	
	@OneToMany(mappedBy="make")
    private Set<Car> cars = new HashSet<Car>();

	/**
	 * @param name
	 * @param rate
	 */
	public Make( String name, int rate) {
		this.name = name;
		this.rate = rate;
	}
	public Make() {}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}
	/**
	 * @return the cars
	 */
	public Set<Car> getCars() {
		return cars;
	}
	/**
	 * @param cars the cars to set
	 */
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}
