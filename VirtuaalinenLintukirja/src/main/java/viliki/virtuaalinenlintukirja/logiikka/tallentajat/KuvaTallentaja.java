package viliki.virtuaalinenlintukirja.logiikka.tallentajat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import viliki.virtuaalinenlintukirja.logiikka.TyokaluPakki;

/**
 * Luokka tallentaa annetun kuvan valittuun resources/ kansioon
 *
 */
public class KuvaTallentaja {

    /**
     * Metodi taallentaa annetun kuvan valittuun resources/ kansioon. Jos kuvan
     * talletus onnistuu palauttaa metodi boolean arvon true, jos ei palautetaan
     * false.
     *
     * @param String polku
     * @param String kuvanNimi
     * @return Boolean true
     * @throws IOException jos metodi heittää virheen eli kuvan tallentaminen
     * epäonnistuu, palauttaa metodi Boolean arvon false
     */
    public boolean tallennaKuva(String polku, String kuvanNimi, String talletusPolku) throws IOException {
        try {
            BufferedImage luettavaKuva = ImageIO.read(new File(polku));
//            luettavaKuva = TyokaluPakki.kuvanSovittaja(luettavaKuva);
            File tallennetteva = new File(this.getClass().getResource("/" + talletusPolku + "/").getPath() + kuvanNimi);
            ImageIO.write(luettavaKuva, TyokaluPakki.kuvaFormaatti(polku), tallennetteva);
            System.out.println("Kuva " + kuvanNimi + " tallennettiin");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            TyokaluPakki.popUpViesti("Kuvan tallennus epäonnistui", "tallennaKuva");
            return false;
        }


    }
}
