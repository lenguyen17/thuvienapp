package com.raven.model.modeldata;

public class HoiVien {

    private String idHoiVien;
    private String maSV;
    private String hoTen;
    private String lop;
    private boolean gioiTinh;
    private String sdt;
    private String email;
    private String trangThai;
    private int sachDaMuon = 0;
    private int sachDangMuon = 0;

    public int getSachDaMuon() {
        return sachDaMuon;
    }

    public void setSachDaMuon(int sachDaMuon) {
        this.sachDaMuon = sachDaMuon;
    }

    public int getSachDangMuon() {
        return sachDangMuon;
    }

    public void setSachDangMuon(int sachDangMuon) {
        this.sachDangMuon = sachDangMuon;
    }

    public String getIdHoiVien() {
        return idHoiVien;
    }

    public void setIdHoiVien(String idHoiVien) {
        this.idHoiVien = idHoiVien;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public HoiVien(String idHoiVien, String maSV, String hoTen, String lop, boolean gioiTinh, String sdt, String email, String trangThai) {
        this.idHoiVien = idHoiVien;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.trangThai = trangThai;
    }

    public HoiVien(String idHoiVien, String maSV, String hoTen, String lop, boolean gioiTinh, String sdt, String email, String trangThai, int sachDaMuon, int sachDangMuon) {
        this.idHoiVien = idHoiVien;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.trangThai = trangThai;
        this.sachDaMuon = sachDaMuon;
        this.sachDangMuon = sachDangMuon;
    }

    public HoiVien() {
    }

    public HoiVien getHoiVienByID(String id) {
        if (getIdHoiVien().equalsIgnoreCase((id))) {
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return "HoiVien{"
                + "idHoiVien='" + idHoiVien + '\''
                + ", maSV='" + maSV + '\''
                + ", hoTen='" + hoTen + '\''
                + ", lop='" + lop + '\''
                + ", gioiTinh=" + gioiTinh
                + ", sdt='" + sdt + '\''
                + ", email='" + email + '\''
                + ", trangThai='" + trangThai + '\''
                + '}';
    }
}
