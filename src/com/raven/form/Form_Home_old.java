package com.raven.form;

import com.raven.component.chart.piechart.ModelPieChart;
import com.raven.component.chart.piechart.PieChart;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.modelcomponent.ModelCard;
import com.raven.model.modelcomponent.ModelStudent;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.Sach;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Form_Home_old extends javax.swing.JPanel {

    public Form_Home_old() {
        initComponents();
        setOpaque(false);
        initData();
        intitPieChartSach();
        intitPieChartTinhTrangSach();
        jPanel1.setBorder(new LineBorder(Color.WHITE, 1, true));
    }

    private void initData() {
        initCardData();
        initNoticeBoard();
    }

    private void initCardData() {
        Icon icon1 = new ImageIcon(getClass().getResource("/com/raven/icon/book_60px.png"));
        card1.setData(new ModelCard("Tổng số sách", ChiTietSachDAO.getInstance().selectAll().size(), 100, icon1));
        Icon icon2 = new ImageIcon(getClass().getResource("/com/raven/icon/user_60px.png"));
        card2.setData(new ModelCard("Hội viên", HoiVienDAO.getInstance().selectAll().size(), 100, icon2));
        Icon icon3 = new ImageIcon(getClass().getResource("/com/raven/icon/themuon_60px.png"));
        card3.setData(new ModelCard("Hội viên đang mượn", TheMuonDAO.getInstance().getSoLuongTheDangMuon(), 100, icon3));
        Icon icon4 = new ImageIcon(getClass().getResource("/com/raven/icon/list_60px.png"));
        card4.setData(new ModelCard("Sách đang mượn", TheMuonDAO.getInstance().getTongSoSachDangMuon(), 100, icon4));

    }

    private void initNoticeBoard() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar today = Calendar.getInstance();
        jPanel1.setBackground(new Color(255, 255, 255, 100));
        noticeBoard.setBackground(new Color(0, 0, 0, 0));
        noticeBoard.addDate(sdf.format(today.getTime()));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Thẻ mượn", "", "- Số thẻ mượn hết hạn vào hôm nay: " + TheMuonDAO.getInstance().getSoLuongHetHanHomNay() + " "));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Hội viên", "", "- Hội viên đang mượn sách: " + HoiVienDAO.getInstance().getSoLuongHoiVienDangMuon() + "  \n"
                + "- Hội viên trễ hẹn trả sách: " + HoiVienDAO.getInstance().getSoLuongHoiVienTreHen() + " \n"
                + "- Tổng số lượng hội viên: " + HoiVienDAO.getInstance().selectAll().size() + " hội viên (" + HoiVienDAO.getInstance().getSoLuongHoiVienNam() + " nam và "
                + (HoiVienDAO.getInstance().selectAll().size() - HoiVienDAO.getInstance().getSoLuongHoiVienNam()) + " nữ)"));

        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Sách", "", "- Có tổng số " + SachDAO.getInstance().selectAll().size() + " đầu sách khác nhau gồm " + ChiTietSachDAO.getInstance().selectAll().size() + " quyển."));
