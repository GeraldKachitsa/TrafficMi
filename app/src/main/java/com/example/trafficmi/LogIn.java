package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trafficmi.Views.ChoiceOfWorkMenu;
import com.google.android.material.textfield.TextInputEditText;

public class LogIn extends AppCompatActivity {
    private Button chiefTrafficOfficerSignInBtn;
    private TextInputEditText chiefTrafficOfficerUsername;
    private TextInputEditText chiefTrafficOfficerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        chiefTrafficOfficerSignInBtn = (Button) findViewById(R.id.chiefTrafficOfficerSignInBtn);
        chiefTrafficOfficerUsername = (TextInputEditText) findViewById(R.id.username);
        chiefTrafficOfficerPassword = (TextInputEditText) findViewById(R.id.password);
        chiefTrafficOfficerSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                goToChoiceOfWork();
            }
        });

    }

    public void goToChoiceOfWork() {
        String chiefTrafficOfficerUserName = chiefTrafficOfficerUsername.getText().toString().trim();

        if (chiefTrafficOfficerUserName.isEmpty()) {

//            chiefTrafficOfficerUsername.setError("Username cannot be empty");
        }
        String chiefTrafficOfficerPassWord = chiefTrafficOfficerPassword.getText().toString().trim();
        if (chiefTrafficOfficerPassWord.isEmpty()) {
//            chiefTrafficOfficerPassword.setError("Password cannot empty");
        } else {

//            chiefTrafficOfficerUsername.setError("");
//            chiefTrafficOfficerPassword.setError("");
            startActivity(new Intent(this, ChoiceOfWorkMenu.class));

        }
    }
}