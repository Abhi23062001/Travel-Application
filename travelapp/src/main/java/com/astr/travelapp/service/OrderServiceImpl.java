package com.astr.travelapp.service;

import com.astr.travelapp.dao.OrderDAO;
import com.astr.travelapp.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderDAO.save(order);
    }
}
