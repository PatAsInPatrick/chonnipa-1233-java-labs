package ngohlumdoun.chonnipa.lab12;

/**
 * Mobile Device V13 Program:
 * Adding and Displaying Items in a List
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Mar 2025 10:57 AM
 */

import javax.swing.*;
import java.awt.event.*;

public class MobileDeviceV13 extends MobileDeviceV12 {

    protected JButton addButton = new JButton("Add");
    protected JButton displayButton = new JButton("Display");

    // Constructor
    public MobileDeviceV13(String title) {
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
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V3");
        mdv13.addComponents();
        mdv13.setFrameFeatures();
        mdv13.addListeners();
        mdv13.setName();
    }

    @Override
    protected void setButtonPanel() {
        super.setButtonPanel();
        
        // Add addButton and displayButton to smallButtonPanel.
        smallButtonPanel.add(addButton);
        smallButtonPanel.add(displayButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

    protected void handleAddButton() {

    }

    protected void handleDisplayButton() {

    }
}
