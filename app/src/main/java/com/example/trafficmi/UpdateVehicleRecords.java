package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateVehicleRecords extends AppCompatActivity {
    private TextInputLayout nameOfCarOwner, carColor, carMake, carName;
    private Button updateVehicleRecordsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehicle_records);

        nameOfCarOwner = (TextInputLayout) findViewById(R.id.nameOfCarOwner);
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
        String fullNameOfCar = nameOfCarOwner.getEditText().getText().toString().trim();

        if (fullNameOfCar.isEmpty()) {
            nameOfCarOwner.setErrorEnabled(true);
            nameOfCarOwner.setError("Name of a car cannot be empty");
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

            Toast.makeText(getApplicationContext(),
                    "Vehicle Records Successfully updated",
                    Toast.LENGTH_LONG)
                    .show();
            nameOfCarOwner.getEditText().setText("");
            carColor.getEditText().setText("");
            carMake.getEditText().setText("");
            carName.getEditText().setText("");


        }
    }
}