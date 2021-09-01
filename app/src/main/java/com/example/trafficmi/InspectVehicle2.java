package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class InspectVehicle2 extends AppCompatActivity {
    TextInputLayout inspectVehicleNumber;
    Button inspectVehicleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_vehicle2);

        inspectVehicleNumber = (TextInputLayout) findViewById(R.id.inspectVehicleNumber);
        inspectVehicleBtn = (Button) findViewById(R.id.inspectVehicleBtn);

        inspectVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyVehicle();
            }
        });

    }

   public void verifyVehicle() {

       String vehicleRegNumber = inspectVehicleNumber.getEditText().getText().toString().trim();
       if (vehicleRegNumber.isEmpty()) {

           inspectVehicleNumber.setErrorEnabled(true);
           inspectVehicleNumber.setError("Please Provide Vehicle Reg number");

       } else {

           inspectVehicleNumber.setErrorEnabled(false);
           Toast.makeText(getApplicationContext(),
                   "ALLOW VEHICLE TO PASS",
                   Toast.LENGTH_LONG)
                   .show();
           inspectVehicleNumber.getEditText().setText("");
       }
    }
}