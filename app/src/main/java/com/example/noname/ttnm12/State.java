package com.example.noname.ttnm12;

public class State {
    private String drone_Id;
    private int state;

    public State(String drone_Id, int state) {
        this.drone_Id = drone_Id;
        this.state = state;
    }

    public String getDrone_Id() {
        return drone_Id;
    }

    public void setDrone_Id(String drone_Id) {
        this.drone_Id = drone_Id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
