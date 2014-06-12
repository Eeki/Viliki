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
    

    //Jos tiedoston polku ei ole oikea tekee errorin eikä heitä exeptionia... korjaa!
    public BufferedImage lataaKuva(Lintu lintu, String lahdeKansio) throws IOException {
   
        BufferedImage kuva ;
        try {
            File filu = new File(getClass().getResource("/"+lahdeKansio+"/" + lintu.getKuva()).getFile());
            kuva = ImageIO.read(filu);     
        } catch (Exception ex) {    
            System.out.println(ex);
            kuva = ImageIO.read(new File(getClass().getResource("/kuvat/"+"noImage.png").getFile()));
            return kuva;
        }

        return kuva;

    }

    /**
     *
     * @param lintu
     * @return
     * @throws IOException
     */
    public String lataaSelitys(Lintu lintu, String lahdeKansio) throws IOException {
        TekstinLukija lukija = new TekstinLukija();
        try {
            String palautettava = lukija.lueTeksti("/"+lahdeKansio+"/" + lintu.getSelitys() + ".txt");
            return palautettava;
        }catch(IOException ex) {
            return "Linnulla ei selitystä";
        }
    }
}
