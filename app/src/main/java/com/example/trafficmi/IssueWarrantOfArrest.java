package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class IssueWarrantOfArrest extends AppCompatActivity {
    Button issueWarrantBtn;
    EditText editTextTextMultiLine;
    TextInputLayout nameOfDriverWarrantOfArrest, warrantOfArrestLicenseNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isue_warrant_of_arrest);
        nameOfDriverWarrantOfArrest = (TextInputLayout) findViewById(R.id.inspectVehicleNumber);
        warrantOfArrestLicenseNumber = (TextInputLayout) findViewById(R.id.warrantOfArrestLicenseNumber);
        editTextTextMultiLine = (EditText) findViewById(R.id.editTextTextMultiLine);
        issueWarrantBtn = (Button) findViewById(R.id.issueWarrantBtn);
        issueWarrantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueWarrantOfArrest();
            }

        });
    }

    public void issueWarrantOfArrest() {

        String warrantOfArrestDriverName = nameOfDriverWarrantOfArrest.getEditText().getText().toString().trim();

        if (warrantOfArrestDriverName.isEmpty()) {
            nameOfDriverWarrantOfArrest.setErrorEnabled(true);
            nameOfDriverWarrantOfArrest.setError("Name of driver cannot be empty");
        } else {
            nameOfDriverWarrantOfArrest.setError("");
            nameOfDriverWarrantOfArrest.getEditText().setText("");


        }
        String licenseNumberWarrantOfArrest = warrantOfArrestLicenseNumber.getEditText().getText().toString().trim();
        if (licenseNumberWarrantOfArrest.isEmpty()) {
            warrantOfArrestLicenseNumber.setErrorEnabled(true);
            warrantOfArrestLicenseNumber.setError("License number cannot be empty");
        }else{

            warrantOfArrestLicenseNumber.setErrorEnabled(false);
            warrantOfArrestLicenseNumber.getEditText().setText("");
            editTextTextMultiLine.setText("");
        }
        if(!(warrantOfArrestDriverName.isEmpty()|licenseNumberWarrantOfArrest.isEmpty()))
            Toast.makeText(getApplicationContext(),
                    "Warrant Successfully Issued",
                    Toast.LENGTH_LONG)
                    .show();
    }
}