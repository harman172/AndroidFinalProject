package com.example.harman_c0765590_fp.Models;

import androidx.annotation.NonNull;

public class Tester extends Employee {

    private int nbBugs;
    private final int GAIN_FACTOR_ERROR = 10;

    public Tester(String empName, String empID, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbBugs) {
        super(empName, empID, birthYear, monthlySalary, rate, vehicle);
        this.nbBugs = nbBugs;
    }

    @Override
    public double annualIncome() {
        double income = super.annualIncome();
        return (income + (nbBugs * GAIN_FACTOR_ERROR));
    }

    @NonNull
    @Override
    public String toString() {
        String str = ", a Tester \nAge: " + getAge() + "\n" +
                getVehicle().toString() +
                "Occupation rate: " + getRate() + "%\n" +
                "Annual Income: $" + String.format("%.2f", annualIncome()) + "\n" +
                "He/She has corrected " + nbBugs + " bugs";
        return super.toString() + str;
    }
}
