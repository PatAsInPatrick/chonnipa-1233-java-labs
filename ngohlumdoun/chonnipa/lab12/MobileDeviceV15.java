package ngohlumdoun.chonnipa.lab12;

/**
 * Mobile Device V15 Program:
 * Writing and Reading Objects to/from a file
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 9 Mar 2025 01:34 AM
 */

import ngohlumdoun.chonnipa.lab7.MobileDevice;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class MobileDeviceV15 extends MobileDeviceV14 {

    protected JMenu formatMenu = new JMenu("Format");
    protected ButtonGroup formatGroup = new ButtonGroup();
    protected JRadioButtonMenuItem textFormat = new JRadioButtonMenuItem("Text");
    protected JRadioButtonMenuItem binaryFormat = new JRadioButtonMenuItem("Binary");

    // Constructor
    public MobileDeviceV15(String title) {
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
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
        mdv15.addComponents();
        mdv15.setFrameFeatures();
        mdv15.addListeners();
        mdv15.setName();
    }

    @Override
    protected void setConfigMenu() {
        super.setConfigMenu();

        // add Submenu to Config Menu
        configMenu.add(formatMenu);

        // add subitems to format Submenu
        formatMenu.add(textFormat);
        formatMenu.add(binaryFormat);

        // add subitems to format group
        formatGroup.add(textFormat);
        formatGroup.add(binaryFormat);

        // Set Text format as default selection
        textFormat.setSelected(true);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        textFormat.addActionListener(this);
        binaryFormat.addActionListener(this);
    }

    @Override
    protected void handleMenuSave() {
        // Save menu : displays a file chooser dialog -> save dialog
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Check which format is selected
            if (textFormat.isSelected()) {
                saveToTextFile(selectedFile);
            } else {
                saveToBinaryFile(selectedFile);
            }
        }
    }

    protected void saveToTextFile(File selectedFile) {
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

    protected void saveToBinaryFile(File selectedFile) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
            // Write the whole ArrayList
            out.writeObject(deviceAL);
            JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getPath() + " successfully!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Save Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    protected void handleMenuOpen() {
        // Open menu : displays a file chooser dialog -> open dialog
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Check which format is selected
            if (textFormat.isSelected()) {
                readFromTextFile(selectedFile);
            } else {
                readFromBinaryFile(selectedFile);
            }
        }
    }

    protected void readFromTextFile(File selectedFile) {
        try {
            // Create new ArrayList to hold devices from file
            ArrayList<String> deviceList = new ArrayList<>();

            // Create a scanner to read the file
            Scanner scanner = new java.util.Scanner(selectedFile);

            // Skip the first line (file name)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Add all devices in together using StringBuilder
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

    @SuppressWarnings("unchecked")
    protected void readFromBinaryFile(File selectedFile) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(selectedFile))) {

            ArrayList<MobileDevice> deviceList = (ArrayList<MobileDevice>) in.readObject();

            // Add header message using StringBuilder
            StringBuilder message = new StringBuilder();
            message.append("Read devices from the file ").append(selectedFile).append("\n");

            // Add each device to message
            for (MobileDevice eachDevice : deviceList) {
                message.append(eachDevice.toString()).append("\n");
            }
            
            JOptionPane.showMessageDialog(this, "Opening: " + selectedFile);

            JOptionPane.showMessageDialog(this, message);

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(),
                    "Read Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
