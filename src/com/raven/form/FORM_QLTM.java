package com.raven.form;

import com.raven.component.panelitems.BookSelected;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.customswing.bordercustom.RoundedBorder;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.tablequanly.cell.CellAction;
import com.raven.swing.tablequanly.cell.CellIDSach;
import com.raven.swing.tablequanly.cell.CellNgayMuon;
import com.raven.swing.tablequanly.cell.CellNgayTra;
import com.raven.swing.tablequanly.cell.CellSTT;
import com.raven.swing.tablequanly.cell.CellSoLuong;
import com.raven.swing.tablequanly.cell.CellTenHV;
import com.raven.swing.tablequanly.cell.CellTheMuon;
import com.raven.swing.tablequanly.cell.CellTinhTrang;
import com.raven.swing.tablequanly.modeltable.ModelStaff;
import com.raven.swing.tablequanly.swing.TableHeaderCustom;
import com.raven.table.model.TableRowData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.scene.input.KeyCode;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FORM_QLTM extends javax.swing.JPanel {

    private JFrame fram;
    private ArrayList<TheMuon> listTM = new ArrayList<TheMuon>();
    public int viTriStart = 0;

    @SuppressWarnings("unchecked")
    public FORM_QLTM(JFrame fram) {
        this.fram = fram;
        initComponents();
        table2.addTableStyle(jScrollPane2);
        startWorkertDataTable();
        pnTable.setBackground(new Color(239, 244, 255));
//        textField_DateFrom.setBackground(Color.BLUE);
//        textField_DateTo.setBackground(Color.BLUE);

        cmdDate_From.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cmdDate_From.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dateFrom.showPopup();
            }
        });
        cmdDate_To.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cmdDate_To.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dateTo.showPopup();
            }
        });
        textField_Search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_Search.getText().equals("Nhập mã thẻ mượn, hội viên, sách, ...")) {
                    textField_Search.setText("");
                    textField_Search.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_Search.getText().isEmpty()) {
                    textField_Search.setForeground(Color.GRAY);
                    textField_Search.setText("Nhập mã thẻ mượn, hội viên, sách, ...");
                }
            }
        });
        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    thucHienTim();
                    viTriStart = 0;
                    showListTheMuon(viTriStart);
                }
            }
        });

        cb_LoaiThe.addItem("Đang mượn");
        cb_LoaiThe.addItem("Trễ hẹn");
        cb_LoaiThe.addItem("Đã trả");
        cb_LoaiThe.addItem("Hoàn tiền");
        cb_LoaiThe.addItem("Tất cả");

        //PAGE
        cmdNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((viTriStart + 12) < listTM.size()) {
                    viTriStart += 12;
                    clearTable();
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    showListTheMuon(viTriStart);
                } else {
                    Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Không còn thông tin để hiển thị thêm.");
                    noti.showNotification();
                    return;
                }
                revalidate();
                repaint();
            }
        });
        cmdPrevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viTriStart -= 12;
                if (viTriStart < 0) {
                    viTriStart = 0;
                    return;
                } else {
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    clearTable();
                    showListTheMuon(viTriStart);
                }
                revalidate();
                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#8EC5FC"), getWidth(), getHeight(), Color.decode("#E0C3FC"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateFrom = new com.raven.datechooser.DateChooser();
        dateTo = new com.raven.datechooser.DateChooser();
        pnTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.tablequanly.swing.Table();
        jPanel1 = new javax.swing.JPanel();
        checkIDTheMuon = new javax.swing.JCheckBox();
        cb_LoaiThe = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        checkHV = new javax.swing.JCheckBox();
        checkSach = new javax.swing.JCheckBox();
        textField_DateFrom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textField_DateTo = new javax.swing.JTextField();
        checkThoiGian = new javax.swing.JCheckBox();
        cmdLoc = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdDate_To = new com.raven.swing.customswing.imageswing.ImageAvatar();
        cmdDate_From = new com.raven.swing.customswing.imageswing.ImageAvatar();
        textField_Search = new javax.swing.JTextField();
        cmdDate_NgayMuon = new com.raven.swing.customswing.imageswing.ImageAvatar();
        lbTrang = new javax.swing.JLabel();
        cmdPrevPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdNextPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jLabel2 = new javax.swing.JLabel();

        dateFrom.setDateFormat("dd/MM/yyyy");
        dateFrom.setTextRefernce(textField_DateFrom);

        dateTo.setDateFormat("dd/MM/yyyy");
        dateTo.setTextRefernce(textField_DateTo);

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        pnTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        pnTable.setForeground(new java.awt.Color(153, 255, 153));

        jScrollPane2.setDoubleBuffered(true);
        jScrollPane2.setOpaque(false);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Thẻ mượn", "ID hội viên", "Tên hội viên", "Số lượng", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Tình trạng", "Action"
            }
        ));
        table2.setOpaque(false);
        table2.setRowHeight(40);
        table2.setSelectionForeground(new java.awt.Color(153, 255, 255));
        table2.setShowHorizontalLines(true);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(2).setMinWidth(200);
            table2.getColumnModel().getColumn(3).setMaxWidth(90);
            table2.getColumnModel().getColumn(8).setPreferredWidth(150);
            table2.getColumnModel().getColumn(8).setMaxWidth(150);
        }

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setOpaque(false);

        checkIDTheMuon.setSelected(true);
        checkIDTheMuon.setText("ID thẻ mượn");
        checkIDTheMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/circle_25px.png"))); // NOI18N
        checkIDTheMuon.setRolloverEnabled(false);
        checkIDTheMuon.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_25px.png"))); // NOI18N

        checkHV.setSelected(true);
        checkHV.setText("Tên hội viên");
        checkHV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/circle_25px.png"))); // NOI18N
        checkHV.setRolloverEnabled(false);
        checkHV.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_25px.png"))); // NOI18N

        checkSach.setSelected(true);
        checkSach.setText("Sách");
        checkSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/circle_25px.png"))); // NOI18N
        checkSach.setRolloverEnabled(false);
        checkSach.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_25px.png"))); // NOI18N
        checkSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSachActionPerformed(evt);
            }
        });

        textField_DateFrom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_DateFrom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("-");

        textField_DateTo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_DateTo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textField_DateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_DateToActionPerformed(evt);
            }
        });

        checkThoiGian.setText("Thời gian:");
        checkThoiGian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/circle_25px.png"))); // NOI18N
        checkThoiGian.setRolloverEnabled(false);
        checkThoiGian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_25px.png"))); // NOI18N
        checkThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkThoiGianActionPerformed(evt);
            }
        });

        cmdLoc.setText("Lọc");
        cmdLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocActionPerformed(evt);
            }
        });

        cmdDate_To.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        cmdDate_From.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        textField_Search.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textField_Search.setForeground(new java.awt.Color(153, 153, 153));
        textField_Search.setText("Nhập mã thẻ mượn, hội viên, sách, ...");
        textField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SearchActionPerformed(evt);
            }
        });

        cmdDate_NgayMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_50px.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_LoaiThe, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkIDTheMuon)
                        .addGap(18, 18, 18)
                        .addComponent(checkHV)
                        .addGap(18, 18, 18)
                        .addComponent(checkSach)
                        .addGap(18, 18, 18)
                        .addComponent(checkThoiGian)
                        .addGap(18, 18, 18)
                        .addComponent(textField_DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDate_From, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField_DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDate_To, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textField_Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDate_NgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdDate_From, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdDate_To, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField_DateFrom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField_DateTo)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkIDTheMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkHV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkSach)
                                .addComponent(checkThoiGian)
                                .addComponent(cb_LoaiThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdDate_NgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ THẺ MƯỢN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkSachActionPerformed

    private void checkThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkThoiGianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkThoiGianActionPerformed

    private void textField_DateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_DateToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_DateToActionPerformed

    private void cmdLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocActionPerformed
        thucHienTim();
        viTriStart = 0;
        showListTheMuon(viTriStart);
    }//GEN-LAST:event_cmdLocActionPerformed

    private void textField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchActionPerformed

    private void cmdPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrevPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdPrevPageActionPerformed

    private void cmdNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdNextPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion cb_LoaiThe;
    private javax.swing.JCheckBox checkHV;
    private javax.swing.JCheckBox checkIDTheMuon;
    private javax.swing.JCheckBox checkSach;
    private javax.swing.JCheckBox checkThoiGian;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDate_From;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDate_NgayMuon;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDate_To;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdNextPage;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdPrevPage;
    private com.raven.datechooser.DateChooser dateFrom;
    private com.raven.datechooser.DateChooser dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTrang;
    private javax.swing.JPanel pnTable;
    private com.raven.swing.tablequanly.swing.Table table2;
    private javax.swing.JTextField textField_DateFrom;
    private javax.swing.JTextField textField_DateTo;
    private javax.swing.JTextField textField_Search;
    // End of variables declaration//GEN-END:variables

    private void startWorkertDataTable() {
        // Tạo một instance của SwingWorker
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                // Thực hiện công việc trên background thread
                initDataTable();
                Thread.sleep(5000);
                return 12;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    private void thucHienTim() {
        listTM = null;
        String con = textField_Search.getText();
        String loaiThe = cb_LoaiThe.getSelectedItem().toString();
        boolean idTM = checkIDTheMuon.isSelected();
        boolean hv = checkHV.isSelected();
        boolean sach = checkSach.isSelected();
        boolean thoiGian = checkThoiGian.isSelected();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dateFrom = Calendar.getInstance();
        Calendar dateTo = Calendar.getInstance();
        try {
            dateFrom.setTime(sdf.parse(textField_DateFrom.getText()));
            dateTo.setTime(sdf.parse(textField_DateTo.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null && !textField_Search.getText().equals("Nhập mã thẻ mượn, hội viên, sách, ...")) {
            listTM = TheMuonDAO.getInstance().searchTMByCondition(con, loaiThe, idTM, hv, sach, thoiGian, dateFrom, dateTo);
        } else {
            listTM = TheMuonDAO.getInstance().searchTMByCondition(con, loaiThe, idTM, hv, sach, thoiGian, dateFrom, dateTo);
        }
    }

    private void initDataTable() {
        table2.addTableCell(new CellSTT(), 0);
        table2.addTableCell(new CellIDSach(), 1);
        table2.addTableCell(new CellTenHV(), 2);
//        table2.addTableCell(new CellSoLuong(), 3);
        table2.addTableCell(new CellNgayMuon(), 4);
        table2.addTableCell(new CellNgayMuon(), 5);
        table2.addTableCell(new CellNgayTra(), 6);
        table2.addTableCell(new CellTinhTrang(), 7);
        table2.addTableCell(new CellAction(null), 8);
        listTM = TheMuonDAO.getInstance().searchTMByCondition("", "Đang mượn", false, false, false, false, null, null);
        showListTheMuon(0);
//        for (int i = 0; i < listTM.size(); i++) {
//            table2.addRow(new ModelStaff(listTM.get(i)), false);
//        }
//        TheMuonDAO.getInstance().selectAll().forEach(tm -> {
//            table2.addRow(new ModelStaff(tm), false);  //  ture is animate row
////        System.out.println(tm.toString());
//        });

        table2.getTableHeader().setDefaultRenderer(new TableHeaderCustom());
//        table2.setGridColor(Color.RED);
        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowCount = table2.getRowCount();
                int selectedRow = table2.getSelectedRow();
                if (rowCount > 0 && selectedRow >= 0 && selectedRow < rowCount) {
                    int soLuongSach = Integer.valueOf(table2.getValueAt(selectedRow, 3).toString());
                    table2.setAnimateRowHeight(soLuongSach * 41 + 40);
                }
            }
        });
    }

    public void showListTheMuon(int viTri) {
        if (listTM.size() == 0) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }

        for (int i = viTri; i < listTM.size() && i < (12 + viTri); i++) {
            table2.addRow(new ModelStaff(listTM.get(i)), false);
        }

//        for(int i=0;i<listTM.size() && i<=15;i++){
//            table2.addRow(new ModelStaff(listTM.get(i)), false);
//        }
    }

}
