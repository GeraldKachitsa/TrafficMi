package com.example.trafficmi;

import com.google.android.material.textfield.TextInputLayout;

public class DriverOffenceRecords {

    String driverName, licenseNumber, driverOffenceLocation;

    public DriverOffenceRecords(TextInputLayout fullNameOfDriver, TextInputLayout driverLicenseNumber, TextInputLayout driverOffenceLocation) {

    }

    public DriverOffenceRecords(String driverName, String licenseNumber, String driverOffenceLocation) {
        this.driverName =driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation =driverOffenceLocation;
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

}
