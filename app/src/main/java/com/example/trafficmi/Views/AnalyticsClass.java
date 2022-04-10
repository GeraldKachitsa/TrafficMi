package com.example.trafficmi.Views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyticsClass extends AppCompatActivity {


    TextView offences, accident_id, vehicle_theft_id;
    DatabaseReference driverOffences, accidentCases, vehicleTheftCases;

    List<Integer> forGraph;
    int countDriverOffences, countAccident, countVehicleTheft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_class);

        driverOffences = FirebaseDatabase.getInstance().getReference().child("DriverOffences");
        accidentCases = FirebaseDatabase.getInstance().getReference().child("AccidentSceneRecords");
        vehicleTheftCases = FirebaseDatabase.getInstance().getReference().child("VehicleTheftReport");
        driverOffences.keepSynced(true);
        accidentCases.keepSynced(true);
        vehicleTheftCases.keepSynced(true);


        offences = (TextView) findViewById(R.id.offences_id);
        accident_id = (TextView) findViewById(R.id.accident_id);
        vehicle_theft_id = (TextView) findViewById(R.id.vehicle_theft_id);



        driverOffences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    countDriverOffences = (int) snapshot.getChildrenCount();
                    offences.setText(Integer.toString(countDriverOffences));

                }else {
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

                if (snapshot.exists()){
                    countAccident = (int) snapshot.getChildrenCount();
                    accident_id.setText(Integer.toString(countAccident));


                }else {
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

                if (snapshot.exists()){
                    countVehicleTheft = (int) snapshot.getChildrenCount();
                    vehicle_theft_id.setText(Integer.toString(countVehicleTheft));

                }else {
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
}