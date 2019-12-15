package com.example.harman_c0765590_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.harman_c0765590_fp.Models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Employee> employeeList = new ArrayList<>();
    private List<Employee> searchList;

    private EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btn_add);
        ListView listView = findViewById(R.id.emp_list);
        final EditText etSearch = findViewById(R.id.et_search);

        employeeAdapter = new EmployeeAdapter(this, employeeList);
        listView.setAdapter(employeeAdapter);


        final Intent intent = getIntent();
        final Employee employee = (Employee) intent.getSerializableExtra("empDetails");

        if (employee != null) {
            employeeList.add(employee);
            employeeAdapter.notifyDataSetChanged();

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent empDetailsIntent = new Intent(MainActivity.this, EmployeeDetailsActivity.class);

                if (!etSearch.getText().toString().isEmpty()) {
                    empDetailsIntent.putExtra("details", searchList.get(position).toString());
                } else {
                    empDetailsIntent.putExtra("details", employeeList.get(position).toString());
                }

                startActivity(empDetailsIntent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchList = new ArrayList<>();

                String text = s.toString();
                if (s.length() != 0) {

                    for (Employee employee : employeeList) {
                        if (employee.getEmpName().startsWith(text)) {

                            searchList.add(employee);
                        }
                    }
                } else {
                    searchList.addAll(employeeList);
                }

                employeeAdapter.setSearchList(searchList);
                employeeAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
