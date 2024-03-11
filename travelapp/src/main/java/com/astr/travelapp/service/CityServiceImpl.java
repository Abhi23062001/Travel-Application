package com.astr.travelapp.service;

import com.astr.travelapp.dao.CityDAO;
import com.astr.travelapp.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService{
    private CityDAO cityDAO;

    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityDAO.findById(id);
    }
}
