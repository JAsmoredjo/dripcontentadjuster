package com.eGoStudio.dripContentAdjuster;

import com.eGoStudio.dripContentAdjuster.ui.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
