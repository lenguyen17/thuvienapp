package com.raven.swing.tablequanly.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.table.DefaultTableCellRenderer;

public class TableHeaderCustom extends DefaultTableCellRenderer {

    public TableHeaderCustom() {
        setPreferredSize(new Dimension(0, 35));
        setBackground(new Color(199, 199, 255));
        setForeground(new Color(8, 8, 100));
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        grphcs.setColor(new Color(100, 100, 100));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
