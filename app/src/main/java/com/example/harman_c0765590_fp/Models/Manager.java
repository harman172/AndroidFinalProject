package com.example.harman_c0765590_fp.Models;

public class Manager extends Employee {

    private int nbClients;

    public Manager(String empName, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbClients) {
        super(empName, birthYear, monthlySalary, rate, vehicle);
        this.nbClients = nbClients;
    }
}