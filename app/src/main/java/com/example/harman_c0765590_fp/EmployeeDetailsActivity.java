package com.example.harman_c0765590_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        TextView textView = findViewById(R.id.tv_details);

        // intent from MainActivity.

        Intent intent = getIntent();
        String details = intent.getExtras().getString("details");
        textView.setText(details);
    }
}
