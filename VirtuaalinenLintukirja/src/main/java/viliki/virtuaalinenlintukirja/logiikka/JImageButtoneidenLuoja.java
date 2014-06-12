package viliki.virtuaalinenlintukirja.logiikka;

import viliki.virtuaalinenlintukirja.logiikka.Lataajat.LinnunTietojenLatain;
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
import viliki.virtuaalinenlintukirja.gui.LinnunKuvausGui;
import viliki.virtuaalinenlintukirja.gui.RuudukkoGui;

public class JImageButtoneidenLuoja {

    public JButton[] luoImageButtoneita(ArrayList<Lintu> linnut) throws IOException {
        LinnunTietojenLatain latain = new LinnunTietojenLatain();
        JButton[] JNappaimet = new JButton[linnut.size()];
        final HashMap<String, Lintu> linnutMap = teeTuoduistaLinnuistaMap(linnut);


        for (int i = 0; i < JNappaimet.length; i++) {
            JNappaimet[i] = new JButton(linnut.get(i).getNimi());
            JNappaimet[i].setSize(80, 80);
            JNappaimet[i].setActionCommand(linnut.get(i).getNimi());
            JNappaimet[i].setIcon(new ImageIcon(latain.lataaKuva(linnut.get(i),"kuvat")));
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

    public HashMap<String, Lintu> teeTuoduistaLinnuistaMap(ArrayList<Lintu> linnut) {
        HashMap<String, Lintu> palautettavaLintuMap = new HashMap<>();
        for (Lintu lintu : linnut) {
            palautettavaLintuMap.put(lintu.getNimi(), lintu);
        }
        return palautettavaLintuMap;
    }
    
}
