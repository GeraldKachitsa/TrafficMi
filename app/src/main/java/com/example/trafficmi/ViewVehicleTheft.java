package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewVehicleTheft extends AppCompatActivity {
// Firebase database
    FirebaseDatabase root;
    DatabaseReference referenci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft);


        // Firebase initialisations

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "UpdatedVehicleRecords");

        //UpdatedVehicleRecords updatedVehicleRecords = new UpdatedVehicleRecords(nameOfCar, makeOfCar, colorOfCar, vehicleRegistrationNumber);
       // referenci.child(vehicleRegistrationNumber).setValue(updatedVehicleRecords);



    }
}