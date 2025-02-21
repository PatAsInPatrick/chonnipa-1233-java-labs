package ngohlumdoun.chonnipa.lab9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage extends JPanel {
    BufferedImage samsungImage;
    String filename = "images/S25-ultra.jpg";

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(samsungImage, 0, 0, getWidth(), getHeight(), null);
    }

    public ReadImage() {
        try {
            samsungImage = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public ReadImage(String filename) {
        String name = "./images/" + filename;
        try {
            samsungImage = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
