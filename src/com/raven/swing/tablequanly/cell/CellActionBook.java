package com.raven.swing.tablequanly.cell;

import com.raven.dialog.Message;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.notification.Notification;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CellActionBook extends TableCustomCell {
    public CellActionBook() {
        initComponents();
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = table.getValueAt(row, 0).toString();
                ChiTietSach cts = ChiTietSachDAO.getInstance().castCTS(id);
                if (cts != null) {
                    DialogSach dia = new DialogSach(null, true, cts);
                    dia.showSach();
                }
            }
        });
        cmdHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = table.getValueAt(row, 0).toString();
                ChiTietSach cts = ChiTietSachDAO.getInstance().castCTS(id);
                if (cts != null) {
                    DialogSach dia = new DialogSach(null, true, cts);
                    dia.showSach();
                }
            }
        });

    }

    private void checkIcon(TableRowData data) {
        if (data.isEditing()) {
            cmdView.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancelview_18px.png")));
        } else {
            cmdView.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/eye_18px.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdView = new com.raven.swing.tablequanly.swing.Button();
        cmdHistory = new com.raven.swing.tablequanly.swing.Button();

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/eye_18px.png"))); // NOI18N

        cmdHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/clock_18px.png"))); // NOI18N
        cmdHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdView, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(cmdHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdHistoryActionPerformed
    @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellActionBook cell = new CellActionBook();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellActionBook cell = new CellActionBook();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.tablequanly.swing.Button cmdHistory;
    private com.raven.swing.tablequanly.swing.Button cmdView;
    // End of variables declaration//GEN-END:variables
}
