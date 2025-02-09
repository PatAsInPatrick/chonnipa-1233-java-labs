package ngohlumdoun.chonnipa.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V7 Program:
 * Pre-Fill the Form
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

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
    }
}
