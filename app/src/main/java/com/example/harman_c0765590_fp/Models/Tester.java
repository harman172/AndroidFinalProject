package com.example.harman_c0765590_fp.Models;

public class Tester extends Employee {

    private int nbBugs;

    public Tester(String empName, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbBugs) {
        super(empName, birthYear, monthlySalary, rate, vehicle);
        this.nbBugs = nbBugs;
    }
}
