package ngohlumdoun.chonnipa.lab10;

import ngohlumdoun.chonnipa.lab9.MobileDeviceV7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    // Contructor
    public MobileDeviceV8(String title) {
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

    public void addListeners() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            createOptionPane();
        } else if (src == resetButton) {
            clearForm();
        }
    }

    protected void createOptionPane() {
        JOptionPane.showMessageDialog(null, "Device Information");
    }

    protected void clearForm() {
        // Clear form fields.
        deviceNameField.setText("");
        brandField.setText("");
        priceField.setText("");
        featuresTextArea.setText("");

        // Set radio buttons to smartphone
        smartphoneRadioButton.setSelected(true);

        // Set Operating System to Android
        OSComboBox.setSelectedItem("Android");

        // Clear vendor selection list.
        vendorList.clearSelection();

        // Set rating to 5
        rateSlider.setValue(5);
    }

    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.setFrameFeatures();
    }
}
