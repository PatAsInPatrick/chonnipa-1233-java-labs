package ngohlumdoun.chonnipa.lab11;

import java.awt.event.*;
import javax.swing.*;

/**
 * Mobile Device Complete V3 Program:
 * Show dialog when type somthing in JTextField
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 21 Feb 2025 10:46 AM
 */

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    // Contructor
    public MobileDeviceCompleteV3(String title) {
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
        MobileDeviceCompleteV3 mdcv3 = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        mdcv3.addComponents();
        mdcv3.setFrameFeatures();
        mdcv3.addListeners();
    }
}
