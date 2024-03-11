package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderDAOImple implements OrderDAO{
    private EntityManager entityManager;

    public OrderDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> typedQuery = entityManager.createQuery("FROM Order", Order.class);
        return typedQuery.getResultList();
    }

    @Override
    public Order findById(Integer id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
