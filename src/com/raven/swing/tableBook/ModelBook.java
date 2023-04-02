package com.raven.swing.tableBook;

import com.raven.swing.table.ModelProfile;
import javax.swing.Icon;

public class ModelBook {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

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

    public String getTheLoaiString() {
        return theLoaiString;
    }

    public void setTheLoaiString(String theLoaiString) {
        this.theLoaiString = theLoaiString;
    }

    public String getTacGiaString() {
        return tacGiaString;
    }

    public void setTacGiaString(String tacGiaString) {
        this.tacGiaString = tacGiaString;
    }

    public int getLuotMuon() {
        return luotMuon;
    }

    public void setLuotMuon(int luotMuon) {
        this.luotMuon = luotMuon;
    }

    public String getGiaTienString() {
        return giaTienString;
    }

    public void setGiaTienString(String giaTienString) {
        this.giaTienString = giaTienString;
    }

    public String getNgayNhapString() {
        return ngayNhapString;
    }

    public void setNgayNhapString(String ngayNhapString) {
        this.ngayNhapString = ngayNhapString;
    }

    private Icon icon;
    private String idSach;
    private String tenSach;
    private String theLoaiString;
    private String tacGiaString;
    private int luotMuon;
    private String giaTienString;
    private String ngayNhapString;

    public ModelBook() {
    }

    public ModelBook(Icon icon, String idSach, String tenSach, String theLoaiString, String tacGiaString, int luotMuon, String giaTienString, String ngayNhapString) {
        this.icon = icon;
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.theLoaiString = theLoaiString;
        this.tacGiaString = tacGiaString;
        this.luotMuon = luotMuon;
        this.giaTienString = giaTienString;
        this.ngayNhapString = ngayNhapString;
    }

    public Object[] toRowTable(EventActionBook event) {
        return new Object[]{new ModelProfile(icon, idSach), tenSach, theLoaiString, tacGiaString, luotMuon, giaTienString, ngayNhapString, new ModelActionBook(this,event)};
    }
    
    

}
