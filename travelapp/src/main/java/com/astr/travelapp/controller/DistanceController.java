package com.astr.travelapp.controller;

import com.astr.travelapp.entity.Distance;
import com.astr.travelapp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DistanceController {
    private CityService cityService;
    private CarService carService;
    private DistanceService distanceService;
    private DriverService driverService;
    private OrderService orderService;

    public DistanceController(CityService cityService, CarService carService, DistanceService distanceService, DriverService driverService, OrderService orderService) {
        this.cityService = cityService;
        this.carService = carService;
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.orderService = orderService;
    }
    @GetMapping("/user/home")
    public String showHome(Model model, @ModelAttribute("distance") Distance distance){
        model.addAttribute("cityList", cityService.findAll());
        return "user/user";
    }

    @PostMapping("/user/selectDistance")
    public String selectDistance(@ModelAttribute("distance") Distance distance, @ModelAttribute("totalPerson") int totalPerson, Model model){
        if(distance.getSource() == distance.getDestination()){
            return "user/source-destination-error";
        }
        try{
            Distance newDistance = distanceService.findBySourceAndDestination(distance.getSource(), distance.getDestination());
            return "redirect:/user/selectCar?distanceId="+newDistance.getId()+"&totalPerson="+totalPerson;
        }
        catch (RuntimeException e){
            return "redirect:/user/showErrorPage";
        }

    }
    //    This error page is for when distance is not set for particular source and destination in distance matrix
    @GetMapping("/user/showErrorPage")
    public String showErrorPage(){
        return "user/source-distance-notfound";
    }
}
