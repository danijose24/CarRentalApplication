package com.i2i.service.impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Car;
import com.i2i.model.Make;
import com.i2i.service.CarService;
import com.i2i.service.UserExistsException;
import com.i2i.dao.CarDao;
import com.i2i.exception.UserDefinedException;

/**
 * <p>
 * The CarService class is used to gets the output from CarDao class and returns to the Controller.
 * Inputs also passes through this class to CarDao.
 * </p>
 *
 * @author Sudhakar
 * @created 25-07-2016
 */
@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
    CarDao carDao;
	
	 public void addCar(Car car) throws UserDefinedException {
		 System.out.println("entering into car service implementation");
		 System.out.println(car);
	     carDao.insertCar(car);
	 }

	@Override
	public Car findCarById(int carId) throws UserDefinedException {
		return carDao.findCar(carId);
	}

	@Override
	public boolean removeCarById(int carId) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Car> totalCarsDetails() throws UserDefinedException {
		return carDao.retrieveCarDetails();
	}

	@Override
	public boolean updateCarById(int carId, int carType, String carNumber) throws UserDefinedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void assignMakeToCars(Set<Car> cars, Make make) throws UserDefinedException {
        	carDao.allocateMakeToCars(cars, make);
	  	
	}
	 
}
