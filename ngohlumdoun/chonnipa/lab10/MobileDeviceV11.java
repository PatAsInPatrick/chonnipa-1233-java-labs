package ngohlumdoun.chonnipa.lab10;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Mobile Device V10 Program:
 * Show dialog when type JButton is changed
 * Add the mnemonic keys and accelerator keys for menu item
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 18 Feb 2025 01:46 PM
 */

public class MobileDeviceV11 extends MobileDeviceV10 implements ActionListener {

    // Contructor
    public MobileDeviceV11(String title) {
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
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents();
        mdv11.setFrameFeatures();
        mdv11.addListeners();
        mdv11.enableKeyboard();
    }

    @Override
    public void addListeners() {
        super.addListeners();

        smartphoneRadioButton.addActionListener(this);
        tabletRadioButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object src = e.getSource();

        // When the user clicks new radio buttonm -> new selection dialog
        if (src == smartphoneRadioButton) {
            JOptionPane.showMessageDialog(this, "Smartphone is selected");
        } else if (src == tabletRadioButton) {
            JOptionPane.showMessageDialog(this, "Tablet is selected");
        }
    }

    protected void setMAKeys(JMenuItem menu, int mKey, int aKey, ActionListener listener) {
        // Set mnemonic key
        menu.setMnemonic(mKey);

        // Set accelerator key
        menu.setAccelerator(KeyStroke.getKeyStroke(aKey, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    protected void enableKeyboard() {

        // Set "New" menu shortcut -> N, Ctrl + N
        setMAKeys(newItem, KeyEvent.VK_N, KeyEvent.VK_N, this);

        // Set "Open" menu shortcut -> O, Ctrl + O
        setMAKeys(openItem, KeyEvent.VK_O, KeyEvent.VK_O, this);

        // Set "Save" menu shortcut -> S, Ctrl + S
        setMAKeys(saveItem, KeyEvent.VK_S, KeyEvent.VK_S, this);

        // Set "Exit" menu shortcut -> X, Ctrl + Q
        setMAKeys(exitItem, KeyEvent.VK_X, KeyEvent.VK_Q, this);
    }
}
