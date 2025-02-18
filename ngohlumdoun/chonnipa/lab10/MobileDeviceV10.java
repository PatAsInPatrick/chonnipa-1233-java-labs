package ngohlumdoun.chonnipa.lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

/**
 * Mobile Device V10 Program:
 * Show dialog when JComboBox, JList, and JSlider is changed
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 18 Feb 2025 01:56 AM
 */

public class MobileDeviceV10 extends MobileDeviceV9 implements ActionListener, ListSelectionListener, ChangeListener {

    // Contructor
    public MobileDeviceV10(String title) {
        super(title);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.setFrameFeatures();
        mdv10.addListeners();
    }

    @Override
    public void addListeners() {
        super.addListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When the user selects a different **Operating System** from the drop-down
        // (`JComboBox`), display a dialog box (`JOptionPane.showMessageDialog`) showing
        // the new selected OS.

        Object src = e.getSource();

        if (src == OSComboBox) {
            JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully!");
        }

    }
}
