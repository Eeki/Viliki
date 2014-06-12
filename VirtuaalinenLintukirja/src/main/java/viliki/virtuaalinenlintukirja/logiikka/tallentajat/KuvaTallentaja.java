package viliki.virtuaalinenlintukirja.logiikka.tallentajat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import viliki.virtuaalinenlintukirja.logiikka.TyokaluPakki;

public class KuvaTallentaja {

    public boolean tallennaKuva(String polku, String kuvanNimi, String formaatti) throws IOException {
        try {
            BufferedImage luettavaKuva = ImageIO.read(new File(polku));
            File tallennetteva = new File(this.getClass().getResource("/kuvat/").getPath() + kuvanNimi);
            ImageIO.write(luettavaKuva, formaatti, tallennetteva);
            System.out.println("Kuva " + kuvanNimi + " tallennettiin");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            TyokaluPakki.popUpViesti("Kuvan tallennus epäonnistui", "tallennaKuva");
            return false;
        }


    }
}
