package com.raven.form;

import com.raven.swing.messagedialog.MessageDialogCustom;
import com.raven.swing.customswing.imageswing.ImageSearchDialog;
import com.raven.component.panelitems.Menu;
import com.raven.dialog.Message;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;

import com.raven.model.modelcomponent.ModelMenu;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.swing.customswing.menu.MenuItem;
import com.raven.swing.customswing.menu.PopupMenu;
import com.raven.swing.notification.Notification;
import com.sun.glass.events.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import static java.awt.SystemColor.menu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Form1_backup_2 extends javax.swing.JPanel {

    private final JFrame fram;
    private ButtonGroup rb;
    private Image bookIcon;

    public Image getBookIcon() {
        return bookIcon;
    }

    public void setBookIcon(Image bookIcon) {
        this.bookIcon = bookIcon;
    }

    public Form1_backup_2(JFrame fram) {
        this.fram = fram;
        initComponents();
        setOpaque(false);
        init();
//        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/book_images/anksd.jpg")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint gp = new GradientPaint(getWidth() / 2, 0, Color.decode("#8BC6EC"), getWidth() / 2, getHeight(), Color.decode("#9599E2"));
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#8EC5FC"), getWidth(), getHeight(), Color.decode("#E0C3FC"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textField_IDSach = new com.raven.swing.messagedialog.textFieldCustom();
        textField_tenSach = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textField_NhaXuatBan = new com.raven.swing.messagedialog.textFieldCustom();
        textField_GiaTien = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel17 = new javax.swing.JLabel();
        textField_namPhatHanh = new com.raven.swing.messagedialog.textFieldCustom();
        textField_SoLuong = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rbTiengViet = new javax.swing.JRadioButton();
        rbTiengAnh = new javax.swing.JRadioButton();
        rbkhac = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        textField_TacGia = new com.raven.swing.messagedialog.textFieldCustom();
        textField_TheLoai = new com.raven.swing.messagedialog.textFieldCustom();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textField_NgayNhap = new com.raven.swing.messagedialog.textFieldCustom();
        cmdDateChooser = new com.raven.swing.customswing.imageswing.ImageAvatar();
        jLabel23 = new javax.swing.JLabel();
        textField_TinhTrang = new com.raven.swing.messagedialog.textFieldCustom();
        cmdRefresh = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        cmdRefresh1 = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        cmdRefresh2 = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        jLabel24 = new javax.swing.JLabel();
        textField_ViTri = new com.raven.swing.messagedialog.textFieldCustom();
        jPanel2 = new javax.swing.JPanel();
        cmd_TimOnline = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        cmd_TimOnline1 = new com.raven.swing.customswing.buttomcustom.ButtonBadges();
        lbAnh = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(textField_NgayNhap);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhập loại đầu sách");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhập thông tin sách mà bạn muốn thêm vào thư viên. ");

        jPanel3.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID sách");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_IDSach.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_IDSach.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_IDSach.setLabelText("");
        textField_IDSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_IDSachActionPerformed(evt);
            }
        });

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
        jLabel7.setText("Tên sách");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nhà Xuất bản");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tác giả");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_NhaXuatBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NhaXuatBan.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NhaXuatBan.setLabelText("");
        textField_NhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NhaXuatBanActionPerformed(evt);
            }
        });

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

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Giá tiền");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_namPhatHanh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_namPhatHanh.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_namPhatHanh.setLabelText("");
        textField_namPhatHanh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField_namPhatHanhFocusLost(evt);
            }
        });
        textField_namPhatHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_namPhatHanhActionPerformed(evt);
            }
        });
        textField_namPhatHanh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField_namPhatHanhKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_namPhatHanhKeyTyped(evt);
            }
        });

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

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Số lượng");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Lưu ý: ID sách nên dùng Tiếng Việt không dấu ");

        rbTiengViet.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbTiengViet.setForeground(new java.awt.Color(247, 247, 247));
        rbTiengViet.setSelected(true);
        rbTiengViet.setText("Tiếng Việt");

        rbTiengAnh.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbTiengAnh.setForeground(new java.awt.Color(247, 247, 247));
        rbTiengAnh.setText("Tiếng Anh");

        rbkhac.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbkhac.setForeground(new java.awt.Color(247, 247, 247));
        rbkhac.setText("Khác");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Thể loại");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        textField_TheLoai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_TheLoai.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_TheLoai.setLabelText("");

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Năm phát hành");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Vị trí");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ngày nhập");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_NgayNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NgayNhap.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NgayNhap.setLabelText("");
        textField_NgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NgayNhapActionPerformed(evt);
            }
        });

        cmdDateChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Trạng thái");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_TinhTrang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_TinhTrang.setText("Sẵn sàng");
        textField_TinhTrang.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_TinhTrang.setLabelText("");
        textField_TinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_TinhTrangActionPerformed(evt);
            }
        });

        cmdRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/reset_18px.png"))); // NOI18N
        cmdRefresh.setText("Làm mới");
        cmdRefresh.setDisabledSelectedIcon(null);
        cmdRefresh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmdRefresh.setIconTextGap(10);
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        cmdRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/save_21px.png"))); // NOI18N
        cmdRefresh1.setText("Lưu sách");
        cmdRefresh1.setDisabledSelectedIcon(null);
        cmdRefresh1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmdRefresh1.setIconTextGap(10);
        cmdRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefresh1ActionPerformed(evt);
            }
        });

        cmdRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/synchronize_21px.png"))); // NOI18N
        cmdRefresh2.setText("Kiểm tra");
        cmdRefresh2.setDisabledSelectedIcon(null);
        cmdRefresh2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmdRefresh2.setIconTextGap(10);
        cmdRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefresh2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Ngôn ngữ");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textField_ViTri.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_ViTri.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_ViTri.setLabelText("");
        textField_ViTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_ViTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(rbTiengViet, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_ViTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_TinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(cmdRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(cmdRefresh2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(cmdRefresh1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(298, 298, 298))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_GiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_namPhatHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_TacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_IDSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_TheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_NhaXuatBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(textField_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_IDSach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textField_TacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbTiengViet, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textField_ViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_namPhatHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_TheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textField_NhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_GiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField_TinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRefresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        cmd_TimOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_in_cloud_21px.png"))); // NOI18N
        cmd_TimOnline.setText("Tìm");
        cmd_TimOnline.setDisabledSelectedIcon(null);
        cmd_TimOnline.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmd_TimOnline.setIconTextGap(8);
        cmd_TimOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_TimOnlineActionPerformed(evt);
            }
        });

        cmd_TimOnline1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/browse_folder_20px.png"))); // NOI18N
        cmd_TimOnline1.setText("Chọn");
        cmd_TimOnline1.setDisabledSelectedIcon(null);
        cmd_TimOnline1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cmd_TimOnline1.setIconTextGap(8);
        cmd_TimOnline1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_TimOnline1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmd_TimOnline, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmd_TimOnline1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_TimOnline1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_TimOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        lbAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnh.setText("Ảnh");
        lbAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_TimOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_TimOnlineActionPerformed

    }//GEN-LAST:event_cmd_TimOnlineActionPerformed

    private void textField_TacGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_TacGiaKeyPressed

    }//GEN-LAST:event_textField_TacGiaKeyPressed

    private void textField_TacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_TacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TacGiaActionPerformed

    private void textField_SoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_SoLuongKeyTyped

    private void textField_SoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongKeyReleased

    private void textField_SoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SoLuongKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongKeyPressed

    private void textField_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongActionPerformed

    private void textField_SoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SoLuongFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongFocusLost

    private void textField_SoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_SoLuongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SoLuongFocusGained

    private void textField_namPhatHanhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_namPhatHanhKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_namPhatHanhKeyTyped

    private void textField_namPhatHanhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_namPhatHanhKeyPressed

    }//GEN-LAST:event_textField_namPhatHanhKeyPressed

    private void textField_namPhatHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_namPhatHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_namPhatHanhActionPerformed

    private void textField_namPhatHanhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_namPhatHanhFocusLost
        if (textField_namPhatHanh.getText().length() > 0) {
            if (Integer.valueOf(textField_namPhatHanh.getText()) > 2023 || Integer.valueOf(textField_namPhatHanh.getText()) < 0) {
                textField_namPhatHanh.setLineColor(Color.RED);
                textField_namPhatHanh.repaint();
            }
        }
    }//GEN-LAST:event_textField_namPhatHanhFocusLost

    private void textField_GiaTienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textField_GiaTienKeyTyped

    private void textField_GiaTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_GiaTienKeyReleased

    private void textField_GiaTienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_GiaTienKeyPressed

    }//GEN-LAST:event_textField_GiaTienKeyPressed

    private void textField_GiaTienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_GiaTienFocusLost
        if (!textField_GiaTien.getText().isEmpty()) {
            String gt = textField_GiaTien.getText().toString();
            DecimalFormat df = new DecimalFormat("###,###,###");
            textField_GiaTien.setText(df.format(Integer.valueOf(gt)) + "   VNĐ");
        }
    }//GEN-LAST:event_textField_GiaTienFocusLost

    private void textField_GiaTienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textField_GiaTienFocusGained
        String s = textField_GiaTien.getText().toString();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("VNĐ", "");
        textField_GiaTien.setText(s.replaceAll(",", ""));
    }//GEN-LAST:event_textField_GiaTienFocusGained

    private void textField_NhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NhaXuatBanActionPerformed

    private void textField_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_tenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_tenSachActionPerformed

    private void textField_IDSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_IDSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_IDSachActionPerformed

    private void textField_GiaTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_GiaTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_GiaTienActionPerformed

    private void cmd_TimOnline1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_TimOnline1ActionPerformed
        chonAnhTuMay();
    }//GEN-LAST:event_cmd_TimOnline1ActionPerformed

    private void textField_NgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NgayNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayNhapActionPerformed

    private void textField_TinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_TinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_TinhTrangActionPerformed

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        lamMoi();
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void cmdRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefresh1ActionPerformed
        try {
            luuSachVaAnh();
        } catch (ParseException ex) {
            Logger.getLogger(Form1_backup_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdRefresh1ActionPerformed

    private void cmdRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefresh2ActionPerformed
        kiemTraCoTheLuu();
    }//GEN-LAST:event_cmdRefresh2ActionPerformed

    private void textField_ViTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_ViTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_ViTriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDateChooser;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdRefresh;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdRefresh1;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmdRefresh2;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmd_TimOnline;
    private com.raven.swing.customswing.buttomcustom.ButtonBadges cmd_TimOnline1;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JRadioButton rbTiengAnh;
    private javax.swing.JRadioButton rbTiengViet;
    private javax.swing.JRadioButton rbkhac;
    private com.raven.swing.messagedialog.textFieldCustom textField_GiaTien;
    private com.raven.swing.messagedialog.textFieldCustom textField_IDSach;
    private com.raven.swing.messagedialog.textFieldCustom textField_NgayNhap;
    private com.raven.swing.messagedialog.textFieldCustom textField_NhaXuatBan;
    private com.raven.swing.messagedialog.textFieldCustom textField_SoLuong;
    private com.raven.swing.messagedialog.textFieldCustom textField_TacGia;
    private com.raven.swing.messagedialog.textFieldCustom textField_TheLoai;
    private com.raven.swing.messagedialog.textFieldCustom textField_TinhTrang;
    private com.raven.swing.messagedialog.textFieldCustom textField_ViTri;
    private com.raven.swing.messagedialog.textFieldCustom textField_namPhatHanh;
    private com.raven.swing.messagedialog.textFieldCustom textField_tenSach;
    // End of variables declaration//GEN-END:variables

    private void init() {
        jPanel2.setBackground(new Color(0, 0, 0, 0));
//        border setting
        textField_IDSach.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_IDSach.setBackground(new Color(0, 0, 0, 0));
        textField_tenSach.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_tenSach.setBackground(new Color(0, 0, 0, 0));
        textField_TacGia.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_TacGia.setBackground(new Color(0, 0, 0, 0));
        textField_NhaXuatBan.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_NhaXuatBan.setBackground(new Color(0, 0, 0, 0));
        textField_GiaTien.setBackground(new Color(0, 0, 0, 0));
        textField_SoLuong.setBackground(new Color(0, 0, 0, 0));
        textField_namPhatHanh.setBackground(new Color(0, 0, 0, 0));
        textField_TheLoai.setBackground(new Color(0, 0, 0, 0));
        textField_NgayNhap.setBackground(new Color(0, 0, 0, 0));
        textField_NgayNhap.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_TinhTrang.setBackground(new Color(0, 0, 0, 0));
        textField_TinhTrang.setBorder(new EmptyBorder(1, 5, 1, 1));
        textField_ViTri.setBackground(new Color(0, 0, 0, 0));
        textField_ViTri.setBorder(new EmptyBorder(1, 5, 1, 1));
//      Xử lý btn ngôn ngữ
        rb = new ButtonGroup();
        rb.add(rbTiengViet);
        rb.add(rbTiengAnh);
        rb.add(rbkhac);

//      Date Chooser
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

//      Xử lý btn thêm loại sách 
        //        add_LoaiSach_btn.addMouseListener(new MouseAdapter() {
        //            @Override
        //            public void mousePressed(java.awt.event.MouseEvent e) {
        //                int viTri = comboBox_LoaiSach.getSelectedIndex() - 1;
        //                Sach temp = new Sach();
        //                if (viTri >= 0) {
        //                    String loaiSach = temp.getListTheLoai().get(viTri);
        //                    if (!getListLoaiSach().contains(loaiSach) && getListLoaiSach().size() < 3) {
        //                        listLoaiSach.add(loaiSach);
        //                        JLabel setLS = new JLabel(loaiSach);
        //                        setLS.setFont(new java.awt.Font("Roboto", Font.PLAIN, 16));
        //                        setLS.addMouseListener(new MouseAdapter() {
        //                            @Override
        //                            public void mousePressed(java.awt.event.MouseEvent e) {
        //                                getListLoaiSach().remove(loaiSach);
        //                                panel_LoaiSach.remove(setLS);
        //                                panel_LoaiSach.revalidate();
        //                                panel_LoaiSach.repaint();
        //                            }
        //                        });
        //                        panel_LoaiSach.add(setLS);
        //                        panel_LoaiSach.revalidate();  // to refresh the panel
        //                        panel_LoaiSach.repaint();  // to repaint the panel
        //                    }
        //                }
        //            }
        //        });
        cmd_TimOnline.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                startWorkerTimAnh();
            }
        });

    }

    public boolean kiemTraIDChuaTonTai() {
        if (SachDAO.getInstance().selectByID(textField_IDSach.getText()) == null) {
            return true;
        }
        return false;
    }

    public String getNgonNgu() {
        for (Enumeration<AbstractButton> buttons = rb.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private void lamMoi() {
        textField_GiaTien.setText("");
        textField_IDSach.setText("");
        textField_NhaXuatBan.setText("");
        textField_tenSach.setText("");
        textField_TacGia.setText("");
        textField_namPhatHanh.setText("");
        textField_SoLuong.setText("");
        textField_TheLoai.setText("");
        rbTiengViet.setSelected(true);
        textField_NgayNhap.setText("");
        lbAnh.setIcon(null);
        lbAnh.setText("Ảnh");
        repaint();
    }

    private boolean kiemTraDaNhap() {
        if (textField_GiaTien.getText().trim().length() == 0
                || textField_IDSach.getText().trim().length() == 0
                || textField_NhaXuatBan.getText().trim().length() == 0
                || textField_tenSach.getText().trim().length() == 0
                || textField_TacGia.getText().trim().length() == 0
                || textField_namPhatHanh.getText().trim().length() == 0
                || textField_SoLuong.getText().trim().length() == 0
                || textField_TinhTrang.getText().trim().length() == 0
                || textField_TheLoai.getText().trim().length() == 0
                || textField_GiaTien.getText().trim().length() == 0
                || textField_NgayNhap.getText().trim().length() == 0
                || rb.getSelection() == null) {
            return false;
        }
        return true;
    }

    private void luuAnh() {
        File thuMuc = new File("src/com/raven/icon/book_images");
        if (!thuMuc.exists()) {
            thuMuc.mkdirs();
        }
        if (getBookIcon() != null) {
            BufferedImage resizedBufferedImage = new BufferedImage(getBookIcon().getWidth(null), getBookIcon().getHeight(null), BufferedImage.TYPE_INT_ARGB);
            resizedBufferedImage.getGraphics().drawImage(getBookIcon(), 0, 0, null);
            try {
                ImageIO.write(resizedBufferedImage, "jpg", new File("src/com/raven/icon/book_images/" + textField_IDSach.getText() + ".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Form1_backup_2.class.getName()).log(Level.SEVERE, null, ex);
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Lưu ảnh thất bại!");
                noti.showNotification();
            }
        }
    }

    private void startWorkerTimAnh() {
        // Tạo một instance của SwingWorker
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                // Thực hiện công việc trên background thread
                ImageSearchDialog iS = new ImageSearchDialog(null);
                if (!textField_tenSach.getText().equals("")) {
                    try {
                        iS.showSearching(textField_tenSach.getText(), textField_IDSach.getText().toString());
                        if (iS.isOk()) {
                            Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã tải thành công");
                            noti.showNotification();
//                            String url = "src/com/raven/icon/book_images/" + textField_IDSach.getText().toString() + ".jpg";
                            setBookIcon(iS.getImageOnly());
                            lbAnh.setText("");
                            lbAnh.setIcon(new ImageIcon(getBookIcon()));
//                            lbAnh.setIcon(iS.getImageSelected());
                            repaint();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Form1_backup_2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Nhập tên sách để tìm ảnh và mã sách để lưu ảnh.");
                    noti.showNotification();
                }
                Thread.sleep(100);
                return 42;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
    }

    public void luuSachVaAnh() throws ParseException {
        if (kiemTraDaNhap()) {
            if (kiemTraIDChuaTonTai()) {
                Message mess = new Message(fram, true);
                if (getBookIcon() == null) {
                    mess.showMessage("Bạn chưa chọn ảnh, lưu không cần ảnh ?");
                } else {
                    mess.showMessage("Bạn có muốn lưu sách ?");
                }
                if (!mess.isOk()) {
                    return;
                }
                String idSach = textField_IDSach.getText().toString();
                String tenSach = textField_tenSach.getText().toString();
                String gt = textField_GiaTien.getText().toString().replaceAll(",", "");
                double giaTien = 0;
                int namPhatHanh = 0, soLuong = 0;
                try {
                    giaTien = Double.valueOf(gt.replaceAll("VNĐ", ""));
                    namPhatHanh = Integer.valueOf(textField_namPhatHanh.getText().toString());
                    soLuong = Integer.valueOf(textField_SoLuong.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (namPhatHanh == 0 || giaTien == 0 || soLuong == 0) {
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Kiểu dữ liệu không hợp lệ (năm, giá tiền, số lượng)");
                    noti.showNotification();
                    return;
                }
                //              Xác nhận số lượng nếu vượt quá 50
                if (soLuong >= 50) {
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Số lượng bạn nhập rất lớn.");
                    noti.showNotification();
                    Message mess1 = new Message(fram, true);
                    mess1.showMessage("Số lượng màn bạn muốn nhập là: " + soLuong + " ?");
                    if (!mess1.isOk()) {
                        return;
                    }
                }
                String ngonNgu = getNgonNgu();
                String nhaXuatBan = textField_NhaXuatBan.getText().toString();
                String viTri = textField_ViTri.getText();
                Sach sach = new Sach(idSach, tenSach, soLuong, viTri);
                ArrayList<String> listTheLoai = new ArrayList<String>();
                Collections.addAll(listTheLoai, textField_TheLoai.getText().split(","));
                ArrayList<String> listTacGia = new ArrayList<String>();
                Collections.addAll(listTacGia, textField_TacGia.getText().split(","));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar ngayNhap = Calendar.getInstance();
                ngayNhap.setTime(sdf.parse(textField_NgayNhap.getText()));
                String tinhTrang = textField_TinhTrang.getText();
                System.out.println(sach.toString());
                //           Lưu sách vào database
                try {
                    SachDAO.getInstance().insert(sach);
                    //                  ADD ChiTietSach
                    for (int i = 0; i < soLuong; i++) {
                        ChiTietSach cts = new ChiTietSach(idSach + "-" + (i < 10 ? "0" + i : i), idSach, namPhatHanh, nhaXuatBan, giaTien, ngonNgu, ngayNhap, tinhTrang, listTheLoai, listTacGia);
                        ChiTietSachDAO.getInstance().insert(cts);
                    }

                    luuAnh();
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã lưu sách vào cơ sở dữ liệu.");
                    noti.showNotification();
                } catch (Exception e) {
                    e.printStackTrace();
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Thất bại, vui lòng kiểm tra lại.");
                    noti.showNotification();
                }
            } else {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "ID sách đã tồn tại!");
                noti.showNotification();
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Vui lòng nhập đầy đủ dữ liệu !");
            noti.showNotification();
        }
    }

    private void kiemTraCoTheLuu() {
        if (!kiemTraDaNhap()) {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Vui lòng nhập đầy đủ dữ liệu !");
            noti.showNotification();
        } else {
            if (kiemTraIDChuaTonTai()) {
                Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Bạn có thể lưu sách này.");
                noti.showNotification();
            } else {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "ID sách đã tồn tại !");
                noti.showNotification();
            }
        }
    }

    private void chonAnhTuMay() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(fram);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            try {
                Image image = ImageIO.read(selectedFile);
                Image resizedImagefinal = image.getScaledInstance(183, 215, Image.SCALE_SMOOTH);
                setBookIcon(resizedImagefinal);
//                setUrlAnh("src/com/raven/icon/book_images/" + textField_IDSach.getText() + ".jpg");
                lbAnh.setText("");
                lbAnh.setIcon(new ImageIcon(resizedImagefinal));
                repaint();
                Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã tải thành công");
                noti.showNotification();
            } catch (IOException ex) {
                Logger.getLogger(Form1_backup_2.class.getName()).log(Level.SEVERE, null, ex);
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Tải hình ảnh thất bại");
                noti.showNotification();
            }
        }
    }

}
