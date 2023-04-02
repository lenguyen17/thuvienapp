package com.raven.model.modeldata;

import java.util.ArrayList;
import java.util.Calendar;

public class TheMuon {

    private String idTheMuon;
    private String idHoiVien;
    private String idNhanVien;
    private Calendar ngayMuon;
    private Calendar ngayHenTra;
    private Calendar ngayTra;
    private ArrayList<ChiTietSach> listCTS;
    private String tinhTrang;

    public TheMuon() {
    }

    public TheMuon(String idTheMuon, String idHoiVien, String idNhanVien, Calendar ngayMuon, Calendar ngayHenTra, Calendar ngayTra, ArrayList<ChiTietSach> listCTS, String tinhTrang) {
        this.idTheMuon = idTheMuon;
        this.idHoiVien = idHoiVien;
        this.idNhanVien = idNhanVien;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ngayTra = ngayTra;
        this.listCTS = listCTS;
        this.tinhTrang = tinhTrang;
    }

    public Calendar getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Calendar ngayTra) {
        this.ngayTra = ngayTra;
    }

    public ArrayList<ChiTietSach> getListCTS() {
        return listCTS;
    }

    public void setListCTS(ArrayList<ChiTietSach> listCTS) {
        this.listCTS = listCTS;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getIdTheMuon() {
        return idTheMuon;
    }

    public void setIdTheMuon(String idTheMuon) {
        this.idTheMuon = idTheMuon;
    }

    public String getIdHoiVien() {
        return idHoiVien;
    }

    public void setIdHoiVien(String idHoiVien) {
        this.idHoiVien = idHoiVien;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Calendar getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Calendar ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Calendar getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(Calendar ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    @Override
    public String toString() {
        return "TheMuon{"
                + "idTheMuon='" + idTheMuon + '\''
                + ", idHoiVien='" + idHoiVien + '\''
                + ", idNhanVien='" + idNhanVien + '\''
                + ", ngayMuon=" + ngayMuon.get(Calendar.YEAR) + "/" + (ngayMuon.get(Calendar.MONTH) + 1) + "/" + ngayMuon.get(Calendar.DAY_OF_MONTH)
                + ", ngayHenTra=" + ngayHenTra.get(Calendar.YEAR) + "/" + (ngayHenTra.get(Calendar.MONTH) + 1) + "/" + ngayHenTra.get(Calendar.DAY_OF_MONTH)
//                + ", ngayTra=" + ngayTra.get(Calendar.YEAR) + "/" + (ngayTra.get(Calendar.MONTH) + 1) + "/" + ngayTra.get(Calendar.DAY_OF_MONTH)
                + ", listCTS=" + listCTS
                + ", tinhTrang='" + tinhTrang + '\''
                + '}';
    }
}
