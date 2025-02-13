package ngohlumdoun.chonnipa.lab9;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ReadImage extends JPanel {
    BufferedImage samsungImage;
    String filename = "images/S25-ultra.jpg";

    public void paintComponent(Graphics g) {
        g.drawImage(samsungImage, 0, 0, null);
    }

    public ReadImage() {
        try {
            samsungImage = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public Dimension getPreferredSize() {
        if (samsungImage == null)
            return new Dimension(100, 100);
        else
            return new Dimension(samsungImage.getWidth(), samsungImage.getHeight());
    }
}
