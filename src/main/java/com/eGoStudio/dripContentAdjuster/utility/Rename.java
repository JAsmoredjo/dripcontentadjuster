package com.eGoStudio.dripContentAdjuster.utility;

import com.eGoStudio.dripContentAdjuster.entity.Sheet;

import java.io.File;
import java.util.List;

public class Rename {
    public boolean renameMP3 (List<Sheet> sheets) {
        boolean renamedAll = true;
        for (Sheet sheet : sheets) {
            if (sheet.getType().toLowerCase().equals("track")) {
                File oldName = new File(sheet.getFolder());
                File newName = new File(oldName.getParent() + "\\" + sheet.getUpcISRC() + ".mp3");

                if (!oldName.renameTo(newName)) {
                    renamedAll = false;
                    break;
                }
            }
        }
        return renamedAll;
    }
}
