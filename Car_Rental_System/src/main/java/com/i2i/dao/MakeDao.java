package com.i2i.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.i2i.model.Car;
import com.i2i.model.Make;
import com.i2i.exception.UserDefinedException;

/**
 *<h1>MakeDao</h1>
 * <p>
 * The class MakeDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different make methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
@Repository("makeDao")
@Transactional
public interface MakeDao extends GenericDao<Make, Long> {
	
	/**
	 * <p>
	 * The method insert Make is used to insert the make details to the database.
	 * </p>
	 * @param Make make 
	 *         make object should be in Make type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the make details through session object.
	 */
	public void insertMake(Make make) throws UserDefinedException ;

	/**
	 * <p>
	 * The method find Make is used to find the particular make details from the database.
	 * </p>
	 * @param int makeId
	 *             makeId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in finding the make details through session object.     
	 * @return make
	 *          returns the make object to MakeService.
	 *
	 */
	public Make findMake(int makeId) throws UserDefinedException;

	/**
	 * <p>
	 * The method delete Make is used to delete the particular make details from the database.
	 * </p>
	 * @param int makeId
	 *             makeId should be in integer type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in deleting the make details through session object.     
	 * @return boolean
	 *          returns true if the Make object is deleted from the database.
	 *
	 */
	public boolean deleteMake(String makeId) throws UserDefinedException ;
 
	/**
     * <p>
     * The retrieve Make Details method is used to retrieve all makes from the database.
     * </p>   
     * @return List<Make>
     *          returns the list of makes to MakeService.  
     * @throws UserDefinedException
     *          If there is any exception occurs in retrieve make Details.
     */
	public List<Make> retrieveMakeDetails() throws UserDefinedException ;

	/**
	 * <p>
	 * The method update Make is used to update the particular make details from the database.
	 * </p>
	 * @param Make make
	 *         make object should be in Make type.
	 * @throws UserDefinedException
	 *          If there is any exception occurs in updating the make details through session object.     
	 * @return boolean
	 *          returns true if the make object is updated from the database.
	 *
	 */
	public boolean updateMake(Make make) throws UserDefinedException ;
}
