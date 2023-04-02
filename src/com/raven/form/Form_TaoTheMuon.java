package com.raven.form;

import com.raven.component.panelitems.BookCard;
import com.raven.component.panelitems.BookSelected;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.modelcomponent.ModelCard;
import com.raven.model.modelcomponent.ModelStudent;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.customswing.imageswing.ImageSearchDialog;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.messagedialog.MessageDialogCustom;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

@SuppressWarnings("unchecked")
public class Form_TaoTheMuon extends javax.swing.JPanel {

    private HoiVien hv;
    ButtonGroup rb;
    private ArrayList<Sach> listSach;
    private Sach sachSelected;
    public final JFrame fram;
    public int soSachCoTheMuon;
    public int soSachToiDa;
    private String idNhanVien;
    private int soNgayChoMuon;

    public Form_TaoTheMuon(ArrayList<Sach> listSach, JFrame fram, int soSachToiDa, String idNhanVien, int soNgayChoMuon) throws ParseException {
        this.soSachToiDa = soSachToiDa;
        this.fram = fram;
        this.listSach = listSach;
        this.idNhanVien = idNhanVien;
        this.soNgayChoMuon = soNgayChoMuon;
        initComponents();
        initCustomCode();
        spListSach.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        pnLeft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spListSach = new javax.swing.JScrollPane();
        pnListSach = new javax.swing.JPanel();
        textField_Search = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JLabel();
        comboBox_loaiSach = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        cmdTatCa = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        checkTenSach = new javax.swing.JCheckBox();
        checkTacGia = new javax.swing.JCheckBox();
        cmdLoc = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        pnRight = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spListSach1 = new javax.swing.JScrollPane();
        pn_BookSelected = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmdKiemTra = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        textField_IDHoiVien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textField_TenHoiVien = new com.raven.swing.messagedialog.textFieldCustom();
        textField_Lop = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textField_NgayMuon = new com.raven.swing.messagedialog.textFieldCustom();
        textField_NgayHenTra = new com.raven.swing.messagedialog.textFieldCustom();
        cmdDate_NgayMuon = new com.raven.swing.customswing.imageswing.ImageAvatar();
        cmdDate_NgayHenTra = new com.raven.swing.customswing.imageswing.ImageAvatar();
        buttonBadges1 = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        lbSD = new javax.swing.JLabel();
        lbIDTheMuon = new javax.swing.JLabel();
        buttonBadges2 = new com.raven.swing.customswing.buttomcustom.ButtonBadges();

        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(textField_NgayMuon);

        dateChooser2.setDateFormat("dd/MM/yyyy");
        dateChooser2.setTextRefernce(textField_NgayHenTra);

        pnLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnLeft.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tạo thẻ mượn");

        spListSach.setBorder(null);
        spListSach.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spListSach.setOpaque(false);

        pnListSach.setBackground(new java.awt.Color(255, 255, 255));
        pnListSach.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnListSach.setOpaque(false);

        javax.swing.GroupLayout pnListSachLayout = new javax.swing.GroupLayout(pnListSach);
        pnListSach.setLayout(pnListSachLayout);
        pnListSachLayout.setHorizontalGroup(
            pnListSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        pnListSachLayout.setVerticalGroup(
            pnListSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        spListSach.setViewportView(pnListSach);

        textField_Search.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textField_Search.setForeground(new java.awt.Color(153, 153, 153));
        textField_Search.setText("Nhập mã,tên,tác giả...");
        textField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SearchActionPerformed(evt);
            }
        });

        cmdSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_icon.png"))); // NOI18N
        cmdSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmdTatCa.setBackground(new java.awt.Color(69, 72, 191));
        cmdTatCa.setText("Tất cả");
        cmdTatCa.setColorHover(new java.awt.Color(112, 119, 225));
        cmdTatCa.setColorPressed(new java.awt.Color(17, 28, 150));
        cmdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTatCaActionPerformed(evt);
            }
        });

        checkTenSach.setSelected(true);
        checkTenSach.setText("Tên sách");

        checkTacGia.setSelected(true);
        checkTacGia.setText("Tác giả");

        cmdLoc.setText("Lọc");
        cmdLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnLeftLayout.createSequentialGroup()
                                        .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkTenSach)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkTacGia))
                                    .addComponent(textField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdSearch)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(spListSach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spListSach, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnRight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnRight.setOpaque(false);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ảnh");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên sách");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mã quyển");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Xóa");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        spListSach1.setBorder(null);
        spListSach1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spListSach1.setOpaque(false);

        pn_BookSelected.setBackground(new java.awt.Color(255, 255, 255));
        pn_BookSelected.setOpaque(false);

        javax.swing.GroupLayout pn_BookSelectedLayout = new javax.swing.GroupLayout(pn_BookSelected);
        pn_BookSelected.setLayout(pn_BookSelectedLayout);
        pn_BookSelectedLayout.setHorizontalGroup(
            pn_BookSelectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        pn_BookSelectedLayout.setVerticalGroup(
            pn_BookSelectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        spListSach1.setViewportView(pn_BookSelected);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spListSach1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(spListSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 220, Short.MAX_VALUE)))
        );

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã hội viên");

        cmdKiemTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/FemaleUserUpdate_22px.png"))); // NOI18N
        cmdKiemTra.setText("Kiểm tra");
        cmdKiemTra.setDoubleBuffered(true);
        cmdKiemTra.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        cmdKiemTra.setIconTextGap(12);
        cmdKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKiemTraActionPerformed(evt);
            }
        });

        textField_IDHoiVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_IDHoiVien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_IDHoiVien.setLabelText("");
        textField_IDHoiVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_IDHoiVienActionPerformed(evt);
            }
        });
        textField_IDHoiVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_IDHoiVienKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tên hội viên");

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lớp");

        textField_TenHoiVien.setEditable(false);
        textField_TenHoiVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_TenHoiVien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_TenHoiVien.setLabelText("");
        textField_TenHoiVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_TenHoiVienActionPerformed(evt);
            }
        });
        textField_TenHoiVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_TenHoiVienKeyTyped(evt);
            }
        });

        textField_Lop.setEditable(false);
        textField_Lop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_Lop.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_Lop.setLabelText("");
        textField_Lop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_LopActionPerformed(evt);
            }
        });
        textField_Lop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_LopKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ngày mượn");

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày hẹn trả");

        textField_NgayMuon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NgayMuon.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NgayMuon.setLabelText("");
        textField_NgayMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NgayMuonActionPerformed(evt);
            }
        });
        textField_NgayMuon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_NgayMuonKeyTyped(evt);
            }
        });

        textField_NgayHenTra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NgayHenTra.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NgayHenTra.setLabelText("");
        textField_NgayHenTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NgayHenTraActionPerformed(evt);
            }
        });
        textField_NgayHenTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_NgayHenTraKeyTyped(evt);
            }
        });

        cmdDate_NgayMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        cmdDate_NgayHenTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        buttonBadges1.setBackground(new java.awt.Color(69, 191, 71));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Tạo thẻ");
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        lbSD.setBackground(new java.awt.Color(102, 102, 102));
        lbSD.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbSD.setForeground(new java.awt.Color(255, 255, 255));
        lbSD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSD.setText("ID THẺ MƯỢN: ");

        lbIDTheMuon.setBackground(new java.awt.Color(102, 102, 102));
        lbIDTheMuon.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbIDTheMuon.setForeground(new java.awt.Color(255, 255, 255));
        lbIDTheMuon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        buttonBadges2.setForeground(new java.awt.Color(76, 76, 76));
        buttonBadges2.setText("Làm mới");
        buttonBadges2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRightLayout = new javax.swing.GroupLayout(pnRight);
        pnRight.setLayout(pnRightLayout);
        pnRightLayout.setHorizontalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRightLayout.createSequentialGroup()
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lbSD))
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(lbIDTheMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField_IDHoiVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnRightLayout.createSequentialGroup()
                                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnRightLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnRightLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textField_TenHoiVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_NgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_NgayHenTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdDate_NgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdDate_NgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118))))
        );
        pnRightLayout.setVerticalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIDTheMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField_IDHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_TenHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_NgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDate_NgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_NgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdDate_NgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchActionPerformed

    private void cmdLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocActionPerformed
        thucHienTim();
    }//GEN-LAST:event_cmdLocActionPerformed

    private void cmdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTatCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdTatCaActionPerformed

    private void cmdKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKiemTraActionPerformed
        kiemTraHoiVien();
        if (this.soSachCoTheMuon > 0) {
//            cmdKiemTra.setBackground(new Color(69, 191, 71));
            cmdKiemTra.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png")));
        } else {
            cmdKiemTra.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancel_22px.png")));
        }
        repaint();
    }//GEN-LAST:event_cmdKiemTraActionPerformed

    private void textField_IDHoiVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_IDHoiVienActionPerformed

    }//GEN-LAST:event_textField_IDHoiVienActionPerformed

    private void textField_IDHoiVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_IDHoiVienKeyTyped

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            kiemTraHoiVien();
            if (this.soSachCoTheMuon > 0) {
//            cmdKiemTra.setBackground(new Color(69, 191, 71));
                cmdKiemTra.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png")));
            } else {
                cmdKiemTra.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancel_22px.png")));
            }
            repaint();
        } else {
            lamMoi();
        }


    }//GEN-LAST:event_textField_IDHoiVienKeyTyped

    private void textField_TenHoiVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_TenHoiVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TenHoiVienActionPerformed

    private void textField_TenHoiVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_TenHoiVienKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TenHoiVienKeyTyped

    private void textField_LopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_LopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_LopActionPerformed

    private void textField_LopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_LopKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_LopKeyTyped

    private void textField_NgayMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NgayMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayMuonActionPerformed

    private void textField_NgayMuonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_NgayMuonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayMuonKeyTyped

    private void textField_NgayHenTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NgayHenTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayHenTraActionPerformed

    private void textField_NgayHenTraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_NgayHenTraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayHenTraKeyTyped

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        try {
            taoTheMuon();
        } catch (Exception e) {
            e.printStackTrace();
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Tạo thẻ mượn thất bại !");
            noti.showNotification();
        }
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void buttonBadges2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges2ActionPerformed
        lamMoi();
        pnListSach.removeAll();
        startWorkerShowSach();
        textField_IDHoiVien.setText("");
        repaint();

    }//GEN-LAST:event_buttonBadges2ActionPerformed

    private void initCustomCode() throws ParseException {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        pnLeft.setBackground(Color.WHITE);
        pnRight.setBackground(new Color(0, 0, 0, 0));
        pn_BookSelected.setLayout(new GridLayout(5, 1, 1, 0));
        spListSach1.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
        spListSach1.getViewport().setOpaque(false);
        spListSach1.setBackground(new Color(0, 0, 0, 0));
        pn_BookSelected.setBackground(new Color(0, 0, 0, 0));
        spListSach1.setVerticalScrollBar(new ScrollBarCustom());
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        pnListSach.setBackground(new Color(0, 0, 0, 0));
        pnListSach.setLayout(new GridLayout(0, 2, 20, 20));

        jLabel2.setBackground(new Color(0, 0, 0, 0));
        jLabel3.setBackground(new Color(0, 0, 0, 0));
        jLabel4.setBackground(new Color(0, 0, 0, 0));
        jLabel5.setBackground(new Color(0, 0, 0, 0));
        jPanel1.setBackground(new Color(0, 0, 0, 0));

        lbIDTheMuon.setText(TheMuonDAO.getInstance().getNewIDTheMuon());

        spListSach.setVerticalScrollBar(new ScrollBarCustom());
        spListSach.getViewport().setOpaque(false);
        textField_Search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_Search.getText().equals("Nhập mã,tên,tác giả...")) {
                    textField_Search.setText("");
                    textField_Search.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_Search.getText().isEmpty()) {
                    textField_Search.setForeground(Color.GRAY);
                    textField_Search.setText("Nhập mã,tên,tác giả...");
                }
            }
        });
        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    thucHienTim();
                }
            }
        });

        //CMD search
        cmdSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cmdSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thucHienTim();
            }

        });

        //CMD DATE CHOOSER
        Calendar ngayht = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ngayht.setTime(sdf.parse(textField_NgayMuon.getText()));
        ngayht.add(Calendar.DAY_OF_YEAR, soNgayChoMuon);
        textField_NgayHenTra.setText(sdf.format(ngayht.getTime()));
        cmdDate_NgayMuon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                cmdDate_NgayMuon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                dateChooser1.showPopup();
            }
        });

        cmdDate_NgayHenTra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                cmdDate_NgayHenTra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                dateChooser2.showPopup();
            }
        });

        //cbbox Loai Sach
        comboBox_loaiSach.addItem("Loại sách");
        for (String tl : ChiTietSachDAO.getInstance().getAllTheLoai()) {
            comboBox_loaiSach.addItem(tl);
        }

        //CMD tất cả
        cmdTatCa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                listSach = SachDAO.getInstance().selectAll();
                pnListSach.removeAll();
                checkTacGia.setSelected(true);
                checkTenSach.setSelected(true);
                comboBox_loaiSach.setSelectedIndex(0);
                startWorkerShowSach();
                revalidate();
                repaint();
            }
        });

        listSach = SachDAO.getInstance().selectAll();
        startWorkerShowSach();
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#8EC5FC"), getWidth(), getHeight(), Color.decode("#E0C3FC"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    public void thucHienTim() {
        if (textField_Search.getText() != null && !textField_Search.getText().equals("Nhập mã,tên,tác giả...")) {
            listSach = SachDAO.getInstance().selectByCondition(textField_Search.getText(), comboBox_loaiSach.getSelectedItem().toString(),
                    checkTenSach.isSelected(), checkTacGia.isSelected());
        } else {
            if (comboBox_loaiSach.getSelectedIndex() != 0) {
                listSach = SachDAO.getInstance().selectByCondition("", comboBox_loaiSach.getSelectedItem().toString(),
                        false, false);
            }
        }
        pnListSach.removeAll();
        startWorkerShowSach();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.ButtonBadges buttonBadges1;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges buttonBadges2;
    private javax.swing.JCheckBox checkTacGia;
    private javax.swing.JCheckBox checkTenSach;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDate_NgayHenTra;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDate_NgayMuon;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdKiemTra;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private javax.swing.JLabel cmdSearch;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTatCa;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_loaiSach;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbIDTheMuon;
    private javax.swing.JLabel lbSD;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnListSach;
    private javax.swing.JPanel pnRight;
    private javax.swing.JPanel pn_BookSelected;
    private javax.swing.JScrollPane spListSach;
    private javax.swing.JScrollPane spListSach1;
    private com.raven.swing.messagedialog.textFieldCustom textField_IDHoiVien;
    private com.raven.swing.messagedialog.textFieldCustom textField_Lop;
    private com.raven.swing.messagedialog.textFieldCustom textField_NgayHenTra;
    private com.raven.swing.messagedialog.textFieldCustom textField_NgayMuon;
    private javax.swing.JTextField textField_Search;
    private com.raven.swing.messagedialog.textFieldCustom textField_TenHoiVien;
    // End of variables declaration//GEN-END:variables

    private void startWorkerShowSach() {
        // Tạo một instance của SwingWorker
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                // Thực hiện công việc trên background thread

                if (listSach != null) {
                    listSach.forEach((s) -> {
                        BookCard bc = new BookCard();
                        URL imageURL = getClass().getResource("/com/raven/icon/book_images/" + s.getIdSach() + ".jpg");
                        ChiTietSach temp = ChiTietSachDAO.getInstance().selectByID(s.getIdSach() + "-00");
                        ImageIcon icon = new ImageIcon(imageURL);
                        bc.showBook(icon, s.getTenSach(), temp.getStringThuocTinh(temp.getTheLoai()), temp.getStringThuocTinh(temp.getTacGia()), s.getSoLuong());
                        bc.setTextSoLuong(ChiTietSachDAO.getInstance().getSachReadyByIDSach(s.getIdSach()), s.getSoLuong());

                        if (s.getViTri() == null) {
                            bc.setViTri(" Không rõ ");
                        } else {
                            bc.setViTri(s.getViTri());
                        }
                        bc.setBorder(new LineBorder(Color.WHITE, 1, true));
                        bc.setOpaque(false);
                        bc.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                if (kiemTraChuaThemSach(s.getIdSach())) {
                                    MouseAdapter event = new MouseAdapter() {
                                        @Override
                                        public void mousePressed(MouseEvent e) {
                                            bc.deSelected();
                                        }
                                    };
                                    if (ChiTietSachDAO.getInstance().getSachReadyByIDSach(s.getIdSach()) == 0) {
                                        return;
                                    }
                                    startWorkerShowSachSelected(s, icon, event);
                                    if (kiemTraChuaThemSach(s.getIdSach())) {
                                        bc.selected();
                                    }
                                    repaint();
                                }
                            }
                        });
                        pnListSach.add(bc);
                        // get Sach selected

                    });
                    if (listSach.size() < 7) {
                        for (int i = 0; i < 7 - listSach.size(); i++) {
                            JPanel temp = new JPanel();
                            temp.setBackground(new Color(0, 0, 0, 0));
                            temp.setOpaque(false);
                            pnListSach.add(temp);
                        }
                    }
                    spListSach.getVerticalScrollBar().setValue(0);
                    pnListSach.revalidate();
                    repaint();
                }
                Thread.sleep(5000);
                return 42;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
    }

    private void startWorkerShowSachSelected(Sach s, ImageIcon icon, MouseAdapter event) {
        // Tạo một instance của SwingWorker
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                // Thực hiện công việc trên background thread
                System.out.println(s.toString());
                BookSelected bs = new BookSelected(icon, s);
                pn_BookSelected.add(bs);
                revalidate();
                repaint();
                bs.getDeleteIA().addMouseListener(event);
                bs.getDeleteIA().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pn_BookSelected.remove(bs);
                        System.out.println("remove success");
                        revalidate();
                        repaint();
                    }
                });
                Thread.sleep(5000);
                return 42;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
    }

    // Kiểm tra xem sinh viên có thể mượn bao nhiêu sách
    public void kiemTraHoiVien() {
        HoiVien hv = HoiVienDAO.getInstance().selectByID(textField_IDHoiVien.getText());
        if (hv != null) {
            textField_TenHoiVien.setText(hv.getHoTen());
            textField_Lop.setText(hv.getLop());
            if (hv.getTrangThai().equalsIgnoreCase("Khóa")) {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Hội viên: " + textField_IDHoiVien.getText() + " đã bị khóa thẻ! ");
                noti.showNotification();
            } else {
                try {
                    int soLuong = TheMuonDAO.getInstance().kiemTraSoSachCoTheMuon(textField_IDHoiVien.getText());
                    this.soSachCoTheMuon = this.soSachToiDa - soLuong;
                    if (this.soSachCoTheMuon > 0) {
                        Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Hội viên: " + textField_IDHoiVien.getText() + " có thể mượn " + this.soSachCoTheMuon + " sách !");
                        noti.showNotification();
                    } else {
                        Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Hội viên: " + textField_IDHoiVien.getText() + " không thể mượn sách! ");
                        noti.showNotification();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Mã hội viên không tồn tại !!!");
            noti.showNotification();
        }
        this.hv = hv;
    }

    public boolean kiemTraChuaThemSach(String id) {
        int sachDaChon = 0;
        Component[] coms = pn_BookSelected.getComponents();
        for (Component com : coms) {
            if (com instanceof BookSelected) {
                sachDaChon++;
                BookSelected bookselected = (BookSelected) com;
                if (bookselected.getIdSach().equalsIgnoreCase(id)) {
                    return false;
                }
            }
        }
        if (sachDaChon >= this.soSachCoTheMuon) {
            if (textField_IDHoiVien.getText().replaceAll(" ", "").length() == 0
                    || textField_TenHoiVien.getText().replaceAll(" ", "").length() == 0
                    || textField_Lop.getText().replaceAll(" ", "").length() == 0) {
                Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Vui lòng nhập và kiểm tra ID hội viên.");
                noti.showNotification();
            } else {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Số sách hội viên có thể mượn đã đạt giới hạn.");
                noti.showNotification();
            }
            return false;
        }
        return true;
    }

    public void lamMoi() {
        Component[] coms = pn_BookSelected.getComponents();
        for (Component com : coms) {
            if (com instanceof BookSelected) {
                BookSelected book = (BookSelected) com;
                pn_BookSelected.remove(book);
            }
        }
        cmdKiemTra.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/FemaleUserUpdate_22px.png")));
        this.hv = null;
        this.soSachCoTheMuon = 0;
        textField_TenHoiVien.setText("");
        textField_Lop.setText("");
        repaint();
    }

    public boolean kiemTraDaNhap() throws ParseException {
        if (textField_IDHoiVien.getText().replaceAll(" ", "").length() == 0
                || textField_TenHoiVien.getText().replaceAll(" ", "").length() == 0
                || textField_Lop.getText().replaceAll(" ", "").length() == 0) {
            return false;
        }
        int check = 0;
        Component[] coms = pn_BookSelected.getComponents();
        for (Component com : coms) {
            if (com instanceof BookSelected) {
                ++check;
            }
        }
        if (check <= 0) {
            return false;
        }

        // checking date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        Calendar ngayMuon = Calendar.getInstance();
        ngayMuon.setTime(sdf.parse(textField_NgayMuon.getText()));
        Calendar ngayHenTra = Calendar.getInstance();
        ngayHenTra.setTime(sdf.parse(textField_NgayHenTra.getText()));

        return true;
    }

    public void taoTheMuon() throws ParseException {
        if (kiemTraDaNhap()) {
            Message mess = new Message(fram, true);
            mess.showMessage("Bạn có muốn tạo thể mượn này ?");
            if (mess.isOk()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar ngayMuon = Calendar.getInstance();
                ngayMuon.setTime(sdf.parse(textField_NgayMuon.getText()));
                Calendar ngayHenTra = Calendar.getInstance();
                ngayHenTra.setTime(sdf.parse(textField_NgayHenTra.getText()));
                String idTheMuon = lbIDTheMuon.getText();
                String idHoiVien = textField_IDHoiVien.getText();
                ArrayList<ChiTietSach> listCTS = new ArrayList<>();
                Component[] coms = pn_BookSelected.getComponents();
                for (Component com : coms) {
                    if (com instanceof BookSelected) {
                        BookSelected book = (BookSelected) com;
                        listCTS.add(ChiTietSachDAO.getInstance().selectByID(book.getComBoBoxID().getSelectedItem().toString()));
                    }
                }
                TheMuon tm = new TheMuon(idTheMuon, idHoiVien, this.idNhanVien, ngayMuon, ngayHenTra, null, listCTS, "Đang mượn");
                TheMuonDAO.getInstance().insert(tm);
                listCTS.forEach(n -> {
                    ChiTietSachDAO.getInstance().updateTrangThai(n.getIdChiTietSach(), "Được mượn");
                });
                HoiVienDAO.getInstance().updateTrangThai(idHoiVien, "Đang mượn");
                Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Tạo thẻ mượn thành công. ");
                noti.showNotification();
                lamMoi();
                textField_IDHoiVien.setText("");
                lbIDTheMuon.setText(TheMuonDAO.getInstance().getNewIDTheMuon());
                repaint();
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Vui lòng nhập đầy đủ thông tin.");
            noti.showNotification();
        }
    }
}
