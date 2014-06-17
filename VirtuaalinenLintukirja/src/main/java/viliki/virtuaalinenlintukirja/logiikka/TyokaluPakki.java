package viliki.virtuaalinenlintukirja.logiikka;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Eeki
 */
public class TyokaluPakki {

    /**
     *
     * @param viesti
     * @param sijainti
     * @return
     */
    public static boolean popUpViesti(String viesti, String sijainti) {
        JOptionPane.showMessageDialog(null, viesti, "InfoBoksi: " + sijainti, JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    /**
     *
     * @param syote
     * @return
     */
    public static String poistaSkandit(String syote) {
        String ilmanSkandeja =
                Normalizer
                .normalize(syote, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        return ilmanSkandeja;
    }

    /**
     *
     * @param kuvanNimi
     * @return
     */
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

    public static BufferedImage kuvanSovittaja(BufferedImage alkukuva) {
        BufferedImage palautettavaKuva = alkukuva;

        if (palautettavaKuva instanceof BufferedImage) {
            palautettavaKuva = (BufferedImage) palautettavaKuva.getScaledInstance(320, 240, Image.SCALE_DEFAULT);
        }
        return palautettavaKuva;
    }

    /**
     * Apuluokka joka muuntaa ArrayList:in HashMapiksi
     *
     * @param ArrayList<Lintu> linnut
     * @return HashMap<String, Lintu> palautettavatlinnut
     */
    public static HashMap<String, Lintu> teeTuoduistaLinnuistaMap(ArrayList<Lintu> linnut) {
        HashMap<String, Lintu> palautettavaLintuMap = new HashMap<>();
        for (Lintu lintu : linnut) {
            palautettavaLintuMap.put(lintu.getNimi(), lintu);
        }
        return palautettavaLintuMap;
    }
}
