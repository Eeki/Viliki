
package viliki.virtuaalinenlintukirja.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private LinnunKuva piirtoalusta;
    @Override
    public void run() {
        this.frame = new JFrame("Swing on");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        ArrayList<LinnunKuva> kaikkiKuvat = new ArrayList<>();
        LinnunKuva alli = new LinnunKuva("c:\\test\\alli.jpg");
        LinnunKuva haahka = new LinnunKuva("c:\\test\\haahka.jpg");
        kaikkiKuvat.add(alli);
        kaikkiKuvat.add(haahka);
        
//        container.add(piirtoalusta);
//        this.piirtoalusta = piirtoalusta;
        
        GridLayout ruudukko = new GridLayout(2,kaikkiKuvat.size()/2);
        ruudukko.addLayoutComponent("alli", alli);
        ruudukko.addLayoutComponent("Haahka", haahka);
    
        container.add(alli);
    
    }

    public JFrame getFrame() {
        return frame;
    }
}
