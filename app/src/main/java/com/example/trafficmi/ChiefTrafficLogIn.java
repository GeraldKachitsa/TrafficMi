package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class ChiefTrafficLogIn extends AppCompatActivity {
    private Button chiefTrafficOfficerSignInBtn;
    private TextInputLayout chiefTrafficOfficerUsername;
    private TextInputLayout chiefTrafficOfficerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chief_traffic_log_in);
        chiefTrafficOfficerSignInBtn = (Button) findViewById(R.id.chiefTrafficOfficerSignInBtn);
        chiefTrafficOfficerUsername = (TextInputLayout) findViewById(R.id.inspectVehicleNumber);
        chiefTrafficOfficerPassword = (TextInputLayout) findViewById(R.id.trafficOfficerPassword);
        chiefTrafficOfficerSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                goToChoiceOfWork();
            }
        });

    }

    public void goToChoiceOfWork() {
        String chiefTrafficOfficerUserName = chiefTrafficOfficerUsername.getEditText().getText().toString().trim();

        if (chiefTrafficOfficerUserName.isEmpty()) {
            chiefTrafficOfficerUsername.setErrorEnabled(true);
            chiefTrafficOfficerUsername.setError("Username cannot be empty");
        }
        String chiefTrafficOfficerPassWord = chiefTrafficOfficerPassword.getEditText().getText().toString().trim();
        if (chiefTrafficOfficerPassWord.isEmpty()) {
            chiefTrafficOfficerPassword.setErrorEnabled(true);
            chiefTrafficOfficerPassword.setError("Password cannot empty");
        } else {

            chiefTrafficOfficerUsername.setError("");
            chiefTrafficOfficerPassword.setError("");
            startActivity(new Intent(this, ChiefTrafficOfficerChoiceOfWork.class));
        }
    }
}