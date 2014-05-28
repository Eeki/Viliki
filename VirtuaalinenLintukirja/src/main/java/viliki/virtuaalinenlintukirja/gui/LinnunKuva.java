/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Eeki
 */
public class LinnunKuva extends JPanel implements Paivitettava{
    
    private BufferedImage kuva;
    private String lahde;
    
    public LinnunKuva(String lahde) {
        this.lahde = lahde;
        try {                
          kuva = ImageIO.read(new File(lahde));
       } catch (IOException ex) {
            // handle exception...
       }
    }
    
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(kuva, 0, 0, null);

    }

    @Override
    public void paivita() {
        repaint();
    }
}

