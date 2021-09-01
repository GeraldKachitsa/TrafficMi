package com.example.trafficmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChiefTrafficOfficerChoiceOfWork extends AppCompatActivity {
    private Button updateDriverChoiceBtn, issueWarrantOfArrestBtn, updateVehicleRecordsChoiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chief_traffic_officer_choice_of_work);

        updateDriverChoiceBtn = (Button) findViewById(R.id.inspectDriverChoiceBtn);


        updateDriverChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUpdateDriverRecords();
            }
        });
        issueWarrantOfArrestBtn = (Button) findViewById(R.id.accidentSceneChoice);
        issueWarrantOfArrestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToIssueWarrantOfArrest();
            }
        });

        updateVehicleRecordsChoiceBtn= (Button) findViewById(R.id.updateVehicleRecordsChoiceBtn);
        updateVehicleRecordsChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUpdateVehicleRecords();
            }
        });

    }
    public void goToUpdateDriverRecords(){
        startActivity( new Intent(this,UpdateDriverRecords.class));
    }
    public void goToIssueWarrantOfArrest(){
        startActivity( new Intent(this,IssueWarrantOfArrest.class));
    }
    public void goToUpdateVehicleRecords(){
        startActivity( new Intent(this,UpdateVehicleRecords.class));
    }

}