package ngohlumdoun.chonnipa.lab10;

import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Mobile Device V10 Program:
 * Show dialog when JComboBox, JList, and JSlider is changed
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 18 Feb 2025 12:53 PM
 */

public class MobileDeviceV10 extends MobileDeviceV9 implements ActionListener, ListSelectionListener, ChangeListener {

    // Contructor
    public MobileDeviceV10(String title) {
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
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.setFrameFeatures();
        mdv10.addListeners();
    }

    @Override
    public void addListeners() {
        super.addListeners();

        OSComboBox.addActionListener(this);
        vendorList.addListSelectionListener(this);
        rateSlider.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object src = e.getSource();

        if (src == OSComboBox) {
            // When the user selects a different Operating System -> new selection dialog
            String selectedOS = (String) OSComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + selectedOS, "OS Selection",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if (src == vendorList && !e.getValueIsAdjusting()) {
            // When the user selects different Vendors -> new selection dialog
            List<String> selectedVendorList = vendorList.getSelectedValuesList();
            if (!selectedVendorList.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Device is available at: " + selectedVendorList.toString().replaceAll("[ \\[\\] ]", ""),
                        "Vendor Selection",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object src = e.getSource();

        if (src == rateSlider) {
            // When the user changes the rating slider -> new rating dialog
            int selectedRating = rateSlider.getValue();
            JSlider Temp = (JSlider) e.getSource();

            if (!Temp.getValueIsAdjusting()) {
                JOptionPane.showMessageDialog(this, "New Rating: " + selectedRating, "Rating Adjustment",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
