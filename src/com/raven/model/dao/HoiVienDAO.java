package com.raven.model.dao;

import com.raven.model.database.JDBCUtil;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.TheMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HoiVienDAO implements DAOInterface<HoiVien> {

    public static HoiVienDAO getInstance() {
        return new HoiVienDAO();
    }

    @Override
    public int insert(HoiVien hoiVien) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO HoiVien (IDHoiVien, MaSV, HoTen, Lop, GioiTinh, SoDT, Email, TrangThai) "
                    + "Values (?,?,?,?,?,?,?,?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, hoiVien.getIdHoiVien());
            st.setString(2, hoiVien.getMaSV());
            st.setString(3, hoiVien.getHoTen());
            st.setString(4, hoiVien.getLop());
            st.setString(5, hoiVien.isGioiTinh() ? "Nam" : "Nữ");
            st.setString(6, hoiVien.getSdt());
            st.setString(7, hoiVien.getEmail());
            st.setString(8, hoiVien.getTrangThai());
            ketQua = st.executeUpdate();
            System.out.println("Đã thực thi câu lệnh");
            System.out.printf("Có %d dòng bị thay đổi", ketQua);
            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HoiVien hoiVien) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sqlCTTM = "DELETE FROM ChiTietTheMuon "
                    + "WHERE idTheMuon in (SELECT idthemuon FROM themuon WHERE idhoivien = ?)";
            PreparedStatement stCTTM = c.prepareStatement(sqlCTTM);
            stCTTM.setString(1, hoiVien.getIdHoiVien());
            stCTTM.executeUpdate();
            
            
            String sqlTM = "DELETE FROM TheMuon "
                    + "WHERE IDHoiVien=?";
            PreparedStatement stTM = c.prepareStatement(sqlTM);
            stTM.setString(1, hoiVien.getIdHoiVien());
            stTM.executeUpdate();
            
            String sql = "DELETE FROM HoiVien "
                    + "WHERE IDHoiVien=?";
            
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, hoiVien.getIdHoiVien());
            ketQua = st.executeUpdate();
            System.out.println("Đã thực thi câu lệnh");
            System.out.printf("Có %d dòng bị thay đổi", ketQua);
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(HoiVien hoiVien) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "UPDATE HoiVien "
                    + "Set MaSV=?, HoTen=?, Lop=?, gioiTinh=?, SoDT=?, email=?, TrangThai=? "
                    + "WHERE idHoiVien=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, hoiVien.getMaSV());
            st.setString(2, hoiVien.getHoTen());
            st.setString(3, hoiVien.getLop());
            st.setString(4, hoiVien.isGioiTinh() ? "Nam" : "Nữ");
            st.setString(5, hoiVien.getSdt());
            st.setString(6, hoiVien.getEmail());
            st.setString(7, hoiVien.getTrangThai());
            st.setString(8, hoiVien.getIdHoiVien());
            ketQua = st.executeUpdate();
            System.out.println("Đã thực thi câu lệnh");
            System.out.printf("Có %d dòng bị thay đổi", ketQua);
            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateTrangThai(String idhoiVien, String trangThai) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "UPDATE HoiVien "
                    + " Set TrangThai=? "
                    + " WHERE idHoiVien=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, trangThai);
            st.setString(2, idhoiVien);
            ketQua = st.executeUpdate();
            System.out.println(sql);
            System.out.printf("Có %d dòng bị thay đổi", ketQua);
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoiVien> selectAll() {
        try (Connection c = JDBCUtil.getConnection()) {
            ArrayList<HoiVien> list = new ArrayList<HoiVien>();
            String sql = "SELECT * FROM HoiVien";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idHoiVien = rs.getString("idHoiVien");
                String maSinhVien = rs.getString("maSV");
                String tenHoiVien = rs.getString("HoTen");
                String tenLop = rs.getString("Lop");
                boolean gioiTinh = rs.getString("gioiTinh").equalsIgnoreCase("Nam");
                String soDienThoai = rs.getString("soDT");
                String email = rs.getString("email");
                String trangThai = rs.getString("TrangThai");
                HoiVien hv = new HoiVien(idHoiVien, maSinhVien, tenHoiVien, tenLop, gioiTinh, soDienThoai, email, trangThai);
                hv.setSachDaMuon(HoiVienDAO.getInstance().getSoLuongSachDaMuon(idHoiVien));
                hv.setSachDangMuon(HoiVienDAO.getInstance().getSoLuongSachChuaTra(idHoiVien));
                list.add(hv);
            }
            JDBCUtil.closeConnection(c);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HoiVien selectByID(String id) {
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM HoiVien WHERE idHoiVien=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idHoiVien = rs.getString("idHoiVien");
                String maSinhVien = rs.getString("maSV");
                String tenHoiVien = rs.getString("HoTen");
                String tenLop = rs.getString("Lop");
                boolean gioiTinh = rs.getString("gioiTinh").equalsIgnoreCase("Nam");
                String soDienThoai = rs.getString("soDT");
                String email = rs.getString("email");
                String trangThai = rs.getString("TrangThai");
                HoiVien hv = new HoiVien(idHoiVien, maSinhVien, tenHoiVien, tenLop, gioiTinh, soDienThoai, email, trangThai);
                hv.setSachDaMuon(HoiVienDAO.getInstance().getSoLuongSachDaMuon(idHoiVien));
                hv.setSachDangMuon(HoiVienDAO.getInstance().getSoLuongSachChuaTra(idHoiVien));
                JDBCUtil.closeConnection(c);
                return hv;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoiVien> searchByCondition(boolean conSearch, String con, boolean lop, String tenLopTK) {
        try (Connection c = JDBCUtil.getConnection()) {
            ArrayList<HoiVien> list = new ArrayList<HoiVien>();
            String sql = "SELECT * FROM HoiVien WHERE ";
            if (conSearch) {
                sql += "( IDHoiVien LIKE \"%" + con + "%\" "
                        + "OR HoTen LiKE \"%" + con + "%\" )";
                if (lop) {
                    sql += " AND ";
                }
            }
            if (lop) {
                sql += " Lop LIKE \"%" + tenLopTK + "%\" ";
            }
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idHoiVien = rs.getString("idHoiVien");
                String maSinhVien = rs.getString("maSV");
                String tenHoiVien = rs.getString("HoTen");
                String tenLop = rs.getString("Lop");
                boolean gioiTinh = rs.getString("gioiTinh").equalsIgnoreCase("Nam");
                String soDienThoai = rs.getString("soDT");
                String email = rs.getString("email");
                String trangThai = rs.getString("TrangThai");
                HoiVien hv = new HoiVien(idHoiVien, maSinhVien, tenHoiVien, tenLop, gioiTinh, soDienThoai, email, trangThai);
                hv.setSachDaMuon(HoiVienDAO.getInstance().getSoLuongSachDaMuon(idHoiVien));
                hv.setSachDangMuon(HoiVienDAO.getInstance().getSoLuongSachChuaTra(idHoiVien));
                list.add(hv);
            }
            JDBCUtil.closeConnection(c);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> selectListLop() {
        try (Connection c = JDBCUtil.getConnection()) {
            ArrayList<String> list = new ArrayList<String>();
            String sql = "SELECT DISTINCT LOP FROM HOIVIEN";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tenLop = rs.getString("Lop");
                list.add(tenLop);
            }
            JDBCUtil.closeConnection(c);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void kiemTraDaTraHet(String idHoiVien) {
        if (idHoiVien == null) {
            return;
        }
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM THEMUON TM, hoivien HV,chitieTthemuon CT "
                    + " WHERE TM.IDHoiVien = HV.IDHoiVien AND TM.IDTHEMUON = CT.IDTheMuon "
                    + " AND HV.IDHOIVIEN = ? AND (CT.TINHTRANG LIKE \'Trễ hẹn\' \n"
                    + "	OR CT.TINHTRANG LIKE \'Đang mượn\' )";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, idHoiVien);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return;
            } else {
                String sqlHV = "UPDATE HOIVIEN SET TrangThai= ? WHERE IDHOIVIEN=? ";
                PreparedStatement sthv = c.prepareStatement(sqlHV);
                sthv.setString(1, "Sẵn sàng");
                sthv.setString(2, idHoiVien);
                sthv.executeUpdate();
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public LinkedHashMap<String, Integer> getSLHVTheoTinhTrang() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT trangthai, COUNT(idhoivien) AS soluong FROM hoivien GROUP BY trangthai";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tt = rs.getString("TrangThai").trim();
                int soLuong = rs.getInt("SoLuong");
                list.put(tt, soLuong);
            }
            JDBCUtil.closeConnection(c);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSoLuongHoiVienDangMuon() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(idhoivien) AS soluong FROM hoivien WHERE TRANGTHAI LIKE \'Đang mượn\'";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SoLuong");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int getSoLuongHoiVienTreHen() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(idhoivien) AS soluong FROM hoivien WHERE IDHOIVIEN IN (SELECT TM.IDhoivien FROM themuon TM, chitietthemuon CT\n"
                    + " WHERE \n"
                    + "	TM.IDTheMuon = CT.IDTheMuon AND CT.TinhTrang LIKE \'Trễ hẹn\')";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SoLuong");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int getSoLuongHoiVienNam() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(IDHOIVIEN) AS SoLuong FROM hoivien WHERE hoivien.GioiTinh LIKE \'Nam\'";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SoLuong");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int getSoLuongSachChuaTra(String idhv) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(*) AS SoLuong FROM chitietthemuon CT, themuon TM, hoivien HV\n"
                    + "			WHERE CT.IDTheMuon = TM.IDTheMuon AND HV.IDHoiVien = TM.IDHOIVIEN\n"
                    + "			AND (CT.TINHTRANG LIKE 'TRỄ HẸN' OR CT.TINHTRANG LIKE 'Đang mượn')\n"
                    + "			AND tm.idhoivien LIKE \'" + idhv + "\'";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SoLuong");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int getSoLuongSachDaMuon(String idhv) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(*) AS SoLuong FROM chitietthemuon CT, themuon TM, hoivien HV\n"
                    + "			WHERE CT.IDTheMuon = TM.IDTheMuon AND HV.IDHoiVien = TM.IDHOIVIEN\n"
                    + "			AND tm.idhoivien LIKE \'" + idhv + "\'";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SoLuong");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
