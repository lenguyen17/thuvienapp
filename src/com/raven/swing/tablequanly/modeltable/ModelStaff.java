package com.raven.swing.tablequanly.modeltable;

import com.raven.model.dao.HoiVienDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import com.raven.table.model.TableRowData;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ModelStaff extends TableRowData {

    public TheMuon getTheMuon() {
        return theMuon;
    }

    public void setTheMuon(TheMuon theMuon) {
        this.theMuon = theMuon;
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

    public String getTenHoiVien() {
        return tenHoiVien;
    }

    public void setTenHoiVien(String tenHoiVien) {
        this.tenHoiVien = tenHoiVien;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(String ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    private TheMuon theMuon;
    private String idTheMuon;
    private String idHoiVien;
    private String tenHoiVien;
    private int soLuongMuon;
    private String ngayMuon = "";
    private String ngayHenTra = "";
    private String ngayTra = "";
    private String tinhTrang;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ModelStaff() {
    }


    public ModelStaff(TheMuon theMuon) {
        this.theMuon = theMuon;
        this.idTheMuon = theMuon.getIdTheMuon();
        this.idHoiVien = theMuon.getIdHoiVien();
        this.tenHoiVien = HoiVienDAO.getInstance().selectByID(theMuon.getIdHoiVien()).getHoTen();
        this.soLuongMuon = theMuon.getListCTS().size();
        if (theMuon.getNgayMuon() != null) {
            this.ngayMuon = sdf.format(theMuon.getNgayMuon().getTime());
        }
        if (theMuon.getNgayHenTra() != null) {
            this.ngayHenTra = sdf.format(theMuon.getNgayHenTra().getTime());
        }
        if (theMuon.getNgayTra() != null) {
            this.ngayTra = sdf.format(theMuon.getNgayTra().getTime());
        }
        this.tinhTrang = theMuon.getTinhTrang();
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{idTheMuon, idHoiVien, tenHoiVien, soLuongMuon, ngayMuon, ngayHenTra, ngayTra, tinhTrang};
    }

}
