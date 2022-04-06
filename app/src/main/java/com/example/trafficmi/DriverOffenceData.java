package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DriverOffenceData extends AppCompatActivity {
    TextView driverName,sex,licenseNumber,location,otherDetails2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_offence_data);
        driverName= findViewById(R.id.carNameTheft);
        sex= findViewById(R.id.carOwnerTheft);
        licenseNumber= findViewById(R.id.sexTheft);
        location= findViewById(R.id.carRegNumTheft);
        otherDetails2 = findViewById(R.id.carYearOfMakeTheft);

        Intent intent = getIntent();
        driverName.setText("Driver's Name :" + " " + " " + intent.getStringExtra("driverName"));
        sex.setText("Sex :" + " " + " " + intent.getStringExtra("driverSex"));
        licenseNumber.setText("License Number :" + " " + " " + intent.getStringExtra("driverLicenseNumber"));
        location.setText("Location :" + " " + " " + intent.getStringExtra("offenceLocation"));
        otherDetails2.setText("Other Details :" + " " + " " + intent.getStringExtra("offenceDescription"));

    }
}