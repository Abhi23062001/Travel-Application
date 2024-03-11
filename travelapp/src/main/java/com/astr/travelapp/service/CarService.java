package com.astr.travelapp.service;

import com.astr.travelapp.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(Integer id);
    void save(Car car);
    void delete(Car car);
    List<Car> getByDriverId(int driverId);
}
