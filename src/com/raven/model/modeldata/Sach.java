package com.raven.model.modeldata;

import java.util.ArrayList;

public class Sach {

    private String idSach;
    private String tenSach;
    private int soLuong;
    private String viTri;
    private ArrayList<String> listTacGia;
    private ArrayList<String> listTheLoai;
    

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public ArrayList<String> getListTacGia() {
        return listTacGia;
    }

    public void setListTacGia(ArrayList<String> listTacGia) {
        this.listTacGia = listTacGia;
    }

    public ArrayList<String> getListTheLoai() {
        return listTheLoai;
    }

    public void setListTheLoai(ArrayList<String> listTheLoai) {
        this.listTheLoai = listTheLoai;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach(String idSach, String tenSach, int soLuong, String viTri) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.viTri = viTri;
    }

    public Sach() {
    }

    public Sach getSachByID(String id) {
        if (getIdSach().equalsIgnoreCase(id)) {
            return this;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sach{"
                + "idSach='" + idSach + '\''
                + ", tenSach='" + tenSach + '\''
                + ", soLuong=" + soLuong
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

    public String getStringTacGia() {
        String result = "";
        for (int i = 0; i < listTacGia.size(); i++) {
            if (i == (listTacGia.size() - 1)) {
                result += listTacGia.get(i);
            } else {
                result += listTacGia.get(i) + ", ";
            }
        }
        return result;
    }

    public String getStringTheLoai() {
        String result = "";
        for (int i = 0; i < listTheLoai.size(); i++) {
            if (i == (listTheLoai.size() - 1)) {
                result += listTheLoai.get(i);
            } else {
                result += listTheLoai.get(i) + ", ";
            }
        }
        return result;
    }
}
