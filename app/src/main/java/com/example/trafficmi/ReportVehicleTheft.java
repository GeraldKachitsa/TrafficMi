package com.example.trafficmi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trafficmi.Model.VehicleTheftReport;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportVehicleTheft extends AppCompatActivity  {

    //toolBar
    Toolbar vehicleTheftToolBar;

    TextInputEditText carName;
    TextInputEditText carMake;
    TextInputEditText carColor;
    TextInputEditText vehicleRegNumber;
    TextInputEditText vehicle_blue_book;
    Button reportTheftBtn;
    Button searchBtn;
    RecyclerView recyclerView;



    //FirebaseDatabase
    FirebaseDatabase root;
    DatabaseReference referenci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_vehicle_theft);

//        //Initializations
        carName = (TextInputEditText) findViewById(R.id.car_name);
        carMake = (TextInputEditText) findViewById(R.id.car_make);
        carColor = (TextInputEditText) findViewById(R.id.car_color);
        vehicleRegNumber = (TextInputEditText) findViewById(R.id.reg_num);
        vehicle_blue_book = (TextInputEditText) findViewById(R.id.blue_book);
        reportTheftBtn = (Button) findViewById(R.id.reportTheftBtn);

        searchBtn = findViewById(R.id.action_search);
        recyclerView = findViewById(R.id.recycler_view_id);



        //Tool bar

        vehicleTheftToolBar = (Toolbar) findViewById(R.id.vehicleTheftToolBar);

       //vehicleTheftToolBar.setTitle("VEHICLE THEFT");
        setSupportActionBar(vehicleTheftToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reportTheftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToViewVehicleTheft();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vehicle_theft_menu, menu);
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
    private void goToViewVehicleTheft() {

        //firebase Database

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "VehicleTheftReport");


        String fullNameCar = carName.getText().toString().trim();
        if(fullNameCar.isEmpty()){

//            carName.setError("Driver name cannot be empty");
        }else{
//            carName.setError("");

        }
        String makeOfCar = carMake.getText().toString().trim();
        if(makeOfCar.isEmpty()){

//            carMake.setError("make cannot be empty");
        }else{
//            carMake.setError("");

        }

        String colorOfVehicle = carColor.getText().toString().trim();
        if(colorOfVehicle.isEmpty()){

//            carColor.setError("color cannot be empty");
        }else{
//            carColor.setError("");

        }

        String regNumberOfVehicle = vehicleRegNumber.getText().toString().trim();
        if(regNumberOfVehicle.isEmpty()){

//            vehicleRegNumber.setError("vehicle reg number cannot be empty");
        }else{
//            vehicleRegNumber.setError("");

        }
        String blueBookOfVehicle =  vehicle_blue_book.getText().toString().trim();
        if(blueBookOfVehicle.isEmpty()){

//            vehicle_blue_book .setError("blue book cannot be empty");
        }else{

            //Writing to database
            //Writing to database
            VehicleTheftReport vehicleTheftReport = new VehicleTheftReport( fullNameCar, makeOfCar, colorOfVehicle, regNumberOfVehicle, blueBookOfVehicle);
            referenci.child(regNumberOfVehicle).setValue(vehicleTheftReport);
            Toast.makeText(getApplicationContext(), "Reported Successfully...", Toast.LENGTH_LONG).show();

            carName.setText("");
            carMake.setText("");
            carColor.setText("");
            vehicleRegNumber.setText("");
            vehicle_blue_book.setText("");
//            startActivity( new Intent(this, ViewVehicleTheft.class));


//            startActivity( new Intent(this,DriverOffenseDetail.class));

        }
    }

}
