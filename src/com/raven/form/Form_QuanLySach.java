package com.raven.form;

import com.raven.component.panelitems.BookCard;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.modelcomponent.ModelCard;
import com.raven.model.modelcomponent.ModelStudent;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.swing.customswing.imageswing.ImageSearchDialog;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.messagedialog.MessageDialogCustom;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.table.EventAction;
import java.awt.Color;
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

public class Form_QuanLySach extends javax.swing.JPanel {

    ButtonGroup rb;
    private ArrayList<Sach> listSach;
    private Sach sachSelected;
    public final JFrame fram;
    private String[] arrTinhTrang = {"Đã trả", "", ""};

    public Form_QuanLySach(ArrayList<Sach> listSach, JFrame fram) {
        this.fram = fram;
        this.listSach = listSach;
        initComponents();
        setOpaque(false);
        initCustomCode();
        initPanelRight();
        spListSach.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdtest = new javax.swing.JButton();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        pnLeft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spListSach = new javax.swing.JScrollPane();
        pnListSach = new javax.swing.JPanel();
        textField_Search = new javax.swing.JTextField();
        comboBox_loaiSach = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        cmdTatCa = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdLoc = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        checkTacGia = new javax.swing.JCheckBox();
        checkTenSach = new javax.swing.JCheckBox();
        cmdSearch = new com.raven.swing.customswing.imageswing.ImageAvatar();
        pnRight = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        textField_tenSach = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textField_IDSach = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textField_nhaXuatBan = new com.raven.swing.messagedialog.textFieldCustom();
        textField_TacGia = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel11 = new javax.swing.JLabel();
        rbkhac = new javax.swing.JRadioButton();
        rbTiengAnh = new javax.swing.JRadioButton();
        rbTiengViet = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        textField_Nam = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel18 = new javax.swing.JLabel();
        textField_SoLuong = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel19 = new javax.swing.JLabel();
        cmdXoa = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdUpdate = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        textField_TheLoai = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textField_NgayNhap = new com.raven.swing.messagedialog.textFieldCustom();
        cmdDateChooser = new com.raven.swing.customswing.imageswing.ImageAvatar();
        jLabel17 = new javax.swing.JLabel();
        textField_GiaTien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel13 = new javax.swing.JLabel();
        textField_ViTri = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel2 = new javax.swing.JLabel();
        lbAnh = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        jLabel3 = new javax.swing.JLabel();

        cmdtest.setText("jButton1");

        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(textField_NgayNhap);

        pnLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnLeft.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Quản lý sách");

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

        cmdTatCa.setBackground(new java.awt.Color(69, 72, 191));
        cmdTatCa.setText("Tất cả");
        cmdTatCa.setColorHover(new java.awt.Color(112, 119, 225));
        cmdTatCa.setColorPressed(new java.awt.Color(17, 28, 150));
        cmdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTatCaActionPerformed(evt);
            }
        });

        cmdLoc.setText("Lọc");
        cmdLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocActionPerformed(evt);
            }
        });

        checkTacGia.setSelected(true);
        checkTacGia.setText("Tác giả");
        checkTacGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/unchecked_checkbox_25px.png"))); // NOI18N
        checkTacGia.setRolloverEnabled(false);
        checkTacGia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_checkbox_25px.png"))); // NOI18N

        checkTenSach.setSelected(true);
        checkTenSach.setText("Tên sách");
        checkTenSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/unchecked_checkbox_25px.png"))); // NOI18N
        checkTenSach.setRolloverEnabled(false);
        checkTenSach.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_checkbox_25px.png"))); // NOI18N

        cmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_50px.png"))); // NOI18N

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spListSach, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTenSach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkTacGia)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addComponent(textField_Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spListSach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnRight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnRight.setOpaque(false);

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setOpaque(false);

        textField_tenSach.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_tenSach.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_tenSach.setLabelText("");
        textField_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_tenSachActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thể loại");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID sách");

        textField_IDSach.setEditable(false);
        textField_IDSach.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_IDSach.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_IDSach.setLabelText("");
        textField_IDSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_IDSachActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tác giả");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên sách");

        textField_nhaXuatBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_nhaXuatBan.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_nhaXuatBan.setLabelText("");
        textField_nhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_nhaXuatBanActionPerformed(evt);
            }
        });

        textField_TacGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_TacGia.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_TacGia.setLabelText("");
        textField_TacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_TacGiaActionPerformed(evt);
            }
        });
        textField_TacGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_TacGiaKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ngôn ngữ");

        rbkhac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbkhac.setForeground(new java.awt.Color(51, 51, 51));
        rbkhac.setText("Khác");

        rbTiengAnh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbTiengAnh.setForeground(new java.awt.Color(51, 51, 51));
        rbTiengAnh.setText("Tiếng Anh");
        rbTiengAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTiengAnhActionPerformed(evt);
            }
        });

        rbTiengViet.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbTiengViet.setForeground(new java.awt.Color(51, 51, 51));
        rbTiengViet.setText("Tiếng Việt");
        rbTiengViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTiengVietActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nhà xuất bản");

        textField_Nam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_Nam.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_Nam.setLabelText("");
        textField_Nam.setName("vnđ"); // NOI18N
        textField_Nam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField_NamFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_NamFocusLost(evt);
            }
        });
        textField_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NamActionPerformed(evt);
            }
        });
        textField_Nam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_NamKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_NamKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_NamKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Năm");

        textField_SoLuong.setEditable(false);
        textField_SoLuong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_SoLuong.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_SoLuong.setLabelText("");
        textField_SoLuong.setName("vnđ"); // NOI18N
        textField_SoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField_SoLuongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_SoLuongFocusLost(evt);
            }
        });
        textField_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SoLuongActionPerformed(evt);
            }
        });
        textField_SoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_SoLuongKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_SoLuongKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_SoLuongKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Số lượng");

        cmdXoa.setBackground(new java.awt.Color(191, 69, 69));
        cmdXoa.setText("Xóa");
        cmdXoa.setColorHover(new java.awt.Color(206, 76, 76));
        cmdXoa.setColorPressed(new java.awt.Color(175, 62, 62));
        cmdXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdXoaActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Cập nhật");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        textField_TheLoai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_TheLoai.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_TheLoai.setLabelText("");
        textField_TheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_TheLoaiActionPerformed(evt);
            }
        });
        textField_TheLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_TheLoaiKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lưu ý: Nếu bạn xóa thì sẽ xóa toàn bộ dữ liệu liên quan đến sách (bao gồm thẻ mượn)");

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Ngày nhập");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_NgayNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NgayNhap.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NgayNhap.setLabelText("");
        textField_NgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NgayNhapActionPerformed(evt);
            }
        });

        cmdDateChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Giá tiền");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_GiaTien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_GiaTien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_GiaTien.setLabelText("");
        textField_GiaTien.setName("vnđ"); // NOI18N
        textField_GiaTien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField_GiaTienFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_GiaTienFocusLost(evt);
            }
        });
        textField_GiaTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_GiaTienActionPerformed(evt);
            }
        });
        textField_GiaTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_GiaTienKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_GiaTienKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_GiaTienKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Vị trí");

        textField_ViTri.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_ViTri.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_ViTri.setLabelText("");
        textField_ViTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_ViTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(cmdXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(cmdUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textField_GiaTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField_Nam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField_nhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(rbTiengViet)
                                .addGap(18, 18, 18)
                                .addComponent(rbTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbkhac, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                            .addComponent(textField_IDSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_TacGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_TheLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_ViTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(textField_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField_IDSach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_TacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_TheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbTiengViet)
                    .addComponent(rbTiengAnh)
                    .addComponent(rbkhac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_ViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField_Nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_GiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(29, 29, 29))
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin sách");

        lbAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Đây là thông tin sách đã được lưu vào trong cơ sở dữ liệu");

        javax.swing.GroupLayout pnRightLayout = new javax.swing.GroupLayout(pnRight);
        pnRight.setLayout(pnRightLayout);
        pnRightLayout.setHorizontalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnRightLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25)))))
                .addContainerGap())
        );
        pnRightLayout.setVerticalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void textField_IDSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_IDSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_IDSachActionPerformed

    private void textField_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_tenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_tenSachActionPerformed

    private void textField_nhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_nhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_nhaXuatBanActionPerformed

    private void textField_TacGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_TacGiaKeyPressed
    }//GEN-LAST:event_textField_TacGiaKeyPressed

    private void textField_TacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_TacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TacGiaActionPerformed

    private void rbTiengAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTiengAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTiengAnhActionPerformed

    private void textField_NamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_NamFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NamFocusGained

    private void textField_NamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_NamFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NamFocusLost

    private void textField_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NamActionPerformed

    private void textField_NamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_NamKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NamKeyPressed

    private void textField_NamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_NamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NamKeyReleased

    private void textField_NamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_NamKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_NamKeyTyped

    private void textField_SoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SoLuongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongFocusGained

    private void textField_SoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SoLuongFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongFocusLost

    private void textField_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongActionPerformed

    private void textField_SoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongKeyPressed

    private void textField_SoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongKeyReleased

    private void textField_SoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_SoLuongKeyTyped

    private void cmdXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdXoaActionPerformed
        if (textField_IDSach.getText().equals("")) {
            Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Chọn sách mà bạn muốn xóa");
            noti.showNotification();
        } else {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Hành động này sẽ xóa đi dữ liệu!");
            noti.showNotification();
            MessageDialogCustom luaChon = new MessageDialogCustom(fram);
            luaChon.showMessage("Cảnh báo xóa sách", "Bạn có muốn xóa vĩnh viễn sách ?");

            if (luaChon.getMessageType() == MessageDialogCustom.MessageType.OK) {
                File icon = new File("src/com/raven/icon/book_images/" + textField_IDSach.getText() + ".jpg");
                icon.delete();
                Sach sachCanXoa = new Sach();
                sachCanXoa.setIdSach(textField_IDSach.getText());
                ChiTietSachDAO.getInstance().multripleDelete(textField_IDSach.getText());
                SachDAO.getInstance().delete(sachCanXoa);
                Notification tt = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã xóa thành công sách.");
                tt.showNotification();
                listSach = SachDAO.getInstance().selectAll();
                pnListSach.removeAll();
                lamMoi();
                startWorkerShowSach();
                pnListSach.repaint();
                revalidate();
                repaint();
            }
        }
    }//GEN-LAST:event_cmdXoaActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        try {
            cmdUpdateCTS();
        } catch (ParseException ex) {
            Logger.getLogger(Form_QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Update sách không thành công !");
            noti.showNotification();
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTatCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdTatCaActionPerformed

    private void textField_TheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_TheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TheLoaiActionPerformed

    private void textField_TheLoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_TheLoaiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TheLoaiKeyPressed

    private void rbTiengVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTiengVietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTiengVietActionPerformed

    private void textField_NgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NgayNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayNhapActionPerformed

    private void textField_GiaTienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_GiaTienFocusGained
        String s = textField_GiaTien.getText().toString();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("VNĐ", "");
        textField_GiaTien.setText(s.replaceAll(",", ""));
    }//GEN-LAST:event_textField_GiaTienFocusGained

    private void textField_GiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_GiaTienFocusLost
        if (!textField_GiaTien.getText().isEmpty()) {
            String gt = textField_GiaTien.getText().toString();
            DecimalFormat df = new DecimalFormat("###,###,###");
            textField_GiaTien.setText(df.format(Integer.valueOf(gt)) + "   VNĐ");
        }
    }//GEN-LAST:event_textField_GiaTienFocusLost

    private void textField_GiaTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_GiaTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_GiaTienActionPerformed

    private void textField_GiaTienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyPressed

    }//GEN-LAST:event_textField_GiaTienKeyPressed

    private void textField_GiaTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_GiaTienKeyReleased

    private void textField_GiaTienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_GiaTienKeyTyped

    private void textField_ViTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_ViTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_ViTriActionPerformed
    @SuppressWarnings("unchecked")
    private void initCustomCode() {
        setBackground(new Color(0, 0, 0, 0));
        pnLeft.setBackground(Color.WHITE);
        pnRight.setBackground(new Color(0, 0, 0, 0));
//        pnListSach.setBackground(new Color(0, 0, 0, 0));
        pnListSach.setLayout(new GridLayout(0, 2, 20, 20));

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

        cmdDateChooser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                cmdDateChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                dateChooser1.showPopup();
            }
        });

        // Custom TextField
        textField_tenSach.setBackground(new Color(0, 0, 0, 0));
        textField_IDSach.setBackground(new Color(0, 0, 0, 0));
        textField_TacGia.setBackground(new Color(0, 0, 0, 0));
        textField_TheLoai.setBackground(new Color(0, 0, 0, 0));
        textField_nhaXuatBan.setBackground(new Color(0, 0, 0, 0));
        textField_Nam.setBackground(new Color(0, 0, 0, 0));
        textField_SoLuong.setBackground(new Color(0, 0, 0, 0));
        textField_NgayNhap.setBackground(new Color(0, 0, 0, 0));
        textField_GiaTien.setBackground(new Color(0, 0, 0, 0));
        textField_ViTri.setBackground(new Color(0, 0, 0, 0));
        // RadioButton ngôn ngữ
        rb = new ButtonGroup();
        rb.add(rbTiengViet);
        rb.add(rbTiengAnh);
        rb.add(rbkhac);
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
    private javax.swing.JCheckBox checkTacGia;
    private javax.swing.JCheckBox checkTenSach;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDateChooser;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdSearch;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTatCa;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdUpdate;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdXoa;
    private javax.swing.JButton cmdtest;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_loaiSach;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare lbAnh;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnListSach;
    private javax.swing.JPanel pnRight;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JRadioButton rbTiengAnh;
    private javax.swing.JRadioButton rbTiengViet;
    private javax.swing.JRadioButton rbkhac;
    private javax.swing.JScrollPane spListSach;
    private com.raven.swing.messagedialog.textFieldCustom textField_GiaTien;
    private com.raven.swing.messagedialog.textFieldCustom textField_IDSach;
    private com.raven.swing.messagedialog.textFieldCustom textField_Nam;
    private com.raven.swing.messagedialog.textFieldCustom textField_NgayNhap;
    private javax.swing.JTextField textField_Search;
    private com.raven.swing.messagedialog.textFieldCustom textField_SoLuong;
    private com.raven.swing.messagedialog.textFieldCustom textField_TacGia;
    private com.raven.swing.messagedialog.textFieldCustom textField_TheLoai;
    private com.raven.swing.messagedialog.textFieldCustom textField_ViTri;
    private com.raven.swing.messagedialog.textFieldCustom textField_nhaXuatBan;
    private com.raven.swing.messagedialog.textFieldCustom textField_tenSach;
    // End of variables declaration//GEN-END:variables

    private void initPanelRight() {
        pnThongTin.setBackground(new Color(0, 0, 0, 0));
    }

    public JButton getCMDButton() {
        return cmdtest;
    }

    private void showSachSelected(Sach s) {
        if (s != null) {
            textField_tenSach.setText(s.getTenSach());
            textField_IDSach.setText(s.getIdSach());
            ChiTietSach temp = ChiTietSachDAO.getInstance().selectByID(s.getIdSach() + "-00");
            textField_TacGia.setText(temp.getStringThuocTinh(temp.getTacGia()));
            textField_TheLoai.setText(temp.getStringThuocTinh(temp.getTheLoai()));
            if (temp.getNgonNgu().equalsIgnoreCase("Tiếng Anh")) {
                rbTiengAnh.setSelected(true);
            } else if (temp.getNgonNgu().equalsIgnoreCase("Khác")) {
                rbkhac.setSelected(true);
            } else {
                rbTiengViet.setSelected(true);
            }
            DecimalFormat df = new DecimalFormat("###,###,###");
            textField_GiaTien.setText(df.format(Double.valueOf(temp.getGiaTien())) + "   VNĐ");
            textField_NgayNhap.setText(temp.getNgayNhap().get(Calendar.DATE) + "/" + (temp.getNgayNhap().get(Calendar.MONTH) + 1) + "/" + temp.getNgayNhap().get(Calendar.YEAR));
            textField_nhaXuatBan.setText(temp.getNhaXuatBan());
            textField_Nam.setText(temp.getNamPhatHanh() + "");

            textField_SoLuong.setText(s.getSoLuong() + "");
            URL imageURL = getClass().getResource("/com/raven/icon/book_images/" + s.getIdSach() + ".jpg");
            if (imageURL != null) {
                lbAnh.setIcon(new ImageIcon(imageURL));
            } else {
                lbAnh.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/" + "spring_bg" + ".jpg")));
            }
            revalidate();
            repaint();
        }
    }

    private boolean kiemTraDaNhap() {
        if (textField_IDSach.getText().trim().length() == 0
                || textField_nhaXuatBan.getText().trim().length() == 0
                || textField_tenSach.getText().trim().length() == 0
                || textField_TacGia.getText().trim().length() == 0
                || textField_Nam.getText().trim().length() == 0
                || textField_SoLuong.getText().trim().length() == 0
                || textField_TheLoai.getText().trim().length() == 0
                || textField_NgayNhap.getText().trim().length() == 0
                || textField_GiaTien.getText().trim().length() == 0
                || rb.getSelection() == null) {
            return false;
        }
        return true;
    }

    private Sach getSachEdited() throws ParseException {
//          get thông tin đã điền
        String idSach = textField_IDSach.getText();
        String tenSach = textField_tenSach.getText();
        int soLuong = Integer.valueOf(textField_SoLuong.getText());
        String viTri = textField_ViTri.getText();
        return new Sach(idSach, tenSach, soLuong, viTri);
    }

    private ChiTietSach getChiTietSachEdited() throws ParseException {
        String idSach = textField_IDSach.getText();
        int namPhatHanh = Integer.valueOf(textField_Nam.getText());
        String ngonNgu = "";
        for (Enumeration<AbstractButton> buttons = rb.getElements(); buttons.hasMoreElements();) {
            AbstractButton nn = buttons.nextElement();
            if (nn.isSelected()) {
                System.out.println(nn.getText() + " is selected");
                ngonNgu = nn.getText();
                break;
            }
        }

        String nhaXuatBan = textField_nhaXuatBan.getText();
        ArrayList<String> listTheLoai = new ArrayList<String>();
        Collections.addAll(listTheLoai, textField_TheLoai.getText().split(","));
        ArrayList<String> listTacGia = new ArrayList<String>();
        Collections.addAll(listTacGia, textField_TacGia.getText().split(","));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar ngayNhap = Calendar.getInstance();
        ngayNhap.setTime(sdf.parse(textField_NgayNhap.getText()));
        String gt = textField_GiaTien.getText().toString().replaceAll(",", "");
        double giaTien = Double.valueOf(gt.replaceAll("VNĐ", ""));
        //ChiTietSach editted khong co trang thai va Trang Thai
        return new ChiTietSach(idSach, idSach, namPhatHanh, nhaXuatBan, giaTien, ngonNgu, ngayNhap, "", listTheLoai, listTacGia);
    }

    private void lamMoi() {
        textField_tenSach.setText("");
        textField_IDSach.setText("");
        textField_TacGia.setText("");
        textField_TheLoai.setText("");
        rbTiengAnh.setSelected(false);
        rbkhac.setSelected(false);
        rbTiengViet.setSelected(false);
        textField_nhaXuatBan.setText("");
        textField_Nam.setText("");
        textField_SoLuong.setText("");
    }

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
                        if (imageURL != null) {
                            ImageIcon icon = new ImageIcon(imageURL);

                            bc.showBook(icon, s.getTenSach(), temp.getStringThuocTinh(temp.getTheLoai()), temp.getStringThuocTinh(temp.getTacGia()), s.getSoLuong());
                        } else {
                            bc.showBook(null, s.getTenSach(), temp.getStringThuocTinh(temp.getTheLoai()), temp.getStringThuocTinh(temp.getTacGia()), s.getSoLuong());
                        }
                        bc.setBorder(new LineBorder(Color.WHITE, 1, true));
                        bc.setOpaque(false);
                        bc.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                sachSelected = s;
                                getCMDButton().doClick();
                                System.out.println(sachSelected.toString());
                                showSachSelected(sachSelected);
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

    private void cmdUpdateCTS() throws ParseException {
        if (!kiemTraDaNhap()) {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Vui lòng nhập đầy đủ dữ liệu !");
            noti.showNotification();

        } else {
            Message mess = new Message(fram, true);
            mess.showMessage("Bạn có muốn cập nhật sách ?");
            if (mess.isOk()) {
                try {
                    Sach sach = getSachEdited();
                    SachDAO.getInstance().update(sach);
                    ChiTietSach cts = getChiTietSachEdited();
                    ArrayList<ChiTietSach> arrCTS = ChiTietSachDAO.getInstance().getCTSByIDSach(textField_IDSach.getText());
                    arrCTS.forEach(i -> System.out.println(i.toString()));
                    ChiTietSachDAO.getInstance().updateByFormQLS(arrCTS, cts, cts.getTacGia(), cts.getTheLoai());
                    System.out.println(sach.toString());
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cập nhật thành công.");
                    noti.showNotification();
                } catch (ParseException ex) {
                    Logger.getLogger(Form_QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
