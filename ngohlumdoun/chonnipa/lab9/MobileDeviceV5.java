package ngohlumdoun.chonnipa.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V4 Program:
 * Add a JList Component for Vendor Selection
 * Add a JSlider Component for Device Rating
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Feb 2025 10:20 AM
 */

public class MobileDeviceV5 extends MobileDeviceV4 {

    protected JPanel ultraPanel = new JPanel();
    protected JPanel devicePanel = new JPanel();
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
        setFormPanel();
        setExtraPanel();
        setUltraPanel();
        setButtonPanel();
        setMainPanel();

        // Add mainPanel to the frame.
        add(mainPanel);
    }

    @Override
    protected void setMainPanel() {
        // Organize mainPanel
        mainPanel.setLayout(new BorderLayout());

        // Add formPanel to mainPanel.
        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Add extraPanel to mainPanel.
        mainPanel.add(ultraPanel, BorderLayout.CENTER);

        // Add buttonPanel to mainPanel.
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    protected void setUltraPanel() {
        ultraPanel.setLayout(new BorderLayout());
        setDevicePanel();
        setRatePanel();

        // Add extraPanel, devicePanel and ratePanel to ultraPanel.
        ultraPanel.add(extraPanel, BorderLayout.NORTH);
        ultraPanel.add(devicePanel, BorderLayout.CENTER);
        ultraPanel.add(ratePanel, BorderLayout.SOUTH);
    }

    protected void setDevicePanel() {
        devicePanel.setLayout(new GridLayout(1, 2));
        setVendorList();

        // Add labels and vendor list to devicePanel.
        devicePanel.add(vendorLabel);
        devicePanel.add(vendorLabel);
        devicePanel.add(new JScrollPane(vendorList));
    }

    protected void setRatePanel() {
        ratePanel.setLayout(new GridLayout(2, 1));
        setRateSlider();

        // Add rateLabel and ratePanel to ratePanel.
        ratePanel.add(rateLabel);
        ratePanel.add(rateSlider);
    }

    protected void setVendorList() {
        String[] vendors = { "AIS", "True", "DTAC", "Shopee" };
        vendorList.setListData(vendors);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
