package com.example.harman_c0765590_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.harman_c0765590_fp.Models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView listView;
    private static List<Employee> employeeList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        listView = findViewById(R.id.emp_list);

        EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.adapter_employee,employeeList);
        listView.setAdapter(employeeAdapter);


        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("empDetails");

        if (employee != null){
            employeeList.add(employee);
            employeeAdapter.notifyDataSetChanged();

        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
