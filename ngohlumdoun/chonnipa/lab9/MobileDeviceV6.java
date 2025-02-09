package ngohlumdoun.chonnipa.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V6 Program:
 * Customize Labels
 * Customize Text Fields & Text Areas
 * Customize Vendor List Appearance
 * Customize Buttons
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 9 Feb 2025 05:57 PM
 */

public class MobileDeviceV6 extends MobileDeviceV5 {

    // Contructor
    public MobileDeviceV6(String title) {
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

    @Override
    protected void addComponents() {
        setFormPanel();
        setExtraPanel();
        setUltraPanel();
        setButtonPanel();
        setMainPanel();

        customizeLabel();
        customizeTFandTA();
        customizeVendorList();
        customizeButton();

        // Add mainPanel to the frame.
        add(mainPanel);
    }

    protected void customizeLabel(){
        // Set font style to Arial, Bold, size 14
        deviceNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        brandLabel.setFont(new Font("Arial", Font.BOLD, 14));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        OSLabel.setFont(new Font("Arial", Font.BOLD, 14));
        featuresLabel.setFont(new Font("Arial", Font.BOLD, 14));
        vendorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        rateLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Set font color to Dark Blue (#000080)
        // Using hex value
        deviceNameLabel.setForeground(new Color(0x000080));
        brandLabel.setForeground(new Color(0x000080));
        priceLabel.setForeground(new Color(0x000080));
        typeLabel.setForeground(new Color(0x000080));
        OSLabel.setForeground(new Color(0x000080));
        featuresLabel.setForeground(new Color(0x000080));
        vendorLabel.setForeground(new Color(0x000080));
        rateLabel.setForeground(new Color(0x000080));
    }

    protected void customizeTFandTA() {
        // Set background color of text fields tolLight Gray
        deviceNameField.setBackground(Color.LIGHT_GRAY);
        brandField.setBackground(Color.LIGHT_GRAY);
        priceField.setBackground(Color.LIGHT_GRAY);

        // Set background color of text area to light yellow
        featuresTextArea.setBackground(new Color(255, 255, 200));

        // Set font color to Dark Gray.
        deviceNameField.setForeground(Color.DARK_GRAY);
        brandField.setForeground(Color.DARK_GRAY);
        priceField.setForeground(Color.DARK_GRAY);
        featuresTextArea.setForeground(Color.DARK_GRAY);

        // Apply Italic font Style for the text inside the text area.
        featuresTextArea.setFont(new Font("Arial", Font.ITALIC, 14));

        // Ensure that the text area wraps text correctly.
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
    }

    protected void customizeVendorList() {
        // Set background color to Light Gray.
        vendorList.setBackground(Color.LIGHT_GRAY);

        // Set foreground color to Dark Green (#006400)
        vendorList.setForeground(new Color(0x006400));

        // Set bold font style for vendor names.
        vendorList.setFont(new Font("Arial", Font.BOLD, 14));

        // Change the selection background color to Yellow.
        vendorList.setSelectionBackground(Color.YELLOW);

        // Change the selection foreground color to Black.
        vendorList.setSelectionForeground(Color.BLACK);
    }

    protected void customizeButton() {
        // Set the OK button text color to Green and background color to White.
        submitButton.setForeground(Color.GREEN);
        submitButton.setBackground(Color.WHITE);

        // Set the Cancel button text color to Red and background color to White.
        resetButton.setForeground(Color.RED);
        resetButton.setBackground(Color.WHITE);    }

    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents();
        mdv6.setFrameFeatures();
    }

}
