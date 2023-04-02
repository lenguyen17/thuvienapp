package com.raven.swing.tablequanly.cell;

import com.raven.dialog.Message;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.TheMuonDAO;
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

public class CellAction extends TableCustomCell {

    private JFrame fram;

    public CellAction(JFrame fram) {
        this.fram = fram;
        initComponents();
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (data.isEditing()) {
                    table.cancelEditRowAt(row);
                    cmdView.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/eye_18px.png")));
                } else {
                    table.editRowAt(row);
                    cmdView.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancelview_18px.png")));
                }
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Message mess = new Message(fram, true);
                mess.showMessage("Bạn có muốn xóa thẻ mượn này ?");
                if (mess.ok) {
                    TheMuon temp = new TheMuon();
                    temp.setIdTheMuon(table.getValueAt(row, 0).toString());
                    TheMuonDAO.getInstance().delete(temp);
                    if (table.getValueAt(row, 1) != null) {
                        HoiVienDAO.getInstance().kiemTraDaTraHet(table.getValueAt(row, 1).toString());
                    }
                    table.deleteRowAt(getRow(), true);
                }
            }
        });
        cmdTraSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {        
                DialogTraSach dia = new DialogTraSach(fram, true, table.getValueAt(row, 0).toString(), table.getValueAt(row, 2).toString());
                dia.showTraSach();
                if (dia.isOk()) {
                    table.deleteRowAt(row, true);
                    if (table.getValueAt(row, 1) != null) {
                        HoiVienDAO.getInstance().kiemTraDaTraHet(table.getValueAt(row, 1).toString());
                    }
                }
            }
        });
        cmdSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
                    @Override
                    protected Integer doInBackground() throws Exception {
                        String mail = HoiVienDAO.getInstance().selectByID(table.getValueAt(row, 1).toString()).getEmail();
                        TheMuon tm = TheMuonDAO.getInstance().selectByID(table.getValueAt(row, 0).toString());
                        SendMail sm = new SendMail(fram, true, mail, tm.getListCTS(), tm.getNgayHenTra());
                        sm.showMessage();
                        Thread.sleep(50);
                        return 12;
                    }
                };
                worker.execute();
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

        cmdTraSach = new com.raven.swing.tablequanly.swing.Button();
        cmdView = new com.raven.swing.tablequanly.swing.Button();
        cmdDelete = new com.raven.swing.tablequanly.swing.Button();
        cmdSend = new com.raven.swing.tablequanly.swing.Button();

        cmdTraSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/rocket_18px.png"))); // NOI18N

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/eye_18px.png"))); // NOI18N

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete_1.png"))); // NOI18N
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/send_18px.png"))); // NOI18N
        cmdSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdView, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdTraSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSendActionPerformed
    @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellAction cell = new CellAction(fram);
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
        CellAction cell = new CellAction(fram);
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.tablequanly.swing.Button cmdDelete;
    private com.raven.swing.tablequanly.swing.Button cmdSend;
    private com.raven.swing.tablequanly.swing.Button cmdTraSach;
    private com.raven.swing.tablequanly.swing.Button cmdView;
    // End of variables declaration//GEN-END:variables
}
