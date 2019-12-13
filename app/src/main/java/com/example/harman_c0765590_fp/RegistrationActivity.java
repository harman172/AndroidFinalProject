package com.example.harman_c0765590_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.harman_c0765590_fp.Models.Car;
import com.example.harman_c0765590_fp.Models.Employee;
import com.example.harman_c0765590_fp.Models.Manager;
import com.example.harman_c0765590_fp.Models.Motorbike;
import com.example.harman_c0765590_fp.Models.Programmer;
import com.example.harman_c0765590_fp.Models.Tester;
import com.example.harman_c0765590_fp.Models.Vehicle;

public class RegistrationActivity extends AppCompatActivity {


    private EditText etFirstName, etLastName, etBirthYear, etMonthlySalary, etRate, etEmpID, etNumber;
    private EditText etCarType, etModel, etPlateNumber;
    private RadioGroup vehicleType, rgSideCar;
    private RadioButton rbCar, rbMotorbike, rbYes, rbNo;
    private Spinner spinnerEmpType, spinnerColor;
    private TextView tvEmp;
    private TableRow trWork, trCarType, trSideCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        getIDs();


        spinnerEmpType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0){
                    trWork.setVisibility(View.VISIBLE);

                    if (position == 1){
                        tvEmp.setText("# clients");
                    } else if (position == 2){
                        tvEmp.setText("# bugs");
                    } else if (position == 3){
                        tvEmp.setText("# projects");
                    }
                } else{
                    trWork.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void getData(){

        String fName = etFirstName.getText().toString();
        String lName = etLastName.getText().toString();
        int birthYear = Integer.valueOf(etBirthYear.getText().toString());
        float salary = Float.valueOf(etMonthlySalary.getText().toString());
        float rate = Float.valueOf(etRate.getText().toString());
        String empID = etEmpID.getText().toString();

        int number = Integer.valueOf(etNumber.getText().toString());


        String vehicleModel = etModel.getText().toString();
        String plateNumber = etPlateNumber.getText().toString();
        String color = spinnerColor.getSelectedItem().toString();

        Vehicle selectedVehicle = new Vehicle(vehicleModel, plateNumber, color);

        switch (vehicleType.getCheckedRadioButtonId()){

            case R.id.rb_car:

                String carType = etCarType.getText().toString();
                selectedVehicle = new Car(vehicleModel,plateNumber,color,carType);
                break;

            case R.id.rb_motorbike:

                if (rgSideCar.getCheckedRadioButtonId() == R.id.rb_sidecar_yes){
                    selectedVehicle = new Motorbike(vehicleModel, plateNumber, color, true);
                } else if (rgSideCar.getCheckedRadioButtonId() == R.id.rb_sidecar_no){
                    selectedVehicle = new Motorbike(vehicleModel, plateNumber, color, false);
                }

                break;
        }

        long empType = spinnerEmpType.getSelectedItemId();
        Log.i("empType", "onClick: " + empType);

        Employee employee;

        if (empType == 1){
            employee = new Manager(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);
            Employee.employeeList.add(employee);
        }
        else if (empType == 2){
            employee = new Tester(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);
            Employee.employeeList.add(employee);
        }
        else if (empType == 3){
            employee = new Programmer(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);
            Employee.employeeList.add(employee);
        }

    }

    public void onRegistration(View view){

        getData();
        

    }

    public void vehicleSelected(View view){
        switch (view.getId()){
            case R.id.rb_car:
                trCarType.setVisibility(View.VISIBLE);
                trSideCar.setVisibility(View.GONE);
                break;
            case R.id.rb_motorbike:
                trSideCar.setVisibility(View.VISIBLE);
                trCarType.setVisibility(View.GONE);
        }
    }

    private void getIDs(){

        etFirstName = findViewById(R.id.et_firstname);
        etLastName = findViewById(R.id.et_lastname);
        etBirthYear = findViewById(R.id.et_birthyear);
        etMonthlySalary = findViewById(R.id.et_salary);
        etRate = findViewById(R.id.et_rate);
        etEmpID = findViewById(R.id.et_id);
        etNumber = findViewById(R.id.et_number);
        etCarType = findViewById(R.id.et_car_type);
        etModel = findViewById(R.id.et_vehicle_model);
        etPlateNumber = findViewById(R.id.et_plate_number);

        vehicleType = findViewById(R.id.rg_vehicle_type);
        rgSideCar = findViewById(R.id.rg_sidecar);

        rbCar = findViewById(R.id.rb_car);
        rbMotorbike = findViewById(R.id.rb_motorbike);
        rbYes = findViewById(R.id.rb_sidecar_yes);
        rbNo = findViewById(R.id.rb_sidecar_no);

        spinnerEmpType = findViewById(R.id.spinner_emp_type);
        spinnerColor = findViewById(R.id.spinner_color);

        tvEmp = findViewById(R.id.tv_emp);
        trWork = findViewById(R.id.tr_work);
        trCarType = findViewById(R.id.tr_car_type);
        trSideCar = findViewById(R.id.tr_sidecar);

    }
}
