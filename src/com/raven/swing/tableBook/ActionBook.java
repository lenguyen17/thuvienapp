package com.raven.swing.tableBook;

import static com.raven.main.Main.fram;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.swing.tablequanly.cell.DialogSach;
import com.raven.table.TableCustom;
import com.raven.table.model.TableRowData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBook extends javax.swing.JPanel {

    public ActionBook(ModelActionBook data){
        initComponents();
        cmdShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               data.getEvent().showHistory(data.getBook());
            }
        });
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               data.getEvent().view(data.getBook());
            }
        });
    } 
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdShow = new com.raven.swing.customswing.buttomcustom.Button();
        cmdView = new com.raven.swing.customswing.buttomcustom.Button();

        cmdShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/clock_18px.png"))); // NOI18N

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/eye_18px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdShow, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button cmdShow;
    private com.raven.swing.customswing.buttomcustom.Button cmdView;
    // End of variables declaration//GEN-END:variables
}
