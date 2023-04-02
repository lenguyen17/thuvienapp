package com.raven.swing.tableBook;

import com.raven.component.chart.piechart.ModelPieChart;
import com.raven.component.chart.piechart.PieChart;
import com.raven.swing.tablequanly.cell.*;
import com.raven.dialog.*;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Color;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogPieChartSach extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    public DialogPieChartSach(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                lbTotal.setText("*Tổng số đầu sách: " + SachDAO.getInstance().selectAll().size());
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
                        switch (i) {
                            case 0:
                                lb1.setText(map.get(listLoaiSach.get(i)) + "");
                                break;
                            case 1:
                                lb2.setText(map.get(listLoaiSach.get(i)) + "");
                                break;
                            case 2:
                                lb3.setText(map.get(listLoaiSach.get(i)) + "");
                                break;
                        }
                    }
                    int volume = 0;
                    for (int i = 3; i < map.size(); i++) {
                        volume += map.get(listLoaiSach.get(i));
                    }
                    if (listLoaiSach.size() > 3) {
                        charTheLoaiSach.addData(new ModelPieChart("Khác", volume, listColor.get(3)));
                        lb_TheLoai4.setText("Khác");
                        lb4.setText(volume + "");
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
                if (listLoaiSach.size() > 0) {
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
                Thread.sleep(100);
                return 12;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }
        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    //STT bắt đầu từ 0
    public void showSach() {
        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        button2 = new com.raven.swing.customswing.buttomcustom.Button();
        lbMessage1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        charTheLoaiSach = new com.raven.component.chart.piechart.PieChart();
        jPanel7 = new javax.swing.JPanel();
        colorTheLoai1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        colorTheLoai2 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        colorTheLoai3 = new javax.swing.JPanel();
        lb3 = new javax.swing.JLabel();
        colorTheLoai4 = new javax.swing.JPanel();
        lb4 = new javax.swing.JLabel();
        lb_TheLoai1 = new javax.swing.JLabel();
        lb_TheLoai2 = new javax.swing.JLabel();
        lb_TheLoai3 = new javax.swing.JLabel();
        lb_TheLoai4 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("sl");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));
        jPanel1.setForeground(new java.awt.Color(75, 134, 253));

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        button2.setForeground(new java.awt.Color(66, 66, 66));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        lbMessage1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage1.setText("SÁCH THEO THỂ LOẠI");

        jSeparator1.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator1.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator1.setOpaque(true);

        jSeparator2.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator2.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator2.setOpaque(true);

        jPanel7.setOpaque(false);

        colorTheLoai1.setOpaque(false);

        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("sl");

        javax.swing.GroupLayout colorTheLoai1Layout = new javax.swing.GroupLayout(colorTheLoai1);
        colorTheLoai1.setLayout(colorTheLoai1Layout);
        colorTheLoai1Layout.setHorizontalGroup(
            colorTheLoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );
        colorTheLoai1Layout.setVerticalGroup(
            colorTheLoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorTheLoai1Layout.createSequentialGroup()
                .addComponent(lb1)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        colorTheLoai2.setOpaque(false);

        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("sl");

        javax.swing.GroupLayout colorTheLoai2Layout = new javax.swing.GroupLayout(colorTheLoai2);
        colorTheLoai2.setLayout(colorTheLoai2Layout);
        colorTheLoai2Layout.setHorizontalGroup(
            colorTheLoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        colorTheLoai2Layout.setVerticalGroup(
            colorTheLoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorTheLoai2Layout.createSequentialGroup()
                .addComponent(lb2)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        colorTheLoai3.setOpaque(false);

        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("sl");

        javax.swing.GroupLayout colorTheLoai3Layout = new javax.swing.GroupLayout(colorTheLoai3);
        colorTheLoai3.setLayout(colorTheLoai3Layout);
        colorTheLoai3Layout.setHorizontalGroup(
            colorTheLoai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        colorTheLoai3Layout.setVerticalGroup(
            colorTheLoai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorTheLoai3Layout.createSequentialGroup()
                .addComponent(lb3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        colorTheLoai4.setOpaque(false);

        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("sl");

        javax.swing.GroupLayout colorTheLoai4Layout = new javax.swing.GroupLayout(colorTheLoai4);
        colorTheLoai4.setLayout(colorTheLoai4Layout);
        colorTheLoai4Layout.setHorizontalGroup(
            colorTheLoai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        colorTheLoai4Layout.setVerticalGroup(
            colorTheLoai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorTheLoai4Layout.createSequentialGroup()
                .addComponent(lb4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbTotal.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(colorTheLoai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorTheLoai3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorTheLoai2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorTheLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TheLoai3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_TheLoai4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_TheLoai1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(lb_TheLoai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TheLoai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorTheLoai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTheLoai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TheLoai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TheLoai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorTheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorTheLoai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thể loại");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("*Biểu đồ số lượng đầu sách theo thể loại.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(charTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(charTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        closeMenu();
    }//GEN-LAST:event_button2ActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button button2;
    private com.raven.component.chart.piechart.PieChart charTheLoaiSach;
    private javax.swing.JPanel colorTheLoai1;
    private javax.swing.JPanel colorTheLoai2;
    private javax.swing.JPanel colorTheLoai3;
    private javax.swing.JPanel colorTheLoai4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lb_TheLoai1;
    private javax.swing.JLabel lb_TheLoai2;
    private javax.swing.JLabel lb_TheLoai3;
    private javax.swing.JLabel lb_TheLoai4;
    // End of variables declaration//GEN-END:variables
}
