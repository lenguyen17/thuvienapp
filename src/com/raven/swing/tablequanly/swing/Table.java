package com.raven.swing.tablequanly.swing;

import com.raven.swing.table.ModelAction;
import com.raven.swing.table.Action;
import com.raven.swing.table.Profile;
import com.raven.swing.table.TableCellAction;
import com.raven.swing.table.ModelProfile;

import com.raven.swing.table.TableCellAction;
import com.raven.swing.table.Profile;
import com.raven.swing.table.Action;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;


import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.tablequanly.swing.TableHeaderCustom;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

public class Table extends TableCustom {

    public Table() {
        setGridColor(Color.BLACK);
    }

    public void addTableStyle(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
//        scroll.getViewport().setBackground(Color.RED);
        scroll.setViewportBorder(null);
        setBorder(null);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setOpaque(true);
        scroll.setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
//        setForeground(new Color(214, 214, 214));
        setSelectionForeground(new Color(102, 102, 102));
        setSelectionBackground(new Color(0,0,0,0));
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
//        setRowHeight(47);
        setShowHorizontalLines(true);

        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
        Component com = super.prepareRenderer(tcr, i, i1);

        if (!isCellSelected(i, i1)) {
            com.setBackground(Color.WHITE);
//            setAnimateRowHeight(41);
        } else {
//            int soLuongSach = Integer.valueOf(getValueAt(getSelectedRow(), 3).toString());
//            System.out.println(soLuongSach*41 +35);
//            setAnimateRowHeight(soLuongSach*41 +35);
//            setSelectionBackground(new Color(0, 0, 0, 0));
            com.setBackground(new Color(0,0,0,0));

        }
        return com;
    }

    @Override
    public void editRowAt(int row) {
        super.editRowAt(row); 
    }

    @Override
    public void cancelEditRowAt(int row) {
        super.cancelEditRowAt(row); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
