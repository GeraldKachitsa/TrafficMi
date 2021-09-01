package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InspectionChoice extends AppCompatActivity {
    private Button inspectDriverChoiceBtn;
    private Button inspectVehicleChoiceBtn;
    private Button accidentSceneChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_choice);

        inspectDriverChoiceBtn = (Button) findViewById(R.id.inspectDriverChoiceBtn);
        inspectDriverChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInspectDriver();
            }

        });
        inspectVehicleChoiceBtn = (Button) findViewById(R.id.updateVehicleRecordsChoiceBtn);
        inspectVehicleChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInspectVehicle();
            }
        });
        accidentSceneChoice = (Button) findViewById(R.id.accidentSceneChoice);
        accidentSceneChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAccidentScene();
            }
        });

    }
    public void goToInspectDriver(){

        startActivity(new Intent(this, InspectDriver.class));
    }


    public void goToInspectVehicle(){

        startActivity(new Intent(this, InspectVehicle2.class));

    }
    public void goToAccidentScene(){

        startActivity(new Intent(this, AccidentScene.class));
    }
}