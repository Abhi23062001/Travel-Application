package com.astr.travelapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distance_matrix")
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "source_city_id")
    private int source;
    @Column(name = "destination_city_id")
    private int destination;
    @Column(name = "distance")
    private int distance;

    public Distance() {
    }

    public Distance(int source, int destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", distance=" + distance +
                '}';
    }
}
