package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Car;
import com.astr.travelapp.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CityDAOImpl implements CityDAO{
    private EntityManager entityManager;

    @Autowired
    public CityDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<City> findAll() {
        TypedQuery<City> typedQuery =  entityManager.createQuery("FROM City", City.class);
        return typedQuery.getResultList();
    }

    @Override
    public City findById(Integer id) {
        return entityManager.find(City.class, id);
    }

    @Override
    public City save(City city) {
        return entityManager.merge(city);
    }
}
