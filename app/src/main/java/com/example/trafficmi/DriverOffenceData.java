package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DriverOffenceData extends AppCompatActivity {
    TextView carRegnum,nameOfCar,colorOfCar,yearOfMake,otherDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft_details);
        carRegnum= findViewById(R.id.driverName);
        nameOfCar= findViewById(R.id.sex);
        colorOfCar= findViewById(R.id.location);
        yearOfMake= findViewById(R.id.licenseNumber);
        otherDetails = findViewById(R.id.otherDetails2);

        Intent intent = getIntent();
        carRegnum.setText("Vehicle Registration Number:" + " " + " " + intent.getStringExtra("carRegnum"));
        nameOfCar.setText("Name of Car:" + " " + " " + intent.getStringExtra("nameOfCar"));
        colorOfCar.setText("color of Car:" + " " + " " + intent.getStringExtra("colorOfCar"));
        yearOfMake.setText("Car Year of Make:" + " " + " " + intent.getStringExtra("yearOfMake"));
        otherDetails.setText("Other Details:" + " " + " " + intent.getStringExtra("otherDetails"));

    }
}