//        String theLoai = "";
//        ArrayList<String> listTL = ChiTietSachDAO.getInstance().getAllTheLoai();
//        for (int i = 0; i < listTL.size(); i++) {
//            theLoai += listTL.get(i);
//            if (i < listTL.size() - 1) {
//                theLoai += ", ";
//            }
//        }
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Thể loại", "", "- Danh sách các thể loại đang có: " + theLoai + "\n- Số trên được viết bởi " + SachDAO.getInstance().getSoLuongTacGia() + " tác giả."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Chi phí", "", "Tổng số lượng tiền sách là: " + NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
//                .format(ChiTietSachDAO.getInstance().getTongChiPhi())));
        noticeBoard.scrollToTop();
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.raven.component.panelitems.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new com.raven.component.panelitems.Card();
        card3 = new com.raven.component.panelitems.Card();
        card4 = new com.raven.component.panelitems.Card();
        jPanel1 = new javax.swing.JPanel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        charTinhTrangSach = new com.raven.component.chart.piechart.PieChart();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        colorTinhTrang1 = new javax.swing.JPanel();
        colorTinhTrang2 = new javax.swing.JPanel();
        colorTinhTrang3 = new javax.swing.JPanel();
        colorTinhTrang4 = new javax.swing.JPanel();
        lb_TinhTrang1 = new javax.swing.JLabel();
        lb_TinhTrang2 = new javax.swing.JLabel();
        lb_TinhTrang3 = new javax.swing.JLabel();
        lb_TinhTrang4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        charTheLoaiSach = new com.raven.component.chart.piechart.PieChart();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        colorTheLoai1 = new javax.swing.JPanel();
        colorTheLoai2 = new javax.swing.JPanel();
        colorTheLoai3 = new javax.swing.JPanel();
        colorTheLoai4 = new javax.swing.JPanel();
        lb_TheLoai1 = new javax.swing.JLabel();
        lb_TheLoai2 = new javax.swing.JLabel();
        lb_TheLoai3 = new javax.swing.JLabel();
        lb_TheLoai4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        card1.setBackground(new java.awt.Color(51, 51, 51));
        card1.setColorGradient(new java.awt.Color(162, 171, 88));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("HOME");

        card2.setBackground(new java.awt.Color(51, 51, 51));
        card2.setColorGradient(new java.awt.Color(234, 24, 77));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(44, 62, 80));
        card4.setToolTipText("");
        card4.setColorGradient(new java.awt.Color(0, 82, 212));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        noticeBoard.setForeground(new java.awt.Color(82, 82, 82));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Thông báo");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Chúc bạn một ngày tốt lành");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 186, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.setOpaque(false);

        jPanel3.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(76, 76, 76));
        jLabel7.setText("Tình trạng sách");
        charTinhTrangSach.add(jLabel7);
        jLabel7.setBounds(130, 0, 150, 24);

        jPanel5.setOpaque(false);

        colorTinhTrang1.setOpaque(false);

        javax.swing.GroupLayout colorTinhTrang1Layout = new javax.swing.GroupLayout(colorTinhTrang1);
        colorTinhTrang1.setLayout(colorTinhTrang1Layout);
        colorTinhTrang1Layout.setHorizontalGroup(
            colorTinhTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTinhTrang1Layout.setVerticalGroup(
            colorTinhTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        colorTinhTrang2.setOpaque(false);

        javax.swing.GroupLayout colorTinhTrang2Layout = new javax.swing.GroupLayout(colorTinhTrang2);
        colorTinhTrang2.setLayout(colorTinhTrang2Layout);
        colorTinhTrang2Layout.setHorizontalGroup(
            colorTinhTrang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTinhTrang2Layout.setVerticalGroup(
            colorTinhTrang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        colorTinhTrang3.setOpaque(false);

        javax.swing.GroupLayout colorTinhTrang3Layout = new javax.swing.GroupLayout(colorTinhTrang3);
        colorTinhTrang3.setLayout(colorTinhTrang3Layout);
        colorTinhTrang3Layout.setHorizontalGroup(
            colorTinhTrang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTinhTrang3Layout.setVerticalGroup(
            colorTinhTrang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        colorTinhTrang4.setOpaque(false);

        javax.swing.GroupLayout colorTinhTrang4Layout = new javax.swing.GroupLayout(colorTinhTrang4);
        colorTinhTrang4.setLayout(colorTinhTrang4Layout);
        colorTinhTrang4Layout.setHorizontalGroup(
            colorTinhTrang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTinhTrang4Layout.setVerticalGroup(
            colorTinhTrang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(colorTinhTrang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TinhTrang4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(colorTinhTrang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TinhTrang3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(colorTinhTrang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TinhTrang2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(colorTinhTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TinhTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TinhTrang1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(colorTinhTrang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTinhTrang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TinhTrang2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TinhTrang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorTinhTrang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTinhTrang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TinhTrang4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(charTinhTrangSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(charTinhTrangSach, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(76, 76, 76));
        jLabel8.setText("Thể loại sách");
        charTheLoaiSach.add(jLabel8);
        jLabel8.setBounds(150, 0, 130, 24);

        jPanel7.setOpaque(false);

        colorTheLoai1.setOpaque(false);

        javax.swing.GroupLayout colorTheLoai1Layout = new javax.swing.GroupLayout(colorTheLoai1);
        colorTheLoai1.setLayout(colorTheLoai1Layout);
        colorTheLoai1Layout.setHorizontalGroup(
            colorTheLoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTheLoai1Layout.setVerticalGroup(
            colorTheLoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        colorTheLoai2.setOpaque(false);

        javax.swing.GroupLayout colorTheLoai2Layout = new javax.swing.GroupLayout(colorTheLoai2);
        colorTheLoai2.setLayout(colorTheLoai2Layout);
        colorTheLoai2Layout.setHorizontalGroup(
            colorTheLoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTheLoai2Layout.setVerticalGroup(
            colorTheLoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        colorTheLoai3.setOpaque(false);

        javax.swing.GroupLayout colorTheLoai3Layout = new javax.swing.GroupLayout(colorTheLoai3);
        colorTheLoai3.setLayout(colorTheLoai3Layout);
        colorTheLoai3Layout.setHorizontalGroup(
            colorTheLoai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTheLoai3Layout.setVerticalGroup(
            colorTheLoai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        colorTheLoai4.setOpaque(false);

        javax.swing.GroupLayout colorTheLoai4Layout = new javax.swing.GroupLayout(colorTheLoai4);
        colorTheLoai4.setLayout(colorTheLoai4Layout);
        colorTheLoai4Layout.setHorizontalGroup(
            colorTheLoai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorTheLoai4Layout.setVerticalGroup(
            colorTheLoai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(colorTheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(colorTheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(colorTheLoai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TheLoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(colorTheLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_TheLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TheLoai1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(colorTheLoai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTheLoai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TheLoai2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TheLoai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorTheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTheLoai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(charTheLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(charTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.panelitems.Card card1;
    private com.raven.component.panelitems.Card card2;
    private com.raven.component.panelitems.Card card3;
    private com.raven.component.panelitems.Card card4;
    private com.raven.component.chart.piechart.PieChart charTheLoaiSach;
    private com.raven.component.chart.piechart.PieChart charTinhTrangSach;
    private javax.swing.JPanel colorSach1;
    private javax.swing.JPanel colorTheLoai1;
    private javax.swing.JPanel colorTheLoai2;
    private javax.swing.JPanel colorTheLoai3;
    private javax.swing.JPanel colorTheLoai4;
    private javax.swing.JPanel colorTinhTrang1;
    private javax.swing.JPanel colorTinhTrang2;
    private javax.swing.JPanel colorTinhTrang3;
    private javax.swing.JPanel colorTinhTrang4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb_TheLoai1;
    private javax.swing.JLabel lb_TheLoai2;
    private javax.swing.JLabel lb_TheLoai3;
    private javax.swing.JLabel lb_TheLoai4;
    private javax.swing.JLabel lb_TinhTrang1;
    private javax.swing.JLabel lb_TinhTrang2;
    private javax.swing.JLabel lb_TinhTrang3;
    private javax.swing.JLabel lb_TinhTrang4;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    // End of variables declaration//GEN-END:variables

    private void intitPieChartSach() {
        LinkedHashMap<String, Integer> map = SachDAO.getInstance().getTop3TheLoai();
        ArrayList<String> listLoaiSach = new ArrayList<String>();
        listLoaiSach.addAll(map.keySet());
        charTheLoaiSach.setChartType(PieChart.PeiChartType.DONUT_CHART);
        ArrayList<Color> listColor = new ArrayList<Color>();
        listColor.add(Color.decode("#EB5C5D"));
        listColor.add(Color.decode("#4863A6"));
        listColor.add(Color.decode("#FF007F"));
        listColor.add(Color.decode("#E9A44F"));
        if (listLoaiSach.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                charTheLoaiSach.addData(new ModelPieChart(listLoaiSach.get(i), map.get(listLoaiSach.get(i)), listColor.get(i)));
            }
            int volume = 0;
            for (int i = 3; i < map.size(); i++) {
                volume += map.get(listLoaiSach.get(i));
            }
            if (listLoaiSach.size() > 3) {
                charTheLoaiSach.addData(new ModelPieChart("Khác", volume, listColor.get(3)));
                lb_TheLoai4.setText("Khác");
                colorTheLoai4.setBackground(listColor.get(3));
                colorTheLoai4.setOpaque(true);
            }
        } else if (listLoaiSach.size() > 0) {
            for (int i = 0; i < listLoaiSach.size(); i++) {
                charTheLoaiSach.addData(new ModelPieChart(listLoaiSach.get(i), map.get(listLoaiSach.get(i)), listColor.get(i)));
            }
        } else {

        }
        // TEXT CHART THE LOAI
        if (listLoaiSach.size() >0) {
            colorTheLoai1.setBackground(listColor.get(0));
            colorTheLoai1.setOpaque(true);
            lb_TheLoai1.setText(listLoaiSach.get(0));
            if (listLoaiSach.size() > 1) {
                colorTheLoai2.setBackground(listColor.get(1));
                colorTheLoai2.setOpaque(true);
                lb_TheLoai2.setText(listLoaiSach.get(1));
            }
            if (listLoaiSach.size() > 2) {
                colorTheLoai3.setBackground(listColor.get(2));
                colorTheLoai3.setOpaque(true);
                lb_TheLoai3.setText(listLoaiSach.get(2));
            }
        }
    }

    private void intitPieChartTinhTrangSach() {
        LinkedHashMap<String, Integer> map = ChiTietSachDAO.getInstance().getSoLuongTheoTinhTrang();
        ArrayList<String> listTinhTrang = new ArrayList<String>();
        listTinhTrang.addAll(map.keySet());
        charTinhTrangSach.setChartType(PieChart.PeiChartType.DONUT_CHART);
        ArrayList<Color> listColor = new ArrayList<Color>();
        listColor.add(Color.decode("#EB5C5D"));
        listColor.add(Color.decode("#4863A6"));
        listColor.add(Color.decode("#FFFF33"));
        listColor.add(Color.decode("#E9A44F"));
        for (int i = 0; i < listTinhTrang.size() && i <= 3; i++) {
            charTinhTrangSach.addData(new ModelPieChart(listTinhTrang.get(i), map.get(listTinhTrang.get(i)), listColor.get(i)));
        }

        // TEXT TÌNH TRẠNG
        for (int i = 0; i < listTinhTrang.size() && i <= 3; i++) {
            if (i == 0) {
                colorTinhTrang1.setBackground(listColor.get(i));
                colorTinhTrang1.setOpaque(true);
                lb_TinhTrang1.setText(listTinhTrang.get(i));
            } else if (i == 1) {
                colorTinhTrang2.setBackground(listColor.get(i));
                colorTinhTrang2.setOpaque(true);
                lb_TinhTrang2.setText(listTinhTrang.get(i));
            } else if (i == 2) {
                colorTinhTrang3.setBackground(listColor.get(i));
                colorTinhTrang3.setOpaque(true);
                lb_TinhTrang3.setText(listTinhTrang.get(i));
            } else if (i == 3) {
                colorTinhTrang4.setBackground(listColor.get(i));
                colorTinhTrang4.setOpaque(true);
                lb_TinhTrang4.setText(listTinhTrang.get(i));
            }
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#8EC5FC"), getWidth(), getHeight(), Color.decode("#E0C3FC"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

}
