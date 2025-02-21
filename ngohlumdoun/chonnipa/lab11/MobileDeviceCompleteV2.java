package ngohlumdoun.chonnipa.lab11;

import java.awt.event.*;
import javax.swing.*;

/**
 * Mobile Device Complete V2 Program:
 * Show dialog when type somthing in JTextField
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 18 Feb 2025 01:46 PM
 */

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    // Constuctor
    public MobileDeviceCompleteV2(String title) {
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
        MobileDeviceCompleteV2 mdcv2 = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        mdcv2.addComponents();
        mdcv2.setFrameFeatures();
        mdcv2.addListeners();
    }

    public void addListeners() {

        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    // Display the entered text in a dialog box using
    // JOptionPane.showMessageDialog(...).
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Implement logic to respond whenever the user presses Enter in any of these
        // text fields.
        if (src == deviceNameField) {
            JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name field: " + deviceNameField.getText(), "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (src == brandField) {
            JOptionPane.showMessageDialog(this, "Brand field says: " + brandField.getText(), "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (src == priceField) {
            JOptionPane.showMessageDialog(this, "Price entered: " + priceField.getText(), "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
