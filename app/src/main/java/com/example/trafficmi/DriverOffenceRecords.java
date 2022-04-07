package com.example.trafficmi;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class DriverOffenceRecords {

    String driverName, licenseNumber, driverOffenceLocation, driverOffenceDescription, selectedSex;

    public DriverOffenceRecords(TextInputLayout fullNameOfDriver, TextInputLayout driverLicenseNumber, TextInputLayout driverOffenceLocation, EditText driverOffenceDescription) {

    }

    public DriverOffenceRecords(String driverName, String licenseNumber, String driverOffenceLocation) {
        this.driverName =driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation =driverOffenceLocation;

    }
    public DriverOffenceRecords(String driverName, String licenseNumber, String driverOffenceLocation, String driverOffenceDescription, String selectedSex) {
        this.driverName =driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation =driverOffenceLocation;
        this.driverOffenceDescription = driverOffenceDescription;
        this.selectedSex = selectedSex;
    }

    public String getDriverName() {

        return driverName;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;
    }


    public String getLicenseNumber() {

        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getDriverOffenceLocation() {

        return driverOffenceLocation;
    }

    public void setDriverOffenceLocation(String driverOffenceLocation) {

        this.driverOffenceLocation = driverOffenceLocation;
    }


    public String getSelectedSex() {

        return selectedSex;
    }

    public void setSelectedSex(String selectedSex) {

        this.selectedSex = selectedSex;
    }

    public String getDriverOffenceDescription() {

        return driverOffenceDescription;
    }

    public void setDriverOffenceDescription(String driverOffenceDescription) {

        this.driverOffenceDescription = driverOffenceDescription;
    }

}
