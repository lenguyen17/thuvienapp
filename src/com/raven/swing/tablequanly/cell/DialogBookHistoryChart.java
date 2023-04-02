package com.raven.swing.tablequanly.cell;

import com.raven.component.chart.curvechart.DatabaseConnection;
import com.raven.component.chart.curvechart.ModelData;
import com.raven.component.chart.curvechart.chart.ModelChart;
import com.raven.dialog.*;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.ThoiGianNguoiMuon;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogBookHistoryChart extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;
    private Color[] colors = {Color.decode("#7b4397"), Color.decode("#dc2430"), Color.decode("#e65c00"),
        Color.decode("#F9D423"), Color.decode("#0099F7"), Color.decode("#F11712")};

    public DialogBookHistoryChart(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        curveLineChart.setIndex(2);
        initCurveChart();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);

//        background1.setIcon(new ImageIcon(getClass().getResource("/com//raven/component/logincomps/login/img.jpg")));   
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

    public void showHistory(String idSach) {
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                Sach s = SachDAO.getInstance().selectByID(idSach);
                lbTitle.setText(s.getTenSach());
                ImageIcon icon = new ImageIcon(getClass().getResource("/com/raven/icon/book_images/" + s.getIdSach() + ".jpg"));
                if (icon != null) {
                    pic.setIcon(icon);
                    pic1.setIcon(icon);
                }
                initNoticeBoard(idSach);
                executeCurveChart(idSach);
                Thread.sleep(5000);
                return 12;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
        animator.start();
        setVisible(true);
    }

    private void initCurveChart() {
        curveLineChart.setTitle("Số lần mượn");
        curveLineChart.setTitle("Biểu đồ lượt mượn");
    }

    public void executeCurveChart(String idSach) {
        curveLineChart.clear();
        //REALTIME VALUE IN 3 CLOSED YEAR
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
//        LinkedHashMap<Integer, Integer> valueCurYear = SachDAO.getInstance().getDataChartBySach(idSach, curYear);
//        LinkedHashMap<Integer, Integer> value1YearAgo = SachDAO.getInstance().getDataChartBySach(idSach, curYear-1);
//        LinkedHashMap<Integer, Integer> value2YearAgo = SachDAO.getInstance().getDataChartBySach(idSach, curYear-2);
//        if(valueCurYear.size()!=0 && value1YearAgo.size()!= 0 && value2YearAgo.size()!=0){
//            for(int i=1;i<=12;i++){
//                curveLineChart.addData(new ModelChart("" + i, new double[]{value2YearAgo.get(i),value1YearAgo.get(i),valueCurYear.get(i)}));
//            }
//        }    
        
//        TEST RANDOM VALUE
        Random rb = new Random();
        for (int i = 1; i <= 12; i++) {
            curveLineChart.addData(new ModelChart("" + i, new double[]{rb.nextInt(500), rb.nextInt(500), rb.nextInt(500)}));
        }
        curveLineChart.addLegend("" + (curYear - 2), colors[0], colors[1]);
        curveLineChart.addLegend("" + (curYear - 1), colors[2], colors[3]);
        curveLineChart.addLegend("" + curYear, colors[4], colors[5]);
        curveLineChart.start();
    }

    public void initNoticeBoard(String idSach) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        noticeBoard.setBackground(new Color(0, 0, 0, 0));
        LinkedHashMap<Integer, ThoiGianNguoiMuon> listHistory = SachDAO.getInstance().getLichSuMuon(idSach);

        for (ThoiGianNguoiMuon value : listHistory.values()) {
            noticeBoard.addNoticeBoard(new ModelNoticeBoard(Color.WHITE, value.getHoTen(), sdf.format(value.getThoigian().getTime()), "Tình trạng: " +value.getTinhTrang()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button2 = new com.raven.swing.customswing.buttomcustom.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pic = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        pic1 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        background1 = new com.raven.component.logincomps.login.BackgroundSquare();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        curveLineChart = new com.raven.component.chart.curvechart.CurveLineChart();
        jLabel1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        button2.setForeground(new java.awt.Color(66, 66, 66));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator1.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator1.setOpaque(true);

        jSeparator2.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator2.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator2.setOpaque(true);

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icon_book_50px.png"))); // NOI18N

        pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icon_book_50px.png"))); // NOI18N

        background1.setBlur(jPanel2);

        jPanel2.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lịch sử mượn gần nhất");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        background1.add(jPanel2);
        jPanel2.setBounds(710, 10, 300, 320);

        curveLineChart.setForeground(new java.awt.Color(255, 255, 255));
        background1.add(curveLineChart);
        curveLineChart.setBounds(20, 10, 680, 320);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tháng");
        background1.add(jLabel1);
        jLabel1.setBounds(30, 300, 40, 30);

        lbTitle.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(75, 134, 253));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("TITLE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private com.raven.component.logincomps.login.BackgroundSquare background1;
    private com.raven.swing.customswing.buttomcustom.Button button2;
    private com.raven.component.chart.curvechart.CurveLineChart curveLineChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbTitle;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare pic;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare pic1;
    // End of variables declaration//GEN-END:variables
}
