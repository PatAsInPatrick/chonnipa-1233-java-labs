package ngohlumdoun.chonnipa.lab12;

/**
 * Mobile Device V13 Program:
 * Adding and Displaying Items in a List
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 8 Mar 2025 09:32 PM
 */

import ngohlumdoun.chonnipa.lab7.MobileDevice;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MobileDeviceV13 extends MobileDeviceV12 {

    // GUI components
    protected JButton addButton = new JButton("Add");
    protected JButton displayButton = new JButton("Display");
    protected ArrayList<MobileDevice> deviceAL = new ArrayList<>();

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
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.addComponents();
        mdv13.setFrameFeatures();
        mdv13.addListeners();
        mdv13.setName();
    }

    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
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

        String deviceInfo = deviceNameField.getText();
        String brandInfo = brandField.getText();
        double priceInfo = Double.parseDouble(priceField.getText());
        String typeInfo = smartphoneRadioButton.isSelected() ? "Smartphone"
                : tabletRadioButton.isSelected() ? "Tablet" : "";

        // Create object of each device then add to deviceAL (MobileDevice)
        if (smartphoneRadioButton.isSelected()) {
            SmartPhone newPhone = new SmartPhone(deviceInfo, brandInfo, priceInfo);
            deviceAL.add(newPhone);
        } else {
            Tablet newTablet = new Tablet(deviceInfo, brandInfo, priceInfo);
            deviceAL.add(newTablet);
        }

        JOptionPane.showMessageDialog(this, typeInfo + " " + deviceInfo + " is added");
    }

    protected void handleDisplayButton() {
        // Show all devices in deviceAL using StringBuilder
        StringBuilder mobileList = new StringBuilder();
        for (MobileDevice eachDevice : deviceAL) {
            mobileList.append(eachDevice.toString() + "\n");
        }

        JOptionPane.showMessageDialog(this, mobileList);
    }
}
