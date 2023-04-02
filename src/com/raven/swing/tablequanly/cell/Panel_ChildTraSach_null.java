package com.raven.swing.tablequanly.cell;

import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class Panel_ChildTraSach_null extends javax.swing.JPanel {


    public Panel_ChildTraSach_null() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelector = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        lbTenSach = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setOpaque(false);

        lbTenSach.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbTenSach.setForeground(new java.awt.Color(82, 82, 82));
        lbTenSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/empty_30px.png"))); // NOI18N
        lbTenSach.setText("Không có sách để hiển thị");
        lbTenSach.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup bgSelector;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel lbTenSach;
    // End of variables declaration//GEN-END:variables
}
