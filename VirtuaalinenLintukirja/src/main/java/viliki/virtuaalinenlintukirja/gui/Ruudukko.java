package viliki.virtuaalinenlintukirja.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

public class Ruudukko extends JFrame {

    public Ruudukko(ArrayList<Lintu> linnut) throws IOException {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, linnut.size()));
        JButton button;

        for (Lintu lintu : linnut) {

            BufferedImage buttonIcon = ImageIO.read(new File(getClass().getResource("/kuvat/" + lintu.getKuva()).getFile())); //"/viliki/virtuaalinenlintukirja/tiedostot/kuvat/"
            button = new JButton(new ImageIcon(buttonIcon));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            pane.add(button);
        }
    }
}
