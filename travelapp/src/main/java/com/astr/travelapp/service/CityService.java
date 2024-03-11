package com.astr.travelapp.service;

import com.astr.travelapp.entity.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City findById(Integer id);
}
