package com.example.harman_c0765590_fp.Models;

import androidx.annotation.NonNull;

public class Car extends Vehicle {

    private String type;

    public Car(String model, String plateNumber, String color, String type) {
        super(model, plateNumber, color);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @NonNull
    @Override
    public String toString() {
        String str = "car\n" +
                "- Model: " + getModel() + "\n" +
                "- Plate: " + getPlateNumber() + "\n" +
                "- Color: " + getColor() + "\n" +
                "- Type: " + getType() + "\n";
        return super.toString() + str;
    }
}
