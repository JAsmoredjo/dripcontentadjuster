package com.eGoStudio.dripContentAdjuster.controller;

import com.eGoStudio.dripContentAdjuster.entity.Sheet;

import java.util.ArrayList;
import java.util.List;

public class SheetDatabase {
    private ArrayList<Sheet> sheets;

    public SheetDatabase() {
        sheets = new ArrayList<Sheet>();
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void addSheet(Sheet sheet) {
        sheets.add(sheet);
    }

    public void clear() {
        sheets.clear();
    }

    public boolean isEmpty() {
        return sheets.isEmpty();
    }
}
