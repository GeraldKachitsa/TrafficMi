package com.example.trafficmi.Views;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.trafficmi.MainActivity;
import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AnalyticsClass extends AppCompatActivity {


    TextView offences, accident_id, vehicle_theft_id, sample_id;
    DatabaseReference driverOffences, accidentCases, vehicleTheftCases;
    Button for_location;
    List<Integer> forGraph;
    int countDriverOffences, countAccident, countVehicleTheft;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_class);

        driverOffences = FirebaseDatabase.getInstance().getReference().child("DriverOffences");
        accidentCases = FirebaseDatabase.getInstance().getReference().child("AccidentSceneRecords");
        vehicleTheftCases = FirebaseDatabase.getInstance().getReference().child("VehicleTheftReport");
        for_location = (Button) findViewById(R.id.for_location);
        //firebase offline capability
        driverOffences.keepSynced(true);
        accidentCases.keepSynced(true);
        vehicleTheftCases.keepSynced(true);


        offences = (TextView) findViewById(R.id.offences_id);
        accident_id = (TextView) findViewById(R.id.accident_id);
        vehicle_theft_id = (TextView) findViewById(R.id.vehicle_theft_id);
        sample_id = (TextView) findViewById(R.id.sample_id);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(AnalyticsClass.this);
//        for_location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(AnalyticsClass.this, permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//
//                    getLocation();
//                }else {
//                    ActivityCompat.requestPermissions(AnalyticsClass.this, new String[]{permission.ACCESS_FINE_LOCATION}, 50);
//                }
//            }
//
//        });


        driverOffences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    countDriverOffences = (int) snapshot.getChildrenCount();
                    offences.setText(Integer.toString(countDriverOffences));

                } else {
                    offences.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        accidentCases.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    countAccident = (int) snapshot.getChildrenCount();
                    accident_id.setText(Integer.toString(countAccident));


                } else {
                    accident_id.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        vehicleTheftCases.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    countVehicleTheft = (int) snapshot.getChildrenCount();
                    vehicle_theft_id.setText(Integer.toString(countVehicleTheft));

                } else {
                    vehicle_theft_id.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, Integer.parseInt(offences.getText().toString())),
//                new DataPoint(1, 21),
//                new DataPoint(2, 9),
//        });
//        graph.addSeries(series);
    }

//    private void getLocation() {
//
//        if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//
//            return;
//        }
//        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
//            @Override
//            public void onComplete(@NonNull Task<Location> task) {
//                Location location = task.getResult();
//
//                if (location != null) {
//                    Geocoder geocoder = new Geocoder(AnalyticsClass.this, Locale.getDefault());
//                    try {
//                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//                        sample_id.setText("Latitude : " + String.valueOf(addresses.get(0).getLatitude()) + " : Longtude : " + String.valueOf(addresses.get(0).getLatitude())+ " : Address : " + String.valueOf(addresses.get(0).getAddressLine(0)));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
}