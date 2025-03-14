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
        mdv14.enableKeyboard();
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
        deviceList.clear();

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

            // Write each device to the file
            for (MobileDevice eachDevice : deviceList) {
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
            // Create a scanner to read the file
            Scanner scanner = new Scanner(selectedFile);

            // Read each device line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Parse the line based on the format: "Type: Model (Brand) Price Baht"
                String[] parts = line.split(": ");
                String type = parts[0]; // SmartPhone or Tablet

                // Split the rest by parentheses to get model and brand
                int brandStart = parts[1].indexOf("(");
                int brandEnd = parts[1].indexOf(")");

                String name = parts[1].substring(0, brandStart).trim();
                String brand = parts[1].substring(brandStart + 1, brandEnd);

                // Get the price (removing "Baht" and trimming)
                String priceStr = parts[1].substring(brandEnd + 1, parts[1].indexOf("Baht")).trim();
                double price = Double.parseDouble(priceStr);

                // Create device and add to list (adjust constructor as needed)
                MobileDevice device = null;
                if (type.equals("SmartPhone")) {
                    device = new SmartPhone(name, brand, price);
                } else if (type.equals("Tablet")) {
                    device = new Tablet(name, brand, price);
                }

                deviceList.add(device);
            }

            // Add all devices together using StringBuilder
            StringBuilder message = new StringBuilder();
            message.append("Read devices from the file ").append(selectedFile.getPath()).append(" are as follows:\n");
            for (MobileDevice eachDevice : deviceList) {
                message.append(eachDevice.toString() + "\n");
            }

            JOptionPane.showMessageDialog(this, message);

            scanner.close();

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
