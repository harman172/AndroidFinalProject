package com.example.harman_c0765590_fp.Models;

public class Motorbike extends Vehicle {

    private boolean sideCar;

    public Motorbike(String model, String plateNumber, String color, Boolean sideCar) {
        super(model, plateNumber, color);
        this.sideCar = sideCar;
    }

    public boolean isSideCar() {
        return sideCar;
    }
}
