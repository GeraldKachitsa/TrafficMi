package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trafficmi.Model.UpdatedVehicleRecords;
import com.example.trafficmi.Views.ViewVehicleTheft;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccidentScene extends AppCompatActivity {
    private TextInputLayout vehicleRegNumber, carColor, carMake, carName;
    private Button updateVehicleRecordsBtn;
    private Toolbar toolbar;

    //firebase database

    FirebaseDatabase root;
    DatabaseReference referenci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accident_scene);

        //toolbar

        toolbar = (Toolbar)findViewById(R.id.myToolBar);
        toolbar.setTitle("Accident Scene");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vehicleRegNumber = (TextInputLayout) findViewById(R.id.vehicleRegNumber);
        carColor = (TextInputLayout) findViewById(R.id.carColor);
        carMake= (TextInputLayout) findViewById(R.id.carMake);
        carName = (TextInputLayout) findViewById(R.id.carName);

        updateVehicleRecordsBtn = (Button) findViewById(R.id.reportTheftBtn);
        updateVehicleRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateVehicleRecords();
            }
        });


    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if yes,Exit
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if No, cancel and continue
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }


    public void updateVehicleRecords() {

        //firebase Database

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "AccidentSceneRecords");


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
            startActivity(new Intent(this, ViewVehicleTheft.class));


        }
    }
}