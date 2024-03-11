package com.astr.travelapp.controller;

import com.astr.travelapp.entity.Car;
import com.astr.travelapp.entity.Driver;
import com.astr.travelapp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    public AdminController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }

    @GetMapping("/listDriver")
    public String showDriverList(Model model){
        model.addAttribute("driverList", driverService.findAll());
        return "admin/driver-list";
    }

    @GetMapping("addDriver")
    public String addDriver(@ModelAttribute("driver") Driver driver){
        return "admin/create-driver";
    }

    @PostMapping("addNewDriver")
    public String createNewDriver(@ModelAttribute("driver") Driver driver){
        driverService.save(driver);
        return "redirect:/admin/listDriver";
    }

    @GetMapping("modifyDriver")
    public  String modifyDriver(@RequestParam("driverId") int driverId, Model model){
        model.addAttribute("driver", driverService.findById(driverId));
        return "admin/create-driver";
    }

    @GetMapping("deleteDriver")
    public String deleteDriver(@RequestParam("driverId") int driverId){
        driverService.delete(driverService.findById(driverId));
        return "redirect:/admin/listDriver";
    }

    @GetMapping("listCar")
    public String listCar(Model model){
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        return "admin/car-list";
    }

    @GetMapping("addCar")
    public String addCar(Model model, @ModelAttribute("car") Car car){
        model.addAttribute("driverList", driverService.findAll());
        return "admin/create-car";
    }

    @PostMapping("addNewCar")
    public String addNewCar(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/admin/listCar";
    }

    @GetMapping("modifyCar")
    public String modifyCar(@RequestParam("carId") int carId, Model model){
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("driverList", driverService.findAll());
        return "admin/create-car";
    }

    @GetMapping("deleteCar")
    public String deleteCar(@RequestParam("carId") int carId){
        carService.delete(carService.findById(carId));
        return "redirect:/admin/listCar";
    }

    @GetMapping("listBooking")
    public String listBooking(Model model){
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("driverList", driverService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("distanceList", distanceService.findAll());
        return  "admin/order-list";
    }

}















