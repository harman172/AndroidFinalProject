package com.example.harman_c0765590_fp.Models;

public class Programmer extends Employee {

    private int nbProjects;

    public Programmer(String empName, int birthYear, float monthlySalary, float rate, Vehicle vehicle, int nbProjects) {
        super(empName, birthYear, monthlySalary, rate, vehicle);
        this.nbProjects = nbProjects;
    }
}
