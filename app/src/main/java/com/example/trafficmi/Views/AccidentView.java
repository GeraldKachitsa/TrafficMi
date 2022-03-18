package com.example.trafficmi.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.AdapterPackage.AccidentAdapter;
import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.R;
import com.example.trafficmi.ReportVehicleTheft;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class AccidentView extends AppCompatActivity {


    //Floating button initialization
    private FloatingActionButton accident_scene_fab_control;



    RecyclerView recyclerView;
    // Firebase database
    FirebaseDatabase root = FirebaseDatabase.getInstance();
    DatabaseReference reference = root.getReference().child("AccidentSceneRecords");

    AccidentAdapter accidentAdapter;
    ArrayList<AccidentSceneModel> dataValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_view);
        dataValues = new ArrayList<AccidentSceneModel>();

        recyclerView = findViewById(R.id.rec_accident);
        accidentAdapter = new AccidentAdapter(this, dataValues);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(accidentAdapter);


        //driver_offence_fab_control
        accident_scene_fab_control= findViewById(R.id.accident_scene_fab_control);

        //Add driver offences

        accident_scene_fab_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccidentView.this,  AccidentScene.class));
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
                            dataValues.add(new AccidentSceneModel(userData.get("vehicleRegNumber").toString(), userData.get("vehicleColor").toString(), userData.get("nameOfVehicle").toString()));
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
                    accidentAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}