package com.astr.travelapp.service;

import com.astr.travelapp.entity.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {
    private CarService carService;

    public CarServiceImplTest(CarService carService) {
        this.carService = carService;
    }

    @Test
    void findById() {
        int carId = 2;
        Car car = new Car();
        car.setId(carId);
        car.setName("Car B");
        car.setModel("Model Y");
        car.setNumber("KA-02-5678");
        car.setStatus("A");
        car.setSeat(6);
        car.setDriverId(2);
        car.setCharge(13);
        assertEquals(car, carService.findById(carId));
    }
}