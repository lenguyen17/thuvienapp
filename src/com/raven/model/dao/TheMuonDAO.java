package com.raven.model.dao;

import com.raven.model.database.JDBCUtil;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.TheMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TheMuonDAO implements DAOInterface<TheMuon> {

    public static TheMuonDAO getInstance() {
        return new TheMuonDAO();
    }

    @Override
    public int insert(TheMuon theMuon) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//          INSRTT INTO TABLE THEMUON
            String sql = "INSERT INTO TheMuon (IDTheMuon, IDHoiVien, IDNhanVien, NgayMuon, NgayHenTra) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, theMuon.getIdTheMuon());
            st.setString(2, theMuon.getIdHoiVien());
            st.setString(3, theMuon.getIdNhanVien());
            st.setString(4, sdf.format(theMuon.getNgayMuon().getTime()));
            st.setString(5, sdf.format(theMuon.getNgayHenTra().getTime()));
            ketQua = st.executeUpdate();
            System.out.printf("Có %d dòng bị thay đổi ở TheMuon \n", ketQua);
//          INSRTT INTO TABLE CHITIETTHEMUON
            ketQua = 0;
            for (ChiTietSach idChiTietSach : theMuon.getListCTS()) {
                String sql2 = "INSERT INTO ChiTietTheMuon (IDTheMuon, IDChiTietSach, NgayTra, TinhTrang) "
                        + "VALUES (?,?,?,?)";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, theMuon.getIdTheMuon());
                st2.setString(2, idChiTietSach.getIdChiTietSach());
                if (theMuon.getNgayTra() != null) {
                    st2.setString(3, sdf.format(theMuon.getNgayTra().getTime()));
                } else {
                    st2.setNull(3, java.sql.Types.DATE);
                }
                st2.setString(4, theMuon.getTinhTrang());
                ketQua += st2.executeUpdate();
            }
            System.out.printf("Có %d dòng bị thay đổi o ChiTietTheMuon \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(TheMuon theMuon) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
//          Xóa dữ liệu ở bảng ChiTietTheMuon để bỏ ràng buộc khóa ngoại
            String sql = "DELETE FROM ChiTietTheMuon WHERE IDTheMuon=? ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, theMuon.getIdTheMuon());
            ketQua = st.executeUpdate();
            System.out.printf("Đã xóa %d dòng ở ChiTietTheMuon \n", ketQua);

//          Xóa xữ liệu ở bảng thẻ mượn
            String sql2 = "DELETE FROM TheMuon WHERE IDTheMuon=? ";
            PreparedStatement st2 = c.prepareStatement(sql2);
            st2.setString(1, theMuon.getIdTheMuon());
            ketQua += st2.executeUpdate();
            System.out.printf("Đã xóa %d dòng ở TheMuon \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public int deleteTMempty() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
//          THẺ MƯỢN KHÔNG CHỨA CTS NÊN KHÔNG CẦN XÓA RÀNG BUỘC TRƯỚC
            String sql = "DELETE FROM themuon WHERE idthemuon NOT IN "
                    + "(SELECT tm.IDTheMuon FROM themuon tm, chitietthemuon ct WHERE tm.IDTheMuon = ct.IDTheMuon)";
            PreparedStatement st = c.prepareStatement(sql);
            ketQua = st.executeUpdate();
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(TheMuon theMuon) {
        delete(theMuon);
        insert(theMuon);
        return 0;
    }

    @Override
    public ArrayList<TheMuon> selectAll() {
        ArrayList<TheMuon> resultList = new ArrayList<TheMuon>();
        SimpleDateFormat sdf = new SimpleDateFormat("mm/DD/yyyy");
        try (Connection c = JDBCUtil.getConnection()) {
            String sqlTM = "SELECT * FROM TheMuon";
            PreparedStatement stTM = c.prepareStatement(sqlTM);
            ResultSet rsTM = stTM.executeQuery();
            while (rsTM.next()) {
                String idTheMuon = rsTM.getString("IDTheMuon");
                String idHoiVien = rsTM.getString("IDHoiVien");
                String idNhanVien = rsTM.getString("IDNhanVien");
                Calendar ngayMuon = Calendar.getInstance();
                ngayMuon.setTime(rsTM.getDate("NgayMuon"));
                Calendar ngayHenTra = Calendar.getInstance();
                ngayHenTra.setTime(rsTM.getDate("NgayHentra"));

                Calendar ngayTra = Calendar.getInstance();
                ngayTra.setTime(sdf.parse("01/01/2000"));
                Calendar temp = Calendar.getInstance();
//          Lấy list ChitietSach đã mượn
//                Lấy list idchitietsach trước
                ArrayList<String> listIDCTS = new ArrayList<String>();
                String sql2 = "SELECT * FROM ChiTietTheMuon WHERE IDTheMuon=?";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, idTheMuon);
                String tinhTrang = "Đang mượn";
                boolean check = false;
                boolean checkTre = false;
                boolean checkDaTra = true;
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String idChiTietSach = rs2.getString("IDChiTietSach");
                    if (rs2.getDate("NgayTra") != null) {
                        temp.setTime(rs2.getDate("NgayTra"));
                        if (ngayTra.compareTo(temp) < 0) {
                            ngayTra.setTime(temp.getTime());
                        }
                    } else {
                        check = true;
                    }
                    if (!rs2.getString("TinhTrang").equalsIgnoreCase("Đã trả") && !rs2.getString("TinhTrang").equalsIgnoreCase("Hoàn tiền")) {
                        checkDaTra = false;
                    }
                    if (rs2.getString("TinhTrang").equalsIgnoreCase("Trễ hẹn")) {
                        checkTre = true;
                    }
                    listIDCTS.add(idChiTietSach);
                }
//                Dùng listID đó lấy ChiTietSach
                ArrayList<ChiTietSach> listCTS = new ArrayList<ChiTietSach>();
                for (String idCTS : listIDCTS) {
                    ChiTietSach cts = ChiTietSachDAO.getInstance().selectByID(idCTS);
                    listCTS.add(cts);
                }
                temp.setTime(sdf.parse("01/01/2000"));
                if (checkDaTra) {
                    tinhTrang = "Đã trả";
                }
                if (checkTre) {
                    tinhTrang = "Trễ hẹn";
                }
                if (check || (ngayTra.compareTo(temp) == 0)) {
                    TheMuon tm = new TheMuon(idTheMuon, idHoiVien, idNhanVien, ngayMuon, ngayHenTra, null, listCTS, tinhTrang);
                    resultList.add(tm);
                } else {
                    TheMuon tm = new TheMuon(idTheMuon, idHoiVien, idNhanVien, ngayMuon, ngayHenTra, ngayTra, listCTS, tinhTrang);
                    resultList.add(tm);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TheMuon selectByID(String id) {
        try (Connection c = JDBCUtil.getConnection()) {
            SimpleDateFormat sdf = new SimpleDateFormat("mm/DD/yyyy");
            String sqlTM = "SELECT * FROM TheMuon WHERE IDTheMuon= ?";
            PreparedStatement stTM = c.prepareStatement(sqlTM);
            stTM.setString(1, id);
            ResultSet rsTM = stTM.executeQuery();
            while (rsTM.next()) {
                String idHoiVien = rsTM.getString("IDHoiVien");
                String idNhanVien = rsTM.getString("IDNhanVien");
                Calendar ngayMuon = Calendar.getInstance();
                ngayMuon.setTime(rsTM.getDate("NgayMuon"));
                Calendar ngayHenTra = Calendar.getInstance();
                ngayHenTra.setTime(rsTM.getDate("NgayHentra"));

                Calendar ngayTra = Calendar.getInstance();
                ngayTra.setTime(sdf.parse("01/01/2000"));
                Calendar temp = Calendar.getInstance();

//          Lấy list ChitietSach đã mượn
//                Lấy list idchitietsach trước
                ArrayList<String> listIDCTS = new ArrayList<String>();
                String sql2 = "SELECT * FROM ChiTietTheMuon WHERE IDTheMuon=?";
                PreparedStatement st2 = c.prepareStatement(sql2);
                st2.setString(1, id);
                String tinhTrang = "Đang mượn";
                boolean check = false;
                boolean checkTre = false;
                boolean checkDaTra = true;
                ResultSet rs2 = st2.executeQuery();
                while (rs2.next()) {
                    String idChiTietSach = rs2.getString("IDChiTietSach");
                    if (rs2.getDate("NgayTra") != null) {
                        temp.setTime(rs2.getDate("NgayTra"));
                        if (ngayTra.compareTo(temp) < 0) {
                            ngayTra.setTime(temp.getTime());
                        }
                    } else {
                        check = true;
                    }
                    if (!rs2.getString("TinhTrang").equalsIgnoreCase("Đã trả") && !rs2.getString("TinhTrang").equalsIgnoreCase("Hoàn tiền")) {
                        checkDaTra = false;
                    }
                    if (rs2.getString("TinhTrang").equalsIgnoreCase("Trễ hẹn")) {
                        checkTre = true;
                    }
                    if (rs2.getString("TinhTrang").equalsIgnoreCase("Đã trả") || rs2.getString("TinhTrang").equalsIgnoreCase("Hoàn tiền")) {
                        if (rs2.getString("TinhTrang").equalsIgnoreCase("Đã trả")) {
                            tinhTrang = "Đã trả";
                        } else {
                            tinhTrang = "Hoàn tiền";
                        }
                    }
                    if (rs2.getString("TinhTrang").equalsIgnoreCase("Trễ hẹn")) {
                        tinhTrang = "Trễ hẹn";
                    }
                    listIDCTS.add(idChiTietSach);
                }
//                Dùng listID đó lấy ChiTietSach
                ArrayList<ChiTietSach> listCTS = new ArrayList<ChiTietSach>();
                for (String idCTS : listIDCTS) {
                    ChiTietSach cts = ChiTietSachDAO.getInstance().selectByID(idCTS);
                    listCTS.add(cts);
                }
                if (checkDaTra) {
                    tinhTrang = "Đã trả";
                }
                if (checkTre) {
                    tinhTrang = "Trễ hẹn";
                }
                if (check) {
                    TheMuon tm = new TheMuon(id, idHoiVien, idNhanVien, ngayMuon, ngayHenTra, null, listCTS, tinhTrang);
                    return tm;
                } else {
                    TheMuon tm = new TheMuon(id, idHoiVien, idNhanVien, ngayMuon, ngayHenTra, ngayTra, listCTS, tinhTrang);
                    return tm;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateChiTietTheMuon(TheMuon theMuon, ChiTietSach cts, Calendar ngayTra, String tinhTrang) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            String sql = "UPDATE ChiTietTheMuon SET NgayTra =?, TinhTrang=?  WHERE IDTheMuon= ? AND IDChiTietSach= ? ";
            PreparedStatement st = c.prepareStatement(sql);
            if (ngayTra != null) {
                st.setString(1, sdf.format(theMuon.getNgayTra().getTime()));
            } else {
                st.setNull(1, java.sql.Types.DATE);
            }
            st.setString(2, tinhTrang);
            st.setString(3, theMuon.getIdTheMuon());
            st.setString(4, cts.getIdChiTietSach());
            ketQua = st.executeUpdate();
            System.out.printf("Có %d đòng thay đổi trong ChiTietTheMuon \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int traHet(TheMuon theMuon) {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            c.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            String sql = "UPDATE ChiTietTheMuon SET NgayTra =?, TinhTrang=?  WHERE IDTheMuon= ? ";
            PreparedStatement st = c.prepareStatement(sql);
            if (theMuon.getNgayTra() != null) {
                st.setString(1, sdf.format(theMuon.getNgayTra().getTime()));
            } else {
                st.setNull(1, java.sql.Types.DATE);
            }
            st.setString(2, "Đã trả");
            st.setString(3, theMuon.getIdTheMuon());
            ketQua = st.executeUpdate();
            System.out.printf("Có %d đòng thay đổi trong ChiTietTheMuon \n", ketQua);
            c.commit();
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int kiemTraSoSachCoTheMuon(String idHoiVien) {
        int ketQua = 0;
        if (idHoiVien.replace(" ", "").length() != 0) {
            try (Connection c = JDBCUtil.getConnection()) {
                String sql = "SELECT * FROM themuon T, chitietthemuon C "
                        + "WHERE T.IDTheMuon = C.IDTheMuon "
                        + "		AND TinhTrang NOT LIKE N'Đã trả' "
                        + "		AND TinhTrang NOT LIKE N'Hoàn tiền' "
                        + "		AND idhoivien LIKE ?";
                PreparedStatement st = c.prepareStatement(sql);
                st.setString(1, idHoiVien);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    ++ketQua;
                }
                JDBCUtil.closeConnection(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(idHoiVien + " đang mượn: " + ketQua);
        return ketQua;
    }

    public String getNewIDTheMuon() {
        String textID = "";
        try (Connection c = JDBCUtil.getConnection()) {
            Calendar cal = Calendar.getInstance();
            String sql = "SELECT IDTheMuon FROM themuon WHERE idtheMuon LIKE \"" + (cal.get(Calendar.YEAR) - 2000) + "" + (cal.get(Calendar.MONTH) + 1 < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + ""
                    + (cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE)) + "%\" ORDER BY idTheMuon desc LIMIT 1";
            System.out.println(sql);
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int numbid = Integer.valueOf(rs.getString("IDTheMuon"));
                ++numbid;
                textID = numbid + "";
            }
            if (textID.length() == 0) {
                String temp = (cal.get(Calendar.YEAR) - 2000) + "" + (cal.get(Calendar.MONTH) + 1 < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + ""
                        + (cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE)) + "001";
                return temp;
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("New ID the muon: " + textID);
        return textID;
    }

    public int traTungQuyen(String idTheMuon, String idCTS, String tinhTrang, Calendar ngayTra) {
        int ketQua = 0;
        String tinhTrangBanDau = "";
        try (Connection c = JDBCUtil.getConnection()) {
            //KIEM TRA TINH TRANG BAN DAU
            String sqlKiemTra = "SELECT * FROM ChiTietTheMuon WHERE idTheMuon =? AND idChiTietSach =? ";
            PreparedStatement stKiemTra = c.prepareStatement(sqlKiemTra);
            stKiemTra.setString(1, idTheMuon);
            stKiemTra.setString(2, idCTS);
            ResultSet rsKiemTra = stKiemTra.executeQuery();
            while (rsKiemTra.next()) {
                tinhTrangBanDau = rsKiemTra.getString("tinhTrang");
            }
            if (tinhTrang.equalsIgnoreCase(tinhTrangBanDau) || tinhTrang.equalsIgnoreCase("Trễ hẹn")) {
                return 0;
            }

            //UPDATE TINH TRANG THE MUON
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sql = "UPDATE ChiTietTheMuon SET NgayTra =?, TinhTrang=?  WHERE IDTheMuon= ? AND IDChiTietSach=? ";
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, sdf.format(ngayTra.getTime()));
            st.setString(2, tinhTrang);
            st.setString(3, idTheMuon);
            st.setString(4, idCTS);
            ketQua = st.executeUpdate();
            //UPDATE TINH TRANG CHI TIET SACH
            String tinhTrangCTS = "";
            if (tinhTrang.equalsIgnoreCase("Hoàn tiền")) {
                tinhTrangCTS = "Mất";
            } else if (tinhTrang.equalsIgnoreCase("Đã trả")) {
                tinhTrangCTS = "Sẵn sàng";
            }
            if (tinhTrangCTS != null) {
                String sqlCTS = "UPDATE ChiTietSach SET trangThai=? WHERE idChiTietSach=? ";
                PreparedStatement stCTS = c.prepareStatement(sqlCTS);
                stCTS.setString(1, idCTS);
                stCTS.setString(2, tinhTrangCTS);
                ketQua += stCTS.executeUpdate();

            }
            System.out.printf("Có %d đòng thay đổi trong ChiTietTheMuon \n", ketQua);
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // IDChiTietSach, Ngaytra
    public LinkedHashMap<String, Calendar> getNgayTraByTheMuon(String idTheMuon) {
        LinkedHashMap<String, Calendar> hmNgayTra = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String sql = "SELECT * FROM ChiTietTheMuon Where IDTheMuon =? ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, idTheMuon);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate("NgayTra");
                if (d != null) {
                    Calendar ngaytra = Calendar.getInstance();
                    ngaytra.setTime(d);
                    hmNgayTra.put(rs.getString("IDChiTietSach"), ngaytra);
                } else {
                    hmNgayTra.put(rs.getString("IDChiTietSach"), null);
                }

            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hmNgayTra;
    }

    // IDChiTietSach, tinhTrang
    public LinkedHashMap<String, String> getTinhTrangByTheMuon(String idTheMuon) {
        LinkedHashMap<String, String> hmTinhTrang = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM ChiTietTheMuon Where IDTheMuon =? ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, idTheMuon);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tt = rs.getString("TinhTrang");
                if (tt.replaceAll(" ", "").length() != 0) {
                    hmTinhTrang.put(rs.getString("IDChiTietSach"), tt);
                } else {
                    hmTinhTrang.put(rs.getString("IDChiTietSach"), "Không rõ");
                }
            }
            JDBCUtil.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hmTinhTrang;
    }

    public ArrayList<TheMuon> searchTMByCondition(String con, String loaiThe, boolean idTM, boolean hv,
            boolean sach, boolean thoiGian, Calendar dateFrom, Calendar dateTo) {
        ArrayList<TheMuon> listIDTM = new ArrayList<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT DISTINCT(TM.IDTHEMUON) FROM themuon TM, chitietthemuon CTTM, hoivien HV, sach S, chitietsach CTS\n"
                    + "		WHERE TM.IDTheMuon = CTTM.IDTheMuon\n"
                    + "		AND TM.IDHoiVien = HV.IDHOIVIEN\n"
                    + "		AND TM.IDHoiVien = HV.IDHoiVien\n"
                    + "		AND CTTM.IDChiTietSach = CTS.IDChiTietSach\n"
                    + "		AND S.IDSach = CTS.IDSACH ";

            //TÌM THEO LOẠI THẺ ( NẾU CÓ ) 
            if (loaiThe.equalsIgnoreCase("Đã trả")) {
                sql += " AND (CTTM.TINHTRANG LIKE \'" + loaiThe + "\' OR " + " CTTM.TINHTRANG LIKE \'Hoàn tiền\' ) ";
            } else if (loaiThe.equalsIgnoreCase("Đang mượn")) {
                sql += " AND (CTTM.TINHTRANG LIKE \'" + loaiThe + "\' OR " + " CTTM.TINHTRANG LIKE \'Trễ hẹn\' ) ";
            } else if (!loaiThe.equalsIgnoreCase("Tất cả")) {
                sql += " AND CTTM.TINHTRANG LIKE \'" + loaiThe + "\' ";
            }

            // FILTER CONDITION
            if (con != null && !con.equalsIgnoreCase("Nhập mã thẻ mượn, hội viên, sách, ...")) {
                if (idTM || hv || sach) {
                    sql += " AND ( ";
                    if (idTM) {
                        sql += " TM.IDTHEMUON LIKE \"%" + con + "%\" ";
                    }
                    if (hv) {
                        if (idTM) {
                            sql += " OR ";
                        }
                        sql += " HV.IDHOIVIEN LIKE \'%" + con + "%\' OR HV.HOTEN LIKE \'%" + con + "%\' ";
                    }
                    if (sach) {
                        if (idTM || hv) {
                            sql += " OR ";
                        }
                        sql += " S.TenSach LIKE \'%" + con + "%\' OR CTS.IDCHITIETSACH LIKE \'%" + con + "%\' ";
                    }
                    sql += " )";
                }
            }
            //FILTER TIME
            if (thoiGian) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String from = sdf.format(dateFrom.getTime());
                String to = sdf.format(dateTo.getTime());
                sql += " AND TM.NGAYMUON BETWEEN \'" + from + "\' AND \'" + to + "\' ";
            }

            sql += " ORDER BY TM.IDTheMuon ASC ";
            System.out.println(sql);
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idCanTim = rs.getString("idTheMuon");
                if (idCanTim != null) {
                    listIDTM.add(selectByID(idCanTim));
                }
            }
            JDBCUtil.closeConnection(c);
            return listIDTM;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedHashMap<String, Integer> getSoLuongTheoTinhTrang() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT tinhtrang, COUNT(DISTINCT(idthemuon)) AS soluong FROM chitietthemuon GROUP BY tinhtrang";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String tt = rs.getString("tinhtrang").trim();
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

    public int getSoLuongTheDangMuon() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(IDTHEMUON) AS SOLUONG FROM themuon \n"
                    + "	WHERE idthemuon IN (SELECT IDTHEMUON FROM chitietthemuon WHERE TINHTRANG LIKE 'Đang mượn' OR\n"
                    + "									TINHTRANG LIKE 'Trễ hẹn')\n";
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

    public int getSoLuongHetHanHomNay() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(idthemuon) AS soluong FROM themuon WHERE ngayhentra = CURDATE();";
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

    public int getTongSoSachDangMuon() {
        int ketQua = 0;
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT COUNT(IDCHITIETSACH) as SoLuong FROM CHITIETTHEMUON WHERE TINHTRANG LIKE 'Trễ hẹn' OR TINHTRANG LIKE 'Đang mượn'";
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

    public LinkedHashMap<Integer, Integer> getSLSachMuonMoiThang(int year) {
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();
        for (int i = 1; i <= 12; i++) {
            list.put(i, 0);
        }
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT MONTH(tm.ngaymuon) AS thang, COUNT(ct.idthemuon) AS soluong\n"
                    + "FROM chitietthemuon ct, themuon tm\n"
                    + "WHERE ct.IDTheMuon = tm.IDTheMuon\n"
                    + "AND YEAR(tm.ngaymuon) = ?\n"
                    + "GROUP BY MONTH(tm.ngaymuon)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, year + "");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int thang = rs.getInt("thang");
                int soLuong = rs.getInt("SoLuong");
                list.put(thang, soLuong);
            }
            JDBCUtil.closeConnection(c);
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
