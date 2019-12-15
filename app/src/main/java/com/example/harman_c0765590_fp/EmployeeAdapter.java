package com.example.harman_c0765590_fp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.harman_c0765590_fp.Models.Employee;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {

    private Context context;
    private List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    //method to set search items list to adapter.

    public void setSearchList(List<Employee> searchList) {
        this.employeeList = searchList;
    }


    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_employee, null);
        }
        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvID = convertView.findViewById(R.id.tv_id);

        tvName.setText(employeeList.get(position).getEmpName());
        tvID.setText(employeeList.get(position).getEmpID());

        return convertView;
    }
}
