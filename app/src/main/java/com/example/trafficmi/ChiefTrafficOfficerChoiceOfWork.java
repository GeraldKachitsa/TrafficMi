package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChiefTrafficOfficerChoiceOfWork extends AppCompatActivity {
    private Button accidentSceneBtn,  driverOffenceBtn,reportVehicleTheftBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chief_traffic_officer_choice_of_work);

        accidentSceneBtn = (Button) findViewById(R.id.driverOffenceBtn);

        reportVehicleTheftBtn = (Button) findViewById(R.id.reportVehicleTheftBtn);


        accidentSceneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUpdateDriverRecords();
            }
        });


        driverOffenceBtn= (Button) findViewById(R.id.accidentSceneBtn);
        driverOffenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUpdateVehicleRecords();
            }
        });

        reportVehicleTheftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReportVehicleTheft();
            }
        });

    }
    public void goToUpdateDriverRecords(){
        startActivity( new Intent(this,UpdateDriverRecords.class));
    }

    public void goToUpdateVehicleRecords(){
        startActivity( new Intent(this,UpdateVehicleRecords.class));
    }

    public void goToReportVehicleTheft(){
        startActivity( new Intent(this,ReportVehicleTheft.class));
    }


}