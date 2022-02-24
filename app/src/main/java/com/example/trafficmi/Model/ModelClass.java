package com.example.trafficmi.Model;

public class ModelClass {
    String  carName, carColor, vehicleRegNumber;

    public ModelClass(String carName, String carColor, String vehicleRegNumber) {
        this.carName = carName;
        this.carColor = carColor;
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }
}
