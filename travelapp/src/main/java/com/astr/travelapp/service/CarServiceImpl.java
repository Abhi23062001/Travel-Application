package com.astr.travelapp.service;

import com.astr.travelapp.dao.CarDAO;
import com.astr.travelapp.entity.Car;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CarServiceImpl implements CarService{
    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> findAll() {
        return carDAO.findAll();
    }

    @Override
    public Car findById(Integer id) {
        return carDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Car car) {
        carDAO.Save(car);
    }

    @Override
    @Transactional
    public void delete(Car car) {
        carDAO.delete(car);
    }

    @Override
    public List<Car> getByDriverId(int driverId) {
        return carDAO.findCarByDriverId(driverId);
    }
}
