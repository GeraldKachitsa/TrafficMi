package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateVehicleRecords extends AppCompatActivity {
    private TextInputLayout vehicleRegNumber, carColor, carMake, carName;
    private Button updateVehicleRecordsBtn;

    //firebase database

    FirebaseDatabase root;
    DatabaseReference referenci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehicle_records);

        vehicleRegNumber = (TextInputLayout) findViewById(R.id.vehicleRegistrationNumber);
        carColor = (TextInputLayout) findViewById(R.id.location);
        carMake= (TextInputLayout) findViewById(R.id.licenseNumber);
        carName = (TextInputLayout) findViewById(R.id.carRegNumber);

        updateVehicleRecordsBtn = (Button) findViewById(R.id.accidentSceneRecordsBtn);
        updateVehicleRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateVehicleRecords();
            }
        });


    }

    public void updateVehicleRecords() {

        //firebase Database

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "UpdatedVehicleRecords");


        String vehicleRegistrationNumber = vehicleRegNumber.getEditText().getText().toString().trim();

        if (vehicleRegistrationNumber.isEmpty()) {
            vehicleRegNumber.setErrorEnabled(true);
            vehicleRegNumber.setError("Name of a car cannot be empty");
        }

        String colorOfCar = carColor.getEditText().getText().toString().trim();
        if(colorOfCar.isEmpty()){
            carColor.setErrorEnabled(true);
            carColor.setError("Color of a car cannot be empty");
        }
        String makeOfCar = carMake.getEditText().getText().toString().trim();
        if(makeOfCar.isEmpty()){
            carMake.setErrorEnabled(true);
            carMake.setError("Make of a car cannot be empty");
        }
        String nameOfCar = carName.getEditText().getText().toString().trim();
        if(nameOfCar.isEmpty()){
            carName.setErrorEnabled(true);
            carName.setError("Name of a car cannot be empty");
        }else {

            // Write to Database


            UpdatedVehicleRecords updatedVehicleRecords = new UpdatedVehicleRecords(nameOfCar, makeOfCar, colorOfCar, vehicleRegistrationNumber);
            referenci.child(vehicleRegistrationNumber).setValue(updatedVehicleRecords);


            Toast.makeText(getApplicationContext(),
                    "Vehicle Records Successfully updated",
                    Toast.LENGTH_LONG)
                    .show();
            vehicleRegNumber.getEditText().setText("");
            carColor.getEditText().setText("");
            carMake.getEditText().setText("");
            carName.getEditText().setText("");


        }
    }
}