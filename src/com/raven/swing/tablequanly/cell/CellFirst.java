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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class CellFirst extends TableCustomCell {

    public JLabel getLbHoTen1() {
        return lbName;
    }

    public CellFirst() {
        initComponents();
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/com/raven/icon/book_images/" + data.toString() + ".png"));
            if (icon != null) {
                pic.setIcon(icon);
            }
        } catch (Exception e) {
            return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbName = new javax.swing.JLabel();

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icon_book_50px.png"))); // NOI18N

        lbName.setForeground(new java.awt.Color(102, 102, 102));
        lbName.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void setData(Object o) {
        lbName.setText(o.toString());
    }

    @Override
    public Object getData() {
        return lbName.getText().trim();
    }
//

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellFirst cell = new CellFirst();
        cell.setData(table.getValueAt(row, column));
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellFirst cell = new CellFirst();
        cell.addEvent(table, data, row);
        cell.setData(table.getValueAt(row, column));
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbName;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare pic;
    // End of variables declaration//GEN-END:variables
}
