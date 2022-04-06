package com.example.trafficmi;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class DriverOffenceRecords {

    String driverName, licenseNumber, driverOffenceLocation, driverOffenceDescription, sexHolder;

    public DriverOffenceRecords(TextInputLayout fullNameOfDriver, TextInputLayout driverLicenseNumber, TextInputLayout driverOffenceLocation, EditText driverOffenceDescription) {

    }

    public DriverOffenceRecords(String driverName, String licenseNumber, String driverOffenceLocation) {
        this.driverName =driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation =driverOffenceLocation;

    }
    public DriverOffenceRecords(String driverName, String licenseNumber, String driverOffenceLocation, String driverOffenceDescription, String sexHolder) {
        this.driverName =driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation =driverOffenceLocation;
        this.driverOffenceDescription = driverOffenceDescription;
        this.sexHolder = sexHolder;
    }

    public String getDriverName() {

        return driverName;
    }

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public String getDriverOffenceLocation() {

        return driverOffenceLocation;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public void setDriverOffenceLocation(String vehicleColor) {

        this.driverOffenceLocation = driverOffenceLocation;
    }


    public String getDriverOffenceDescription() {

        return driverOffenceDescription;
    }

    public void setDriverOffenceDescription(String driverOffenceDescription) {

        this.driverOffenceDescription = driverOffenceDescription;
    }

}
