package com.example.trafficmi.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trafficmi.HelpCenter;
import com.example.trafficmi.LogIn;
import com.example.trafficmi.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DriverOffence extends AppCompatActivity {
    private TextInputEditText fullNameOfDriver;
    private TextInputEditText driverLicenseNumber;
    private TextInputEditText driverOffenceLocation;
    EditText driverOffenceDescription;
    private Button updateDriverRecordsBtn;

    private TextView textView;
    FusedLocationProviderClient fusedLocationProviderClient;

    //toolBar
    Toolbar driverOffenceToolBar;

    //firebase database

    FirebaseDatabase root;
    DatabaseReference referenci;
    private Object FusedLocationProviderClient;

    RadioGroup radioGroup;
    RadioButton radioBtn;
    String sexHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_offence);
        fullNameOfDriver = (TextInputEditText) findViewById(R.id.vehicleRegNumber_id);
        driverLicenseNumber = (TextInputEditText) findViewById(R.id.carMake_id);
        driverOffenceLocation = (TextInputEditText) findViewById(R.id.car_name_id);
        driverOffenceDescription = (EditText) findViewById(R.id.otherDetails);
        driverOffenceToolBar = (Toolbar) findViewById(R.id.driverOffenceToolBar);
        textView = findViewById(R.id.textView1);
        radioGroup = findViewById(R.id.radioGroup);
        // fused location initialization
        FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        setSupportActionBar(driverOffenceToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateDriverRecordsBtn = (Button) findViewById(R.id.goToNextOffenceBtn);

        updateDriverRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permission
                if (ActivityCompat.checkSelfPermission(DriverOffence.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    //permission granted
                    getLocation();
                } else {
                    //when permission denied
                    ActivityCompat.requestPermissions(DriverOffence.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 12);
                }

                driverOffenceRecords();


            }
        });
    }

    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //initialize location

                Location location = task.getResult();
                if (location != null) {


                    try {

                        //initialize geocoder
                        Geocoder geocoder = new Geocoder(DriverOffence.this, Locale.getDefault());

                        //initialize address list
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 4
                        );
                        Toast.makeText(DriverOffence.this, "hie hie", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
   @Override
  public boolean onSupportNavigateUp(){
       onBackPressed();
      return true;
    }
   public void driverOffenceRecords(){
        //firebase Database
       int clickedRadioButton=radioGroup.getCheckedRadioButtonId();
       radioBtn = findViewById(clickedRadioButton);

       if (clickedRadioButton == -1){
            radioBtn.setError("Choose sex");
       }else{
          sexHolder = radioBtn.getText().toString();
       }

       root = FirebaseDatabase.getInstance();
       referenci = root.getReference();
        referenci = root.getReference(  "DriverOffences");

        String fullNameDriver = fullNameOfDriver.getText().toString().trim();
        if(fullNameDriver.isEmpty()){
           fullNameOfDriver.setError("Driver name cannot be empty");
        }else{
            fullNameOfDriver.setError("");

        }
        String driverLicense = driverLicenseNumber.getText().toString().trim();
       if(driverLicense.isEmpty()){
            driverLicenseNumber.setError("");
            driverLicenseNumber.setError("License number cannot be empty");
        }else{
            driverLicenseNumber.setError("");

        }
        String locationOfOffence = driverOffenceLocation.getText().toString().trim();
        if(locationOfOffence.isEmpty()){
            driverOffenceLocation.setError("");
            driverOffenceLocation.setError("address of driver cannot be empty");
        }

       String offenceDescription = driverOffenceDescription.getText().toString().trim();

       if (offenceDescription.isEmpty()) {
           // accidentDescription.setErrorEnabled(true);
           driverOffenceDescription.setError("Offence description cannot be empty");
       }


        else{

            //Writing to database
           com.example.trafficmi.DriverOffenceRecords driverOffenceRecords = new com.example.trafficmi.DriverOffenceRecords(fullNameDriver, driverLicense, locationOfOffence,offenceDescription, sexHolder);
            referenci.child(driverLicense).setValue(driverOffenceRecords);
           driverOffenceLocation.setError("");
           Toast.makeText(getApplicationContext(),
                    "Records Successfully updated",
                    Toast.LENGTH_LONG)
                   .show();
           fullNameOfDriver.setText("");
            driverLicenseNumber.setText("");
            driverOffenceLocation.setText("");
           driverOffenceDescription.setText("");
           startActivity( new Intent(this, DriverOffenseDetail.class));

        }
    }
}