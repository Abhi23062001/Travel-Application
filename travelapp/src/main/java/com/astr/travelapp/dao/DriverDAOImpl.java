package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DriverDAOImpl implements DriverDAO{
    public EntityManager entityManager;

    public DriverDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Driver> findAll() {
        TypedQuery<Driver> typedQuery = entityManager.createQuery("FROM Driver", Driver.class);
        return typedQuery.getResultList();
    }

    @Override
    public Driver findById(Integer id) {
        return entityManager.find(Driver.class, id);
    }

    @Override
    public Driver save(Driver driver) {
       return entityManager.merge(driver);
    }

    @Override
    public void delete(Driver driver) {
        entityManager.remove(driver);
    }
}
