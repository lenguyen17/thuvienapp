package com.raven.model.dao;

import com.raven.model.database.JDBCUtil;
import com.raven.model.modeldata.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO Sach (idSach, tenSach, soLuong, viTri) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, sach.getIdSach());
            st.setString(2, sach.getTenSach());
            st.setString(3, sach.getSoLuong() + "");
            st.setString(4, sach.getViTri());
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
    public int delete(Sach sach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM SACH "
                    + "WHERE idSach=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, sach.getIdSach());
            ketQua = st.executeUpdate();
            System.out.println("Xóa thành công");
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Sach sach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "UPDATE Sach "
                    + "SET tenSach=?,soLuong= ? , viTri = ? "
                    + "WHERE idSach=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, sach.getTenSach());
            st.setString(2, sach.getSoLuong() + "");
            st.setString(3, sach.getViTri());
            st.setString(4, sach.getIdSach());
            ketQua = st.executeUpdate();
            System.out.println("Đã thực thi");
            System.out.printf("Có %d thay đổi", ketQua);

            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> listAllSach = new ArrayList<Sach>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM SACH";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idSach = rs.getString("idSach");
                String tenSach = rs.getString("tenSach");
                int soLuong = rs.getInt("soLuong");
                String viTri = rs.getString("ViTri");
                Sach sach = new Sach(idSach, tenSach, soLuong, viTri);
                listAllSach.add(sach);
            }
            JDBCUtil.closeConnection(c);
            return listAllSach;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sach selectByID(String id) {
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM SACH WHERE idSach=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idSach = rs.getString("idSach");
                String tenSach = rs.getString("tenSach");
                int soLuong = rs.getInt("soLuong");
                String viTri = rs.getString("ViTri");
                Sach sach = new Sach(idSach, tenSach, soLuong, viTri);
                JDBCUtil.closeConnection(c);
                return sach;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sach selectByIDCTS(String idCTS) {
        try (Connection c = JDBCUtil.getConnection()) {
            String[] parts = idCTS.split("-");
            String id = parts[0];
            String sql = "SELECT * FROM SACH WHERE idSach=?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, id);
            System.out.println(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idSach = rs.getString("idSach");
                String tenSach = rs.getString("tenSach");
                int soLuong = rs.getInt("soLuong");
                String viTri = rs.getString("ViTri");
                Sach sach = new Sach(idSach, tenSach, soLuong, viTri);
                JDBCUtil.closeConnection(c);
                return sach;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Sach> selectByCondition(String condition, String ls, boolean ten, boolean tac) {
        ArrayList<Sach> listSach = new ArrayList<Sach>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT DISTINCT (S.IDSach), S.TenSach,S.SoLuong,S.ViTri, C.NamPhatHanh "
                    + " FROM sach S, chitietsach C, tacgia TG, theloai TL "
                    + "	WHERE S.IDSach = C.IDSACH "
                    + "	AND C.IDChiTietSach = TL.IDChiTietSach "
                    + "	AND C.IDChiTietSach = TG.IDChiTietSach ";

            if (!ls.equals("") && !ls.equals("Loại sách")) {
                sql += " AND TL.THELOAI LIKE \"%" + ls + "%\" ";
            }
            if (tac && ten) {
                if (tac) {
                    sql += " AND ( TG.TacGia LIKE \"%" + condition + "%\" ";
                }
                if (ten) {
                    sql += " OR S.TENSACH LIKE \"%" + condition + "%\" ) ";
                }
            } else {
                if (tac) {
                    sql += " AND TG.TacGia LIKE \"%" + condition + "%\" ";
                }
                if (ten) {
                    sql += " AND S.TENSACH LIKE \"%" + condition + "%\" ";
                }
            }

            System.out.println(sql);
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idSach = rs.getString("idSach");
                String tenSach = rs.getString("tenSach");
                int soLuong = rs.getInt("soLuong");
                String viTri = rs.getString("ViTri");
                Sach s = new Sach(idSach, tenSach, soLuong, viTri);
                listSach.add(s);
            }
            JDBCUtil.closeConnection(c);
            return listSach;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSach;
    }

    public LinkedHashMap<String, Integer> getTop3TheLoai() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT t.TheLoai, COUNT(DISTINCT (s.IDSach)) as SoLuong FROM sach s, theloai t, chitietsach c\n"
                    + "	WHERE s.IDSach = c.IDSach \n"
                    + "		AND t.IDChiTietSach = c.IDChiTietSach\n"
                    + "		GROUP BY t.theloai\n"
                    + "		ORDER BY COUNT(s.IDSach) desc";

            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tl = rs.getString("TheLoai").trim();
                int soLuong = rs.getInt("SoLuong");
                list.put(tl, soLuong);
            }
            JDBCUtil.closeConnection(c);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //get 20 người mượn gần nhất
    public LinkedHashMap<Integer, ThoiGianNguoiMuon> getLichSuMuon(String idSach) {
        LinkedHashMap<Integer, ThoiGianNguoiMuon> list = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT TM.NgayMuon, HV.HoTen, CT.TinhTrang FROM chitietthemuon CT, themuon TM, hoivien HV, chitietsach CTS\n"
                    + "WHERE CT.IDTheMuon = TM.IDTheMuon AND HV.IDHoiVien = TM.IDHOIVIEN AND CTS.IDChiTietSach = CT.IDChiTietSach\n"
                    + "AND CTS.IDSach LIKE \"" + idSach + "\" "
                    + "ORDER BY TM.NgayMuon DESC LIMIT 20";

            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                Calendar ngayMuon = Calendar.getInstance();
                ngayMuon.setTime(rs.getDate("NgayMuon"));
                String hoTen = rs.getString("HoTen");
                String tinhTrang = rs.getString("TinhTrang");
                list.put(i, new ThoiGianNguoiMuon(ngayMuon, hoTen, tinhTrang));
                i++;
            }
            JDBCUtil.closeConnection(c);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSoLuongTacGia() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT count(DISTINCT(tacgia)) as soluong FROM tacgia";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SOLUONG");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int getLuotMuon(String idSach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(S.IDSACH) AS SOLUONG FROM chitietthemuon cttm, chitietsach cts, sach s\n"
                    + "WHERE cttm.IDChiTietSach = cts.IDChiTietSach AND cts.IDSach = s.IDSach\n"
                    + "		AND s.IDSach = ? "
                    + "		GROUP BY S.IDSACH";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, idSach);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("SOLUONG");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public LinkedHashMap<Integer, Integer> getDataChartBySach(String idSach, int year) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= 12; i++) {
            map.put(i, 0);
        }
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT MONTH(NgayMuon) AS Thang ,COUNT(CTS.IDSACH) AS SoLuong FROM chitietsach CTS, chitietthemuon CT, themuon TM\n"
                    + "WHERE CTS.IDChiTietSach = CT.IDChiTietSach AND CT.IDTheMuon = TM.IDTheMuon\n"
                    + "	AND CTS.IDSACH = ? AND YEAR(TM.NgayMuon) = " + year
                    + "	GROUP BY MONTH(NgayMuon), CTS.IDSACH";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, idSach);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int thang = rs.getInt("Thang");
                int soLuong = rs.getInt("soLuong");
                map.put(thang, soLuong);
            }
            JDBCUtil.closeConnection(c);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
