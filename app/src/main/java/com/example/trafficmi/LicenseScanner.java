package com.example.trafficmi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LicenseScanner extends AppCompatActivity {

    //variable initialiozation

    Button btScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_scanner);

        //assign variable
        btScan = findViewById(R.id.bt_scan);

        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initialize intent integrator
                IntentIntegrator intentIntegrator = new IntentIntegrator(LicenseScanner.this);

                //set prompt text
                intentIntegrator.setPrompt("for flash use volume up key");

                // set beep
                intentIntegrator.setBeepEnabled(true);

                //Locked orientenion
                intentIntegrator.setOrientationLocked(true);

                //set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);

                //Initiate Scan
                intentIntegrator.initiateScan();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Initilalize inntent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        //check condition
        if (intentResult.getContents() != null){
            //When result content is not null
            //Initialize alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(LicenseScanner.this);

            //Set title
            builder.setTitle("Result");
            //set message
            builder.setMessage(intentResult.getContents());
            //Set positive button
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //Dismiss dialog

                    dialogInterface.dismiss();

                }
            });

            //Shown alert dialog
            builder.show();
        }

        else {
            //When result content is null
            //Display toast

            Toast.makeText(getApplicationContext(), "You did not scan anything", Toast.LENGTH_SHORT).show();
        }

    }
}