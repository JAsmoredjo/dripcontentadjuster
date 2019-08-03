package com.eGoStudio.dripContentAdjuster.ui;

import com.eGoStudio.dripContentAdjuster.controller.OpenFormListener;
import com.eGoStudio.dripContentAdjuster.controller.SaveAndExportFormListener;
import com.eGoStudio.dripContentAdjuster.controller.UpdateFormListener;
import com.eGoStudio.dripContentAdjuster.entity.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FormPanel extends JPanel {
    private JLabel folderLabel;
    private JTextField folderField;
    private JButton openButton;
    private JLabel discNumberLabel;
    private JTextField discNumberField;
    private JLabel albumTitleLabel;
    private JTextField albumTitleField;
    private JLabel artistLabel;
    private JTextField artistField;
    private JLabel languageLabel;
    private JTextField languageField;
    private JLabel upcLabel;
    private JTextField upcField;
    private JLabel lastISRCLabel;
    private JTextField lastISRCField;
    private JLabel releaseDateLabel;
    private JTextField releaseDateField;
    private JLabel releaseLanguageLabel;
    private JTextField releaseLanguageField;
    private JLabel explicitLabel;
    private JTextField explicitField;
    private JLabel streamLabel;
    private JTextField streamField;
    private JLabel territoryLabel;
    private JTextField territoryField;
    private JLabel genreLabel;
    private JTextField genreField;
    private JLabel subGenreLabel;
    private JTextField subGenreField;
    private JLabel labelLabel;
    private JTextField labelField;
    private JLabel copyrightLabel;
    private JTextField copyrightField;
    private JButton updateButton;
    private JButton saveAndExportButton;
    private JFileChooser fileChooser;
    private OpenFormListener openFormListener;
    private UpdateFormListener updateFormListener;
    private SaveAndExportFormListener saveAndExportFormListener;

    public FormPanel() {
        folderLabel = new JLabel("Folder:");
        folderField = new JTextField();
        openButton = new JButton("Open");
        discNumberLabel = new JLabel("Disc Number:");
        discNumberField = new JTextField();
        albumTitleLabel = new JLabel("Album Title:");
        albumTitleField = new JTextField();
        artistLabel = new JLabel("Artist:");
        artistField = new JTextField();
        languageLabel = new JLabel("Language:");
        languageField = new JTextField();
        upcLabel = new JLabel("UPC:");
        upcField = new JTextField();
        lastISRCLabel = new JLabel("Last ISRC:");
        lastISRCField = new JTextField();
        releaseDateLabel = new JLabel("Release Date:");
        releaseDateField = new JTextField();
        releaseLanguageLabel = new JLabel("Release Language:");
        releaseLanguageField = new JTextField();
        explicitLabel = new JLabel("Explicit:");
        explicitField = new JTextField();
        streamLabel = new JLabel("Stream:");
        streamField = new JTextField();
        territoryLabel = new JLabel("Territory:");
        territoryField = new JTextField();
        genreLabel = new JLabel("Genre:");
        genreField = new JTextField();
        subGenreLabel = new JLabel("Sub Genre:");
        subGenreField = new JTextField();
        labelLabel = new JLabel("Label:");
        labelField = new JTextField();
        copyrightLabel = new JLabel("Copyright:");
        copyrightField = new JTextField();
        updateButton = new JButton("Update");
        saveAndExportButton = new JButton("Save and Export");
        fileChooser = new JFileChooser();

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    folderField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    File file = new File(folderField.getText()) ;

                    if (openFormListener != null) {
                        if (file.listFiles().length > 0) {
                            updateButton.setEnabled(true);
                            saveAndExportButton.setEnabled(true);
                        }
                        openFormListener.openFormAction(file);
                    }
                }
            }
        });

        updateButton.setEnabled(false);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String folder = folderField.getText();
                String discNumber = discNumberField.getText();
                String albumTitle = albumTitleField.getText();
                String artist = artistField.getText();
                String language = languageField.getText();
                String upc = upcField.getText();
                String lastISRC = lastISRCField.getText();
                String releaseDate = releaseDateField.getText();
                String releaseLanguage = releaseLanguageField.getText();
                String explicit = explicitField.getText();
                String stream = streamField.getText();
                String territory = territoryField.getText();
                String genre = genreField.getText();
                String subGenre = subGenreField.getText();
                String label = labelField.getText();
                String copyright = copyrightField.getText();

                Form form = new Form(folder, discNumber, albumTitle, artist, language, upc, lastISRC, releaseDate, releaseLanguage, explicit, stream, territory, genre, subGenre, label, copyright);

                if (updateFormListener != null) {
                    updateFormListener.updateFormAction(form);
                }
            }
        });

        saveAndExportButton.setEnabled(false);
        saveAndExportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saveAndExportFormListener != null) {
                    saveAndExportFormListener.saveAndExportAction();
                }
            }
        });

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        SpringLayout layout = new SpringLayout();

        setLayout(layout);

        Dimension labelDimension = releaseLanguageLabel.getPreferredSize();
        labelDimension.height = saveAndExportButton.getPreferredSize().height;

        Dimension textFieldDimension = releaseLanguageLabel.getPreferredSize();
        textFieldDimension.width *= 2;
        textFieldDimension.height = saveAndExportButton.getPreferredSize().height;

        Dimension buttonDimension = saveAndExportButton.getPreferredSize();
        buttonDimension.width = saveAndExportButton.getPreferredSize().width;

        int padding = 5;

        folderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        folderLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, folderLabel, padding, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, folderLabel, padding, SpringLayout.NORTH, this);
        add(folderLabel);

        openButton.setPreferredSize(buttonDimension);
        layout.putConstraint(SpringLayout.WEST, openButton, padding, SpringLayout.EAST, folderLabel);
        layout.putConstraint(SpringLayout.NORTH, openButton, 0, SpringLayout.NORTH, folderLabel);
        add(openButton);

        discNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        discNumberLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, discNumberLabel, 0, SpringLayout.WEST, folderLabel);
        layout.putConstraint(SpringLayout.NORTH, discNumberLabel, padding, SpringLayout.SOUTH, folderLabel);
        add(discNumberLabel);

        discNumberField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, discNumberField, padding, SpringLayout.EAST, discNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, discNumberField, 0, SpringLayout.NORTH, discNumberLabel);
        add(discNumberField);

        albumTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        albumTitleLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, albumTitleLabel, 0, SpringLayout.WEST, discNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, albumTitleLabel, padding, SpringLayout.SOUTH, discNumberLabel);
        add(albumTitleLabel);

        albumTitleField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, albumTitleField, padding, SpringLayout.EAST, albumTitleLabel);
        layout.putConstraint(SpringLayout.NORTH, albumTitleField, 0, SpringLayout.NORTH, albumTitleLabel);
        add(albumTitleField);

        artistLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        artistLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, artistLabel, 0, SpringLayout.WEST, albumTitleLabel);
        layout.putConstraint(SpringLayout.NORTH, artistLabel, padding, SpringLayout.SOUTH, albumTitleLabel);
        add(artistLabel);

        artistField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, artistField, padding, SpringLayout.EAST, artistLabel);
        layout.putConstraint(SpringLayout.NORTH, artistField, 0, SpringLayout.NORTH, artistLabel);
        add(artistField);

        languageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        languageLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, languageLabel, 0, SpringLayout.WEST, artistLabel);
        layout.putConstraint(SpringLayout.NORTH, languageLabel, padding, SpringLayout.SOUTH, artistLabel);
        add(languageLabel);

        languageField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, languageField, padding, SpringLayout.EAST, languageLabel);
        layout.putConstraint(SpringLayout.NORTH, languageField, 0, SpringLayout.NORTH, languageLabel);
        add(languageField);

        upcLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        upcLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, upcLabel, 0, SpringLayout.WEST, languageLabel);
        layout.putConstraint(SpringLayout.NORTH, upcLabel, padding, SpringLayout.SOUTH, languageLabel);
        add(upcLabel);

        upcField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, upcField, padding, SpringLayout.EAST, upcLabel);
        layout.putConstraint(SpringLayout.NORTH, upcField, 0, SpringLayout.NORTH, upcLabel);
        add(upcField);

        lastISRCLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastISRCLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, lastISRCLabel, 0, SpringLayout.WEST, upcLabel);
        layout.putConstraint(SpringLayout.NORTH, lastISRCLabel, padding, SpringLayout.SOUTH, upcLabel);
        add(lastISRCLabel);

        lastISRCField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, lastISRCField, padding, SpringLayout.EAST, lastISRCLabel);
        layout.putConstraint(SpringLayout.NORTH, lastISRCField, 0, SpringLayout.NORTH, lastISRCLabel);
        add(lastISRCField);

        releaseDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        releaseDateLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, releaseDateLabel, 0, SpringLayout.WEST, lastISRCLabel);
        layout.putConstraint(SpringLayout.NORTH, releaseDateLabel, padding, SpringLayout.SOUTH, lastISRCLabel);
        add(releaseDateLabel);

        releaseDateField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, releaseDateField, padding, SpringLayout.EAST, releaseDateLabel);
        layout.putConstraint(SpringLayout.NORTH, releaseDateField, 0, SpringLayout.NORTH, releaseDateLabel);
        add(releaseDateField);

        releaseLanguageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        releaseLanguageLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, releaseLanguageLabel, 0, SpringLayout.WEST, releaseDateLabel);
        layout.putConstraint(SpringLayout.NORTH, releaseLanguageLabel, padding, SpringLayout.SOUTH, releaseDateLabel);
        add(releaseLanguageLabel);

        releaseLanguageField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, releaseLanguageField, padding, SpringLayout.EAST, releaseLanguageLabel);
        layout.putConstraint(SpringLayout.NORTH, releaseLanguageField, 0, SpringLayout.NORTH, releaseLanguageLabel);
        add(releaseLanguageField);

        explicitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        explicitLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, explicitLabel, 0, SpringLayout.WEST, releaseLanguageLabel);
        layout.putConstraint(SpringLayout.NORTH, explicitLabel, padding, SpringLayout.SOUTH, releaseLanguageLabel);
        add(explicitLabel);

        explicitField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, explicitField, padding, SpringLayout.EAST, explicitLabel);
        layout.putConstraint(SpringLayout.NORTH, explicitField, 0, SpringLayout.NORTH, explicitLabel);
        add(explicitField);

        streamLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        streamLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, streamLabel, 0, SpringLayout.WEST, explicitLabel);
        layout.putConstraint(SpringLayout.NORTH, streamLabel, padding, SpringLayout.SOUTH, explicitLabel);
        add(streamLabel);

        streamField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, streamField, padding, SpringLayout.EAST, streamLabel);
        layout.putConstraint(SpringLayout.NORTH, streamField, 0, SpringLayout.NORTH, streamLabel);
        add(streamField);

        territoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        territoryLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, territoryLabel, 0, SpringLayout.WEST, streamLabel);
        layout.putConstraint(SpringLayout.NORTH, territoryLabel, padding, SpringLayout.SOUTH, streamLabel);
        add(territoryLabel);

        territoryField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, territoryField, padding, SpringLayout.EAST, territoryLabel);
        layout.putConstraint(SpringLayout.NORTH, territoryField, 0, SpringLayout.NORTH, territoryLabel);
        add(territoryField);

        genreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        genreLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, genreLabel, 0, SpringLayout.WEST, territoryLabel);
        layout.putConstraint(SpringLayout.NORTH, genreLabel, padding, SpringLayout.SOUTH, territoryLabel);
        add(genreLabel);

        genreField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, genreField, padding, SpringLayout.EAST, genreLabel);
        layout.putConstraint(SpringLayout.NORTH, genreField, 0, SpringLayout.NORTH, genreLabel);
        add(genreField);

        subGenreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        subGenreLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, subGenreLabel, 0, SpringLayout.WEST, genreLabel);
        layout.putConstraint(SpringLayout.NORTH, subGenreLabel, padding, SpringLayout.SOUTH, genreLabel);
        add(subGenreLabel);

        subGenreField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, subGenreField, padding, SpringLayout.EAST, subGenreLabel);
        layout.putConstraint(SpringLayout.NORTH, subGenreField, 0, SpringLayout.NORTH, subGenreLabel);
        add(subGenreField);

        labelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        labelLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, labelLabel, 0, SpringLayout.WEST, subGenreLabel);
        layout.putConstraint(SpringLayout.NORTH, labelLabel, padding, SpringLayout.SOUTH, subGenreLabel);
        add(labelLabel);

        labelField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, labelField, padding, SpringLayout.EAST, labelLabel);
        layout.putConstraint(SpringLayout.NORTH, labelField, 0, SpringLayout.NORTH, labelLabel);
        add(labelField);

        copyrightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        copyrightLabel.setPreferredSize(labelDimension);
        layout.putConstraint(SpringLayout.WEST, copyrightLabel, 0, SpringLayout.WEST, labelLabel);
        layout.putConstraint(SpringLayout.NORTH, copyrightLabel, padding, SpringLayout.SOUTH, labelLabel);
        add(copyrightLabel);

        copyrightField.setPreferredSize(textFieldDimension);
        layout.putConstraint(SpringLayout.WEST, copyrightField, padding, SpringLayout.EAST, copyrightLabel);
        layout.putConstraint(SpringLayout.NORTH, copyrightField, 0, SpringLayout.NORTH, copyrightLabel);
        add(copyrightField);

        updateButton.setPreferredSize(buttonDimension);
        layout.putConstraint(SpringLayout.WEST, updateButton, 0, SpringLayout.WEST, copyrightField);
        layout.putConstraint(SpringLayout.NORTH, updateButton, padding, SpringLayout.SOUTH, copyrightField);
        add(updateButton);

        saveAndExportButton.setPreferredSize(buttonDimension);
        layout.putConstraint(SpringLayout.WEST, saveAndExportButton, 0, SpringLayout.WEST, updateButton);
        layout.putConstraint(SpringLayout.NORTH, saveAndExportButton, padding, SpringLayout.SOUTH, updateButton);
        add(saveAndExportButton);

        Dimension dimension = getPreferredSize();
        dimension.width = padding + labelDimension.width + padding + textFieldDimension.width + padding;
        setPreferredSize(dimension);
    }

    public void setOpenFormListener(OpenFormListener openFolderListener) {
        this.openFormListener = openFolderListener;
    }

    public void setUpdateFormListener(UpdateFormListener updateFormListener) {
        this.updateFormListener = updateFormListener;
    }

    public void setSaveAndExportFormListener(SaveAndExportFormListener saveAndExportFormListener) {
        this.saveAndExportFormListener = saveAndExportFormListener;
    }
}