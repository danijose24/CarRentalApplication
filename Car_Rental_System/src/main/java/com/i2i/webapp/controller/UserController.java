package com.i2i.webapp.controller;

import com.i2i.Constants;
import com.i2i.dao.SearchException;
import com.i2i.exception.UserDefinedException;
import com.i2i.model.Booking;
import com.i2i.model.Car;
import com.i2i.model.Make;
import com.i2i.model.User;
import com.i2i.model.Role;
import com.i2i.service.BookingService;
import com.i2i.service.CarService;
import com.i2i.service.MakeService;
import com.i2i.service.UserManager;
import com.i2i.service.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Simple class to retrieve a list of users from the database.
 * <p/>
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
public class UserController {
    private UserManager userManager = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Autowired
    CarService carService;
    
    @Autowired
     MakeService makeService;
    
    @Autowired
    BookingService bookingService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/admin/users*")
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }
    
    @RequestMapping("/availableCar")
	public ModelAndView carList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("entering into available cars");
		    model.put("car", carService.totalCarsDetails());
		    System.out.println(carService.totalCarsDetails());
	    	System.out.println("after total car details");
		} catch(UserDefinedException e) {
			e.printStackTrace();
		}
		return new ModelAndView("availableCars", model);
	}
    
    @RequestMapping("/home")
	public ModelAndView mainHomePage(final HttpServletRequest request) {
		System.out.println("entering into main pages");
		
	    	String userName = request.getRemoteUser();
			User user = userService.getUserByUsername(userName);
	        if(null != user) {
	        	Set<Role> roles = user.getRoles();
	        	for(Role role : roles){
	        		if("ROLE_ADMIN".equals(role.getName())) {
	        			return new ModelAndView("adminHome");
	        		}
	        	}
	        }
    	return new ModelAndView("home");
	}
    
    @RequestMapping(value = "/bookCar")
	public ModelAndView signUp(@RequestParam("car") int carId) {
    	tempCarId = carId;
		return new ModelAndView("booking");
	}
    
    @RequestMapping("/logIn")
	public ModelAndView logInForm() {
		return new ModelAndView("logIn");
	}
    
    private Booking confirmBooking = null;
    private int tempCarId ;
    
    @RequestMapping("/bookingSuccess")	
	public ModelAndView booking(@RequestParam("pickupDate") String pickupDate, @RequestParam("dropDate") String dropDate, @ModelAttribute("booking") Booking booking,BindingResult result) {
	    
		Map<String, Booking> model = new HashMap<String, Booking>();
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = df.parse(pickupDate);
			Date d2 = df.parse(dropDate);
			java.sql.Date pickup_Date = new java.sql.Date(d1.getTime());
	        java.sql.Date drop_Date = new java.sql.Date(d2.getTime());
			booking.setPickupDate(pickup_Date);
			booking.setDropDate(drop_Date);
		    confirmBooking = booking;
		    Car car = carService.findCarById(tempCarId);
            long difference = d2.getTime() - d1.getTime();
            int dayDifference = (int) (long) difference;
            int totalDays = dayDifference / (24 * 60 * 60 * 1000);
            totalDays = totalDays + 1;
            int amount = car.getMake().getRate() * totalDays;
            booking.setAmount(amount);
	        model.put("booking", booking);
	    } catch (UserDefinedException e) {
		    System.out.println(e);
        } catch (ParseException e) {
            e.printStackTrace();     
        }
			return new ModelAndView("confirmBooking", model);
	}
    
    @RequestMapping("/admin")
	public ModelAndView adminLogIn() {
		return new ModelAndView("admin");
	}
    
    @RequestMapping("/addCar")
	public ModelAndView addCar() {
        return new ModelAndView("addNewCar");
	}
    
    @RequestMapping("/carAddResult")
	public ModelAndView addNewCar(@ModelAttribute("car") Car car,BindingResult result) {
		try {
		    System.out.println(car);
		    java.sql.Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
            car.setCreatedAt(createdAt);
            System.out.println(createdAt);
		    carService.addCar(car);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("adminHome");
	}
    
    @RequestMapping("/addMake")
	public ModelAndView addMake() {
	    return new ModelAndView("addNewMake");
	}
    
    @RequestMapping("/carMakeResult")
	public ModelAndView addNewMake(@ModelAttribute("make") Make make,BindingResult result) {
		try {
		    makeService.addMake(make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("adminHome");
	}
    
    @RequestMapping("/assignMakeToCar")
	public ModelAndView assignMakeToCar() {
		return new ModelAndView("assignMakeToCar");
	}
    
    @RequestMapping(value = "/saveAssignMakeToCar", method=RequestMethod.POST)
	public ModelAndView assignMakeToCar(@RequestParam("makeId") int makeId , @RequestParam("carId") int carId) {
		try {
            System.out.println("after controller");
            Make make = makeService.findMakeById(makeId);
            Car car = carService.findCarById(carId);
		    Set<Car> cars = new HashSet<Car>();
		    cars.add(car);
            carService.assignMakeToCars(cars, make);
		} catch(UserDefinedException e) {
			System.out.println(e);
		}
		return new ModelAndView("adminHome");
	}
    
    @RequestMapping("/finalBooking")
	public ModelAndView finalBooking( @RequestParam("userName") String userName) {
    	try {
		    Car car = carService.findCarById(tempCarId);
		    confirmBooking.setCar(car);
		    User user = userManager.getUserByUsername(userName);
		    System.out.println(user);
		    confirmBooking.setUser(user);
		    java.sql.Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
		    confirmBooking.setCreatedAt(createdAt);
		    bookingService.addBooking(confirmBooking);
	    } catch (UserDefinedException e) {
	    	e.printStackTrace();
		    System.out.println(e);
		    return new ModelAndView("bookingCar");
        }
			return new ModelAndView("payment");
	}
}