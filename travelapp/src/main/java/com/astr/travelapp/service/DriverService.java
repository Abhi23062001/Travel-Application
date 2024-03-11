package com.astr.travelapp.service;

import com.astr.travelapp.entity.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> findAll();
    Driver findById(Integer id);
    Driver save(Driver driver);
    void delete(Driver driver);
}
