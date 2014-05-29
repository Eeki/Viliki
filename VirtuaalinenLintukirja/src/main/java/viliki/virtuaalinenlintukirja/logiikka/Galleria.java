/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import viliki.virtuaalinenlintukirja.gui.Ruudukko;

public class Galleria {
    private ArrayList<Lintu> linnut = new ArrayList<Lintu>();
    private Ruudukko ruudukko;
    
    public Galleria(Lintukirja kirja) {
        System.out.println("Galleria avattu");
        linnut = kirja.palautaLinnutArrayList();
    }
    
    public void avaaGalleriaNakyma() throws IOException {
        this.ruudukko = new Ruudukko(linnut);  
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.pack();
        ruudukko.setVisible(true);
    }
}
