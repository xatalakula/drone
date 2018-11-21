package com.example.noname.ttnm12;

public class Drone {
    private String drone_Id;
    private String state;


    public Drone(String drone_Id, String state) {

        this.drone_Id = drone_Id;
        this.state = state;
    }

    public String getDrone_Id() {
        return drone_Id;
    }

    public void setDrone_Id(String drone_Id) {
        this.drone_Id = drone_Id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void connect(){
        this.setState("đã kết nối");
    }
}
