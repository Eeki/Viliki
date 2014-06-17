/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka.Lataajat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

/**
 *
 * @author Eeki
 */
public class LinnunTietojenLatain {

    /**
     * LinnunTietojenLatain on apuluokka, joka lataa joko kuvan tai selityksen
     * tekstitiedostosta
     *
     */
    public LinnunTietojenLatain() {
    }

    /**
     * Metodi lataa ja palauttaa kuvan BufferedImage muodossa. Metodiin tulee
     * syöttää lintu-olio, jonka perusteella metodi hakee kuvan, sekä
     * lahdekansion nimi josta kuva haetaan.
     *
     * @param Lintu lintu
     * @param String lahdekansio
     * @return BufferedImage kuva
     * @throws IOException Jos metodi heittää virheen palauttaa se "noImage"
     * -kuvan
     */
    public BufferedImage lataaKuva(Lintu lintu, String lahdeKansio) throws IOException {

        BufferedImage kuva;
        try {
            File filu = new File(getClass().getResource("/" + lahdeKansio + "/" + lintu.getKuva()).getFile());
            kuva = ImageIO.read(filu);
        } catch (Exception ex) {
            System.out.println(ex);
            kuva = ImageIO.read(new File(getClass().getResource("/kuvat/" + "noImage.png").getFile()));
            return kuva;
        }

        return kuva;

    }

    /**
     * Metodi käyttää luokkaa TekstinLukija, jonka avulla se lataa .txt
     * tiedostosta tekstin ja palauttaa sen String muodossa
     *
     * @param lintu
     * @param String lahdeKansio
     * @return String palautettava selitys
     * @throws IOException jos heittää virheen palauttaa myös String:in "Linnulla ei selitystä"
     */
    public String lataaSelitys(Lintu lintu, String lahdeKansio) throws IOException {
        TekstinLukija lukija = new TekstinLukija();
        try {
            String palautettava = lukija.lueTeksti("/" + lahdeKansio + "/" + lintu.getSelitys() + ".txt");
            return palautettava;
        } catch (IOException ex) {
            return "Linnulla ei selitystä";
        }
    }
}
