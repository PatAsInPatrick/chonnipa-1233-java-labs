package ngohlumdoun.chonnipa.lab12;

import javax.swing.SwingUtilities;

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
        mdv13.addComponents();
        mdv13.setFrameFeatures();
        mdv13.addListeners();
        mdv13.setName();
    }
}
