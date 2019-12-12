package com.example.harman_c0765590_fp.Models;

public class Car extends Vehicle {

    private String type;

    public Car(String model, String plateNumber, String color, String type) {
        super(model, plateNumber, color);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
