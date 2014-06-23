package viliki.virtuaalinenlintukirja.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import viliki.virtuaalinenlintukirja.logiikka.Lataajat.LinnunTietojenLatain;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.logiikka.TyokaluPakki;

/**
 *
 * Luokka luo listan ImageButtoneita annettujen lintujen perusteella
 */
public class JImageButtoneidenLuoja {

    /**
     *Metodi luo ja palauttaa listan JButtoneita. JButtoneiden nimet ja kuvat tulevat lintu olioiden mukaan
     * @param linnut 
     * @param ArrayList<Lintu> linnut
     * @return JButton[]
     * @throws IOException
     */
    public JButton[] luoImageButtoneita(ArrayList<Lintu> linnut) throws IOException {
        LinnunTietojenLatain latain = new LinnunTietojenLatain();
        JButton[] JNappaimet = new JButton[linnut.size()];
        final HashMap<String, Lintu> linnutMap = TyokaluPakki.teeLintuArrayLististaHashMap(linnut);


        for (int i = 0; i < JNappaimet.length; i++) {
            JNappaimet[i] = new JButton(linnut.get(i).getNimi());
            JNappaimet[i].setPreferredSize(new Dimension(320, 270));
            JNappaimet[i].setActionCommand(linnut.get(i).getNimi());
            JNappaimet[i].setIcon(new ImageIcon(latain.lataaKuva(linnut.get(i),"Resources/kuvat/")));
            JNappaimet[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            JNappaimet[i].setHorizontalTextPosition(SwingConstants.CENTER);

            JNappaimet[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String valinnanNimi = e.getActionCommand();
                    LinnunKuvausGui kuvaus = new LinnunKuvausGui(linnutMap.get(valinnanNimi));
                    try {
                        kuvaus.asetaTiedot();
                    } catch (IOException ex) {
                        Logger.getLogger(RuudukkoGui.class.getName()).log(Level.SEVERE, null, ex);
                        TyokaluPakki.popUpViesti("Virhe linnun kuvauksen asettamisessa", valinnanNimi);
                    }
                    kuvaus.setVisible(true);
                }
            });

        }
        return JNappaimet;
    }    
}