package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class TrafficOfficerLogIn extends AppCompatActivity {
    private Button trafficOfficerLogInBtn;
    private TextInputLayout trafficOfficerUserName;
    private TextInputLayout trafficOfficerPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_officer_log_in);

        trafficOfficerLogInBtn = (Button) findViewById(R.id.trafficOfficerLogInBtn);
        trafficOfficerUserName = (TextInputLayout) findViewById(R.id.inspectVehicleNumber);
        trafficOfficerPassword = (TextInputLayout) findViewById(R.id.trafficOfficerPassword);

        trafficOfficerLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInspectionChoice();
            }
        });


    }public void goToInspectionChoice(){
        String trafficOfficerUserNameLogIn = trafficOfficerUserName.getEditText().getText().toString().trim();

        if (trafficOfficerUserNameLogIn.isEmpty()) {
            trafficOfficerUserName.setErrorEnabled(true);
            trafficOfficerUserName.setError("Username cannot be empty");
        }
        String trafficOfficerPassWrd = trafficOfficerPassword.getEditText().getText().toString().trim();
        if (trafficOfficerPassWrd.isEmpty()) {
            trafficOfficerPassword.setErrorEnabled(true);
            trafficOfficerPassword.setError("Password cannot empty");
        } else {

            trafficOfficerUserName.setError("");
            trafficOfficerPassword.setError("");
            startActivity(new Intent(this,InspectionChoice.class));
        }


    }
}