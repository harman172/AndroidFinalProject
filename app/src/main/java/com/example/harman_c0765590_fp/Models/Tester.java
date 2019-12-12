package com.example.harman_c0765590_fp.Models;

public class Tester extends Employee {

    private int nbBugs;
    private final int GAIN_FACTOR_ERROR = 10;

    public Tester(String empName, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbBugs) {
        super(empName, birthYear, monthlySalary, rate, vehicle);
        this.nbBugs = nbBugs;
    }

    @Override
    public double annualIncome() {
        double income = super.annualIncome();
        return (income + (nbBugs * GAIN_FACTOR_ERROR));
    }
}
