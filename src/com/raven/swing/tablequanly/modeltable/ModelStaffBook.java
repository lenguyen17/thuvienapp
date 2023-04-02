package com.raven.swing.tablequanly.modeltable;

import com.raven.table.model.TableRowData;

public class ModelStaffBook extends TableRowData {

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getLuotMuon() {
        return luotMuon;
    }

    public void setLuotMuon(String luotMuon) {
        this.luotMuon = luotMuon;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    private String idSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private String luotMuon;
    private String giatien;
    private String ngayNhap;

    public ModelStaffBook(String idSach, String tenSach, String theLoai, String tacGia, String luotMuon, String giatien, String ngayNhap) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.luotMuon = luotMuon;
        this.giatien = giatien;
        this.ngayNhap = ngayNhap;
    }
    

    @Override
    public Object[] toTableRow() {
        return new Object[]{idSach, tenSach, theLoai, tacGia, luotMuon, giatien, ngayNhap};
    }

}
