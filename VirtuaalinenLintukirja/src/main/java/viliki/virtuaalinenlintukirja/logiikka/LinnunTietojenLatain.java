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
    

    //Jos tiedoston polku ei ole oikea tekee errorin eikä heitä exeptionia... korjaa!
    public BufferedImage lataaKuva(Lintu lintu) throws IOException {
   
        BufferedImage kuva ;
        try {
            File filu = new File(getClass().getResource("/kuvat/" + lintu.getKuva()).getFile());
            kuva = ImageIO.read(filu);     
        } catch (IOException ex) {    
            System.out.println(ex);
            kuva = ImageIO.read(new File(getClass().getResource("/kuvat/"+"noImage.png").getFile()));
            ErrorPopUp.popUpErrori("Kuvaa ei löydy", "Linnun tietojen latain");
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
    public String lataaSelitys(Lintu lintu) throws IOException {
        TekstinLukija lukija = new TekstinLukija();
        try {
            String palautettava = lukija.lueTeksti("/selitykset/" + lintu.getSelitys() + ".txt");
            return palautettava;
        }catch(IOException ex) {
            return "Linnulla ei selitystä";
        }
    }
}
