package com.astr.travelapp.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "number")
    private String number;

    @Column(name = "seat")
    private int seat;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "status")
    private String status;
    @Column(name = "charge")
    private int charge;

    public Car() {
    }

    public Car(String name, String model, String number, int seat, Integer driverId, String status, int charge) {
        this.name = name;
        this.model = model;
        this.number = number;
        this.seat = seat;
        this.driverId = driverId;
        this.status = status;
        this.charge = charge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", seat=" + seat +
                ", driverId=" + driverId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getId() == car.getId() && getSeat() == car.getSeat() && getCharge() == car.getCharge() && Objects.equals(getName(), car.getName()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getNumber(), car.getNumber()) && Objects.equals(getDriverId(), car.getDriverId()) && Objects.equals(getStatus(), car.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModel(), getNumber(), getSeat(), getDriverId(), getStatus(), getCharge());
    }
}
