package com.i2i.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.i2i.model.Booking;
import com.i2i.model.Car;
import com.i2i.model.User;
import com.i2i.exception.UserDefinedException;

/**
 *<h1>BookingDao</h1>
 * <p>
 * The class BookingDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different booking methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
@Repository("bookingDao")
@Transactional
public interface BookingDao extends GenericDao<Booking, Long> {
	
	/**
	 * <p>
	 * The method insert Booking is used to insert the booking details to the database.
	 * </p>
	 * @param Booking booking 
	 *         booking object should be in Booking type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the booking details through session object.
	 */
	public void insertBooking(Booking booking) throws UserDefinedException ;

	/**
	 * <p>
	 * The method find Booking is used to find the particular booking details from the database.
	 * </p>
	 * @param int bookingId
	 *             bookingId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the booking details through session object.     
	 * @return booking
	 *          returns the booking object to BookingService.
	 *
	 */
	public Booking findBooking(int bookingId) throws UserDefinedException ;

	/**
	 * <p>
	 * The method delete Booking is used to delete the particular booking details from the database.
	 * </p>
	 * @param int bookingId
	 *             bookingId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the booking details through session object.     
	 * @return boolean
	 *          returns true if the Booking object is deleted from the database.
	 *
	 */
	public boolean deleteBooking(int bookingId) throws UserDefinedException ;
 
	/**
     * <p>
     * The retrieve Booking Details method is used to retrieve all bookings from the database.
     * </p>   
     * @return List<Booking>
     *          returns the list of bookings to BookingService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve booking Details.
     */
	public List<Booking> retrieveBookingDetails() throws UserDefinedException ;

	/**
	 * <p>
	 * The method update Booking is used to update the particular booking details from the database.
	 * </p>
	 * @param Booking booking
	 *         booking object should be in Booking type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the booking details through session object.     
	 * @return boolean
	 *          returns true if the booking object is updated from the database.
	 *
	 */
	public boolean updateBooking(Booking booking) throws UserDefinedException ;
	
    /**
	 * <p>
	 * The method allocate User To Bookings is used to allocate a particular user to many bookings.
	 * </p>
	 * @param Booking booking
	 *
	 * @param User user
	 *
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the user to bookings through session object.
	 */
	public void allocateUserToBookings(Booking booking, User user) throws UserDefinedException ;
	
    /**
	 * <p>
	 * The method allocate Car To Bookings is used to allocate a particular Car to many bookings.
	 * </p>
	 * @param Booking booking
	 *
	 * @param Car car
	 *
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the car to bookings through session object.
	 */
	public void allocateCarToBookings(Booking booking, Car car) throws UserDefinedException ;
}
