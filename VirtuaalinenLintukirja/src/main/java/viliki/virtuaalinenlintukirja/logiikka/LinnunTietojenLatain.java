/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Eeki
 */
public class LinnunTietojenLatain {

    /**
     * LinnunTietojenLatain on apuluokka, joka lataa joko kuvan polun tai
     * selityksen tekstitiedostosta ja palauttaa nämä String muodossa
     *
     */
    public LinnunTietojenLatain() {
    }

    /**
     *
     * @param lintu
     * @return
     * @throws IOException
     */
    public BufferedImage lataaKuva(Lintu lintu) throws IOException {
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(new File(getClass().getResource("/kuvat/" + lintu.getKuva()).getFile()));
        } catch (IOException ex) {
            System.out.println("Kuvan lataaminen epäonnistui");
        }

        return kuva;

    }

    /**
     *
     * @param lintu
     * @return
     * @throws IOException
     */
    public String lataaSelitys(Lintu lintu) throws IOException {
        TekstinLukija lukija = new TekstinLukija();
        String palautettava = lukija.lueTeksti("/selitykset/" + lintu.getSelitys() + ".txt");
        return palautettava;
    }
}
