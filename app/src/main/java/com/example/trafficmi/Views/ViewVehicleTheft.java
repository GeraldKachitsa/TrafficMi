package com.example.trafficmi.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.trafficmi.AdapterPackage.VehicleTheftAdapter;
import com.example.trafficmi.Model.ModelClass;
import com.example.trafficmi.R;
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
    FirebaseDatabase root = FirebaseDatabase.getInstance();
    DatabaseReference reference = root.getReference().child("VehicleTheftReport");

    VehicleTheftAdapter vehicleTheftAdapter;
    ArrayList<ModelClass> dataValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft);
        dataValues = new ArrayList<ModelClass>();

        recyclerView = findViewById(R.id.recycler_view_id);
        vehicleTheftAdapter = new VehicleTheftAdapter(this, dataValues);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vehicleTheftAdapter);
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
                                            dataValues.add(new ModelClass(userData.get("carName").toString(), userData.get("carColor").toString(), userData.get("vehicleRegNumber").toString()));
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
                    vehicleTheftAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
