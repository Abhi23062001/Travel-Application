# Travel-Application

# Technology Stack
  Spring \n
  Spring Boot \n
  JUnit \n
  Thymeleaf \n
  Hibernate ORM \n
  MySQL \n
  Embedded Tomcat Server
  
# Implemented Features
# User Authentication
  Implemented a login form with two types of authentications - one for users and another for admin.
  
# User Interface
  For users, a welcome page is created with fields for start destination, end destination, and number of persons travelling. Upon clicking next, users are directed to a page where   they can select a car based on available seats. After selecting a car, users are directed to a payment page where the total bill is displayed. Upon booking, users are redirected   to an orders page displaying all their bookings. There is also a logout link in the navigation bar which redirects users to the login form.
  
# Admin Interface
  For admins, there are four navigation links. Admins can book a cab and view all bookings. Admins have additional features to add a driver, add a car, read the details of a         driver or a car, delete a car, or delete a driver. There is also a navigation link for admins to view all orders booked in the application. Like users, admins also have a logout   link in the navigation bar which redirects them to the login form.
  
# Database Schema
  The database schema consists of seven tables: Cars, Drivers, Cities, Distance Matrix of Cities, Users, User Authorities, and Orders.
