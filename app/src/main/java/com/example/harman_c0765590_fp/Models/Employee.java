package com.example.harman_c0765590_fp.Models;


import java.util.Calendar;

public class Employee {
    private String empName;
    private int birthYear, age;
    private float monthlySalary, rate;
    private Vehicle vehicle;


    int currentYear = Calendar.getInstance().get(Calendar.YEAR);


    public Employee(String empName, int birthYear, float monthlySalary, float rate, Vehicle vehicle) {
        this.empName = empName;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
        this.vehicle = vehicle;

        this.age = currentYear - birthYear;
    }

    public double annualIncome(){
        return (monthlySalary * 12) * rate;
    }

}
