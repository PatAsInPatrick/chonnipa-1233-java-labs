package ngohlumdoun.chonnipa.lab12;

/**
 * Mobile Device V14 Program:
 * Writing and Reading Text to/from a file
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Mar 2025 10:57 AM
 */

import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.util.ArrayList;

public class MobileDeviceV14 extends MobileDeviceV13 {
    // Constructor
    public MobileDeviceV14(String title) {
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
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
        mdv14.addComponents();
        mdv14.setFrameFeatures();
        mdv14.addListeners();
        mdv14.setName();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object srcObj = event.getSource();
        if (srcObj == openMI) {
            handleMenuOpen();
        } else if (srcObj == saveMI) {
            handleMenuSave();
        } else {
            super.actionPerformed(event);
        }
    }

}
