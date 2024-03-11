package com.astr.travelapp.dao;


import com.astr.travelapp.entity.Driver;

import java.util.List;

public interface DriverDAO {
    List<Driver> findAll();
    Driver findById(Integer id);
    Driver save(Driver driver);
    void delete(Driver driver);
}
