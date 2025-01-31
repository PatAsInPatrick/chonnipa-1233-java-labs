package ngohlumdoun.chonnipa.lab8;

import javax.swing.*;

/**
 * My Simple Window Program:
 * Display a simple interface with two buttons "Cancel" and "OK".
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 28 Jan 2025 10:03 PM
 */

public class MySimpleWindow extends JFrame {
    // Create and initialize resetButton and submitButton.
    protected JButton resetButton = new JButton("Cancel");
    protected JButton submitButton = new JButton("OK");

    // Create and initialize mainPanel and buttonPanel.
    protected JPanel mainPanel = new JPanel();
    protected JPanel buttonPanel = new JPanel();

    // Contructor
    public MySimpleWindow(String title) {
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

    protected void addComponents() {
        setButtonPanel();
        setMainPanel();

        // Add mainPanel to the frame.
        add(mainPanel);
    }

    protected void setButtonPanel() {
        // Add resetButton and submitButton to buttonPanel.
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
    }

    protected void setMainPanel() {
        // Add buttonPanel to mainPanel.
        mainPanel.add(buttonPanel);
    }

    protected void setFrameFeatures() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}