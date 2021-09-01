package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button chiefTrafficOfficerLogInBtn, trafficOfficerHomeLogInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chiefTrafficOfficerLogInBtn = (Button) findViewById(R.id.chiefTrafficOfficerLogInBtn);

        trafficOfficerHomeLogInBtn = (Button) findViewById(R.id.trafficOfficerHomeLogInBtn);

       chiefTrafficOfficerLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChiefTrafficLogIn.class);
                startActivity(intent);

            }
       });
       trafficOfficerHomeLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View v) {
               Intent intent1 = new Intent(MainActivity.this, TrafficOfficerLogIn.class);
               startActivity(intent1);

            }
        });


    }

}