package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.trafficmi.Views.AccidentScene;
import com.example.trafficmi.Views.DriverOffence;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ChoiceOfWorkMenu extends AppCompatActivity {
    private Button driverOffenceBtn2;
    private Button accidentSceneBtn;
    private FloatingActionButton reportVehicleTheftBtn, reportDriverOffenceBtn,reportAccidentScene, viewReportstBtn;

    FloatingActionButton fab_control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_work_menu);


        driverOffenceBtn2= (Button) findViewById(R.id.driverOffenceBtn);

        accidentSceneBtn= (Button) findViewById(R.id.accidentSceneBtn);

//        reportVehicleTheftBtn = findViewById(R.id.reportVehicleTheftBtn);

        viewReportstBtn = findViewById(R.id.fab_control);
        reportAccidentScene = findViewById(R.id.fab_control_as);
        reportDriverOffenceBtn = findViewById(R.id.fab_control_do);
        reportVehicleTheftBtn = findViewById(R.id.fab_control_vt);

        reportAccidentScene.setVisibility(View.INVISIBLE);
        reportVehicleTheftBtn.setVisibility(View.INVISIBLE);
        reportDriverOffenceBtn.setVisibility(View.INVISIBLE);

        viewReportstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportAccidentScene.setVisibility(View.VISIBLE);
                reportVehicleTheftBtn.setVisibility(View.VISIBLE);
                reportDriverOffenceBtn.setVisibility(View.VISIBLE);
//                startActivity(new Intent(getApplicationContext(), ViewVehicleTheft.class));
            }
        });
//        driverOffenceBtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToUpdateDriverRecords();
//            }
//        });



//        accidentSceneBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToUpdateVehicleRecords();
//            }
//        });

//        viewReportstBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToReportVehicleTheft();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void goToUpdateDriverRecords() {
        startActivity(new Intent(this, DriverOffence.class));
    }

    public void goToUpdateVehicleRecords() {
        startActivity(new Intent(this, AccidentScene.class));
    }

    public void goToReportVehicleTheft() {
        startActivity(new Intent(this, ReportVehicleTheft.class));
    }
}


