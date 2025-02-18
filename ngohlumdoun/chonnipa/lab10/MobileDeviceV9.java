package ngohlumdoun.chonnipa.lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.*;

/**
 * Mobile Device V9 Program:
 * Add ActionListener to other items in menubar
 * new, open, save, exit menus
 * change font, font size, font color
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 18 Feb 2025 01:56 AM
 */

public class MobileDeviceV9 extends MobileDeviceV8 implements ActionListener {

    // Contructor
    public MobileDeviceV9(String title) {
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
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.setFrameFeatures();
        mdv9.addListeners();
    }

    @Override
    public void addListeners() {
        super.addListeners();

        // Add actionListener to file menu
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        // Add actionListener to size menu
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        extraLarge.addActionListener(this);

        // Add actionListener to color menu
        black.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        // Add actionListener to font menu
        font1.addActionListener(this);
        font2.addActionListener(this);
        font3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object src = e.getSource();

        // File menu
        if (src == newItem) {
            // Save menu : displays a file chooser dialog -> save dialog
            clearForm();
        } else if (src == openItem) {
            // Open menu : displays a file chooser dialog -> open dialog
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Opening: " + selectedFile.getName());
            }
        } else if (src == saveItem) {
            // Save menu : displays a file chooser dialog -> save dialog
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully!");
            }
        } else if (src == exitItem) {
            // Exit menu : close the program.
            System.exit(0);
        }

        // Size menu
        else if (src == small) {
            changeFontSize_TFandTA(10);
        } else if (src == medium) {
            changeFontSize_TFandTA(14);
        } else if (src == large) {
            changeFontSize_TFandTA(18);
        } else if (src == extraLarge) {
            changeFontSize_TFandTA(22);
        }

        // Color menu
        else if (src == black) {
            changeColor_TFandTA("#000000");
        } else if (src == red) {
            changeColor_TFandTA("#FF0000");
        } else if (src == green) {
            changeColor_TFandTA("#00FF00");
        } else if (src == blue) {
            changeColor_TFandTA("#0000FF");
        }

        // Font menu
        else if (src == font1) {
            changeFont_TFandTA("Serif");
        } else if (src == font2) {
            changeFont_TFandTA("SansSerif");
        } else if (src == font3) {
            changeFont_TFandTA("Monospaced");
        }
    }

    // change font size for all the text fields and text area.
    protected void changeFontSize_TFandTA(int newFontSize) {
        deviceNameField.setFont(deviceNameField.getFont().deriveFont(Font.PLAIN, newFontSize));
        brandField.setFont(brandField.getFont().deriveFont(Font.PLAIN, newFontSize));
        priceField.setFont(priceField.getFont().deriveFont(Font.PLAIN, newFontSize));
        featuresTextArea.setFont(featuresTextArea.getFont().deriveFont(Font.PLAIN, newFontSize));
    }

    // Change the font color for all the text fields and text area.
    protected void changeColor_TFandTA(String newColor) {
        deviceNameField.setForeground(Color.decode(newColor));
        brandField.setForeground(Color.decode(newColor));
        priceField.setForeground(Color.decode(newColor));
        featuresTextArea.setForeground(Color.decode(newColor));
    }

    // Change the font for all the text fields and text area.
    protected void changeFont_TFandTA(String newFont) {
        deviceNameField.setFont(new Font(newFont, Font.PLAIN, deviceNameField.getFont().getSize()));
        brandField.setFont(new Font(newFont, Font.PLAIN, brandField.getFont().getSize()));
        priceField.setFont(new Font(newFont, Font.PLAIN, priceField.getFont().getSize()));
        featuresTextArea.setFont(new Font(newFont, Font.PLAIN, featuresTextArea.getFont().getSize()));
    }
}
