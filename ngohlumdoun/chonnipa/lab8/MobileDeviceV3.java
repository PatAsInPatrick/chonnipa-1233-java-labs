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

    // File Menu: Includes 'New', 'Open', 'Save', and 'Exit'.
    protected JMenuItem newItem = new JMenuItem("New");
    protected JMenuItem openItem = new JMenuItem("Open");
    protected JMenuItem saveItem = new JMenuItem("Save");
    protected JMenuItem exitItem = new JMenuItem("Exit");

    // Config Menu: Includes submenus
    protected JMenu colorMenu = new JMenu("Color");
    protected JMenu sizeMenu = new JMenu("Size");
    protected JMenu fontMenu = new JMenu("Font");

    // Size Submenu: Contains 'Small', 'Medium', 'Large', and 'Extra Large'.
    protected JMenuItem small = new JMenuItem("Small");
    protected JMenuItem medium = new JMenuItem("Medium");
    protected JMenuItem large = new JMenuItem("Large");
    protected JMenuItem extraLarge = new JMenuItem("Extra Large");

    // Color Submenu: Contains 'Black', 'Red', 'Green', and 'Blue'.
    protected JMenuItem black = new JMenuItem("Black");
    protected JMenuItem red = new JMenuItem("Red");
    protected JMenuItem green = new JMenuItem("Green");
    protected JMenuItem blue = new JMenuItem("Blue");

    // Font Submenu: Contains 'Font 1', 'Font 2', and 'Font 3'.
    protected JMenuItem font1 = new JMenuItem("Font 1");
    protected JMenuItem font2 = new JMenuItem("Font 2");
    protected JMenuItem font3 = new JMenuItem("Font 3");

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
        addMenu();
        setMainPanel();

        // Add mainPanel to the frame.
        add(mainPanel);
    }

    protected void addMenu() {
        setFileMenu();
        setConfigMenu();
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        setJMenuBar(menuBar);
    }

    protected void setFileMenu() {
        // add items to File Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
    }

    protected void setConfigMenu() {
        // add Submenu to File Menu
        configMenu.add(sizeMenu);
        configMenu.add(colorMenu);
        configMenu.add(fontMenu);

        // add subitems to Size Submenu
        sizeMenu.add(small);
        sizeMenu.add(medium);
        sizeMenu.add(large);
        sizeMenu.add(extraLarge);

        // add items to Color Submenu
        colorMenu.add(black);
        colorMenu.add(red);
        colorMenu.add(green);
        colorMenu.add(blue);

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
