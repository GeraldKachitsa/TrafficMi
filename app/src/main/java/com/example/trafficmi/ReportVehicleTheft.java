package com.example.trafficmi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportVehicleTheft extends AppCompatActivity  {

    Button accidentSceneRecordsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_vehicle_theft);
        accidentSceneRecordsBtn = (Button) findViewById(R.id.accidentSceneRecordsBtn);
        accidentSceneRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToViewVehicleTheft();
            }
        });

    }

    private void goToViewVehicleTheft() {
        startActivity( new Intent(this, ViewVehicleTheft.class));
    }
}
