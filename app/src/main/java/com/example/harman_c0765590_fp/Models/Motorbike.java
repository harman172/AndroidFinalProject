package com.example.harman_c0765590_fp.Models;

import androidx.annotation.NonNull;

public class Motorbike extends Vehicle {

    private boolean sideCar;

    public Motorbike(String model, String plateNumber, String color, Boolean sideCar) {
        super(model, plateNumber, color);
        this.sideCar = sideCar;
    }

    public boolean isSideCar() {
        return sideCar;
    }

    @NonNull
    @Override
    public String toString() {
        String str = "motorcycle\n" +
                "- Model: " + getModel() + "\n" +
                "- Plate: " + getPlateNumber() + "\n" +
                "- Color: " + getColor() + "\n" +
                (isSideCar() ? "- with a side car\n" : "- without a side car\n");
        return super.toString() + str;

    }
}
