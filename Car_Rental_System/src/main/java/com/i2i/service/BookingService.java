package com.i2i.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.i2i.model.Booking;
import com.i2i.model.User;
import com.i2i.model.Car;
import com.i2i.dao.BookingDao;
import com.i2i.dao.CarDao;
import com.i2i.exception.UserDefinedException;

/**
 * <p>
 * The BookingService class is used to gets the output from BookingDao class and returns to the Controller.
 * Inputs also passes through this class to BookingDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
@Service
public interface BookingService {
	
    /**
	 * <p>
	 * The add booking method is used to add booking details to the database,
	 * here we create an object for booking using Booking model.
	 * booking Object is passed as a parameter to BookingDao class to insert into the database.
	 * </p>
	 * 
     * @param booking
	 *         booking should be Booking.
	 * @throws UserDefinedException
	 *          If there is failed in inserting operation.           
	 */
    public void addBooking(Booking booking) throws UserDefinedException ;
    /**
	 * <p>
	 * This method is used to find particular booking by using bookingId. 
	 * </p>
	 * @param bookingId
	 *         bookingId should be in int.
	 * @return Booking 
	 *         returns the Booking object to Controller class.
	 * @throws UserDefinedException 
	 *         If there is failed to find booking details.                        
	 */
    public Booking findBookingById(int bookingId) throws UserDefinedException ;
    
     /**
      * <p>
	  * This method is used to remove particular booking by using bookingId. 
	  * </p>
	  * @param bookingId
	  *         used to remove booking
	  * @return boolean 
	  *         returns true if the booking details is removed.
	  * @throws UserDefinedException 
	  *         If there is failed to remove booking details.                        
	  */
	 public boolean removeBookingById(int bookingId) throws UserDefinedException ;
	 
     /**
      * <p>
	  * This method is used to display all the booking details. 
	  * </p>
	  * @return List<Booking> 
	  *         returns list of bookings to the controller.
	  * @throws UserDefinedException 
	  *         If there is failed to display all booking details.                        
	  */
	 public List<Booking> totalBookingDetails() throws UserDefinedException ;
	 
	 /**
	  * <p>
	  * This method is used to update particular booking by using bookingId. 
	  * </p>
	  * @param bookingId
	  *         used to find booking
	  * @param pickupDate
	  *         pickupDate should be in Date.
	  * @param dropDate
	  *         dropDate should be in Date.
	  * @param amount
	  *         amount should be in int.
  	  * @return boolean 
	  *         returns true if the booking details is updated.
	  * @throws UserDefinedException 
	  *         If there is failed in updating booking details.                        
	  */
	 public boolean updateBookingById(int bookingId, Date pickupDate,
				Date dropDate, int amount) throws UserDefinedException ;
	 
	 /**
      * <p>
	  * The method assign User To Bookings is used to assign a particular user to many bookings.
	  * </p>
	  * @param set<Booking> bookings
	  *
	  * @param User user
	  *
	  */
	 public void assignUserToBookings(Set<Booking> bookings, User user) throws UserDefinedException ;
	 
	 /**
      * <p>
	  * The method assign Car To Bookings is used to assign a particular car to many Bookings.
	  * </p>
	  * @param set<Booking> bookings
	  *
	  * @param Car car
	  *
	  */
	 public void assignCarToBookings(Set<Booking> bookings, Car car) throws UserDefinedException ;
}
