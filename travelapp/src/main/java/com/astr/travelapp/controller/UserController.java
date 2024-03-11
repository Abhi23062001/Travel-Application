package com.astr.travelapp.controller;

import com.astr.travelapp.entity.*;
import com.astr.travelapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    @Autowired
    public UserController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/home")
    public String showHome(Model model, @ModelAttribute("distance") Distance distance){
        model.addAttribute("cityList", cityService.findAll());
        return "user/user";
    }

    @PostMapping("selectDistance")
    public String selectCar(@ModelAttribute("distance") Distance distance, @ModelAttribute("totalPerson") int totalPerson, Model model){
        if(distance.getSource() == distance.getDestination()){
            return "user/source-destination-error";
        }
        Distance newDistance = distanceService.findBySourceAndDestination(distance.getSource(), distance.getDestination());
        return "redirect:/user/selectCar?distanceId="+newDistance.getId()+"&totalPerson="+totalPerson;
    }

    @GetMapping("selectCar")
    public String showCar(@RequestParam("distanceId") int distance, Model model, @RequestParam("totalPerson") int totalPerson){
        model.addAttribute("totalPerson", totalPerson);
        model.addAttribute("distanceId", distance);
        model.addAttribute("carList", carService.findAll());
        return "user/car-select";
    }

    @GetMapping("displayOrder")
    public String displayOrder(@RequestParam("distanceId") int distanceId, @RequestParam("carId") int carId, Model model){
        Distance distance = distanceService.findById(distanceId);
        Car car = carService.findById(carId);
        City source = cityService.findById(distance.getSource());
        City destination = cityService.findById(distance.getDestination());
        Driver driver = driverService.findById(car.getDriverId());
        model.addAttribute("distance", distance);
        model.addAttribute("car",car);
        model.addAttribute("source",source);
        model.addAttribute("destination",destination);
        model.addAttribute("driver",driver);
        return "user/display-order";
    }

    @GetMapping("createOrder")
    public String createOrder(@RequestParam("distanceId") int distanceId, @RequestParam("carId") int carId, Authentication authentication){
        Distance distance = distanceService.findById(distanceId);
        Car car = carService.findById(carId);
        car.setStatus("B");
        carService.save(car);
        City source = cityService.findById(distance.getSource());
        City destination = cityService.findById(distance.getDestination());
        Driver driver = driverService.findById(car.getDriverId());
        Order order = new Order();
        order.setUserId(authentication.getName());
        order.setCarId(car.getId());
        order.setFare(car.getCharge() * distance.getDistance());
        order.setDriverId(driver.getId());
        order.setDistanceId(distance.getId());
        order.setCompleted("N");
        orderService.save(order);
        return "redirect:/user/orderList";
    }

    @GetMapping("/orderList")
    public String orderList(Model model, Authentication authentication){
        model.addAttribute("userName", authentication.getName());
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("distanceList", distanceService.findAll());
        return "user/order-list";
    }
}























