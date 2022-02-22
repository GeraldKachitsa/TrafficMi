package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverOffence extends AppCompatActivity {
    private TextInputLayout fullNameOfDriver;
    private TextInputLayout driverLicenseNumber;
    private TextInputLayout driverOffenceLocation;
    private Button updateDriverRecordsBtn;
    Toolbar toolbar;

    //firebase database

    FirebaseDatabase root;
    DatabaseReference referenci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_offence);
        fullNameOfDriver = (TextInputLayout)findViewById(R.id.vehicleRegNumber);
        driverLicenseNumber = (TextInputLayout)findViewById(R.id.carMake);
        driverOffenceLocation = (TextInputLayout)findViewById(R.id.carName);



        //  showing toolbar
        toolbar = ( Toolbar)findViewById(R.id.myToolBar);
        toolbar.setTitle("Driver Offences");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateDriverRecordsBtn = (Button)findViewById(R.id.goToNextOffenceBtn);
        updateDriverRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driverOffenceRecords();
            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
   @Override
  public boolean onSupportNavigateUp(){
       onBackPressed();
      return true;
    }
    public void driverOffenceRecords(){

        //firebase Database

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "DriverOffences");


        String fullNameDriver = fullNameOfDriver.getEditText().getText().toString().trim();
        if(fullNameDriver.isEmpty()){
            fullNameOfDriver.setErrorEnabled(true);
            fullNameOfDriver.setError("Driver name cannot be empty");
        }else{
            fullNameOfDriver.setErrorEnabled(false);

        }
        String driverLicense = driverLicenseNumber.getEditText().getText().toString().trim();
        if(driverLicense.isEmpty()){
            driverLicenseNumber.setErrorEnabled(true);
            driverLicenseNumber.setError("License number cannot be empty");
        }else{
            driverLicenseNumber.setErrorEnabled(false);

        }
        String locationOfOffence = driverOffenceLocation.getEditText().getText().toString().trim();
        if(locationOfOffence.isEmpty()){
            driverOffenceLocation.setErrorEnabled(true);
            driverOffenceLocation.setError("address of driver cannot be empty");
        }else{

            //Writing to database
            DriverOffenceRecords driverOffenceRecords = new DriverOffenceRecords(fullNameDriver, driverLicense, locationOfOffence);
            referenci.child(driverLicense).setValue(driverOffenceRecords);
            driverOffenceLocation.setErrorEnabled(false);
            Toast.makeText(getApplicationContext(),
                    "Records Successfully updated",
                    Toast.LENGTH_LONG)
                    .show();
            fullNameOfDriver.getEditText().setText("");
            driverLicenseNumber.getEditText().setText("");
            driverOffenceLocation.getEditText().setText("");
            startActivity( new Intent(this,DriverOffenseDetail.class));

        }
    }
}