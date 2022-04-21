package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trafficmi.Views.ChoiceOfWorkMenu;
import com.example.trafficmi.Model.LogInModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogIn extends AppCompatActivity {
    private Button chiefTrafficOfficerSignInBtn, graphButton,buttonScanner,location, smsButton;
    private TextInputEditText chiefTrafficOfficerUsername;
    private TextInputEditText chiefTrafficOfficerPassword;

    //database
    FirebaseDatabase root;
    DatabaseReference referenci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        chiefTrafficOfficerSignInBtn = (Button) findViewById(R.id.chiefTrafficOfficerSignInBtn);
        chiefTrafficOfficerUsername = (TextInputEditText) findViewById(R.id.username);
        chiefTrafficOfficerPassword = (TextInputEditText) findViewById(R.id.password);
        graphButton = (Button)findViewById(R.id.graphButton);
        buttonScanner = findViewById(R.id.buttonScanner);
        smsButton = findViewById(R.id.smsButton);
        location = findViewById(R.id.location);


        chiefTrafficOfficerSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                goToChoiceOfWork();
            }
        });

        //Setting events to view graph button

        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               viewGraphicData();
            }
        });
        buttonScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSMS();
            }
        });


            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    viewAccidentLocation();
                }
            });
    }

    private void sendSMS() {

        Intent intent = new Intent(this,DemoSms.class);
        startActivity(intent);
    }

    private void viewAccidentLocation() {
        Intent intent = new Intent(this,ViewAccidentLocation.class);
        startActivity(intent);
    }

    private void scan() {
        Intent intent = new Intent(this,LicenseScanner.class);
        startActivity(intent);
    }

    //View Graphing data method

    private void viewGraphicData() {

        Intent intent = new Intent(this, ViewGraphicalData.class);



        startActivity(intent);
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

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference(  "users");
        LogInModel logIn = new LogInModel(chiefTrafficOfficerUserName, chiefTrafficOfficerPassWord);
        referenci.child(chiefTrafficOfficerUserName).setValue(logIn);
    }
}