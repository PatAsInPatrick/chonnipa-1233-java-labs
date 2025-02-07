package ngohlumdoun.chonnipa.lab9;

import ngohlumdoun.chonnipa.lab8.MobileDeviceV3;
import javax.swing.*;

/**
 * Mobile Device V3 Program:
 * Add icons to the menu items
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 1 Feb 2025 01:21 PM
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
        // Use the setIcon() method to set "New" item icon.
        newItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));

        // Use the setIcon() method to set "Open" item icon.
        openItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/open_icon.png")));

        // Use the setIcon() method to set "Save" item icon.
        saveItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save_icon.png")));

        // Use the setIcon() method to set "Exit" item icon.
        exitItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit_icon.png")));
    }

    @Override
    protected void setConfigMenu() {
        // Config Menu: Includes submenus
        JMenu sizeMenu = new JMenu("Size");
        JMenu colorMenu = new JMenu("Color");
        JMenu fontMenu = new JMenu("Font");

        // add Submenu to File Menu
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);

        // Size Submenu: Contains 'Small', 'Medium', 'Large', and 'Extra Large'.
        JMenuItem small = new JMenuItem("Small");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem large = new JMenuItem("Large");
        JMenuItem extraLarge = new JMenuItem("Extra Large");

        // add subitems to Size Submenu
        sizeMenu.add(small);
        sizeMenu.add(medium);
        sizeMenu.add(large);
        sizeMenu.add(extraLarge);

        // Color Submenu: Contains 'Black', 'Red', 'Green', and 'Blue'.
        JMenuItem black = new JMenuItem("Black");
        JMenuItem red = new JMenuItem("Red");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem blue = new JMenuItem("Blue");

        // add items to Color Submenu
        colorMenu.add(black);
        colorMenu.add(red);
        colorMenu.add(green);
        colorMenu.add(blue);

        // Font Submenu: Contains 'Font 1', 'Font 2', and 'Font 3'.
        JMenuItem font1 = new JMenuItem("Font 1");
        JMenuItem font2 = new JMenuItem("Font 2");
        JMenuItem font3 = new JMenuItem("Font 3");

        // add items to Font Submenu
        fontMenu.add(font1);
        fontMenu.add(font2);
        fontMenu.add(font3);
    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.setFrameFeatures();
    }
}
