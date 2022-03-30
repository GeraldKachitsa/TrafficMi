package com.example.trafficmi.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trafficmi.R;

public class ViewVehicleTheftDetails extends AppCompatActivity {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_theft_details);
        text1= findViewById(R.id.text1);
        Intent intent = getIntent();
        text1.setText(intent.getStringExtra("carRegnum"));
    }
}