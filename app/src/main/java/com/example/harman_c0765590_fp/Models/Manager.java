package com.example.harman_c0765590_fp.Models;

public class Manager extends Employee {

    private int nbClients;
    private final int GAIN_FACTOR_CLIENT = 500;


    public Manager(String empName, String empID, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbClients) {
        super(empName, empID, birthYear, monthlySalary, rate, vehicle);
        this.nbClients = nbClients;
    }


    @Override
    public double annualIncome() {
        double income = super.annualIncome();
        return (income + (nbClients * GAIN_FACTOR_CLIENT));
    }
}
