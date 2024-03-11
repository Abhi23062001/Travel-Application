package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarDAOImpl implements CarDAO{
    private EntityManager entityManager;

    @Autowired
    public CarDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Car> findAll() {
        TypedQuery<Car> typedQuery =  entityManager.createQuery("FROM Car", Car.class);
        return typedQuery.getResultList();
    }

    @Override
    public Car findById(Integer id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public void Save(Car car) {
        entityManager.merge(car);
    }

    @Override
    public void delete(Car car) {
        entityManager.remove(car);
    }

    @Override
    public List<Car> findCarByDriverId(int driverId) {
        TypedQuery<Car> typedQuery = entityManager.createQuery("FROM Car WHERE driverId=:driverId", Car.class);
        typedQuery.setParameter("driverId", driverId);
        return typedQuery.getResultList();
    }

    @Override
    public void setDriverIdNull() {

    }
}
