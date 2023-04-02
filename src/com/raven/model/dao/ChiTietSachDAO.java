package com.raven.model.dao;

import com.raven.model.database.JDBCUtil;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;

public class ChiTietSachDAO implements DAOInterface<ChiTietSach> {

    public static ChiTietSachDAO getInstance() {
        return new ChiTietSachDAO();
    }

    @Override
    public int insert(ChiTietSach cts) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sql = "INSERT INTO ChiTietSach (IDChiTietSach, IDSach, NamPhatHanh, NhaXuatBan, GiaTien, NgonNgu, NgayNhap, TrangThai) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, cts.getIdChiTietSach());
            st.setString(2, cts.getIdSach());
            st.setString(3, cts.getNamPhatHanh() + "");
            st.setString(4, cts.getNhaXuatBan());
            st.setString(5, cts.getGiaTien() + "");
            st.setString(6, cts.getNgonNgu());
            st.setString(7, sdf.format(cts.getNgayNhap().getTime()));
            st.setString(8, cts.getTrangThai() + "");
            ketQua = st.executeUpdate();
            System.out.printf("Có %d dòng bị thay đổi ở ChiTietSach \n", ketQua);

//          INSERT TACGIA
            for (String tenTG : cts.getTacGia()) {
                String sqlTacGia = "INSERT INTO TacGia (IDChiTietSach, TacGia) "
                        + "VALUES (?,?)";
                PreparedStatement st2 = c.prepareStatement(sqlTacGia);
                st2.setString(1, cts.getIdChiTietSach());
                String tg = tenTG.trim();
                st2.setString(2, tg);
                st2.executeUpdate();
            }
//          INSERT THELOAI
            for (String tenTL : cts.getTheLoai()) {
                String sql4 = "INSERT INTO THELOAI (IDChiTietSach, TheLoai) "
                        + "VALUES (?,?)";
                PreparedStatement st4 = c.prepareStatement(sql4);
                st4.setString(1, cts.getIdChiTietSach());
                String tl = tenTL.trim();
                st4.setString(2, tl);
                ketQua += st4.executeUpdate();
            }
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(ChiTietSach cts) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            String sql2 = "DELETE FROM TacGia "
                    + "WHERE idChiTietSach = ? ";
            PreparedStatement st2 = c.prepareStatement(sql2);
            st2.setString(1, cts.getIdChiTietSach());
            ketQua += st2.executeUpdate();

            String sql = "DELETE FROM ChiTietSach "
                    + "WHERE idChiTietSach = ? ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, cts.getIdChiTietSach());
            ketQua += st.executeUpdate();
            c.commit();
            JDBCUtil.closeConnection(c);
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateTrangThai(String idChiTietSach, String trangThai) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "UPDATE chitietsach SET TrangThai= ? WHERE IDChiTietSach = ? ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, trangThai);
            st.setString(2, idChiTietSach);
            ketQua += st.executeUpdate();
            JDBCUtil.closeConnection(c);
            System.out.println("Update tình trạng thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int multripleDelete(String idSach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            String sql2 = "DELETE FROM TacGia "
                    + "WHERE idChiTietSach LIKE \"" + idSach + "-%\"";
            PreparedStatement st2 = c.prepareStatement(sql2);
            st2.executeUpdate();

            String sql3 = "DELETE FROM TheLoai "
                    + "WHERE idChiTietSach LIKE \"" + idSach + "-%\"";
            PreparedStatement st3 = c.prepareStatement(sql3);
            st3.executeUpdate();

            String sql = "DELETE FROM ChiTietSach "
                    + "WHERE idChiTietSach LIKE \"" + idSach + "-%\"";
            PreparedStatement st = c.prepareStatement(sql);
            ketQua += st.executeUpdate();

            String sql4 = "DELETE FROM chitietthemuon WHERE IDChiTietSach IN (SELECT IDChiTietSach FROM chitietsach WHERE idsach = \"" + idSach + "\"";
            PreparedStatement st4 = c.prepareStatement(sql4);
            st4.executeUpdate();

            c.commit();
            JDBCUtil.closeConnection(c);
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //XÓA CÁC THẺ MƯỢN TRỐNG SAU KHI XÓA SÁCH
        TheMuonDAO.getInstance().deleteTMempty();
        return ketQua;
    }

