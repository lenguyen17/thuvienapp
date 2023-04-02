package com.raven.swing.tablequanly.cell;

import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CellTinhTrang extends TableCustomCell {
    
    public CellTinhTrang() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTinhTrang = new javax.swing.JLabel();
        lbTinhTrang1 = new javax.swing.JLabel();
        lbTinhTrang2 = new javax.swing.JLabel();
        lbTinhTrang3 = new javax.swing.JLabel();
        lbTinhTrang4 = new javax.swing.JLabel();
        lbTinhTrang5 = new javax.swing.JLabel();

        lbTinhTrang.setFocusable(false);

        lbTinhTrang1.setFocusable(false);

        lbTinhTrang2.setFocusable(false);

        lbTinhTrang3.setFocusable(false);

        lbTinhTrang4.setFocusable(false);

        lbTinhTrang5.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(lbTinhTrang1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(lbTinhTrang2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(lbTinhTrang3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(lbTinhTrang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTinhTrang5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTinhTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbTinhTrang2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTinhTrang3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTinhTrang4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTinhTrang5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void setData(Object o) {
        if(o!=null){
            lbTinhTrang.setText(o.toString());
        }    
    }

    @Override
    public Object getData() {
        return lbTinhTrang.getText();
    }
//

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellTinhTrang cell = new CellTinhTrang();
        cell.setData(table.getValueAt(row, column)); 
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
//        lbTinhTrang.setText(table.getValueAt(row, column).toString());
        LinkedHashMap<String, String> hmTinhTrang = TheMuonDAO.getInstance().getTinhTrangByTheMuon(table.getValueAt(row, 0).toString());
        ArrayList<String> arrTinhTrang = new ArrayList<>(hmTinhTrang.values());
        for (int i = 0; i < arrTinhTrang.size(); i++) {
            if (i == 0) {
                lbTinhTrang1.setText(arrTinhTrang.get(i));
            } else if (i == 1) {
                lbTinhTrang2.setText(arrTinhTrang.get(i));
            } else if (i == 2) {
                lbTinhTrang3.setText(arrTinhTrang.get(i));
            } else if (i == 3) {
                lbTinhTrang4.setText(arrTinhTrang.get(i));
            }else if (i == 4) {
                lbTinhTrang5.setText(arrTinhTrang.get(i));
            }
        }
        return this;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellTinhTrang cell = new CellTinhTrang();
        cell.setData(o);
//        cell.getCbSach1().setSelectedIndex(getCbSach1().getSelectedIndex());
//        cell.getCbSach2().setSelectedIndex(getCbSach2().getSelectedIndex());
//        cell.getCbSach3().setSelectedIndex(getCbSach3().getSelectedIndex());
//        cell.setSize(152, 17);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTinhTrang;
    private javax.swing.JLabel lbTinhTrang1;
    private javax.swing.JLabel lbTinhTrang2;
    private javax.swing.JLabel lbTinhTrang3;
    private javax.swing.JLabel lbTinhTrang4;
    private javax.swing.JLabel lbTinhTrang5;
    // End of variables declaration//GEN-END:variables

}
