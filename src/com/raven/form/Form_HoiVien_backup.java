package com.raven.form;

import com.raven.component.panelitems.BookCard;
import com.raven.dialog.Message;
import com.raven.model.modelcomponent.ModelCard;
import com.raven.model.modelcomponent.ModelStudent;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.table.EventAction;
import com.raven.swing.tablequanly.cell.DialogHoiVien;
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
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
@SuppressWarnings("unchecked")
public class Form_HoiVien_backup extends javax.swing.JPanel {

    ButtonGroup rbGioiTinh;
    private ArrayList<HoiVien> listHoiVien;
    private Sach sachSelected;
    public final JFrame fram;

    @SuppressWarnings("unchecked")
    public Form_HoiVien_backup(ArrayList<HoiVien> listHoiVien, JFrame fram) {
        this.fram = fram;
        this.listHoiVien = listHoiVien;
        initComponents();
        setOpaque(false);
        initCustomCode();
        initPanelRight();
        initTabaleData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdtest = new javax.swing.JButton();
        pnLeft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textField_Search = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JLabel();
        comboBox_Lop = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        cmdTatCa = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdLoc = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        buttonCustom1 = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        pnRight = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        textField_tenHoiVien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textField_IDHoiVien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textField_maSinhVien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel11 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        rbNam = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textField_SDT = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel19 = new javax.swing.JLabel();
        textField_SachChuaTra = new com.raven.swing.messagedialog.textFieldCustom();
        textField_Lop = new com.raven.swing.messagedialog.textFieldCustom();
        textField_SachDaMuon = new com.raven.swing.messagedialog.textFieldCustom();
        textField_Email = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel20 = new javax.swing.JLabel();
        comboBox_TrangThai = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        cmdUpdateHV = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        cmdSaveNewHV = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        cmdtest.setText("jButton1");

        pnLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnLeft.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Quản lý hội viên");

        textField_Search.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textField_Search.setForeground(new java.awt.Color(153, 153, 153));
        textField_Search.setText("Nhập mã, tên hoặc mã sinh viên");
        textField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SearchActionPerformed(evt);
            }
        });
        textField_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_SearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_SearchKeyTyped(evt);
            }
        });

        cmdSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_client_30px.png"))); // NOI18N
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

        cmdLoc.setText("Lọc");
        cmdLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocActionPerformed(evt);
            }
        });

        buttonCustom1.setText("Thêm");
        buttonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustom1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hội viên", "Tên hội viên", "Tên lớp", "Mã sinh viên", "Title 5", "Title 6", "Title 7", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(150);
            table1.getColumnModel().getColumn(1).setPreferredWidth(200);
            table1.getColumnModel().getColumn(7).setPreferredWidth(110);
            table1.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                        .addComponent(textField_Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnLeftLayout.createSequentialGroup()
                                .addComponent(comboBox_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)))
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
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
                    .addComponent(comboBox_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );

        pnRight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnRight.setOpaque(false);

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setOpaque(false);

        textField_tenHoiVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_tenHoiVien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_tenHoiVien.setLabelText("");
        textField_tenHoiVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_tenHoiVienActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tên Lớp");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("ID hội viên");

        textField_IDHoiVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_IDHoiVien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_IDHoiVien.setLabelText("");
        textField_IDHoiVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_IDHoiVienActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Mã sinh viên");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tên hội viên");

        textField_maSinhVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_maSinhVien.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_maSinhVien.setLabelText("");
        textField_maSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_maSinhVienActionPerformed(evt);
            }
        });
        textField_maSinhVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_maSinhVienKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Giới tính");

        rbNu.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbNu.setForeground(new java.awt.Color(51, 51, 51));
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        rbNam.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        rbNam.setForeground(new java.awt.Color(51, 51, 51));
        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Số điện thoại");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Sách đã mượn");

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Email");

        textField_SDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_SDT.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_SDT.setLabelText("");
        textField_SDT.setName("vnđ"); // NOI18N
        textField_SDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField_SDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_SDTFocusLost(evt);
            }
        });
        textField_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SDTActionPerformed(evt);
            }
        });
        textField_SDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_SDTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_SDTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_SDTKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Sách chưa trả");

        textField_SachChuaTra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_SachChuaTra.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_SachChuaTra.setLabelText("");
        textField_SachChuaTra.setName("vnđ"); // NOI18N
        textField_SachChuaTra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField_SachChuaTraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_SachChuaTraFocusLost(evt);
            }
        });
        textField_SachChuaTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SachChuaTraActionPerformed(evt);
            }
        });
        textField_SachChuaTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_SachChuaTraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField_SachChuaTraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_SachChuaTraKeyTyped(evt);
            }
        });

        textField_Lop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_Lop.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_Lop.setLabelText("");
        textField_Lop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_LopActionPerformed(evt);
            }
        });
        textField_Lop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_LopKeyPressed(evt);
            }
        });

        textField_SachDaMuon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_SachDaMuon.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_SachDaMuon.setLabelText("");
        textField_SachDaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SachDaMuonActionPerformed(evt);
            }
        });
        textField_SachDaMuon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_SachDaMuonKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_SachDaMuonKeyTyped(evt);
            }
        });

        textField_Email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_Email.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_Email.setLabelText("");
        textField_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_EmailActionPerformed(evt);
            }
        });
        textField_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_EmailKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Trạng thái");

        comboBox_TrangThai.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cmdUpdateHV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Female User Update_22px.png"))); // NOI18N
        cmdUpdateHV.setText("Cập nhật");
        cmdUpdateHV.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmdUpdateHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateHVActionPerformed(evt);
            }
        });

        cmdSaveNewHV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/save_21px.png"))); // NOI18N
        cmdSaveNewHV.setText("Lưu mới");
        cmdSaveNewHV.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmdSaveNewHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveNewHVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_tenHoiVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textField_maSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField_Lop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnThongTinLayout.createSequentialGroup()
                                        .addComponent(rbNam)
                                        .addGap(31, 31, 31)
                                        .addComponent(rbNu)
                                        .addGap(0, 147, Short.MAX_VALUE))
                                    .addComponent(textField_IDHoiVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1))
                            .addComponent(textField_SDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(textField_SachDaMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(textField_SachChuaTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addComponent(comboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(cmdUpdateHV, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSaveNewHV, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(textField_tenHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField_IDHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_maSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNam)
                    .addComponent(rbNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_SachDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_SachChuaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdUpdateHV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSaveNewHV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin hội viên");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Điền thông tin hội viên mới hoặc chọn hội viên muốn hiển thị");

        javax.swing.GroupLayout pnRightLayout = new javax.swing.GroupLayout(pnRight);
        pnRight.setLayout(pnRightLayout);
        pnRightLayout.setHorizontalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRightLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnRightLayout.createSequentialGroup()
                        .addGroup(pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                        .addGap(14, 14, 14))))
        );
        pnRightLayout.setVerticalGroup(
            pnRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }//GEN-LAST:event_cmdLocActionPerformed

    private void textField_IDHoiVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_IDHoiVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_IDHoiVienActionPerformed

    private void textField_tenHoiVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_tenHoiVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_tenHoiVienActionPerformed

    private void textField_maSinhVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_maSinhVienKeyPressed
    }//GEN-LAST:event_textField_maSinhVienKeyPressed

    private void textField_maSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_maSinhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_maSinhVienActionPerformed

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void textField_SDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SDTFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTFocusGained

    private void textField_SDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SDTFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTFocusLost

    private void textField_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTActionPerformed

    private void textField_SDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SDTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTKeyPressed

    private void textField_SDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SDTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTKeyReleased

    private void textField_SDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SDTKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_SDTKeyTyped

    private void cmdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTatCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdTatCaActionPerformed

    private void textField_SachChuaTraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SachChuaTraFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachChuaTraFocusGained

    private void textField_SachChuaTraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SachChuaTraFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachChuaTraFocusLost

    private void textField_SachChuaTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SachChuaTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachChuaTraActionPerformed

    private void textField_SachChuaTraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SachChuaTraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachChuaTraKeyPressed

    private void textField_SachChuaTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SachChuaTraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachChuaTraKeyReleased

    private void textField_SachChuaTraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SachChuaTraKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_SachChuaTraKeyTyped

    private void textField_LopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_LopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_LopActionPerformed

    private void textField_LopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_LopKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_LopKeyPressed

    private void textField_SachDaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SachDaMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachDaMuonActionPerformed

    private void textField_SachDaMuonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SachDaMuonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SachDaMuonKeyPressed

    private void textField_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_EmailActionPerformed

    private void textField_EmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_EmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_EmailKeyPressed

    private void textField_SachDaMuonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SachDaMuonKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_SachDaMuonKeyTyped

    private void textField_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SearchKeyTyped

    }//GEN-LAST:event_textField_SearchKeyTyped

    private void textField_SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchKeyPressed

    private void buttonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom1ActionPerformed
        lamMoi();
    }//GEN-LAST:event_buttonCustom1ActionPerformed

    private void cmdUpdateHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateHVActionPerformed
        cmdUpdateHoiVien();
    }//GEN-LAST:event_cmdUpdateHVActionPerformed

    private void cmdSaveNewHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveNewHVActionPerformed
        cmdSaveHoiVien();
    }//GEN-LAST:event_cmdSaveNewHVActionPerformed

    private void initCustomCode() {
        setBackground(new Color(0, 0, 0, 0));
        pnLeft.setBackground(Color.WHITE);
        pnRight.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        textField_Search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_Search.getText().equals("Nhập mã, tên hoặc mã sinh viên")) {
                    textField_Search.setText("");
                    textField_Search.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_Search.getText().isEmpty()) {
                    textField_Search.setForeground(Color.GRAY);
                    textField_Search.setText("Nhập mã, tên hoặc mã sinh viên");
                }
            }
        });
        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });

        //CMD search
        cmdSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cmdSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clearTable();
                thucHienTimHoiVien();
                addDataToTable();
            }
        });

        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clearTable();
                    thucHienTimHoiVien();
                    addDataToTable();
                }
            }
        });
        cmdLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
                thucHienTimHoiVien();
                addDataToTable();
            }

        });

        // Combobox Trang Thai
        comboBox_TrangThai.addItem("Sẵn sàng");
        comboBox_TrangThai.addItem("Đang mượn");
        comboBox_TrangThai.addItem("Khóa");

        // ComboBox Lop
        comboBox_Lop.addItem("Chọn lớp");
        for (String lop : HoiVienDAO.getInstance().selectListLop()) {
            comboBox_Lop.addItem(lop);
        }
        //CMD tất cả
        cmdTatCa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                listHoiVien = HoiVienDAO.getInstance().selectAll();
                clearTable();
                addDataToTable();
                comboBox_Lop.setSelectedIndex(0);
                revalidate();
                repaint();
            }
        });

        // RadioButton giới tính
        rbGioiTinh = new ButtonGroup();
        rbGioiTinh.add(rbNam);
        rbGioiTinh.add(rbNu);
        listHoiVien = HoiVienDAO.getInstance().selectAll();
        addDataToTable();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.ButtonCustom buttonCustom1;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdSaveNewHV;
    private javax.swing.JLabel cmdSearch;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTatCa;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdUpdateHV;
    private javax.swing.JButton cmdtest;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_Lop;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_TrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnRight;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private com.raven.swing.table.Table table1;
    private com.raven.swing.messagedialog.textFieldCustom textField_Email;
    private com.raven.swing.messagedialog.textFieldCustom textField_IDHoiVien;
    private com.raven.swing.messagedialog.textFieldCustom textField_Lop;
    private com.raven.swing.messagedialog.textFieldCustom textField_SDT;
    private com.raven.swing.messagedialog.textFieldCustom textField_SachChuaTra;
    private com.raven.swing.messagedialog.textFieldCustom textField_SachDaMuon;
    private javax.swing.JTextField textField_Search;
    private com.raven.swing.messagedialog.textFieldCustom textField_maSinhVien;
    private com.raven.swing.messagedialog.textFieldCustom textField_tenHoiVien;
    // End of variables declaration//GEN-END:variables

    private void initPanelRight() {
        pnThongTin.setBackground(new Color(0, 0, 0, 0));
    }

    public JButton getCMDButton() {
        return cmdtest;
    }

    private void initTabaleData() {

        table1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.setBorder(null);
        jScrollPane2.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.getViewport().setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.setViewportBorder(new EmptyBorder(1, 1, 1, 1));

        listHoiVien = HoiVienDAO.getInstance().selectAll(); //DEFAULT

        // test
//        ArrayList<HoiVien> listHV = new ArrayList<HoiVien>();
//        for(int i=0; i< 50; i++){
//            boolean gioi =true;
//            if(i%2==0){
//                gioi = false;
//            }
//            HoiVien hv = new HoiVien(i+"", "501220033", "Nguyễn Văn A", "CD22CT1", gioi, "0123456789", "nguyenvana@gmail.com", null);
//           listHV.add(hv);
//        }
//        for (HoiVien hv : listHV) {
//            String url = "girl";
//            if (hv.isGioiTinh()) {
//                url = "boy";
//            }
//            table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/" + url + ".png")), hv.getIdHoiVien(), hv.getTenHoiVien(), hv.getTenLop(), hv.getMaSinhVien()).toRowTable(eventAction));
//        }
    }

    private boolean showMessage(String message) {
        Message obj = new Message(fram, true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public void showHoiVienInTable(String idHoiVien) {
        HoiVien hv = HoiVienDAO.getInstance().selectByID(idHoiVien);
        textField_tenHoiVien.setText(hv.getHoTen());
        textField_IDHoiVien.setText(hv.getIdHoiVien());
        textField_IDHoiVien.setEditable(false);
        textField_maSinhVien.setText(hv.getMaSV());
        textField_Lop.setText(hv.getLop());
        if (hv.isGioiTinh()) {
            rbNam.setSelected(true);
        } else {
            rbNu.setSelected(true);
        }
        if (hv.getTrangThai().equalsIgnoreCase("Sẵn sàng")) {
            comboBox_TrangThai.setSelectedIndex(0);
        } else if (hv.getTrangThai().equalsIgnoreCase("Đang mượn")) {
            comboBox_TrangThai.setSelectedIndex(1);
        } else if (hv.getTrangThai().equalsIgnoreCase("Khóa")) {
            comboBox_TrangThai.setSelectedIndex(2);
        }

        textField_SDT.setText(hv.getSdt());
        textField_Email.setText(hv.getEmail());
    }

    public void thucHienTimHoiVien() {
        if (textField_Search.getText() != null && !textField_Search.getText().equals("Nhập mã, tên hoặc mã sinh viên")) {
            listHoiVien = HoiVienDAO.getInstance().searchByCondition(true, textField_Search.getText(), comboBox_Lop.getSelectedIndex() != 0, comboBox_Lop.getSelectedItem().toString());
        } else {
            if (comboBox_Lop.getSelectedIndex() == 0) {
                listHoiVien = HoiVienDAO.getInstance().selectAll();
            } else {
                listHoiVien = HoiVienDAO.getInstance().searchByCondition(false, textField_Search.getText(), comboBox_Lop.getSelectedIndex() != 0, comboBox_Lop.getSelectedItem().toString());
            }
        }
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void addDataToTable() {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Bạn có chắc chắn muốn xóa hội viên : " + student.getTenHoiVien())) {
                    HoiVien hvCanXoa = new HoiVien();
                    hvCanXoa.setIdHoiVien(student.getMaHoiVien());
                    HoiVienDAO.getInstance().delete(hvCanXoa);
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã xóa thành công!");
                    noti.showNotification();
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    if (table1.getSelectedRow() != -1) {
                        model.removeRow(table1.getSelectedRow());
                    }
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Update Student : " + student.getTenHoiVien())) {
                    showHoiVienInTable(student.getMaHoiVien());
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void view(ModelStudent student) {
                if (student.getMaHoiVien() != null) {
                    DialogHoiVien hvInfo = new DialogHoiVien(null, true);
                    hvInfo.showHoiVienInFo(student.getMaHoiVien());
                }
            }
        };

        //Adding DATA
        for (HoiVien hv : listHoiVien) {
            String gioi = hv.isGioiTinh() ? "boy" : "girl";
            table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/" + gioi + ".png")), hv.getIdHoiVien(), hv.getHoTen(), hv.getLop(), hv.getMaSV(),5,5,"").toRowTheMuonTableHoiVien(eventAction));
        }
    }

    public void lamMoi() {
        textField_IDHoiVien.setText("");
        textField_tenHoiVien.setText("");
        textField_IDHoiVien.setEditable(true);
        textField_maSinhVien.setText("");
        textField_Lop.setText("");
        rbNam.setSelected(true);
        rbNu.setSelected(false);
        textField_SDT.setText("");
        textField_Email.setText("");
        comboBox_TrangThai.setSelectedIndex(0);
        textField_SachChuaTra.setText("");
        textField_SachDaMuon.setText("");
    }

    public HoiVien getHoiVienEditted() {
        boolean gioi = true;
        if (rbNu.isSelected()) {
            gioi = false;
        }
        return new HoiVien(textField_IDHoiVien.getText(), textField_maSinhVien.getText(), textField_tenHoiVien.getText(), textField_Lop.getText(), gioi, textField_SDT.getText(), textField_Email.getText(), comboBox_TrangThai.getSelectedItem().toString());
    }

    public boolean kiemTraNhapLieu() {
        if (textField_tenHoiVien.getText().trim().length() == 0
                || textField_IDHoiVien.getText().trim().length() == 0
                || textField_maSinhVien.getText().trim().length() == 0
                || textField_Lop.getText().trim().length() == 0
                || textField_SDT.getText().trim().length() != 10
                || textField_Email.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    public void cmdSaveHoiVien() {
        if (kiemTraNhapLieu()) {
            if (HoiVienDAO.getInstance().selectByID(textField_IDHoiVien.getText()) == null) {
                Message mess = new Message(fram, true);
                mess.showMessage("Bạn có muốn thêm hội viên mới ?");
                if (mess.isOk()) {
                    try {
                        HoiVienDAO.getInstance().insert(getHoiVienEditted());
                        Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cập nhật thành công.");
                        noti.showNotification();
                    } catch (Exception e) {
                        Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Cập nhật thất bại !!");
                        noti.showNotification();
                    }
                }
            } else {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "ID hội viên đã tồn tại !!!");
                noti.showNotification();
                Message mess2 = new Message(fram, true);
                mess2.showMessage("Bạn có cập nhật thay vì lưu mới ? ");
                if (mess2.isOk()) {
                    try {
                        HoiVienDAO.getInstance().update(getHoiVienEditted());
                        Notification noti2 = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cập nhật thành công.");
                        noti2.showNotification();
                    } catch (Exception e) {
                        Notification noti2 = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Cập nhật thất bại !!");
                        noti2.showNotification();
                    }
                }
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Vui lòng kiểm tra lại dữ liệu!");
            noti.showNotification();
        }
    }

    public void cmdUpdateHoiVien() {
        if (kiemTraNhapLieu()) {
            try {
                HoiVienDAO.getInstance().update(getHoiVienEditted());
                Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cập nhật thành công.");
                noti.showNotification();
            } catch (Exception e) {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Cập nhật thất bại !!");
                noti.showNotification();
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Vui lòng kiểm tra lại dữ liệu!");
            noti.showNotification();
        }
    }
}
