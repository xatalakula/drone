package com.example.noname.ttnm12;

public class Schedule {
    private String ngay;
    private String khuvuc;

    public Schedule(String ngay, String khuvuc) {
        this.ngay = ngay;
        this.khuvuc = khuvuc;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(String khuvuc) {
        this.khuvuc = khuvuc;
    }
}