    @Override
    public int update(ChiTietSach cts) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sql = "UPDATE ChiTietSach "
                    + "SET IDSach =?, NamPhatHanh=?, NhaXuatBan=?, GiaTien=?, NgonNgu=?, NgayNhap=?, TrangThai =? "
                    + "WHERE IDChiTietSach= ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, cts.getIdSach());
            st.setString(2, cts.getNamPhatHanh() + "");
            st.setString(3, cts.getNhaXuatBan());
            st.setString(4, cts.getGiaTien() + "");
            st.setString(5, cts.getNgonNgu());
            st.setString(6, sdf.format(cts.getNgayNhap().getTime()));
            st.setString(7, cts.getTrangThai() + "");
            st.setString(8, cts.getIdChiTietSach());
            ketQua = st.executeUpdate();

            // UPDATE tacgia && theloai
            String sql2 = "DELETE FROM TacGia WHERE IDChiTietSach = ? ";
            PreparedStatement st2 = c.prepareStatement(sql2);
            st2.setString(1, cts.getIdChiTietSach());
            ketQua += st2.executeUpdate();

            String sql3 = "DELETE FROM TheLoai WHERE idChiTietSach=? ";
            PreparedStatement st3 = c.prepareStatement(sql3);
            st3.setString(1, cts.getIdChiTietSach());
            ketQua += st3.executeUpdate();

//          INSERT TACGIA
            if (cts.getTacGia() != null) {
                for (String tenTG : cts.getTacGia()) {
                    String sql4 = "INSERT INTO TacGia (IDChiTietSach, TacGia) "
                            + "VALUES (?,?)";
                    PreparedStatement st4 = c.prepareStatement(sql4);
                    st4.setString(1, cts.getIdChiTietSach());
                    st4.setString(2, tenTG);
                    ketQua += st4.executeUpdate();
                }
            }
//          INSERT THELOAI
            if (cts.getTheLoai() != null) {
                for (String tenTL : cts.getTheLoai()) {
                    String sql4 = "INSERT INTO THELOAI (IDChiTietSach, TheLoai) "
                            + "VALUES (?,?)";
                    PreparedStatement st4 = c.prepareStatement(sql4);
                    st4.setString(1, cts.getIdChiTietSach());
                    st4.setString(2, tenTL);
                    ketQua += st4.executeUpdate();
                }
            }
            System.out.printf("Có %d dòng bị thay đổi \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietSach> selectAll() {
        ArrayList<ChiTietSach> resultList = new ArrayList<ChiTietSach>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sqlALL = "SELECT * FROM ChiTietSach";
            PreparedStatement stALL = c.prepareStatement(sqlALL);
            ResultSet rsALL = stALL.executeQuery();
            while (rsALL.next()) {
                String idChiTietSach = rsALL.getString("idChiTietSach");
                String idSach = rsALL.getString("IDSach");
                int namPhatHanh = rsALL.getInt("NamPhatHanh");
                String nhaXuatBan = rsALL.getString("NhaXuatBan");
                double giaTien = rsALL.getDouble("GiaTien");
                String ngonNgu = rsALL.getString("NgonNgu");
                Calendar ngayNhap = Calendar.getInstance();
                ngayNhap.setTime(rsALL.getDate("NgayNhap"));
//                ngayNhap.set(Calendar.MONTH, ngayNhap.get(Calendar.MONTH) + 1);
                String trangThai = rsALL.getString("TrangThai");

//              GET ARR TACGIA
                ArrayList<String> arrTacGia = new ArrayList<String>();
                String sql2 = "SELECT * FROM TacGia WHERE IDChiTietSach=? ";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, idChiTietSach);
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String tenTG = rs2.getString("TacGia");
                    arrTacGia.add(tenTG);
                }

//              GET ARR THELOAI
                ArrayList<String> arrTheLoai = new ArrayList<String>();
                String sql3 = "SELECT * FROM TheLoai WHERE IDChiTietSach=? ";
                PreparedStatement st3 = c.prepareStatement(sql3);
                st3.setString(1, idChiTietSach);
                ResultSet rs3 = st3.executeQuery();
                while (rs3.next()) {
                    String theLoai = rs3.getString("TheLoai");
                    arrTheLoai.add(theLoai);
                }

                ChiTietSach cts = new ChiTietSach(idChiTietSach, idSach, namPhatHanh, nhaXuatBan, giaTien,
                        ngonNgu, ngayNhap, trangThai, arrTheLoai, arrTacGia);

