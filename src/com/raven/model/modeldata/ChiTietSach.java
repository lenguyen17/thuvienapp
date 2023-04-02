package com.raven.model.modeldata;

import java.util.ArrayList;
import java.util.Calendar;

public class ChiTietSach {

    private String idChiTietSach;
    private String idSach;
    private int namPhatHanh;
    private String nhaXuatBan;
    private double giaTien;
    private String ngonNgu;
    private Calendar ngayNhap;
    private String trangThai;
    private ArrayList<String> theLoai = new ArrayList<String>();
    private ArrayList<String> tacGia = new ArrayList<String>();

    public String getIdChiTietSach() {
        return idChiTietSach;
    }

    public void setIdChiTietSach(String idChiTietSach) {
        this.idChiTietSach = idChiTietSach;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public int getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public Calendar getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Calendar ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ArrayList<String> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(ArrayList<String> theLoai) {
        this.theLoai = theLoai;
    }

    public ArrayList<String> getTacGia() {
        return tacGia;
    }

    public void setTacGia(ArrayList<String> tacGia) {
        this.tacGia = tacGia;
    }

    public ChiTietSach(String idChiTietSach, String idSach, int namPhatHanh, String nhaXuatBan, double giaTien,
            String ngonNgu, Calendar ngayNhap, String trangThai, ArrayList<String> theLoai, ArrayList<String> tacGia) {
        this.idChiTietSach = idChiTietSach;
        this.idSach = idSach;
        this.namPhatHanh = namPhatHanh;
        this.nhaXuatBan = nhaXuatBan;
        this.giaTien = giaTien;
        this.ngonNgu = ngonNgu;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
    }

    public ChiTietSach() {
    }

    public ChiTietSach getChiTietSachByID(String id) {
        if (getIdChiTietSach().equalsIgnoreCase(id)) {
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ChiTietSach{"
                + "idChiTietSach='" + idChiTietSach + '\''
                + ", idSach='" + idSach + '\''
                + ", namPhatHanh=" + namPhatHanh
                + ", nhaXuatBan='" + nhaXuatBan + '\''
                + ", giaTien=" + giaTien
                + ", ngonNgu='" + ngonNgu + '\''
                + ", ngayNhap=" + ngayNhap.get(Calendar.YEAR) + "/" + (ngayNhap.get(Calendar.MONTH) + 1) + "/" + ngayNhap.get(Calendar.DAY_OF_MONTH)
                + ", trangThai='" + trangThai + '\''
                + ", theLoai=" + theLoai
                + ", tacGia=" + tacGia
                + '}';
    }

    public String getStringThuocTinh(ArrayList<String> listCanGet) {
        String result = "";
        for (int i = 0; i < listCanGet.size(); i++) {
            if (i == (listCanGet.size() - 1)) {
                result += listCanGet.get(i);
            } else {
                result += listCanGet.get(i) + ", ";
            }
        }
        return result;
    }

    public String getStringTheLoai() {
        String result = "";
        for (int i = 0; i < getTheLoai().size(); i++) {
            result += getTheLoai().get(i);
            if (i != getTheLoai().size() - 1) {
                result += ", ";
            }
        }
        return result;
    }
    
    public String getStringTacGia() {
        String result = "";
        for (int i = 0; i < getTacGia().size(); i++) {
            result += getTacGia().get(i);
            if (i != getTacGia().size() - 1) {
                result += ", ";
            }
        }
        return result;
    }
}
