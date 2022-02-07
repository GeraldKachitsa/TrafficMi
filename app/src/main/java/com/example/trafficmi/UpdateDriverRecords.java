package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateDriverRecords extends AppCompatActivity {
    private TextInputLayout fullNameOfDriver;
    private TextInputLayout driverLicenseNumber;
    private TextInputLayout driverAddress;
    private Button updateDriverRecordsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_driver_records);
        fullNameOfDriver = (TextInputLayout)findViewById(R.id.vehicleRegistrationNumber);
        driverLicenseNumber = (TextInputLayout)findViewById(R.id.licenseNumber);
        driverAddress = (TextInputLayout)findViewById(R.id.carRegNumber);
        updateDriverRecordsBtn = (Button)findViewById(R.id.goToNextOffenceBtn);
        updateDriverRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upDateDriverRecords();
            }
        });
    }
    public void upDateDriverRecords(){
        String fullNameDriver = fullNameOfDriver.getEditText().getText().toString().trim();
        if(fullNameDriver.isEmpty()){
            fullNameOfDriver.setErrorEnabled(true);
            fullNameOfDriver.setError("Driver name cannot be empty");
        }else{
            fullNameOfDriver.setErrorEnabled(false);

        }
        String driverLicense = driverLicenseNumber.getEditText().getText().toString().trim();
        if(driverLicense.isEmpty()){
            driverLicenseNumber.setErrorEnabled(true);
            driverLicenseNumber.setError("License number cannot be empty");
        }else{
            driverLicenseNumber.setErrorEnabled(false);

        }
        String addressOfDriver = driverAddress.getEditText().getText().toString().trim();
        if(addressOfDriver.isEmpty()){
            driverAddress.setErrorEnabled(true);
            driverAddress.setError("address of driver cannot be empty");
        }else{
            driverAddress.setErrorEnabled(false);
            Toast.makeText(getApplicationContext(),
                    "Records Successfully updated",
                    Toast.LENGTH_LONG)
                    .show();
            fullNameOfDriver.getEditText().setText("");
            driverLicenseNumber.getEditText().setText("");
            driverAddress.getEditText().setText("");
            startActivity( new Intent(this,DriverOffenseDetail.class));

        }
    }
}