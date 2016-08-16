package com.i2i.dao.hibernate;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.Car;
import com.i2i.model.Make;
import com.i2i.dao.CarDao;
import com.i2i.exception.UserDefinedException;

/**
 *<h1>CarDao</h1>
 * <p>
 * The class CarDao is the derived class of GenericDao.
 * This class handles the hibernate operations for different car methods.
 * </p>
 *
 * @author sudhakar
 * @version 1.0
 * @created 25-07-2016
 */
@Repository("carDao")
public class CarDaoHibernate extends GenericDaoHibernate<Car, Long> implements CarDao {

		public CarDaoHibernate() {
	        super(Car.class);
	    }
	
		@Override
		public void insertCar(Car car) throws UserDefinedException {
			try {
				System.out.println("entering into car implement dao");
		    	System.out.println(car);
		    	System.out.println(getSession());
	            getSession().saveOrUpdate(car);
		        // necessary to throw a DataIntegrityViolation and catch it in UserManager
		        getSession().flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	    /*@SuppressWarnings("unchecked")
	    public List<Car> getCars() {
	        Query qry = getSession().createQuery("from Car u order by upper(u.carname)");
	        return qry.list();
	    }
        */
	
	/**
	 * <p>
	 * The method allocate Make To Cars is used to allocate a particular Make to many cars.
	 * </p>
	 * @param Car car
	 *         car object should be in Car type.
	 * @param Make make
	 *         make object should be in Make type.
	 * @throws UserDefinedException
	 *        If there is any exception occurs in allocating the make to cars through session object.
	 */
	public void allocateMakeToCars(Set<Car> cars, Make make) throws UserDefinedException {
        try {
        	for (Car car : cars) {
        		car.setMake(make);
                getSession().update(car);
        	}            
        } catch (HibernateException e) {
            throw new UserDefinedException("Make could not assign for this car", e);
        }
	}


	@Override
	public Car findCar(int carId) throws UserDefinedException {
	    Car car;
	    try {
	        car = (Car)getSession().get(Car.class, carId);
	    } catch (HibernateException e) {
	        throw new UserDefinedException("Can not able to find for this car Id: "+carId, e);
	    }
	    return car;
	}

	@Override
	public boolean deleteCar(int carId) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Car> retrieveCarDetails() throws UserDefinedException {
		System.out.println("entering into car dao implementation");
		System.out.println(getSession());
		Query qry = getSession().createQuery("from Car");
		System.out.println("returning car details");
        return qry.list();
	}


	@Override
	public boolean updateCar(Car car) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}
}