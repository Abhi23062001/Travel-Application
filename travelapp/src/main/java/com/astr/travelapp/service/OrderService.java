package com.astr.travelapp.service;

import com.astr.travelapp.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Integer id);
    void save(Order order);
}
