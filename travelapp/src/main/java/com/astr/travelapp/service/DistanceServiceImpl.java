package com.astr.travelapp.service;

import com.astr.travelapp.dao.DistanceDAO;
import com.astr.travelapp.entity.Distance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService{
    private DistanceDAO distanceDAO;

    public DistanceServiceImpl(DistanceDAO distanceDAO) {
        this.distanceDAO = distanceDAO;
    }

    @Override
    public List<Distance> findAll() {
        return distanceDAO.findAll();
    }

    @Override
    public Distance findById(Integer id) {
        return distanceDAO.findById(id);
    }

    @Override
    public Distance findBySourceAndDestination(int source, int destination) throws RuntimeException {
        return distanceDAO.findBySourceAndDestination(source, destination);
    }
}
