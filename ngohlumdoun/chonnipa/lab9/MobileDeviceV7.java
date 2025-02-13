package ngohlumdoun.chonnipa.lab9;

import java.awt.*;
import javax.swing.*;

/**
 * Mobile Device V7 Program:
 * Pre-Fill the Form
 * Add image
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 13 Feb 2025 11:50 PM
 */

public class MobileDeviceV7 extends MobileDeviceV6 {

    protected JPanel smallButtonPanel = new JPanel();
    protected JPanel imagePanel = new JPanel();
    protected ReadImage samsungImage = new ReadImage();

    // Contructor
    public MobileDeviceV7(String title) {
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

        preFillForm();
    }

    @Override
    protected void setButtonPanel() {
        buttonPanel.setLayout(new BorderLayout());

        // Ad image to imagePanel
        imagePanel.add(samsungImage);
        buttonPanel.add(imagePanel, BorderLayout.CENTER);

        // Add resetButton and submitButton to buttonPanel.
        smallButtonPanel.add(resetButton);
        smallButtonPanel.add(submitButton);

        buttonPanel.add(smallButtonPanel, BorderLayout.SOUTH);
    }

    protected void preFillForm() {
        deviceNameField.setText("Samsung Galaxy S25 Ultra");
        brandField.setText("Samsung");
        priceField.setText("46,900");
        featuresTextArea.setText("- 200MP Camera\n" +
                "- 1TB Storage\n" +
                "- Snapdragon Gen 4 Processor\n" +
                "- 5000mAh Battery\n" +
                "- 6.8-inch AMOLED Display\n" +
                "- 120Hz Refresh Rate\n" +
                "- Fast Charging");

        // Available At : AIS (Preselected in JList)
        vendorList.setSelectedIndex(0);

        // Device Rating : 9
        rateSlider.setValue(9);
    }

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
    }
}
