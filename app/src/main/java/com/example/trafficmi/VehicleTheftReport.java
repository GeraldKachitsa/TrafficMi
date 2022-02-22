package com.example.trafficmi;

import com.google.android.material.textfield.TextInputLayout;

public class VehicleTheftReport {

    String  carName, carMake, carColor, vehicleRegNumber,vehicle_blue_book;

    public VehicleTheftReport() {

    }

    public VehicleTheftReport( String  carName, String  carMake, String carColor, String vehicleRegNumber, String vehicle_blue_book) {

        this.carName = carName;
        this.carMake = carMake;
        this.carColor = carColor;
        this.vehicleRegNumber = vehicleRegNumber;
        this.vehicle_blue_book = vehicle_blue_book;

    }

    public VehicleTheftReport( String  carName, String carColor, String vehicleRegNumber) {
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

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
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

    public String getVehicle_blue_book() {
        return vehicle_blue_book;
    }

    public void setVehicle_blue_book(String vehicle_blue_book) {
        this.vehicle_blue_book = vehicle_blue_book;
    }
}
