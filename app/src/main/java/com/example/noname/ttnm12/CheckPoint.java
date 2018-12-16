package com.example.noname.ttnm12;

public class CheckPoint {

    public String ordinal;
    public String coordinate1;
    public String coordinate2;
    public int imageLevel;
    public int imageCheck;

    public CheckPoint(String ordinal, String coordinate1, String coordinate2, int imageLevel, int imageCheck) {
        this.ordinal = ordinal;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
        this.imageLevel = imageLevel;
        this.imageCheck = imageCheck;
    }

    public String getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    public String getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(String coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public String getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(String coordinate2) {
        this.coordinate2 = coordinate2;
    }

    public int getImageLevel() {
        return imageLevel;
    }

    public void setImageLevel(int imageLevel) {
        this.imageLevel = imageLevel;
    }

    public int getImageCheck() {
        return imageCheck;
    }

    public void setImageCheck(int imageCheck) {
        this.imageCheck = imageCheck;
    }
}
