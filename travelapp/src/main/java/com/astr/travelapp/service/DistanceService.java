package com.astr.travelapp.service;

import com.astr.travelapp.entity.Distance;

import java.util.List;

public interface DistanceService {
    List<Distance> findAll();
    Distance findById(Integer id);

    Distance findBySourceAndDestination(int source, int destination);
}
