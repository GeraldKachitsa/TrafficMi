package com.example.trafficmi.Model;

public class AccidentSceneModel {
    private String regNum,color,name;

    public AccidentSceneModel(String regNum, String color, String name) {
        this.regNum = regNum;
        this.color = color;
        this.name = name;

    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
