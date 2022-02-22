package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class ChoiceOfWorkMenu extends AppCompatActivity {
    private Button driverOffenceBtn2;
    private Button accidentSceneBtn;
    private Button reportVehicleTheftBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_work_menu);


        driverOffenceBtn2= (Button) findViewById(R.id.driverOffenceBtn);

        accidentSceneBtn= (Button) findViewById(R.id.accidentSceneBtn);

        reportVehicleTheftBtn = (Button) findViewById(R.id.reportVehicleTheftBtn);

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

        reportVehicleTheftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReportVehicleTheft();
            }
        });

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


