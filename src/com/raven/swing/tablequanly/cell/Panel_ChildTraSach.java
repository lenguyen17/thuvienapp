package com.raven.swing.tablequanly.cell;

import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class Panel_ChildTraSach extends javax.swing.JPanel {
    
    public String getSelectedTinhTrang() {
        for (Enumeration<AbstractButton> buttons = bgSelector.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    

    public Panel_ChildTraSach(int stt, int soLuong, ChiTietSach cts, String tinhTrang) {
        initComponents();
        bgSelector.add(rb_DangMuon);
        bgSelector.add(rb_HoanTien);
        bgSelector.add(rb_DaTra);
        if(tinhTrang.equalsIgnoreCase("Đã trả")){
            rb_DaTra.setSelected(true);
        }else if(tinhTrang.equalsIgnoreCase("Hoàn tiền")){
            rb_HoanTien.setSelected(true);
        }else if(tinhTrang.equalsIgnoreCase("Trễ hẹn")){
            rb_DangMuon.setText("Trễ hẹn");
        }
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                if (stt <= soLuong && stt > 0) {
                    STT.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/level_" + stt + "_50px.png")));
                }
                if (stt != soLuong) {
//                    jSeparator4.setForeground(new Color(0,0,0,0));
//                    jSeparator4.setOpaque(false);
                    jSeparator4.setPreferredSize(new Dimension(0,4));
                }
                Sach s = SachDAO.getInstance().selectByID(cts.getIdSach());
                if (s != null) {
                    lbTenSach.setText(s.getTenSach());
                    lbGiaTien.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
                            .format(cts.getGiaTien()));
                }
                Thread.sleep(5000);
                return 12;
            }
        };
        worker.execute();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelector = new javax.swing.ButtonGroup();
        STT = new com.raven.swing.customswing.imageswing.ImageAvatar();
        jSeparator4 = new javax.swing.JSeparator();
        lbTenSach = new javax.swing.JLabel();
        lbGiaTien = new javax.swing.JLabel();
        rb_HoanTien = new javax.swing.JRadioButton();
        rb_DangMuon = new javax.swing.JRadioButton();
        rb_DaTra = new javax.swing.JRadioButton();

        setOpaque(false);

        STT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/level_1_50px.png"))); // NOI18N

        jSeparator4.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 0));

        lbTenSach.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbTenSach.setForeground(new java.awt.Color(82, 82, 82));
        lbTenSach.setText("Tên sách:");
        lbTenSach.setToolTipText("");

        lbGiaTien.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbGiaTien.setForeground(new java.awt.Color(82, 82, 82));
        lbGiaTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGiaTien.setText("Giá tiền");

        rb_HoanTien.setText("Hoàn tiền");
        rb_HoanTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_HoanTienActionPerformed(evt);
            }
        });

        rb_DangMuon.setSelected(true);
        rb_DangMuon.setText("Đang mượn");

        rb_DaTra.setText("Đã trả");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(STT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rb_DangMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_HoanTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(rb_DaTra, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rb_HoanTien)
                        .addComponent(rb_DangMuon)
                        .addComponent(rb_DaTra))
                    .addComponent(STT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rb_HoanTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_HoanTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_HoanTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.imageswing.ImageAvatar STT;
    public javax.swing.ButtonGroup bgSelector;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbGiaTien;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JRadioButton rb_DaTra;
    private javax.swing.JRadioButton rb_DangMuon;
    private javax.swing.JRadioButton rb_HoanTien;
    // End of variables declaration//GEN-END:variables

    void setTraSach() {
        rb_DaTra.setSelected(true);
    }
}
