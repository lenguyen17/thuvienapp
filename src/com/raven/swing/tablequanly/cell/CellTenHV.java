package com.raven.swing.tablequanly.cell;

import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.TheMuon;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CellTenHV extends TableCustomCell {

    public JLabel getLbHoTen1() {
        return lbHoTen1;
    }

    public CellTenHV() {
        initComponents();
//        setSize(getWidth(), 17);
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String idHV = table.getValueAt(row, 1) + "";
                if (idHV != null) {
                    DialogHoiVien hvInfo = new DialogHoiVien(null, true);
                    hvInfo.showHoiVienInFo(idHV);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdView = new com.raven.swing.tablequanly.swing.Button();
        lbHoTen = new javax.swing.JLabel();
        cmdView1 = new com.raven.swing.tablequanly.swing.Button();
        lbHoTen1 = new javax.swing.JLabel();
        cmdView2 = new com.raven.swing.tablequanly.swing.Button();
        lbHoTen2 = new javax.swing.JLabel();
        lbHoTen3 = new javax.swing.JLabel();
        cmdView3 = new com.raven.swing.tablequanly.swing.Button();
        cmdView4 = new com.raven.swing.tablequanly.swing.Button();
        lbHoTen4 = new javax.swing.JLabel();
        lbHoTen5 = new javax.swing.JLabel();
        cmdView5 = new com.raven.swing.tablequanly.swing.Button();

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/male_user_18px.png"))); // NOI18N

        cmdView1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_18px.png"))); // NOI18N

        cmdView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_18px.png"))); // NOI18N
        cmdView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdView2ActionPerformed(evt);
            }
        });

        cmdView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_18px.png"))); // NOI18N

        cmdView4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_18px.png"))); // NOI18N

        cmdView5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_18px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHoTen1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(cmdView1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHoTen2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(cmdView2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHoTen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdView3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbHoTen4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdView4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHoTen5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdView5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHoTen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHoTen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHoTen4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHoTen5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdView5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdView2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdView2ActionPerformed
    @Override
    public void setData(Object o) {
        lbHoTen.setText(o.toString());
    }

    @Override
    public Object getData() {
        return lbHoTen.getText().trim();
    }
//

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellTenHV cell = new CellTenHV();
        cell.setData(table.getValueAt(row, column));
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        lbHoTen.setText(table.getValueAt(row, column).toString());
        TheMuon tm = TheMuonDAO.getInstance().selectByID(table.getValueAt(row, 0).toString());
        int soLuong = tm.getListCTS().size();

        if (soLuong != 0) {
            if (soLuong > 0) {
                lbHoTen1.setText(SachDAO.getInstance().selectByID(tm.getListCTS().get(0).getIdSach()).getTenSach());
                cmdView1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        DialogSach dia = new DialogSach(null, true, tm.getListCTS().get(0));
                        dia.showSach();
                    }
                });

            }
            if (soLuong > 1) {
                lbHoTen2.setText(SachDAO.getInstance().selectByID(tm.getListCTS().get(1).getIdSach()).getTenSach());
                cmdView2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        DialogSach dia = new DialogSach(null, true, tm.getListCTS().get(1));
                        dia.showSach();
                    }
                });
            }
            if (soLuong > 2) {
                lbHoTen3.setText(SachDAO.getInstance().selectByID(tm.getListCTS().get(2).getIdSach()).getTenSach());
                cmdView3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        DialogSach dia = new DialogSach(null, true, tm.getListCTS().get(2));
                        dia.showSach();
                    }
                });
            }
            if (soLuong > 3) {
                lbHoTen4.setText(SachDAO.getInstance().selectByID(tm.getListCTS().get(3).getIdSach()).getTenSach());
                cmdView4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        DialogSach dia = new DialogSach(null, true, tm.getListCTS().get(3));
                        dia.showSach();
                    }
                });
            }
            if (soLuong > 4) {
                lbHoTen5.setText(SachDAO.getInstance().selectByID(tm.getListCTS().get(4).getIdSach()).getTenSach());
                cmdView5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        DialogSach dia = new DialogSach(null, true, tm.getListCTS().get(4));
                        dia.showSach();
                    }
                });
            }
        }
        return this;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellTenHV cell = new CellTenHV();
        cell.addEvent(table, data, row);
        cell.setData(table.getValueAt(row, column));
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.tablequanly.swing.Button cmdView;
    private com.raven.swing.tablequanly.swing.Button cmdView1;
    private com.raven.swing.tablequanly.swing.Button cmdView2;
    private com.raven.swing.tablequanly.swing.Button cmdView3;
    private com.raven.swing.tablequanly.swing.Button cmdView4;
    private com.raven.swing.tablequanly.swing.Button cmdView5;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbHoTen1;
    private javax.swing.JLabel lbHoTen2;
    private javax.swing.JLabel lbHoTen3;
    private javax.swing.JLabel lbHoTen4;
    private javax.swing.JLabel lbHoTen5;
    // End of variables declaration//GEN-END:variables
}
