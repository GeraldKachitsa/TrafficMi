package com.example.trafficmi.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trafficmi.AdapterPackage.DriverOffinceAdapter;
import com.example.trafficmi.Model.DriversOffenceModel;
import com.example.trafficmi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverOffenseDetail extends AppCompatActivity {

    //Floating button initialization
    private FloatingActionButton driver_offence_fab_control;

    RecyclerView recyclerView;
    // Firebase database
    FirebaseDatabase root = FirebaseDatabase.getInstance();
    DatabaseReference reference = root.getReference().child("DriverOffences");

    DriverOffinceAdapter driverOffinceAdapter;
    ArrayList<DriversOffenceModel> dataValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_offense_detail);
        dataValues = new ArrayList<DriversOffenceModel>();

        recyclerView = findViewById(R.id.recycler_view);
        driverOffinceAdapter = new DriverOffinceAdapter(this, dataValues);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(driverOffinceAdapter);

        //driver_offence_fab_control
        driver_offence_fab_control = findViewById(R.id.accident_scene_fab_control);

        //Add driver offences

        driver_offence_fab_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverOffenseDetail.this, DriverOffence.class));
            }
        });
        // Firebase initialisations
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    HashMap<String, Object> dataMap = (HashMap<String, Object>) snapshot.getValue();

                    for (String key : dataMap.keySet()){

                        Object data = dataMap.get(key);

                        try{
                            HashMap<String, Object> userData = (HashMap<String, Object>) data;
//
                            dataValues.add(new DriversOffenceModel(userData.get("driverName").toString(), userData.get("driverOffenceLocation").toString(), userData.get("licenseNumber").toString()));
//
                        }catch (ClassCastException cce){


                            try{
//
//                                        String mString = String.valueOf(dataMap.get(key));
////
//                                        tvView.setText(mString);


                            }catch (ClassCastException cce2){

                            }
                        }

                    }
                    driverOffinceAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}