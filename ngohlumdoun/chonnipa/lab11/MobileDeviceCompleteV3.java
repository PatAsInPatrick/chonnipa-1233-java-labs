package ngohlumdoun.chonnipa.lab11;

import java.awt.event.*;
import javax.swing.*;

/**
 * Mobile Device Complete V3 Program:
 * Show dialog when component is resized, moved, shown, hidden
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 21 Feb 2025 11:54 AM
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
        mdcv3.addMenus();
        mdcv3.setFrameFeatures();
        mdcv3.addListeners();
    }

    @Override
    public void addListeners() {
        super.addListeners();

        this.addComponentListener(this);
    }

    // When the frame is hidden/shown, display a message indicating the visibility.
    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now visible.");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now hidden.");
    }

    // When the frame is resized, display a message showing new width and height.
    @Override
    public void componentResized(ComponentEvent e) {
        int width = this.getWidth();
        int height = this.getHeight();
        JOptionPane.showMessageDialog(this, "Window resized to: " + width + " x " + height);
    }

    // When the frame is moved, display a message showing the new position.
    @Override
    public void componentMoved(ComponentEvent e) {
        int x_position = this.getLocation().x;
        int y_position = this.getLocation().y;
        JOptionPane.showMessageDialog(this, "Window moved to: X=" + x_position + " Y=" + y_position);
    }
}
