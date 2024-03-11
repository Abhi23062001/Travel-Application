package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Car;
import com.astr.travelapp.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> findAll();
    City findById(Integer id);
    City save(City city);
}
