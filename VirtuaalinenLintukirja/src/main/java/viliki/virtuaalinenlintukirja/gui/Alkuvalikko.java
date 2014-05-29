package viliki.virtuaalinenlintukirja.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import viliki.virtuaalinenlintukirja.logiikka.Galleria;

public class Alkuvalikko implements Runnable {

    private JFrame frame;
    private Galleria galleria;
    private JButton galleriaNappi;
    private JButton pelinappi;
    private JButton lisaaLintuNappi;
    
    public Alkuvalikko(Galleria galleria) {
        this.galleria = galleria;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Viliki");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        container.add(new JTextArea());
        container.add(luoValikko(), BorderLayout.SOUTH);

    }

    public JFrame getFrame() {
        return frame;
    }


    private JPanel luoValikko() {
        luoNapit();
        JPanel panel = new JPanel(new GridLayout(1, 3));

        panel.add(galleriaNappi);
        panel.add(pelinappi);
        panel.add(lisaaLintuNappi);

        
        return panel;
    }

    private void luoNapit() {
        galleriaNappi = (new JButton(new AbstractAction("Galleria") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    avaaGalleria();
                } catch (IOException ex) {
                    Logger.getLogger(Alkuvalikko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        
        pelinappi = new JButton("Peli");
        lisaaLintuNappi = new JButton("Lisaa lintu");
        



    }
    
    private void avaaGalleria() throws IOException {
        this.galleria.avaaGalleriaNakyma();
    }
    
    private void avaaPeli() {
        
    }
    
    private void avaaLisaaLintu() {
        
    }
}
