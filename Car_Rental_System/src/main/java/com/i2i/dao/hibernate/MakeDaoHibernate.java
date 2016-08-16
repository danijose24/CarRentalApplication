package com.i2i.dao.hibernate;

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
import com.i2i.dao.CarDao;
import com.i2i.dao.MakeDao;
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
public class MakeDaoHibernate extends GenericDaoHibernate<Make, Long> implements MakeDao {
	
	public MakeDaoHibernate() {
        super(Make.class);
    }
	
	/**
	 * <p>
	 * The method insert Make is used to insert the make details to the database.
	 * </p>
	 * @param Make make 
	 *         make object should be in Make type. 
	 * @throws UserDefinedException
	 *          If there is any exception occurs in inserting the make details through session object.
	 */
	public void insertMake(Make make) throws UserDefinedException {
		try {
			System.out.println("entering into make implement dao");
	    	System.out.println(make);
	    	System.out.println(getSession());
            getSession().saveOrUpdate(make);
	        // necessary to throw a DataIntegrityViolation and catch it in UserManager
	        getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public Make findMake(int makeId) throws UserDefinedException {
		Make make;
	    try {
	        make = (Make)getSession().get(Make.class, makeId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this Make Id: "+makeId, e);
	    }
	    return make;
	}

	@Override
	public boolean deleteMake(String makeId) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Make> retrieveMakeDetails() throws UserDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMake(Make make) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
