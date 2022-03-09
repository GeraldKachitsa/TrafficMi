package com.example.trafficmi.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.AdapterPackage.AccidentAdapter;
import com.example.trafficmi.AdapterPackage.DriverOffinceAdapter;
import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.Model.DriversOffence;
import com.example.trafficmi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class AccidentView extends AppCompatActivity {



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