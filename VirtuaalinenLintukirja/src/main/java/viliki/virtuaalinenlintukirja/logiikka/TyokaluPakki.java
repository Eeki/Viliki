package viliki.virtuaalinenlintukirja.logiikka;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Tyokalupakki on luokka, jossa on lajitelma erillaisia staattisia apumetodeita
 *
 * @author Eeki
 */
public class TyokaluPakki {

    /**
     * Luo erillisessä ikkunassa olevan viestikentän, jossa voi ilmoittaa
     * ohjelmassa tapahtuvia asioita
     *
     * @param viesti ruudulla näkyvä viesti
     * @param sijainti miltä luokalta/metodilta viesti tulee
     * @return totuusarvo true
     */
    public static boolean popUpViesti(String viesti, String sijainti) {
        JOptionPane.showMessageDialog(null, viesti, "InfoBoksi: " + sijainti, JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    /**
     * PoistaSkandit poistaa kaikki skandit ja muut merkit jotka voivat sotkea
     * tiedostopolkuja
     *
     * @param syote merkkijono josta poistetaan
     * @return syötetty merkkijono ilman erikoismerkkejä
     */
    public static String poistaSkandit(String syote) {
        String ilmanSkandeja =
                Normalizer
                .normalize(syote, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        return ilmanSkandeja;
    }

    /**
     * Palauttaa kuvatiedostojen .png, .gif ja .jpg tiedostotyypin. Jos ei ole
     * joku näistä tiedostotyypeistä palauttaa jpg:n.
     *
     * @param kuvanNimi skaalattavan tiedoston polku
     * @return tiedoston tyypin merkkijonona
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

    /**
     * Skaalaa kuvan lintukirjaan sopivaksi
     *
     * @param alkukuva skaalattava kuva
     * @return skaalattu kuva
     */
    public static BufferedImage kuvanSovittaja(BufferedImage alkukuva) {
        BufferedImage palautettavaKuva = alkukuva;

        if (palautettavaKuva instanceof BufferedImage) {
            palautettavaKuva = (BufferedImage) palautettavaKuva.getScaledInstance(320, 240, Image.SCALE_DEFAULT);
        }
        return palautettavaKuva;
    }

    /**
     * Muuntaa lintu ArrayList:in HashMapiksi
     *
     * @param linnut arrayList linnuista
     * @return palautettavatlinnut HashMap<String, Lintu>
     */
    public static HashMap<String, Lintu> teeLintuArrayLististaHashMap(ArrayList<Lintu> linnut) {
        HashMap<String, Lintu> palautettavaLintuMap = new HashMap<>();
        for (Lintu lintu : linnut) {
            palautettavaLintuMap.put(lintu.getNimi(), lintu);
        }
        return palautettavaLintuMap;
    }
}