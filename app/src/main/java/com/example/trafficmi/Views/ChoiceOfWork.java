package com.example.trafficmi.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import static com.example.trafficmi.R.menu.menu;


//public class ChoiceOfWork extends AppCompatActivity {
//    private Button accidentSceneBtn,  driverOffenceBtn,reportVehicleTheftBtn;
//    private Toolbar my_toolbar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.choice_of_work);
//
//        //  showing toolbar
//        my_toolbar = (Toolbar)findViewById(R.id.myToolBar);
//        my_toolbar.setTitle("Work to Perform");
//        setSupportActionBar(my_toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        accidentSceneBtn = (Button) findViewById(R.id.driverOffenceBtn);
//
//        reportVehicleTheftBtn = (Button) findViewById(R.id.reportVehicleTheftBtn);
//
//
//        accidentSceneBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToUpdateDriverRecords();
//            }
//        });
//
//
//        driverOffenceBtn= (Button) findViewById(R.id.accidentSceneBtn);
//        driverOffenceBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToUpdateVehicleRecords();
//            }
//        });
//
//        reportVehicleTheftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToReportVehicleTheft();
//            }
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return true;
//    }
//    public void goToUpdateDriverRecords(){
//        startActivity( new Intent(this, DriverOffence.class));
//    }
//
//    public void goToUpdateVehicleRecords(){
//        startActivity( new Intent(this, AccidentScene.class));
//    }
//
//    public void goToReportVehicleTheft(){
//        startActivity( new Intent(this,ReportVehicleTheft.class));
//    }
//
//
//}