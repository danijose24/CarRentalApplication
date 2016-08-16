<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<html lang="en">
<head>
  <title>CarRentalSystem</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <!-- modernizr enables HTML5 elements and feature detects -->
 
  <script src="js/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body class="backround">
  <div id="main">
    <header>
	  <div id="banner">
	  <div id="welcome">
	   <center>
	      <h1 style="color:white; font: bold; display: block;">Quick Cars</h1>
	   </center> 		
	   </div>	  	
	  </div><!--close banner-->	
	</header>
	<br>
	<br>
	<nav>
	  <div id="menubar">
        <ul id="nav">
          <li ><a href="mainHome.html">Home</a></li>
          <li><a href="availableCar.html">Available Cars</a></li>
          <li class="current"><a href="bookingCar.html">LogIn</a></li>
           
          
        </ul>
      </div><!--close menubar-->	
    </nav>	
    
	<div id="site_content">		

      <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="940" height="300" src="images/car1.jpg" alt="&quot;Happy Journy With Us&quot;" /></li>
          <li><img width="940" height="300" src="images/car2.jpg" alt="&quot;Pay Less Drive More&quot;" /></li>
          <li><img width="940" height="300" src="images/car3.jpg" alt="&quot;Feel Safe we will be With u&quot;" /></li>
          <li><img width="940" height="300" src="images/car4.jpg" alt="&quot;Every Journy thought us lot&quot;" /></li>
          <li><img width="940" height="300" src="images/car5.png" alt="&quot;Provide our Best Service to U&quot;" /></li>
          <li><img width="940" height="300" src="images/car6.jpg" alt="&quot;Have a great Journy&quot;" /></li>
        </ul> 
	  </div><!--close slideshow-->	
	
	  <div class="sidebar_container">       
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Our Service</h2>
            <p>Welcome to our website.This is the great palce to book a car for your drive to any palce.We are providing the Best Service in car Rending.</p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Offer For You</h2>
            <h3>Free Trip</h3>
            <p>Every month we are selecting some lucky lots to provide the free trip to any were across India.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
		  		
        <div class="sidebar">
          <div class="sidebar_item">
            <h2>Contact</h2>
            <p>Phone: +044 567891</p>
            <p>Email: quickCars@gmail.com</a></p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->	
	
	  <div id="content">
        <div class="content_item">
	    <h1 style="color:silver;">Happy Journy with Qiuck Cars</h1>
        <br>
       
        <h4 align="right" style="color:silver;">If already have an account Login here<a href="logIn.html"> <input class="btn btn-default" type="submit" value="logIn"/></a></h4>
       
     <form action="saveUser.html" modelAttribute="user" method="post" role="form">
                    
        <center>
            <h1 style="color:silver;">Sign Up Here</h1><br>
        <table cellspacing="30">
                   
           <tr>
              <td><h4 style="color:silver;"><label for="name">Name</label></h4></td>
              <td><input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required="required" pattern="[a-zA-Z ]*"></td>
           
           </tr>
           
           <tr>
               <td><h4 style="color:silver;"><label for="phoneNumber">Phone Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></h4></td>
               <td><input type="text" class="form-control bfh-phone" data-format="+1 (ddd) ddd-dddd" placeholder="Enter Phone Number" name="phoneNumber" required="required" pattern="[789][0-9]{9}"></td>
           </tr>
           
           <tr>
               <td><h4 style="color:silver;"><label for="email">Email</label></h4></td>
               <td><input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"></td>
           </tr>
           
           <tr>
               <td><h4 style="color:silver;"><label for="pwd">Password</label></h4></td>
               <td><input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required="required" pattern=".{6,}"></td>
           </tr>
           
           <tr> 
              <td><h4 style="color:silver;"><label for="address">Address</label></h4></td>
               <td><input type="TextArea" class="form-control" id="address" placeholder="Enter Address" name="address" required="required"></td>
           </tr>
               
           <tr>
               <td></td>
               <td> <center></center><input class="btn btn-default" type="submit" class="btn btn-default" value="Sign Up"> <a href="availableCar.html"><button class="btn btn-default" type="button" required="required">Go Back</button></a></center></td>
           </tr>
        </table>
        </center>
    </form>
    		  
		</div><!--close content-->   
	
	</div><!--close site_content-->  	
  <br>
    <footer>
	 <center><h3>WE ARE HAPPY TO HELP YOU </h3></center><br>
	 
	 </footer> 
  <br>
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>

