package com.example.trafficmi.Model;

public class AccidentScene {
    private String disPayName;
    private String driverOffenceLocation;
    private String lisenceNumber;

    public AccidentScene(String disPayName, String driverOffenceLocation, String lisenceNumber) {
        this.disPayName = disPayName;
        this.driverOffenceLocation = driverOffenceLocation;
        this.lisenceNumber = lisenceNumber;
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
