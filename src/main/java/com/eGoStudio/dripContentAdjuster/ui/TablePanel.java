package com.eGoStudio.dripContentAdjuster.ui;

import com.eGoStudio.dripContentAdjuster.entity.Sheet;
import com.eGoStudio.dripContentAdjuster.utility.TableColumnAdjuster;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private SheetTableModel sheetTableModel;
    private TableColumnAdjuster columnAdjuster;

    public TablePanel() {
        sheetTableModel = new SheetTableModel();
        table = new JTable(sheetTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        columnAdjuster = new TableColumnAdjuster(table);
        columnAdjuster.adjustColumns();

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Sheet> sheets) {
        sheetTableModel.setSheets(sheets);
        columnAdjuster.adjustColumns();
    }

    public void refresh() {
        sheetTableModel.fireTableDataChanged();
        columnAdjuster.adjustColumns();
    }

    public void stopEditing() {
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
            table.removeEditor();
        }
    }

    public List<Sheet> getData() {
        stopEditing();
        return sheetTableModel.getSheets();
    }
}
