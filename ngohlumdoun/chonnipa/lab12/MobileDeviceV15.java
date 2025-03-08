package ngohlumdoun.chonnipa.lab12;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

/**
 * Mobile Device V15 Program:
 * Writing and Reading Objects to/from a file
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 7 Mar 2025 11:21 AM
 */

public class MobileDeviceV15 extends MobileDeviceV14 {

    protected JMenu formatMenu = new JMenu("Format");
    protected ButtonGroup formatGroup = new ButtonGroup();
    protected JRadioButtonMenuItem text = new JRadioButtonMenuItem("Text");
    protected JRadioButtonMenuItem binary = new JRadioButtonMenuItem("Binary");

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
        formatMenu.add(text);
        formatMenu.add(binary);

        // add subitems to format group
        formatGroup.add(text);
        formatGroup.add(binary);
    }

    @Override

    public void addListeners() {
        super.addListeners();
        text.addActionListener(this);
        binary.addActionListener(this);
    }
}
