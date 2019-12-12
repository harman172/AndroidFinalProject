package com.example.harman_c0765590_fp.Models;

public class Vehicle {
    private String model, plateNumber, color;

    public Vehicle(String model, String plateNumber, String color) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getColor() {
        return color;
    }
}