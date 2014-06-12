package viliki.virtuaalinenlintukirja.logiikka;

import java.text.Normalizer;
import javax.swing.JOptionPane;

public class TyokaluPakki {

    public static boolean popUpViesti(String viesti, String sijainti) {
        JOptionPane.showMessageDialog(null, viesti, "InfoBoksi: " + sijainti, JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static String poistaSkandit(String syote) {
        String ilmanSkandeja =
                Normalizer
                .normalize(syote, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        return ilmanSkandeja;
    }

    public static String kuvaFormaatti(String kuvanNimi) {
        String teksti = kuvanNimi;
        teksti.toLowerCase();

        if (teksti.endsWith(".png")) {
            return "png";
        }
        if (teksti.endsWith(".gif")) {
            return "gif";
        }
        if (teksti.endsWith(".jpg")) {
            return "jpg";
        }
        return "jpg"; 
    }
}
