package com.i2i.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Make;
import com.i2i.service.CarService;
import com.i2i.service.MakeService;
import com.i2i.dao.MakeDao;
import com.i2i.exception.UserDefinedException;

/**
 * <p>
 * The MakeService class is used to gets the output from MakeDao class and returns to the Controller.
 * Inputs also passes through this class to MakeDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
@Service
public class MakeServiceImpl implements MakeService {
	
	@Autowired
    MakeDao makeDao ;
    /**
     * <p>
     * The add make method is used to add make details to the database,
	 * here we create an object for an make using Make model.
	 * make Object is passed as a parameter to makeDao class to insert into the database.
	 * </p>
     * @param make         
	 *         make should be in Make.
	 * @throws UserDefinedException
	 *          If there is failed in inserting operation.           
	 */
	public void addMake(Make make) throws UserDefinedException {
	    System.out.println("Enter into Make Service impl");
	    makeDao.insertMake(make);
	}

	/**
	 * <p>
	 * This method is used to find particular make by using id. 
	 * </p>
	 * @param id
	 *         used to find make
	 * @return Make 
	 *         returns the Make object to Controller class.
	 * @throws UserDefinedException 
	 *         If there is failed to find make details.                        
	 */
	public Make findMakeById(int id) throws UserDefinedException {
	    return makeDao.findMake(id);
	}
    /**
     * <p>
	 * This method is used to remove particular make by using id. 
     * </p>
	 * @param id
	 *         used to remove make
	 * @return boolean 
	 *         returns true if the make details is removed.
	 * @throws UserDefinedException 
	 *         If there is failed to remove make details.                        
	 */
	 public boolean removeMakeById(String id) throws UserDefinedException {
	     return makeDao.deleteMake(id);
	 }
    /**
	 * <p>
	 * This method is used to display all the Make details. 
	 * </p>
	 * @return List<Make> 
	 *         returns list of makes to the controller.
	 * @throws UserDefinedException 
	 *         If there is failed to display all makes details.                        
	 */
	 public List<Make> totalMakesDetails() throws UserDefinedException {
	     return makeDao.retrieveMakeDetails();
	 }
	/**
	 * <p>
	 * This method is used to update particular Make by using id. 
	 * </p>
	 * @param id
	 *         used to find make.
	 * @param name         
	 *         name should be in String.
	 * @param rate
	 *         rate should be in int.
	 * @return boolean 
	 *         returns true if the Make details is updated.
	 * @throws UserDefinedException 
	 *         If there is failed in updating make details.                        
	 */
	 public boolean updateMakeById(int id,String name, int rate) throws UserDefinedException {
	     Make make = findMakeById(id);
	     make.setName(name);
	     make.setRate(rate);
	     return makeDao.updateMake(make);
	 }
}
