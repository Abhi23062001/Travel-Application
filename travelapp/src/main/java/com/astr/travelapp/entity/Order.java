package com.astr.travelapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "car_id")
    private int carId;
    @Column(name = "driver_id")
    private int driverId;
    @Column(name = "fare")
    private int fare;
    @Column(name = "distance_id")
    private int distanceId;
    @Column(name = "completed")
    private String completed;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_datetime")
    private String dateTime;

    public Order() {
    }

    public Order(String userId, int carId, int driverId, int fare, int distanceId, String completed) {
        this.userId = userId;
        this.carId = carId;
        this.driverId = driverId;
        this.fare = fare;
        this.distanceId = distanceId;
        this.completed = completed;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getDistanceId() {
        return distanceId;
    }

    public void setDistanceId(int distanceId) {
        this.distanceId = distanceId;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", driverId=" + driverId +
                ", fare=" + fare +
                ", distanceId=" + distanceId +
                ", completed='" + completed + '\'' +
                '}';
    }
}
