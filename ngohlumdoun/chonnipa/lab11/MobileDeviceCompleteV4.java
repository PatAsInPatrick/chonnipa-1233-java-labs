package ngohlumdoun.chonnipa.lab11;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * Mobile Device Complete V3 Program:
 * Add Config menu -> Color -> Custom that allows the user to pick a color using
 * JColorChooser.showDialog(...)
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 21 Feb 2025 05:59 PM
 */

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 implements ActionListener {

    protected JMenu configMenu = new JMenu("Config");
    protected JMenu colorMenu = new JMenu("Color");
    protected JMenuItem customMI = new JMenuItem("Custom");

    // Contructor
    public MobileDeviceCompleteV4(String title) {
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
        MobileDeviceCompleteV4 mdcv4 = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        mdcv4.addComponents();
        mdcv4.addMenus();
        mdcv4.setFrameFeatures();
        mdcv4.addListeners();
    }

    @Override
    public void addMenus() {
        super.addMenus();

        colorMenu.add(customMI);
        configMenu.add(colorMenu);
        menuBar.add(configMenu);
    }

    @Override
    public void addListeners() {
        super.addListeners();

        customMI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object src = e.getSource();
        Color initialColor = deviceNameField.getForeground();

        // If the user cancels the selection, keep the text color unchanged.
        if (src == customMI) {
            Color newColor = JColorChooser.showDialog(this, "Choose Text Color", initialColor);
            if (newColor != null) {
                deviceNameField.setForeground(newColor);
                brandField.setForeground(newColor);
                priceField.setForeground(newColor);
            }
        }
    }
}
