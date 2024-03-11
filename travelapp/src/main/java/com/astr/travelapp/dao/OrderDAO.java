package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Distance;
import com.astr.travelapp.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll();
    Order findById(Integer id);
    void save(Order order);
}
