package com.raven.model.dao;

import java.util.Calendar;

public class ThoiGianNguoiMuon {

    private Calendar thoigian;
    private String hoTen;
    private String tinhTrang;

    public Calendar getThoigian() {
        return thoigian;
    }

    public void setThoigian(Calendar thoigian) {
        this.thoigian = thoigian;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public ThoiGianNguoiMuon(Calendar thoigian, String hoTen, String tinhTrang) {
        this.thoigian = thoigian;
        this.hoTen = hoTen;
        this.tinhTrang = tinhTrang;
    }

    public ThoiGianNguoiMuon() {
    }

}
