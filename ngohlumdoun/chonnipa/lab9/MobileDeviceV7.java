package ngohlumdoun.chonnipa.lab9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.IOException;
import java.io.File;

/**
 * Mobile Device V7 Program:
 * Pre-Fill the Form
 * Add image
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 9 Feb 2025 05:57 PM
 */

public class MobileDeviceV7 extends MobileDeviceV6 {

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

    // Create a new class ReadImage to handle image rendering
    public static class ReadImage extends JPanel {
        BufferedImage samsungImage;
        String filename = "images/S25-ultra.jpg";

        public void paintComponent(Graphics g) {
            g.drawImage(samsungImage, 0, 0, null);
        }

        public ReadImage() {
            try {
                samsungImage = ImageIO.read(new File(filename));
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
