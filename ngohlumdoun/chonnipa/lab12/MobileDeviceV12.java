package ngohlumdoun.chonnipa.lab12;

/**
 * Mobile Device V12 Program:
 * Checking and Handling Exceptions in Text Fields
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Mar 2025 10:57 AM
 */

import ngohlumdoun.chonnipa.lab10.MobileDeviceV11;

import javax.swing.*;
import java.awt.event.*;

public class MobileDeviceV12 extends MobileDeviceV11 {
    // Constructor
    public MobileDeviceV12(String title) {
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
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
        mdv12.addComponents();
        mdv12.setFrameFeatures();
        mdv12.addListeners();
        mdv12.setName();
        mdv12.enableKeyboard();
    }

    @Override
    public void addListeners() {
        super.addListeners();
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();

        // Handling all three text fields
        if (srcObject == deviceNameField) {
            handleNormalTextField(deviceNameField, brandField);
        } else if (srcObject == brandField) {
            handleNormalTextField(brandField, priceField);
        } else if (srcObject == priceField) {
            handlePosNumTextField(priceField, OSComboBox);
        }
    }

    protected void setName() {
        // differentiate between different components
        deviceNameField.setName("Device Name");
        brandField.setName("Brand");
        priceField.setName("Price");
    }

    protected void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        String text = tf.getText();
        String fieldName = tf.getName();

        // If the name is empty “Please enter some data in <Text field name>” is shown
        if (text.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + fieldName);
            tf.requestFocus();
            nextComponent.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, fieldName + " is changed to " + text);
            nextComponent.setEnabled(true);
        }
    }

    protected void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        String text = tf.getText();
        String fieldName = tf.getName();

        // If the name is empty “Please enter some data in <Text field name>” is shown
        if (text.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + fieldName);
            tf.requestFocus();
            nextComponent.setEnabled(false);
        } else {
            try {
                double price = Double.parseDouble(text);

                if (price <= 0) {
                    JOptionPane.showMessageDialog(this, fieldName + " must be a positive number", "Message",
                            JOptionPane.ERROR_MESSAGE);
                    tf.requestFocus();
                    nextComponent.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, fieldName + " is changed to " + text);
                    nextComponent.setEnabled(true);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number in " + fieldName);
                tf.requestFocus();
                nextComponent.setEnabled(false);
            }
        }
    }
}
