package com.example.harman_c0765590_fp.Models;

import androidx.annotation.NonNull;

public class Programmer extends Employee {

    private int nbProjects;
    private final int GAIN_FACTOR_PROJECTS = 200;

    public Programmer(String empName, String empID, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbProjects) {
        super(empName, empID, birthYear, monthlySalary, rate, vehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    public double annualIncome() {
        double income =  super.annualIncome();
        return (income + (nbProjects * GAIN_FACTOR_PROJECTS));
    }


    @NonNull
    @Override
    public String toString() {
        String str = ", a Programmer\nAge: " + getAge() + "\n" +
                getVehicle().toString() +
                "Occupation rate: " + getRate() + "%\n" +
                "Annual Income: $" + String.format("%.2f",annualIncome()) + "\n" +
                "He/She has completed " + nbProjects+ " projects";
        return super.toString() + str;
    }
}
