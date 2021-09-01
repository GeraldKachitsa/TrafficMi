package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class InspectDriver extends AppCompatActivity {
    TextInputLayout inspectDriverLicenseNumber;
    Button inspectDriverLicenseBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_driver);
        inspectDriverLicenseNumber = ( TextInputLayout) findViewById(R.id.inspectVehicleNumber);
        inspectDriverLicenseBtn = (Button) findViewById(R.id.inspectVehicleBtn);
        inspectDriverLicenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyLicense();
            }
        });

    }
    public void verifyLicense() {
        String driverLicenseNumber = inspectDriverLicenseNumber.getEditText().getText().toString().trim();
        if (driverLicenseNumber.isEmpty()) {

            inspectDriverLicenseNumber.setErrorEnabled(true);
            inspectDriverLicenseNumber.setError("Please Provide Driver License number");

        } else {

            inspectDriverLicenseNumber.setErrorEnabled(false);
            Toast.makeText(getApplicationContext(),
                    "ALLOW DRIVER TO PASS",
                    Toast.LENGTH_LONG)
                    .show();
            inspectDriverLicenseNumber.getEditText().setText("");
        }
    }
}

