package ngohlumdoun.chonnipa.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V5 Program:
 * Add a JList Component for Vendor Selection
 * Add a JSlider Component for Device Rating
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 13 Feb 2025 11:50 PM
 */

public class MobileDeviceV5 extends MobileDeviceV4 {

    protected JPanel ultraPanel = new JPanel();
    protected JPanel vendorPanel = new JPanel();
    protected JPanel ratePanel = new JPanel();
    protected JLabel vendorLabel = new JLabel("The device is available at:");
    protected JLabel rateLabel = new JLabel("Rate the device (0-10):");
    protected JSlider rateSlider = new JSlider();
    protected JList<String> vendorList = new JList<String>();

    // Contructor
    public MobileDeviceV5(String title) {
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
        super.addComponents();

        setUltraPanel();
    }

    @Override
    protected void setMainPanel() {
        // Organize mainPanel
        mainPanel.setLayout(new BorderLayout());

        // Add formPanel to mainPanel.
        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Add ultraPanel to mainPanel.
        mainPanel.add(ultraPanel, BorderLayout.CENTER);

        // Add buttonPanel to mainPanel.
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    protected void setUltraPanel() {
        ultraPanel.setLayout(new BorderLayout());
        setVendorPanel();
        setRatePanel();

        // Add extraPanel, vendorPanel and ratePanel to ultraPanel.
        ultraPanel.add(extraPanel, BorderLayout.NORTH);
        ultraPanel.add(vendorPanel, BorderLayout.CENTER);
        ultraPanel.add(ratePanel, BorderLayout.SOUTH);
    }

    protected void setVendorPanel() {
        vendorPanel.setLayout(new GridLayout(1, 2));
        setVendorList();

        // Add labels and vendor list to vendorPanel.
        vendorPanel.add(vendorLabel);
        vendorPanel.add(new JScrollPane(vendorList));
    }

    protected void setRatePanel() {
        ratePanel.setLayout(new BorderLayout());
        setRateSlider();

        // Add rateLabel and ratePanel to ratePanel.
        ratePanel.add(rateLabel, BorderLayout.NORTH);
        ratePanel.add(rateSlider, BorderLayout.CENTER);
    }

    protected void setVendorList() {
        String[] vendors = { "AIS", "True", "DTAC", "Shopee" };
        vendorList.setListData(vendors);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorList.setVisibleRowCount(vendors.length);
    }

    protected void setRateSlider() {
        // Set the range for the rateSlider.
        rateSlider.setMinimum(0);
        rateSlider.setMaximum(10);
        rateSlider.setMajorTickSpacing(1);

        // Enable tick marks and labels for better visualization.
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);

        // Set a default rating of 5.
        rateSlider.setValue(5);
    }

    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.setFrameFeatures();
    }

}
