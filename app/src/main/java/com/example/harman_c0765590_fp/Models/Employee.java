package com.example.harman_c0765590_fp.Models;


import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Employee implements Serializable {
    private String empName, empID;
    private int birthYear, age;
    private float monthlySalary, rate;
    private Vehicle vehicle;

    //arraylist

    public static int currentYear = Calendar.getInstance().get(Calendar.YEAR);

//    public static ArrayList<Employee> employeeList = new ArrayList<>();


    public Employee(String empName, String empID, int birthYear, float monthlySalary, float rate, Vehicle vehicle) {
        this.empName = empName;
        this.empID = empID;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
        this.vehicle = vehicle;

        this.age = currentYear - birthYear;
    }

    public double annualIncome(){
        return (monthlySalary * 12) * rate;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + empName;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpID() {
        return empID;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        return age;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public float getRate() {
        return rate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
