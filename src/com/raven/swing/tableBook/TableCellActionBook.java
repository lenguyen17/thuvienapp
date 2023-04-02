package com.raven.swing.tableBook;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionBook extends DefaultCellEditor {

    private ModelActionBook data;

    public TableCellActionBook() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionBook) o;
        ActionBook cell = new ActionBook(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
