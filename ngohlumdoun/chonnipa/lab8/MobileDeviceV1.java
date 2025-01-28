package ngohlumdoun.chonnipa.lab8;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V1 Program:
 * Display a simple interface with two buttons "Cancel" and "OK".
 * and add more Device Name, Brand, Price, Type above
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 28 Jan 2025 11:22 PM
 */

public class MobileDeviceV1 extends MySimpleWindow {

    // Create and initialize Device Name
    protected JLabel deviceNameLabel = new JLabel("Device Name:");
    protected JTextField deviceNameField = new JTextField(15);

    // Create and initialize Brand
    protected JLabel brandLabel = new JLabel("Brand:");
    protected JTextField brandField = new JTextField(15);

    // Create and initialize Price
    protected JLabel priceLabel = new JLabel("Price:");
    protected JTextField priceField = new JTextField(15);

    // Create and initialize Type
    protected JLabel typeLabel = new JLabel("Type:");
    protected ButtonGroup typeButtonGroup = new ButtonGroup();
    protected JRadioButton smartphoneRadioButton = new JRadioButton("Smartphone", true);
    protected JRadioButton tabletRadioButton = new JRadioButton("Tablet");

    // Constructor
    public MobileDeviceV1(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {

        // Create a new JPanel called formPanel.
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        // Add JLabels and JTextFields.
        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameField);
        formPanel.add(brandLabel);
        formPanel.add(brandField);
        formPanel.add(priceLabel);
        formPanel.add(priceField);
        formPanel.add(typeLabel);

        // Create a new JPanel called typePanel and add the JRadioButtons
        // The "Smartphone" button should be selected by default.
        JPanel typePanel = new JPanel();
        typeButtonGroup.add(smartphoneRadioButton);
        typeButtonGroup.add(tabletRadioButton);
        typePanel.add(smartphoneRadioButton);
        typePanel.add(tabletRadioButton);

        // include typePanel in formPanel.
        formPanel.add(typePanel);

        // Organize mainPanel
        mainPanel.setLayout(new BorderLayout());

        // Add formPanel to mainPanel.
        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Add the buttons to a buttoPanel and
        // include buttoPanel in mainPanel.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add mainPanel to the frame.
        add(mainPanel);
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

    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures();
    }
}
