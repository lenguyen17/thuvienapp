package com.raven.swing.tablequanly.cell;

import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class Panel_ChildTraSach_Empty extends javax.swing.JPanel {


    public Panel_ChildTraSach_Empty() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelector = new javax.swing.ButtonGroup();
        jSeparator4 = new javax.swing.JSeparator();

        setOpaque(false);

        jSeparator4.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup bgSelector;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
