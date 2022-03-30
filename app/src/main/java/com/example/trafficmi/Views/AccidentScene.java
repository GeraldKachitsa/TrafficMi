package com.example.trafficmi.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trafficmi.HelpCenter;
import com.example.trafficmi.LogIn;
import com.example.trafficmi.Model.UpdatedVehicleRecords;
import com.example.trafficmi.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccidentScene extends AppCompatActivity {
    private TextInputLayout vehicleRegNumber, carColor, carMake, carName;
    EditText accidentSceneDescription;
    private Button updateVehicleRecordsBtn;
    private Toolbar accidentSceneToolBar;
    //firebase database

    FirebaseDatabase root;
    DatabaseReference referenci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accident_scene);

        vehicleRegNumber = (TextInputLayout) findViewById(R.id.vehicleRegNumber);
        carColor = (TextInputLayout) findViewById(R.id.carColor);
        carMake= (TextInputLayout) findViewById(R.id.carMake);
        carName = (TextInputLayout) findViewById(R.id.carName);
        accidentSceneDescription = (EditText) findViewById(R.id.driverOffenceDescription);
        //Tool bar

        accidentSceneToolBar = (Toolbar) findViewById(R.id.accidentSceneToolBar);

        //accidentSceneToolBar.setTitle("VEHICLE THEFT");
        setSupportActionBar(accidentSceneToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateVehicleRecordsBtn = (Button) findViewById(R.id.reportTheftBtn);
        updateVehicleRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateVehicleRecords();
            }
        });

    }

    //menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
// Handling menu items events

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.log_out:
                startActivity(new Intent(this, LogIn.class));
                return true;
            case R.id.help:
                startActivity(new Intent(this, HelpCenter.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Handling back button when pressed
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

//    @Override
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
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

        //offline capability
        referenci.keepSynced(true);


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

        }

        String accidentDescription = accidentSceneDescription.getText().toString().trim();

        if (accidentDescription.isEmpty()) {
           // accidentDescription.setErrorEnabled(true);
            accidentSceneDescription.setError("Accident description cannot be empty");
        }

        else {

            // Write to Database

            UpdatedVehicleRecords updatedVehicleRecords = new UpdatedVehicleRecords(nameOfCar, makeOfCar, colorOfCar, vehicleRegistrationNumber,accidentDescription);
            referenci.child(vehicleRegistrationNumber).setValue(updatedVehicleRecords);
            Toast.makeText(getApplicationContext(),
                    "Vehicle Records Successfully updated",
                    Toast.LENGTH_LONG)
                    .show();
            vehicleRegNumber.getEditText().setText("");
            carColor.getEditText().setText("");
            carMake.getEditText().setText("");
            carName.getEditText().setText("");
            accidentSceneDescription.setText("");
            startActivity(new Intent(this, AccidentView.class));


        }
    }
}