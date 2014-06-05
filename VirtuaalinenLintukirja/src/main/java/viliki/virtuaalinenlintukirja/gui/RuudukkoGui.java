package viliki.virtuaalinenlintukirja.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import viliki.virtuaalinenlintukirja.logiikka.Galleria;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

public class RuudukkoGui extends javax.swing.JFrame {

    private Lintukirja kirja;
    private Galleria galleria;
    private JButton[] JNappaimet;
    private ArrayList<Lintu> linnut;
    private HashMap<String,Lintu> linnutMap = new HashMap<String,Lintu>();

    public RuudukkoGui(Lintukirja kirja) throws IOException {
        this.kirja = kirja;
        galleria = new Galleria();
        this.linnut = this.kirja.palautaLinnutArrayList();
        
        for (Lintu lintu : this.linnut) {
            linnutMap.put(lintu.getNimi(), lintu);
        }
        
        this.JNappaimet = new JButton[linnut.size()];
        Container panel = getContentPane();
        panel.setLayout(new GridLayout(3, linnut.size()));


        for (int i = 0; i < JNappaimet.length; i++) {
            JNappaimet[i] = new JButton(linnut.get(i).getNimi());
            JNappaimet[i].setSize(80, 80);
            JNappaimet[i].setActionCommand(linnut.get(i).getNimi());
            JNappaimet[i].setIcon(new ImageIcon(new File(getClass().getResource("/kuvat/" + linnut.get(i).getKuva()).getFile()).getPath()));

            JNappaimet[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String valinnanNimi = e.getActionCommand();
                    LinnunKuvausGui kuvaus = new LinnunKuvausGui(linnutMap.get(valinnanNimi));
                    try {
                        kuvaus.asetaTiedot();
                    } catch (IOException ex) {
                        Logger.getLogger(RuudukkoGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    kuvaus.setVisible(true);
                }
            });
            panel.add(JNappaimet[i]);
        }
        
        JPanel paneeli = new JPanel();
        JButton nappain = new JButton();
        nappain.setText("Näppäin");
        JLabel labeli = new JLabel();
        labeli.setText("labeli");
        paneeli.add(nappain,JLabel.NORTH);
        paneeli.add(labeli,JLabel.EAST);
        panel.add(paneeli);
        
        validate();
    }
    
}
