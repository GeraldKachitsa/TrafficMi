package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccidentScene extends AppCompatActivity {
    TextInputLayout carRegNumber,licenseNumber,location;
    Button accidentSceneRecordsBtn;
    //firebase definition

    FirebaseDatabase root;
    DatabaseReference referenci2;

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_scene);

        //initializing views

        carRegNumber = (TextInputLayout) findViewById(R.id.carRegNumber);
        licenseNumber = (TextInputLayout) findViewById(R.id.licenseNumber);
        location = (TextInputLayout) findViewById(R.id.location);
        accidentSceneRecordsBtn = (Button)findViewById(R.id.accidentSceneRecordsBtn);

        //setting button listener


        accidentSceneRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //method to handle accident scene records
                handleAccidentSceneRecords();

            }
        });


    }


    //method to handle accident scene records

    public void handleAccidentSceneRecords() {

        //handling firebase

        root = FirebaseDatabase.getInstance();
        referenci2 = root.getReference();
        referenci2 = root.getReference(  "professionals");

        //getting text from input fields


        String carReg = carRegNumber.getEditText().getText().toString();
        String locationOfAccidentScene = location.getEditText().getText().toString();
        String DriverLicenseNumber= licenseNumber.getEditText().getText().toString();

        AccidentSceneRecords accidentScene = new AccidentSceneRecords(carReg,locationOfAccidentScene,DriverLicenseNumber);
        referenci2.setValue(accidentScene);

        //handling errors

        if(carReg.isEmpty()) {


            carRegNumber.setErrorEnabled(true);
            carRegNumber.setError("Please Provide Driver License number");

        }

        if(locationOfAccidentScene.isEmpty()){

            location.setErrorEnabled(true);
            location.setError("Please Provide Location of accident");



        }

        if(DriverLicenseNumber.isEmpty()) {

            licenseNumber.setErrorEnabled(true);
            licenseNumber.setError("Please Provide Driver License number");


        }else {


                Toast.makeText(getApplicationContext(),
                        "RECORDS RECORDED SUCCESSFULLY",
                        Toast.LENGTH_LONG)
                        .show();
            carRegNumber.getEditText().setText("");
            location.getEditText().setText("");
            licenseNumber.getEditText().setText("");
            }
        }

    }
