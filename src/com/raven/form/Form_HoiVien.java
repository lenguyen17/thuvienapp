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
import com.raven.swing.tablequanly.cell.DialogHoiVienAdd;
import com.raven.swing.tablequanly.cell.DialogHoiVienEditing;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;
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
import java.util.Comparator;
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
public class Form_HoiVien extends javax.swing.JPanel {

    ButtonGroup rbGioiTinh;
    private ArrayList<HoiVien> listHoiVien;
    private Sach sachSelected;
    public final JFrame fram;
    private boolean sapXepGiam = true;
    private boolean theoDangMuon = true;
    private int viTriStart = 0;

    @SuppressWarnings("unchecked")
    public Form_HoiVien(ArrayList<HoiVien> listHoiVien, JFrame fram) {
        this.fram = fram;
        this.listHoiVien = listHoiVien;
        initComponents();
        setOpaque(false);
        initCustomCode();
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
        cmdAddNew = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        cmdSXDangMuon = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdSXDaMuon = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        lbTrang = new javax.swing.JLabel();
        cmdPrevPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdNextPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();

        cmdtest.setText("jButton1");

        pnLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnLeft.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        cmdAddNew.setText("Thêm");
        cmdAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddNewActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hội viên", "Tên hội viên", "Tên lớp", "Mã sinh viên", "Đã mượn", "Đang mượn", "Email", "Action"
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
            table1.getColumnModel().getColumn(4).setPreferredWidth(80);
            table1.getColumnModel().getColumn(4).setMaxWidth(80);
            table1.getColumnModel().getColumn(5).setPreferredWidth(80);
            table1.getColumnModel().getColumn(5).setMaxWidth(80);
            table1.getColumnModel().getColumn(6).setPreferredWidth(180);
            table1.getColumnModel().getColumn(6).setMaxWidth(200);
            table1.getColumnModel().getColumn(7).setPreferredWidth(110);
            table1.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        cmdSXDangMuon.setBackground(new java.awt.Color(242, 242, 242));
        cmdSXDangMuon.setForeground(new java.awt.Color(0, 0, 0));
        cmdSXDangMuon.setText("Đang mượn");
        cmdSXDangMuon.setColorHover(new java.awt.Color(255, 255, 255));
        cmdSXDangMuon.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdSXDangMuon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdSXDangMuon.setIconTextGap(8);
        cmdSXDangMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSXDangMuonActionPerformed(evt);
            }
        });

        cmdSXDaMuon.setBackground(new java.awt.Color(242, 242, 242));
        cmdSXDaMuon.setForeground(new java.awt.Color(0, 0, 0));
        cmdSXDaMuon.setText("Đã mượn");
        cmdSXDaMuon.setColorHover(new java.awt.Color(255, 255, 255));
        cmdSXDaMuon.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdSXDaMuon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdSXDaMuon.setIconTextGap(8);
        cmdSXDaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSXDaMuonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/sapxep_20px.png"))); // NOI18N
        jLabel2.setText("Sắp xếp:");

        lbTrang.setBackground(new java.awt.Color(255, 255, 255));
        lbTrang.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lbTrang.setForeground(new java.awt.Color(255, 255, 255));
        lbTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cube_25px.png"))); // NOI18N
        lbTrang.setText("Trang 1");

        cmdPrevPage.setText("Trước");
        cmdPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrevPageActionPerformed(evt);
            }
        });

        cmdNextPage.setText("Sau");
        cmdNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                        .addComponent(comboBox_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSXDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdSXDangMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                        .addComponent(textField_Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdSXDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdSXDangMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnLeftLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocActionPerformed
    }//GEN-LAST:event_cmdLocActionPerformed

    private void cmdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTatCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdTatCaActionPerformed

    private void cmdAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddNewActionPerformed

    }//GEN-LAST:event_cmdAddNewActionPerformed

    private void textField_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SearchKeyTyped

    }//GEN-LAST:event_textField_SearchKeyTyped

    private void textField_SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_SearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchKeyPressed

    private void textField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchActionPerformed

    private void cmdSXDangMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSXDangMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSXDangMuonActionPerformed

    private void cmdSXDaMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSXDaMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSXDaMuonActionPerformed

    private void cmdPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrevPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdPrevPageActionPerformed

    private void cmdNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdNextPageActionPerformed

    private void initCustomCode() {
        setBackground(new Color(0, 0, 0, 0));
        pnLeft.setBackground(Color.WHITE);
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

        //CMD search
        cmdSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cmdSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clearTable();
                viTriStart = 0;
                thucHienTimHoiVien();
                addDataToTable(viTriStart);
                lbTrang.setText("Trang 1");
            }
        });

        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    clearTable();
                    viTriStart = 0;
                    thucHienTimHoiVien();
                    addDataToTable(viTriStart);
                    lbTrang.setText("Trang 1");
                }
            }
        });
        cmdLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
                viTriStart = 0;
                thucHienTimHoiVien();
                addDataToTable(viTriStart);
                lbTrang.setText("Trang 1");
            }
        });

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
                viTriStart = 0;
                addDataToTable(viTriStart);
                comboBox_Lop.setSelectedIndex(0);
                lbTrang.setText("Trang 1");
                revalidate();
                repaint();
            }
        });

        //cmdSXDangMuon
        cmdSXDangMuon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                theoDangMuon = true;
                sapXepGiam = !sapXepGiam;
                cmdSXDaMuon.setIcon(null);
                viTriStart = 0;
                lbTrang.setText("Trang 1");
                cmdSXDangMuon.setHorizontalAlignment((int) LEFT_ALIGNMENT);
                cmdSXDaMuon.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                if (sapXepGiam) {
                    cmdSXDangMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxepgiam_16px.png")));
                } else {
                    cmdSXDangMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxeptang_16px.png")));
                }
                sapXep();
                clearTable();
                addDataToTable(viTriStart);
                revalidate();
                repaint();
            }
        });

        //cmdSXDaMuon
        cmdSXDaMuon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                theoDangMuon = false;
                sapXepGiam = !sapXepGiam;
                viTriStart = 0;
                lbTrang.setText("Trang 1");
                cmdSXDangMuon.setIcon(null);
                cmdSXDangMuon.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                cmdSXDaMuon.setHorizontalAlignment((int) LEFT_ALIGNMENT);
                if (sapXepGiam) {
                    cmdSXDaMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxepgiam_16px.png")));
                } else {
                    cmdSXDaMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxeptang_16px.png")));
                }
                sapXep();
                clearTable();
                addDataToTable(viTriStart);
                revalidate();
                repaint();
            }
        });

        //PAGE
        cmdNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((viTriStart + 12) < listHoiVien.size()) {
                    viTriStart += 12;
                    clearTable();
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    addDataToTable(viTriStart);
                } else {
                    Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Không còn thông tin để hiển thị thêm.");
                    noti.showNotification();
                    return;
                }
