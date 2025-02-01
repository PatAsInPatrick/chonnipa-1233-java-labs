package ngohlumdoun.chonnipa.lab8;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V2 Program:
 * Display a simple interface with two buttons "Cancel" and "OK".
 * and add more Device Name, Brand, Price, Type above
 * Add Operating System and features abive button
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 31 Jan 2025 11:29 PM
 */

public class MobileDeviceV2 extends MobileDeviceV1 {

    // Create and initialize Operating System Combo Box
    protected JLabel OSLabel = new JLabel("Operating System:");
    protected JComboBox<String> OSComboBox = new JComboBox<String>();

    // Create and initialize Text Area
    protected JLabel featuresLabel = new JLabel("Features:");
    protected JTextArea featuresTextArea = new JTextArea(3, 25);
    protected JScrollPane scrollPane = new JScrollPane(featuresTextArea);

    // Create and initialize extraPanel
    protected JPanel extraPanel = new JPanel();

    // Contructor
    public MobileDeviceV2(String title) {
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
        mainPanel.add(extraPanel, BorderLayout.CENTER);

        // Add buttonPanel to mainPanel.
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    protected void setExtraPanel() {
        extraPanel.setLayout(new GridLayout(2, 2));

        setComboBox();

        // Add labels and Combo Box to extraPanel.
        extraPanel.add(OSLabel);
        extraPanel.add(OSComboBox);
        extraPanel.add(featuresLabel);
        extraPanel.add(scrollPane);
    }

    protected void setComboBox() {
        // Add items to the Combo Box
        OSComboBox.addItem("Android");
        OSComboBox.addItem("iOS");
        OSComboBox.addItem("Windows");
        OSComboBox.addItem("Others");
        OSComboBox.setEditable(true);
    }

    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }

}
