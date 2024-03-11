package com.astr.travelapp.service;

import com.astr.travelapp.dao.DriverDAO;
import com.astr.travelapp.entity.Car;
import com.astr.travelapp.entity.Driver;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverServiceImpl implements DriverService{
    private DriverDAO driverDAO;
    private CarService carService;

    public DriverServiceImpl(DriverDAO driverDAO, CarService carService) {
        this.driverDAO = driverDAO;
        this.carService = carService;
    }

    @Override
    public List<Driver> findAll() {
        return driverDAO.findAll();
    }

    @Override
    public Driver findById(Integer id) {
        return driverDAO.findById(id);
    }

    @Override
    @Transactional
    public Driver save(Driver driver) {
        return driverDAO.save(driver);
    }

    @Override
    @Transactional
    public void delete(Driver driver) {
        List<Car> carList = carService.getByDriverId(driver.getId());
        for (Car car:carList){
            car.setDriverId(null);
        }
        driverDAO.delete(driver);
    }
}
