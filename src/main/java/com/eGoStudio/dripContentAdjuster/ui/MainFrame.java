package com.eGoStudio.dripContentAdjuster.ui;

import com.eGoStudio.dripContentAdjuster.controller.OpenFormListener;
import com.eGoStudio.dripContentAdjuster.controller.SaveAndExportFormListener;
import com.eGoStudio.dripContentAdjuster.controller.SheetDatabase;
import com.eGoStudio.dripContentAdjuster.controller.UpdateFormListener;
import com.eGoStudio.dripContentAdjuster.entity.Form;
import com.eGoStudio.dripContentAdjuster.entity.Sheet;
import com.eGoStudio.dripContentAdjuster.utility.Excel;
import com.eGoStudio.dripContentAdjuster.utility.Rename;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainFrame extends JFrame {
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private SheetDatabase sheetDatabase;

    public MainFrame() {
        super("Drip Content Adjuster");

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        sheetDatabase = new SheetDatabase();

        formPanel.setOpenFormListener(new OpenFormListener() {
            @Override
            public void openFormAction(File file) {
                tablePanel.stopEditing();

                if (file.listFiles().length > 0) {
                    if (!sheetDatabase.isEmpty()) {
                        sheetDatabase.clear();
                    }

                    Sheet albumSheet = new Sheet();
                    albumSheet.setFolder(file.getAbsolutePath());
                    albumSheet.setAction("INSERT");
                    albumSheet.setType("Album");
                    albumSheet.setDeliveredBy("TrackDrip");

                    sheetDatabase.addSheet(albumSheet);

                    for (File fileTemp : file.listFiles()) {
                        if (fileTemp.isFile() && FilenameUtils.getExtension(fileTemp.getName()).toLowerCase().equals("mp3")) {
                            String filename = FilenameUtils.removeExtension(fileTemp.getName());

                            int spliceIndex = filename.indexOf(" ");

                            Sheet trackSheet = new Sheet();
                            trackSheet.setFolder(fileTemp.getAbsolutePath());
                            trackSheet.setAction("INSERT");
                            trackSheet.setType("Track");
                            trackSheet.setSeq(String.valueOf(Integer.parseInt(filename.substring(0, spliceIndex))));
                            trackSheet.setTitle(filename.substring(spliceIndex + 1));
                            trackSheet.setMediaType("MP3");
                            trackSheet.setDeliveredBy("TrackDrip");

                            sheetDatabase.addSheet(trackSheet);
                        }
                    }

                    tablePanel.refresh();
                } else {
                    JOptionPane.showMessageDialog(null, "Empty Folder", "Empty Folder", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formPanel.setUpdateFormListener(new UpdateFormListener() {
            @Override
            public void updateFormAction(Form form) {
                tablePanel.stopEditing();

                List<Sheet> sheets = sheetDatabase.getSheets();
                int isrcNumber = Integer.parseInt(form.getLastISRC().substring(5));
                for (Sheet sheet : sheets) {
                    sheet.setDiscNumber(form.getDiscNumber());
                    if (sheets.indexOf(sheet) == 0) {
                        sheet.setTitle(form.getAlbumTitle());
                    }
                    sheet.setArtist(form.getArtist());
                    sheet.setLanguage(form.getLanguage().toUpperCase());
                    if (sheets.indexOf(sheet) == 0) {
                        sheet.setUpcISRC(form.getUpc().toUpperCase());
                    } else {
                        sheet.setUpcISRC("QZF8D" + String.valueOf(++isrcNumber).toUpperCase());
                    }
                    sheet.setReleaseDate(form.getReleaseDate());
                    sheet.setReleaseLanguage(form.getReleaseLanguage().toUpperCase());
                    sheet.setExplicit(form.getExplicit().toUpperCase());
                    sheet.setStream(form.getStream().toUpperCase());
                    sheet.setTerritory(form.getTerritory().toUpperCase());
                    sheet.setGenre(form.getGenre());
                    sheet.setSubGenre(form.getSubGenre());
                    sheet.setLabel(form.getLabel());
                    sheet.setCopyright(form.getCopyright());
                }

                tablePanel.refresh();
            }
        });

        formPanel.setSaveAndExportFormListener(new SaveAndExportFormListener() {
            @Override
            public void saveAndExportAction() {
                List<Sheet> sheets = tablePanel.getData();
                if (sheets.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Content To Adjust", "No Content", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean existAlbum = false;
                    boolean existTrack = false;
                    boolean validUPCisrc = true;
                    for (Sheet sheet : sheets) {
                        if (sheet.getType().toLowerCase().equals("album")) {
                            existAlbum = true;
                            if (sheet.getUpcISRC() == null || sheet.getUpcISRC().equals("")) {
                                validUPCisrc = false;
                                break;
                            }
                        } else if (sheet.getType().toLowerCase().equals("track")) {
                            existTrack = true;
                            if (sheet.getUpcISRC() == null || !sheet.getUpcISRC().contains("QZF8D")) {
                                validUPCisrc = false;
                                break;
                            }
                        }
                    }
                    if (existAlbum && existTrack && validUPCisrc) {
                        Excel excel = new Excel();
                        if (excel.createExcel(sheets)) {
                            Rename rename = new Rename();
                            if (rename.renameMP3(sheets)) {
                                JOptionPane.showMessageDialog(null, "Save And Rename Finished", "Save And Rename Finished", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "MP3 Renaming Error", "MP3 Renaming Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Excel Creation Error", "Excel Creation Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Missing UPC/ISRC", "Missing UPC/ISRC", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tablePanel.setData(sheetDatabase.getSheets());

        setLayout(new BorderLayout());

        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);

        setSize(900, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}