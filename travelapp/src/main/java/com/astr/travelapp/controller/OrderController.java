package com.astr.travelapp.controller;

import com.astr.travelapp.entity.*;
import com.astr.travelapp.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    public OrderController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/user/displayOrder")
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

    @GetMapping("/user/createOrder")
    public String createOrder(@RequestParam("distanceId") int distanceId, @RequestParam("carId") int carId, Authentication authentication){
        Distance distance = distanceService.findById(distanceId);
        Car car = carService.findById(carId);
        car.setStatus("B");
        carService.save(car);
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

    @GetMapping("/user/orderList")
    public String orderList(Model model, Authentication authentication){
        model.addAttribute("userName", authentication.getName());
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("distanceList", distanceService.findAll());
        return "user/order-list";
    }

    @GetMapping("/admin/listBooking")
    public String listBooking(Model model){
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("distanceList", distanceService.findAll());
        return  "admin/order-list";
    }
}
