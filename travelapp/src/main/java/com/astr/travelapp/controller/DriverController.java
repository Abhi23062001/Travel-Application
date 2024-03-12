package com.astr.travelapp.controller;

import com.astr.travelapp.entity.Driver;
import com.astr.travelapp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DriverController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    public DriverController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/admin/listDriver")
    public String showDriverList(Model model){
        model.addAttribute("driverList", driverService.findAll());
        return "admin/driver-list";
    }

    @GetMapping("/admin/addDriver")
    public String addDriver(@ModelAttribute("driver") Driver driver){
        return "admin/create-driver";
    }

    @PostMapping("/admin/addNewDriver")
    public String createNewDriver(@ModelAttribute("driver") Driver driver){
        driverService.save(driver);
        return "redirect:/admin/listDriver";
    }

    @GetMapping("/admin/modifyDriver")
    public  String modifyDriver(@RequestParam("driverId") int driverId, Model model){
        model.addAttribute("driver", driverService.findById(driverId));
        return "admin/create-driver";
    }

    @GetMapping("/admin/deleteDriver")
    public String deleteDriver(@RequestParam("driverId") int driverId){
        driverService.delete(driverService.findById(driverId));
        return "redirect:/admin/listDriver";
    }
}
