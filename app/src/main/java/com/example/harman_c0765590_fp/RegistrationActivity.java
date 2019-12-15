package com.example.harman_c0765590_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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
    private Spinner spinnerEmpType, spinnerColor;
    private TextView tvEmp;
    private TableRow trWork, trCarType, trSideCar;

    private String fName, lName, empID, vehicleModel, plateNumber, color;
    private int birthYear, number;
    private float salary, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        getIDs();

        spinnerEmpType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    trWork.setVisibility(View.VISIBLE);

                    if (position == 1) {
                        tvEmp.setText("# clients");
                    } else if (position == 2) {
                        tvEmp.setText("# bugs");
                    } else if (position == 3) {
                        tvEmp.setText("# projects");
                    }
                } else {
                    trWork.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onRegistration(View view) {

        if (emptyFieldValidations()) {
            if (inputValidations()) {

                Employee emp = getData();

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("empDetails", emp);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show();
        }


    }

    public void vehicleSelected(View view) {
        switch (view.getId()) {
            case R.id.rb_car:
                trCarType.setVisibility(View.VISIBLE);
                trSideCar.setVisibility(View.GONE);
                break;
            case R.id.rb_motorbike:
                trSideCar.setVisibility(View.VISIBLE);
                trCarType.setVisibility(View.GONE);
        }
    }

    private void getIDs() {

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

        spinnerEmpType = findViewById(R.id.spinner_emp_type);
        spinnerColor = findViewById(R.id.spinner_color);

        tvEmp = findViewById(R.id.tv_emp);
        trWork = findViewById(R.id.tr_work);
        trCarType = findViewById(R.id.tr_car_type);
        trSideCar = findViewById(R.id.tr_sidecar);

    }

    private void getEditTextsData() {
        fName = etFirstName.getText().toString();
        lName = etLastName.getText().toString();
        birthYear = Integer.valueOf(etBirthYear.getText().toString());
        salary = Float.valueOf(etMonthlySalary.getText().toString());
        rate = Float.valueOf(etRate.getText().toString());
        empID = etEmpID.getText().toString();

        number = Integer.valueOf(etNumber.getText().toString());

        vehicleModel = etModel.getText().toString();
        plateNumber = etPlateNumber.getText().toString();
        color = spinnerColor.getSelectedItem().toString();
    }

    private Employee getData() {

        Vehicle selectedVehicle = new Vehicle(vehicleModel, plateNumber, color);

        switch (vehicleType.getCheckedRadioButtonId()) {

            case R.id.rb_car:

                String carType = etCarType.getText().toString();
                selectedVehicle = new Car(vehicleModel, plateNumber, color, carType);
                break;

            case R.id.rb_motorbike:

                if (rgSideCar.getCheckedRadioButtonId() == R.id.rb_sidecar_yes) {
                    selectedVehicle = new Motorbike(vehicleModel, plateNumber, color, true);
                } else if (rgSideCar.getCheckedRadioButtonId() == R.id.rb_sidecar_no) {
                    selectedVehicle = new Motorbike(vehicleModel, plateNumber, color, false);
                }

                break;
        }

        long empType = spinnerEmpType.getSelectedItemId();

        Employee employee = new Employee("", "", 0, 0, 0, null);

        if (empType == 1) {
            employee = new Manager(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);

        } else if (empType == 2) {
            employee = new Tester(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);
        } else if (empType == 3) {
            employee = new Programmer(fName + " " + lName, empID, birthYear, salary, rate, selectedVehicle, number);
        }

        return employee;
    }


    private boolean emptyFieldValidations() {

        boolean isValid = false;

        if (!etFirstName.getText().toString().isEmpty()) {
            if (!etLastName.getText().toString().isEmpty()) {
                if (!etBirthYear.getText().toString().isEmpty()) {
                    if (!etMonthlySalary.getText().toString().isEmpty()) {
                        if (!etRate.getText().toString().isEmpty()) {
                            if (!etEmpID.getText().toString().isEmpty()) {

                                if (spinnerEmpType.getSelectedItemPosition() > 0) {
                                    if (!etNumber.getText().toString().isEmpty()) {

                                        if (vehicleType.getCheckedRadioButtonId() != -1) {

                                            if (!etModel.getText().toString().isEmpty()) {
                                                if (!etPlateNumber.getText().toString().isEmpty()) {
                                                    if (spinnerColor.getSelectedItemPosition() > 0) {

                                                        if (trCarType.getVisibility() == View.VISIBLE) {
                                                            if (!etCarType.getText().toString().isEmpty()) {

                                                                isValid = true;
                                                            }
                                                        } else if (trSideCar.getVisibility() == View.VISIBLE) {
                                                            if (rgSideCar.getCheckedRadioButtonId() != -1) {

                                                                isValid = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return isValid;

    }

    private boolean inputValidations() {

        getEditTextsData();

        boolean alreadyExists = false;

        if (MainActivity.employeeList.size() > 0) {
            for (int i = 0; i < MainActivity.employeeList.size(); i++) {
                if (MainActivity.employeeList.get(i).getEmpID().equals(empID)) {
                    alreadyExists = true;
                    break;
                }
            }
        }

        if (birthYear > 1900 && birthYear < Employee.currentYear) {
            if (rate >= 10 && rate <= 100) {
                if (!alreadyExists) {
                    return true;
                } else {
                    makeToast("ID already exists. Try another.");
                    return false;
                }
            } else {
                makeToast("Occupation rate must be between 10 and 100");
                return false;
            }
        } else {
            makeToast("Birth year must be between 1900 and " + Employee.currentYear);
            return false;
        }
    }

    private void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
















