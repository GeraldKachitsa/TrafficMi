package com.example.trafficmi.Model;

public class DriversOffenceModel {
    private String disPayName;
    private String driverOffenceLocation;
    private String lisenceNumber;
    private String driverOffenceDescription;
    private String selectedSex;

//    public DriversOffenceModel(String disPayName, String driverOffenceLocation, String lisenceNumber) {
//        this.disPayName = disPayName;
//        this.driverOffenceLocation = driverOffenceLocation;
//        this.lisenceNumber = lisenceNumber;
//    }

    public DriversOffenceModel(String disPayName, String driverOffenceLocation, String lisenceNumber, String driverOffenceDescription, String selectedSex) {
        this.disPayName = disPayName;
        this.driverOffenceLocation = driverOffenceLocation;
        this.lisenceNumber = lisenceNumber;
        this.driverOffenceDescription = driverOffenceDescription;
        this.selectedSex = selectedSex;
    }


    public String getDriverOffenceDescription() {
        return driverOffenceDescription;
    }

    public void setDriverOffenceDescription(String driverOffenceDescription) {
        this.driverOffenceDescription = driverOffenceDescription;
    }

    public String getSelectedSex() {
        return selectedSex;
    }

    public void setSelectedSex(String selectedSex) {
        this.selectedSex = selectedSex;
    }


    public String getDisPayName() {
        return disPayName;
    }

    public void setDisPayName(String disPayName) {
        this.disPayName = disPayName;
    }

    public String getDriverOffenceLocation() {
        return driverOffenceLocation;
    }

    public void setDriverOffenceLocation(String driverOffenceLocation) {
        this.driverOffenceLocation = driverOffenceLocation;
    }

    public String getLisenceNumber() {
        return lisenceNumber;
    }

    public void setLisenceNumber(String lisenceNumber) {
        this.lisenceNumber = lisenceNumber;
    }
}
