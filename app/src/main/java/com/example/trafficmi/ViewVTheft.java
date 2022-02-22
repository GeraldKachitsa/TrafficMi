package com.example.trafficmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.trafficmi.AdapterPackage.VehicleTheftAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewVTheft extends AppCompatActivity {
    private RecyclerView recycler;
    private ArrayList<VehicleTheftReport> vData;
    private VehicleTheftAdapter vehicleTheftAdapter;
    FirebaseDatabase root;
    DatabaseReference referenci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_v_theft);
        recycler = findViewById(R.id.recycler_view_id2);

        root = FirebaseDatabase.getInstance();

        vData = new ArrayList<>();
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        vehicleTheftAdapter = new VehicleTheftAdapter(this, vData);

        // setting adapter to our recycler view.
        recycler.setAdapter(vehicleTheftAdapter);


//        root.getReference("Courses").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        // after getting the data we are calling on success method
//                        // and inside this method we are checking if the received
//                        // query snapshot is empty or not.
//                        if (!queryDocumentSnapshots.isEmpty()) {
//                            // if the snapshot is not empty we are
//                            // hiding our progress bar and adding
//                            // our data in a list.
////                            loadingPB.setVisibility(View.GONE);
//                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//                            for (DocumentSnapshot d : list) {
//                                // after getting this list we are passing
//                                // that list to our object class.
////                                Courses c = d.toObject(Courses.class);
//                                VehicleTheftReport c = d.toObject(VehicleTheftReport.class);
//                                // and we will pass this object class
//                                // inside our arraylist which we have
//                                // created for recycler view.
//                                vData.add(c);
//                            }
//                            // after adding the data to recycler view.
//                            // we are calling recycler view notifuDataSetChanged
//                            // method to notify that data has been changed in recycler view.
//                            vehicleTheftAdapter.notifyDataSetChanged();
//                        } else {
//                            // if the snapshot is empty we are displaying a toast message.
//                            Toast.makeText(this, "No data found in Database", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                // if we do not get any data or any error we are displaying
//                // a toast message that we do not get any data
//                Toast.makeText(ViewVTheft.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}