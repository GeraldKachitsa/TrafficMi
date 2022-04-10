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
        driverName= findViewById(R.id.driversN);
        sex= findViewById(R.id.sexId);
        licenseNumber= findViewById(R.id.license);
        location= findViewById(R.id.location);
        otherDetails2 = findViewById(R.id.otherDetail);
//        lat = findViewById(R.id.lat);
//        longt = findViewById(R.id.longt);

        Intent intent = getIntent();
        driverName.setText("Driver's Name :" + " " + " " + intent.getStringExtra("driverName"));
        sex.setText("Sex :" + " " + " " + intent.getStringExtra("driverSex"));
        licenseNumber.setText("License Number :" + " " + " " + intent.getStringExtra("offenceDescription"));
        location.setText("Location :" + " " + " " + intent.getStringExtra("driverLicenseNumber"));
        otherDetails2.setText("Other Details :" + " " + " " + intent.getStringExtra("offenceLocation"));
//        lat.setText("Latitude :" + " " + " " + intent.getStringExtra("latitude"));
//        longt.setText("Longitude :" + " " + " " + intent.getStringExtra("longitude"));

    }
}