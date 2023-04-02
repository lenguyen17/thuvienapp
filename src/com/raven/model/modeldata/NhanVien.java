package com.raven.model.modeldata;

public class NhanVien {

    private String idNhanVien;
    private String password;
    private String hoTen;
    private String chucVu;

    public NhanVien() {
    }
    
    public NhanVien(String idNhanVien, String password, String hoTen, String chucVu) {
        this.idNhanVien = idNhanVien;
        this.password = password;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