                resultList.add(cts);
            }
            JDBCUtil.closeConnection(c);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ChiTietSach selectByID(String id) {
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM ChiTietSach "
                    + "WHERE IDChiTietSach= ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idChiTietSach = rs.getString("idChiTietSach");
                String idSach = rs.getString("IDSach");
                int namPhatHanh = rs.getInt("NamPhatHanh");
                String nhaXuatBan = rs.getString("NhaXuatBan");
                double giaTien = rs.getDouble("GiaTien");
                String ngonNgu = rs.getString("NgonNgu");
                Calendar ngayNhap = Calendar.getInstance();
                ngayNhap.setTime(rs.getDate("NgayNhap"));

                String trangThai = rs.getString("TrangThai");

//              GET ARR TACGIA
                ArrayList<String> arrTacGia = new ArrayList<String>();
                String sql2 = "SELECT * FROM TacGia WHERE IDChiTietSach=? ";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, id);
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String tenTG = rs2.getString("TacGia");
                    arrTacGia.add(tenTG);
                }

//              GET ARR THELOAI
                ArrayList<String> arrTheLoai = new ArrayList<String>();
                String sql3 = "SELECT * FROM TheLoai WHERE IDChiTietSach=? ";
                PreparedStatement st3 = c.prepareStatement(sql3);
                st3.setString(1, id);
                ResultSet rs3 = st3.executeQuery();
                while (rs3.next()) {
                    String theLoai = rs3.getString("TheLoai");
                    arrTheLoai.add(theLoai);
                }

                ChiTietSach cts = new ChiTietSach(idChiTietSach, idSach, namPhatHanh, nhaXuatBan, giaTien,
                        ngonNgu, ngayNhap, trangThai, arrTheLoai, arrTacGia);
                JDBCUtil.closeConnection(c);
                return cts;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getAllTheLoai() {
        ArrayList<String> resultList = new ArrayList<String>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT DISTINCT(theloai) FROM THELOAI";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                resultList.add(rs.getString("TheLoai"));
            }
            JDBCUtil.closeConnection(c);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ChiTietSach> getCTSByIDSach(String idSach) {
        ArrayList<ChiTietSach> resultList = new ArrayList<ChiTietSach>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql5 = "SELECT * FROM ChiTietSach WHERE idSach = \"" + idSach + "\"";
            PreparedStatement st5 = c.prepareStatement(sql5);
            ResultSet rs5 = st5.executeQuery();
            while (rs5.next()) {
                String idChiTietSach = rs5.getString("idChiTietSach");
                int namPhatHanh = rs5.getInt("NamPhatHanh");
                String nhaXuatBan = rs5.getString("NhaXuatBan");
                double giaTien = rs5.getDouble("GiaTien");
                String ngonNgu = rs5.getString("NgonNgu");
                Calendar ngayNhap = Calendar.getInstance();
                ngayNhap.setTime(rs5.getDate("NgayNhap"));
//                ngayNhap.set(Calendar.MONTH, ngayNhap.get(Calendar.MONTH) + 1);
                String trangThai = rs5.getString("TrangThai");

                //              GET ARR TACGIA
                ArrayList<String> arrTacGia = new ArrayList<String>();
                String sql2 = "SELECT * FROM TacGia WHERE IDChiTietSach=? ";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, idSach + "-00");
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String tenTG = rs2.getString("TacGia");
                    arrTacGia.add(tenTG);
                }

//              GET ARR THELOAI
                ArrayList<String> arrTheLoai = new ArrayList<String>();
                String sql3 = "SELECT * FROM TheLoai WHERE IDChiTietSach=? ";
                PreparedStatement st3 = c.prepareStatement(sql3);
                st3.setString(1, idSach + "-00");
                ResultSet rs3 = st3.executeQuery();
                while (rs3.next()) {
                    String theLoai = rs3.getString("TheLoai");
                    arrTheLoai.add(theLoai);
                }

                ChiTietSach cts = new ChiTietSach(idChiTietSach, idSach, namPhatHanh, nhaXuatBan, giaTien,
                        ngonNgu, ngayNhap, trangThai, arrTheLoai, arrTacGia);
                resultList.add(cts);
            }
            JDBCUtil.closeConnection(c);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSach castCTS(String idSach) {
        ChiTietSach cts = null;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql5 = "SELECT * FROM ChiTietSach WHERE idSach = \"" + idSach + "\"";
            PreparedStatement st5 = c.prepareStatement(sql5);
            ResultSet rs5 = st5.executeQuery();
            while (rs5.next()) {
                String idChiTietSach = rs5.getString("idChiTietSach");
                int namPhatHanh = rs5.getInt("NamPhatHanh");
                String nhaXuatBan = rs5.getString("NhaXuatBan");
                double giaTien = rs5.getDouble("GiaTien");
                String ngonNgu = rs5.getString("NgonNgu");
                Calendar ngayNhap = Calendar.getInstance();
                ngayNhap.setTime(rs5.getDate("NgayNhap"));
//                ngayNhap.set(Calendar.MONTH, ngayNhap.get(Calendar.MONTH) + 1);
                String trangThai = rs5.getString("TrangThai");

                //              GET ARR TACGIA
                ArrayList<String> arrTacGia = new ArrayList<String>();
                String sql2 = "SELECT * FROM TacGia WHERE IDChiTietSach=? ";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, idSach + "-00");
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String tenTG = rs2.getString("TacGia");
                    arrTacGia.add(tenTG);
                }

