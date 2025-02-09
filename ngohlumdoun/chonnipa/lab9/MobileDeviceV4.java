package ngohlumdoun.chonnipa.lab9;

import ngohlumdoun.chonnipa.lab8.MobileDeviceV3;
import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V4 Program:
 * Add icons to the menu items, change font, font size, and text color.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Feb 2025 10:20 AM
 */

public class MobileDeviceV4 extends MobileDeviceV3 {
    // Contructor
    public MobileDeviceV4(String title) {
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
    protected void setFileMenu() {
        super.setFileMenu();
        // Use the setIcon() method to set item icons.
        newItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));
        openItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/open_icon.png")));
        saveItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save_icon.png")));
        exitItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit_icon.png")));
    }

    @Override
    protected void setConfigMenu() {
        super.setConfigMenu();
        // Use the setFont() method to set the font size.
        small.setFont(new Font("Arial", Font.PLAIN, 10));
        medium.setFont(new Font("Arial", Font.PLAIN, 14));
        large.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLarge.setFont(new Font("Arial", Font.PLAIN, 22));

        // Use the setForeground() method to set the text color.
        black.setForeground(Color.BLACK);
        red.setForeground(Color.RED);
        green.setForeground(Color.GREEN);
        blue.setForeground(Color.BLUE);

        // Use the setFont() method to apply different font styles.
        font1.setFont(new Font("Serif", Font.PLAIN, 14));
        font2.setFont(new Font("SansSerif", Font.BOLD, 14));
        font3.setFont(new Font("Monospaced", Font.ITALIC, 14));
    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.setFrameFeatures();
    }
}
