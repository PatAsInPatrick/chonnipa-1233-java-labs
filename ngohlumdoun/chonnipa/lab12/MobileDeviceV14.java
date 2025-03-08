package ngohlumdoun.chonnipa.lab12;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Mobile Device V14 Program:
 * Writing and Reading Text to/from a file
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Mar 2025 11:21 AM
 */

import ngohlumdoun.chonnipa.lab7.MobileDevice;

import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.io.*;
import java.util.*;

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
        if (srcObj == openItem) {
            handleMenuOpen();
        } else if (srcObj == saveItem) {
            handleMenuSave();
        } else {
            super.actionPerformed(event);
        }
    }

    protected void handleMenuOpen() {
        // Open menu : displays a file chooser dialog -> open dialog
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Opening: " + selectedFile);
            readFromFile(selectedFile);
        }
    }

    protected void handleMenuSave() {
        // Save menu : displays a file chooser dialog -> save dialog
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            saveToFile(selectedFile);
        }
    }

    protected void saveToFile(File selectedFile) {
        try (PrintWriter write = new PrintWriter(new FileWriter(selectedFile))) {
            // Write file name not the full file path
            write.println(selectedFile.getName());

            // Write each device to the file
            for (MobileDevice eachDevice : deviceAL) {
                write.println(eachDevice.toString());
            }

        } catch (IOException e) {
            // Show error message
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Save Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    protected void readFromFile(File selectedFile) {
        try {
            // Create new ArrayList to hold devices from file
            ArrayList<String> deviceList = new ArrayList<>();

            // Create a scanner to read the file
            Scanner scanner = new java.util.Scanner(selectedFile);

            // Skip the first line (file name)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Add all devices together using StringBuilder
            StringBuilder message = new StringBuilder();
            message.append("Read devices from the file ").append(selectedFile).append(" are as follows:\n");

            // Read each device line and add to message
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                deviceList.add(line);
                message.append(line + "\n");
            }
            scanner.close();

            JOptionPane.showMessageDialog(this, message);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(),
                    "Read Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error processing file data: " + e.getMessage(),
                    "Parse Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
