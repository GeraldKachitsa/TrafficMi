package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewVehicleTheft extends AppCompatActivity {

    TextView tvView;
// Firebase database
    FirebaseDatabase root;
    DatabaseReference referenci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft);

        tvView = (TextView) findViewById(R.id.tvView);


        // Firebase initialisations

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "UpdatedVehicleRecords").child("vehicleRegistrationNumber");

        //UpdatedVehicleRecords updatedVehicleRecords = new UpdatedVehicleRecords(nameOfCar, makeOfCar, colorOfCar, vehicleRegistrationNumber);
       // referenci.child(vehicleRegistrationNumber).setValue(updatedVehicleRecords);

        // Read from the database
        referenci.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = String.valueOf(dataSnapshot.child("make").getValue());
                tvView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                tvView.setText("Failed to read data");
            }
        });



    }
}