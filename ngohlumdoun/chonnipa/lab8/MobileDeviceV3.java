package ngohlumdoun.chonnipa.lab8;

import javax.swing.*;

/**
 * Mobile Device V3 Program:
 * Incorporates a menu bar for advanced features
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 1 Feb 2025 01:21 PM
 */

public class MobileDeviceV3 extends MobileDeviceV2 {

    // Create a menu bar with the following menus and items
    protected JMenuBar menuBar = new JMenuBar();
    protected JMenu fileMenu = new JMenu("File");
    protected JMenu configMenu = new JMenu("Config");

    // Contructor
    public MobileDeviceV3(String title) {
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
        setMenuBar();
        setMainPanel();

        // Add mainPanel to the frame.
        add(mainPanel);
    }

    protected void setMenuBar() {
        setFileMenu();
        setConfigMenu();
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        setJMenuBar(menuBar);
    }

    protected void setFileMenu() {
        // File Menu: Includes 'New', 'Open', 'Save', and 'Exit'.
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // add items to File Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
    }

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
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.addComponents();
        mdv3.setFrameFeatures();
    }

}
