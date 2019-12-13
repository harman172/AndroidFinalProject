package com.example.harman_c0765590_fp;


import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.harman_c0765590_fp.Models.Employee;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {

    public EmployeeAdapter(@NonNull Context context, int resource, List<Employee> employeeList) {
        super(context, resource);
    }
}
