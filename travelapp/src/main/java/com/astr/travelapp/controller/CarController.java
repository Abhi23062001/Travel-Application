package com.astr.travelapp.controller;

import com.astr.travelapp.entity.Car;
import com.astr.travelapp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CarController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    public CarController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/user/selectCar")
    public String showCar(@RequestParam("distanceId") int distance, Model model, @RequestParam("totalPerson") int totalPerson){
        model.addAttribute("totalPerson", totalPerson);
        model.addAttribute("distanceId", distance);
        model.addAttribute("carList", carService.findAll());
        return "user/car-select";
    }

    @GetMapping("/admin/listCar")
    public String listCar(Model model){
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        return "admin/car-list";
    }

    @GetMapping("/admin/addCar")
    public String addCar(Model model, @ModelAttribute("car") Car car){
        model.addAttribute("driverList", driverService.findAll());
        return "admin/create-car";
    }

    @PostMapping("/admin/addNewCar")
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/admin/listCar";
    }

    @GetMapping("/admin/modifyCar")
    public String modifyCar(@RequestParam("carId") int carId, Model model){
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("driverList", driverService.findAll());
        return "admin/create-car";
    }

    @GetMapping("/admin/deleteCar")
    public String deleteCar(@RequestParam("carId") int carId){
        carService.delete(carService.findById(carId));
        return "redirect:/admin/listCar";
    }
}
