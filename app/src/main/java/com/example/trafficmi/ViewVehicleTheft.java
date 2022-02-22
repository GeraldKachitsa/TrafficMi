package com.example.trafficmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trafficmi.AdapterPackage.VehicleTheftAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewVehicleTheft extends AppCompatActivity {

    TextView tvView;
    RecyclerView recyclerView;
// Firebase database
    FirebaseDatabase root;
    DatabaseReference referenci;
    VehicleTheftAdapter vehicleTheftAdapter;
    ArrayList<VehicleTheftReport> dataValues;
    ArrayList<String> ls = new ArrayList<>();
    ArrayList <String> arrayl = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft);
        dataValues = new ArrayList<VehicleTheftReport>();
        root = FirebaseDatabase.getInstance();
        //referenci = root.getReference();
        //referenci = root.getReference(  "UpdatedVehicleRecords");


        // Read from the database

//        getData();
        referenci = FirebaseDatabase.getInstance().getReference().child("UpdatedVehicleRecords");
        referenci.orderByChild("nameOfVehicle").equalTo("Honda").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //data will be available on
                        if (dataSnapshot.exists()){
                            HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();

                            for (String key : dataMap.keySet()){

                                Object data = dataMap.get(key);

                                try{
                                    HashMap<String, Object> userData = (HashMap<String, Object>) data;
//                                    Toast.makeText(ViewVehicleTheft.this, userData.get("carName").toString(), Toast.LENGTH_SHORT).show();
//                                    tvView.setText(userData.get("carName").toString());
                                    VehicleTheftReport vehicleTheftReport = new VehicleTheftReport(userData.get("carName").toString(), userData.get("carColor").toString(), userData.get("vehicleRegNumber").toString());
                                    dataValues.add(new VehicleTheftReport("Car", "Color", "Reg num"));
//
                                }catch (ClassCastException cce){



                                    try{

                                        String mString = String.valueOf(dataMap.get(key));
//                                        addTextToView(mString);
                                        tvView.setText(mString);


                                    }catch (ClassCastException cce2){

                                    }
                                }

                            }
                        }
//

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        dataValues.add(new VehicleTheftReport("Mazda", "Red", "BK 435"));
//        dataValues.add(new VehicleTheftReport("Nissan", "Green", "BK 435"));
//        dataValues.add(new VehicleTheftReport("Honda", "White", "BK 435"));
//        dataValues.add(new VehicleTheftReport("Ranger", "Black", "BK 435"));

        tvView = (TextView) findViewById(R.id.tvView);
        recyclerView = findViewById(R.id.recycler_view_id);
        vehicleTheftAdapter = new VehicleTheftAdapter(getApplicationContext(), dataValues);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vehicleTheftAdapter);
        // Firebase initialisations
    }

//    private void getData() {
//
//        // calling add value event listener method
//        // for getting the values from database.
//        referenci = FirebaseDatabase.getInstance().getReference().child("UpdatedVehicleRecords");
//        referenci.orderByChild("nameOfVehicle").equalTo("Honda").addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        //data will be available on
//                        if (dataSnapshot.exists()){
//                            HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();
//
//                            for (String key : dataMap.keySet()){
//
//                                Object data = dataMap.get(key);
//
//                                try{
//                                    HashMap<String, Object> userData = (HashMap<String, Object>) data;
////
//                                            VehicleTheftReport vehicleTheftReport = new VehicleTheftReport(userData.get("carName").toString(), userData.get("carColor").toString(), userData.get("vehicleRegNumber").toString());
//                                            dataValues.add(new VehicleTheftReport("Car", "Color", "Reg num"));
////
//                                }catch (ClassCastException cce){
//
//
//
//                                    try{
//
//                                        String mString = String.valueOf(dataMap.get(key));
////                                        addTextToView(mString);
//                                        tvView.setText(mString);
//
//
//                                    }catch (ClassCastException cce2){
//
//                                    }
//                                }
//
//                            }
//                        }
////
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        //Log.w(TAG, "getUser:onCancelled", databaseError.toException());
//                    }
//                });
//    }
}