//                if (viTriStart <= listHoiVien.size()) {
//                    clearTable();
//                    addDataToTable(viTriStart);
//                }
            }
        });
        cmdPrevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viTriStart -= 12;
                if (viTriStart < 0) {
                    viTriStart = 0;
                    return;
                }
                if (viTriStart >= 0) {
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    clearTable();
                    addDataToTable(viTriStart);
                }
            }
        });

        //cmd addNew
        cmdAddNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                DialogHoiVienAdd hvAdd = new DialogHoiVienAdd(null, true);
                hvAdd.showTheHVMoi();
            }
        });
        if (listHoiVien.size() == 0) {
            listHoiVien = HoiVienDAO.getInstance().selectAll();
        }
        addDataToTable(viTriStart);
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
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdAddNew;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdNextPage;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdPrevPage;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdSXDaMuon;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdSXDangMuon;
    private javax.swing.JLabel cmdSearch;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTatCa;
    private javax.swing.JButton cmdtest;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_Lop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTrang;
    private javax.swing.JPanel pnLeft;
    private com.raven.swing.table.Table table1;
    private javax.swing.JTextField textField_Search;
    // End of variables declaration//GEN-END:variables

    public JButton getCMDButton() {
        return cmdtest;
    }

    private void initTabaleData() {
        table1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.setBorder(null);
        jScrollPane2.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.getViewport().setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
    }

    private boolean showMessage(String message) {
        Message obj = new Message(fram, true);
        obj.showMessage(message);
        return obj.isOk();
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

    public void addDataToTable(int viTri) {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Bạn có chắc chắn muốn xóa hội viên : " + student.getTenHoiVien())) {
                    HoiVien hvCanXoa = new HoiVien();
                    hvCanXoa.setIdHoiVien(student.getMaHoiVien());
                    HoiVienDAO.getInstance().delete(hvCanXoa);
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    if (table1.getSelectedRow() != -1 && table1.getSelectedRow() < model.getRowCount()) {
                        model.removeRow(table1.getSelectedRow());
                    }
                    for (int i = 0; i < listHoiVien.size(); i++) {
                        if (hvCanXoa.getIdHoiVien().equalsIgnoreCase(listHoiVien.get(i).getIdHoiVien())) {
                            listHoiVien.remove(i);
                            break;
                        }
                    }
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã xóa thành công!");
                    noti.showNotification();
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Chỉnh sửa thông tin hội viên:  " + student.getTenHoiVien() + " ?")) {
                    DialogHoiVienEditing hvEditing = new DialogHoiVienEditing(null, true);
                    hvEditing.showEdit(student.getMaHoiVien());
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

        //Adding DATA theo vị trí
        for (int i = viTri; i < listHoiVien.size() && i < (12 + viTri); i++) {
            HoiVien hv = listHoiVien.get(i);
            String gioi = hv.isGioiTinh() ? "boy" : "girl";
            table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/" + gioi + ".png")), hv.getIdHoiVien(),
                    hv.getHoTen(), hv.getLop(), hv.getMaSV(), hv.getSachDaMuon(), hv.getSachDangMuon(), hv.getEmail()).toRowTheMuonTableHoiVien(eventAction));
        }
    }

    public void sapXep() {
        // Sắp xếp
        listHoiVien.sort(new Comparator<HoiVien>() {
            @Override
            public int compare(HoiVien hv1, HoiVien hv2) {
                if (theoDangMuon) {
                    if (sapXepGiam) {
                        return hv2.getSachDangMuon() - hv1.getSachDangMuon();
                    } else {
                        return hv1.getSachDangMuon() - hv2.getSachDangMuon();
                    }
                } else {
                    // sap xep theo da 
                    if (sapXepGiam) {
                        return hv2.getSachDaMuon() - hv1.getSachDaMuon();
                    } else {
                        return hv1.getSachDaMuon() - hv2.getSachDaMuon();
                    }
                }
            }
        });
    }
}
