package com.raven.model.dao;

import com.raven.model.dao.DAOInterface;
import com.raven.model.database.JDBCUtil;
import com.raven.model.modeldata.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienDAO implements DAOInterface<NhanVien> {

    public static NhanVienDAO getInstance() {
        return new NhanVienDAO();
    }

    @Override
    public int insert(NhanVien nhanVien) {
        return 0;
    }

    @Override
    public int delete(NhanVien nhanVien) {
        return 0;
    }

    @Override
    public int update(NhanVien nhanVien) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "UPDATE NHANVIEN SET Password= ? "
                    + "WHERE IDNhanVien= ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, nhanVien.getPassword());
            st.setString(2, nhanVien.getIdNhanVien());
            ketQua = st.executeUpdate();
            System.out.println("Đổi mật khẩu thành công");
            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
        return null;
    }

    @Override
    public NhanVien selectByID(String id) {
        return null;
    }

    public NhanVien login(String id, String pass) {
        NhanVien nv = null;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM nhanvien WHERE IDNHANVIEN LIKE ? AND PASSWORD LIKE ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String hoTen = rs.getString("hoTen");
                String chucVu = rs.getString("chucVu");
                nv = new NhanVien(id, pass, hoTen, chucVu);
            }
            JDBCUtil.closeConnection(c);
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
}
