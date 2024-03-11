package com.astr.travelapp.dao;

import com.astr.travelapp.entity.Distance;


import java.util.List;

public interface DistanceDAO {
    List<Distance> findAll();
    Distance findById(Integer id);

    Distance findBySourceAndDestination(int source, int destination);
}
