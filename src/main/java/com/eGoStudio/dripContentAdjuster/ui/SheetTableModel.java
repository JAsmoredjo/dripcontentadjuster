package com.eGoStudio.dripContentAdjuster.ui;

import com.eGoStudio.dripContentAdjuster.entity.Sheet;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SheetTableModel extends AbstractTableModel {
    private String[] columnNames = {"ACTION", "TYPE", "DISC NUMBER", "SEQ", "TITLE", "ARTIST","LANGUAGE", "UPC/ISRC", "RELEASE_DATE", "RELEASE LANGUAGE", "EXPLICIT", "STREAM", "TERRITORY", "GENRE", "SUB_GENRE", "MEDIA_TYPE", "LABEL", "COPYRIGHT", "DELIVERED BY", "TITLE 2", "ARTIST 2", "LANGUAGE 2", "TITLE 3", "ARTIST 3", "LANGUAGE 3"};
    private List<Sheet> sheets = new ArrayList<Sheet>();

    public SheetTableModel() {
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    @Override
    public int getRowCount() {
        return sheets.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sheet sheet = sheets.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sheet.getAction();
            case 1:
                return sheet.getType();
            case 2:
                return sheet.getDiscNumber();
            case 3:
                return sheet.getSeq();
            case 4:
                return sheet.getTitle();
            case 5:
                return sheet.getArtist();
            case 6:
                return sheet.getLanguage();
            case 7:
                return sheet.getUpcISRC();
            case 8:
                return sheet.getReleaseDate();
            case 9:
                return sheet.getReleaseLanguage();
            case 10:
                return sheet.getExplicit();
            case 11:
                return sheet.getStream();
            case 12:
                return sheet.getTerritory();
            case 13:
                return sheet.getGenre();
            case 14:
                return sheet.getSubGenre();
            case 15:
                return sheet.getMediaType();
            case 16:
                return sheet.getLabel();
            case 17:
                return sheet.getCopyright();
            case 18:
                return sheet.getDeliveredBy();
            case 19:
                return sheet.getTitle2();
            case 20:
                return sheet.getArtist2();
            case 21:
                return sheet.getLanguage2();
            case 22:
                return sheet.getTitle3();
            case 23:
                return sheet.getArtist3();
            case 24:
                return sheet.getLanguage3();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Sheet sheet = sheets.get(rowIndex);

        switch (columnIndex) {
            case 0:
                sheet.setAction((String) aValue);
                break;
            case 1:
                sheet.setType((String) aValue);
                break;
            case 2:
                sheet.setDiscNumber((String) aValue);
                break;
            case 3:
                sheet.setSeq((String) aValue);
                break;
            case 4:
                sheet.setTitle((String) aValue);
                break;
            case 5:
                sheet.setArtist((String) aValue);
                break;
            case 6:
                sheet.setLanguage((String) aValue);
                break;
            case 7:
                sheet.setUpcISRC((String) aValue);
                break;
            case 8:
                sheet.setReleaseDate((String) aValue);
                break;
            case 9:
                sheet.setReleaseLanguage((String) aValue);
                break;
            case 10:
                sheet.setExplicit((String) aValue);
                break;
            case 11:
                sheet.setStream((String) aValue);
                break;
            case 12:
                sheet.setTerritory((String) aValue);
                break;
            case 13:
                sheet.setGenre((String) aValue);
                break;
            case 14:
                sheet.setSubGenre((String) aValue);
                break;
            case 15:
                sheet.setMediaType((String) aValue);
                break;
            case 16:
                sheet.setLabel((String) aValue);
                break;
            case 17:
                sheet.setCopyright((String) aValue);
                break;
            case 18:
                sheet.setDeliveredBy((String) aValue);
                break;
            case 19:
                sheet.setTitle2((String) aValue);
                break;
            case 20:
                sheet.setArtist2((String) aValue);
                break;
            case 21:
                sheet.setLanguage2((String) aValue);
                break;
            case 22:
                sheet.setTitle3((String) aValue);
                break;
            case 23:
                sheet.setArtist3((String) aValue);
                break;
            case 24:
                sheet.setLanguage3((String) aValue);
                break;
        }
    }
}