//              GET ARR THELOAI
                ArrayList<String> arrTheLoai = new ArrayList<String>();
                String sql3 = "SELECT * FROM TheLoai WHERE IDChiTietSach=? ";
                PreparedStatement st3 = c.prepareStatement(sql3);
                st3.setString(1, idSach + "-00");
                ResultSet rs3 = st3.executeQuery();
                while (rs3.next()) {
                    String theLoai = rs3.getString("TheLoai");
                    arrTheLoai.add(theLoai);
                }
                cts = new ChiTietSach(idChiTietSach, idSach, namPhatHanh, nhaXuatBan, giaTien,
                        ngonNgu, ngayNhap, trangThai, arrTheLoai, arrTacGia);
                break;
            }
            JDBCUtil.closeConnection(c);
            return cts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cts;
    }

    public int updateByFormQLS(ArrayList<ChiTietSach> arr, ChiTietSach cts, ArrayList<String> arrTacGia, ArrayList<String> arrTheLoai) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sql = "UPDATE ChiTietSach "
                    + "SET NamPhatHanh=?, NhaXuatBan=?, GiaTien=?, NgonNgu=?, NgayNhap=? "
                    + "WHERE IDSach =?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, cts.getNamPhatHanh() + "");
            st.setString(2, cts.getNhaXuatBan());
            st.setString(3, cts.getGiaTien() + "");
            st.setString(4, cts.getNgonNgu());
            st.setString(5, sdf.format(cts.getNgayNhap().getTime()));
            st.setString(6, cts.getIdSach());
            ketQua = st.executeUpdate();

            // UPDATE tacgia && theloai
            String sql2 = "DELETE FROM TacGia WHERE IDChiTietSach LIKE \"" + cts.getIdSach() + "-%\" ";
            PreparedStatement st2 = c.prepareStatement(sql2);
            ketQua += st2.executeUpdate();

            String sql3 = "DELETE FROM TheLoai WHERE IDChiTietSach LIKE \"" + cts.getIdSach() + "-%\" ";
            PreparedStatement st3 = c.prepareStatement(sql3);
            ketQua += st3.executeUpdate();

//          INSERT TACGIA
            for (ChiTietSach idCTS : arr) {
                if (arrTacGia != null) {
                    for (String tenTG : cts.getTacGia()) {
                        String sql4 = "INSERT INTO TacGia (IDChiTietSach, TacGia) "
                                + "VALUES (?,?)";
                        PreparedStatement st4 = c.prepareStatement(sql4);
                        st4.setString(1, idCTS.getIdChiTietSach());
                        st4.setString(2, tenTG);
                        ketQua += st4.executeUpdate();
                    }
                }
//                INSERT THELOAI
                if (cts.getTheLoai() != null) {
                    for (String tenTL : arrTheLoai) {
                        String sql4 = "INSERT INTO THELOAI (IDChiTietSach, TheLoai) "
                                + "VALUES (?,?)";
                        PreparedStatement st4 = c.prepareStatement(sql4);
                        st4.setString(1, idCTS.getIdChiTietSach());
                        st4.setString(2, tenTL);
                        ketQua += st4.executeUpdate();
                    }
                }
            }

//          
            System.out.printf("Có %d dòng bị thay đổi \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return ketQua;
    }

    public int getSachReadyByIDSach(String idSach) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(IDSACH) AS SOLUONG FROM chitietsach WHERE IDSACH = ? AND TRANGTHAI = 'Sẵn sàng' "
                    + "GROUP BY IDSACH";
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

    public LinkedHashMap<String, Integer> getSoLuongTheoTinhTrang() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT TRANGTHAI, COUNT(IDCHITIETSACH) AS SOLUONG FROM chitietsach GROUP BY TRANGTHAI";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tt = rs.getString("TrangThai").trim();
                int soLuong = rs.getInt("SoLuong");
                list.put(tt, soLuong);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTongChiPhi() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT  sum(giatien) as chiphi FROM chitietsach";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ketQua = rs.getInt("chiphi");
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
