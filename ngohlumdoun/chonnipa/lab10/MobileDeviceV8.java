package ngohlumdoun.chonnipa.lab10;

import ngohlumdoun.chonnipa.lab9.MobileDeviceV7;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Mobile Device V8 Program:
 * Add ActionListener
 * Click Cancel -> clear form
 * Click OK -> Show Device Information
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 13 Feb 2025 10:05 AM
 */

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    // Contructor
    public MobileDeviceV8(String title) {
        super(title);
    }

    // Main method
    public static void main(String[] args) {
        // This runs on the main thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // This runs on the EDT
                createAndShowGUI();
            }
        });
    }

    public void addListeners() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            showOnPane();
        } else if (src == resetButton) {
            clearForm();
        }
    }

    public void showOnPane() {
        // Declaration
        String deviceInfo = deviceNameField.getText();
        String brandInfo = brandField.getText();
        String priceInfo = priceField.getText();
        String typeInfo = smartphoneRadioButton.isSelected() ? "Smartphone" : "Tablet";
        String OSInfo = (String) OSComboBox.getSelectedItem();
        String featuresInfo = featuresTextArea.getText();
        List<String> vendorInfo = vendorList.getSelectedValuesList();
        String rateInfo = String.valueOf(rateSlider.getValue());

        // Show Device Infomation
        JOptionPane.showMessageDialog(null,
                "Device Name: " + deviceInfo + "\n" +
                "Brand: " + brandInfo + "\n" +
                "Price: " + priceInfo + "\n" +
                "Type: " + typeInfo + "\n" +
                "Operation System: " + OSInfo + "\n" +
                "Features: " + featuresInfo + "\n" +
                "Available at: " + vendorInfo.toString().replaceAll("[ \\[\\] ]", "") + "\n" +
                "Rating: " + rateInfo
                , "Device Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearForm() {
        // Clear form fields.
        deviceNameField.setText("");
        brandField.setText("");
        priceField.setText("");
        featuresTextArea.setText("");

        // Set radio buttons to smartphone
        smartphoneRadioButton.setSelected(true);

        // Set Operating System to Android
        OSComboBox.setSelectedIndex(0);

        // Clear vendor selection list.
        vendorList.clearSelection();

        // Set rating to 5
        rateSlider.setValue(5);
    }

    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.setFrameFeatures();
        mdv8.addListeners();
    }
}
