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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

public class AlkuvalikkoGui implements Runnable {

    private JFrame frame;
    private JButton galleriaNappi;
    private JButton pelinappi;
    private JButton lisaaLintuNappi;
    private Lintukirja kirja;

    public AlkuvalikkoGui(Lintukirja kirja) {
        this.kirja = kirja;
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
        container.add(new JLabel("Virtuaalinen lintukirja"));
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
                    Logger.getLogger(AlkuvalikkoGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));

        pelinappi = new JButton(new AbstractAction("Peli") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    avaaPeli();
                } catch (IOException ex) {
                    Logger.getLogger(AlkuvalikkoGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        lisaaLintuNappi = new JButton(new AbstractAction("lisaa lintu") {
            @Override
            public void actionPerformed(ActionEvent e) {
                    avaaLisaaLintu();
            }
        });




    }

    private void avaaGalleria() throws IOException {
        RuudukkoGui ruudukko = new RuudukkoGui(kirja);
        ruudukko.pack();
        ruudukko.setVisible(true);

    }

    private void avaaPeli() throws IOException {
        PeliGui peli = new PeliGui(kirja.palautaLinnutArrayList());
        peli.setVisible(true);
    }

    private void avaaLisaaLintu() {
        LisaaLintuGui lisaa = new LisaaLintuGui(kirja);
        lisaa.setVisible(true);
    }
}
