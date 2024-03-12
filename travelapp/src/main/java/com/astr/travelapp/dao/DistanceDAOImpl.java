package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Distance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DistanceDAOImpl implements DistanceDAO{
    private EntityManager entityManager;
    @Autowired
    public DistanceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Distance> findAll() {
        TypedQuery<Distance> typedQuery = entityManager.createQuery("FROM Distance ", Distance.class);
        return typedQuery.getResultList();
    }

    @Override
    public Distance findById(Integer id) {
        return entityManager.find(Distance.class, id);
    }

    @Override
    public Distance findBySourceAndDestination(int source, int destination) throws RuntimeException {
        TypedQuery<Distance> typedQuery = entityManager.createQuery("FROM Distance WHERE source=:source AND destination=:destination", Distance.class);
        typedQuery.setParameter("source", source);
        typedQuery.setParameter("destination", destination);
        Distance distance = typedQuery.getSingleResult();
        if (distance == null){
            throw new RuntimeException("source and destination does not exits");
        }
        return distance;
    }
}
