package com.raven.model.modelcomponent;


import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;
import javax.swing.Icon;

public class ModelStudent {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMaHoiVien() {
        return maHoiVien;
    }

    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }

    public String getTenHoiVien() {
        return tenHoiVien;
    }

    public void setTenHoiVien(String tenHoiVien) {
        this.tenHoiVien = tenHoiVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }
    public ModelStudent(Icon icon, String maHoiVien, String tenHoiVien, String tenLop, String idSinhVien) {
        this.icon = icon;
        this.maHoiVien = maHoiVien;
        this.tenHoiVien = tenHoiVien;
        this.tenLop = tenLop;
        this.idSinhVien = idSinhVien;
    }
    
    public ModelStudent(Icon icon, String maHoiVien, String tenHoiVien, String tenLop, String idSinhVien,int sachDaMuon, int sachDangMuon, String email) {
        this.icon = icon;
        this.maHoiVien = maHoiVien;
        this.tenHoiVien = tenHoiVien;
        this.tenLop = tenLop;
        this.idSinhVien = idSinhVien;
        this.sachDaMuon = sachDaMuon;
        this.sachDangMuon = sachDangMuon;
        this.email = email;
    }

    public ModelStudent() {
    }

    private Icon icon;
    private String maHoiVien;
    private String tenHoiVien;
    private String tenLop;
    private String idSinhVien;
    private String email;
    private int sachDaMuon;
    private int sachDangMuon;
    

    public Object[] toRowTable(EventAction event) {
        return new Object[]{new ModelProfile(icon, maHoiVien), tenHoiVien, tenLop, idSinhVien, new ModelAction(this, event)};
    }

    public Object[] toRowTheMuonTable(EventAction event) {
        return new Object[]{new ModelProfile(icon, maHoiVien), tenHoiVien, tenLop, idSinhVien, new ModelAction(this, event)};
    }

    public Object[] toRowTheMuonTableHoiVien(EventAction event) {
        return new Object[]{new ModelProfile(icon, maHoiVien), tenHoiVien, tenLop, idSinhVien, sachDaMuon, sachDangMuon, email, new ModelAction(this, event)};
    }
}
