package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findAll();
    Car findById(Integer id);
    void Save(Car car);
    void delete(Car car);
    List<Car> findCarByDriverId(int driverId);
    void setDriverIdNull();

}
