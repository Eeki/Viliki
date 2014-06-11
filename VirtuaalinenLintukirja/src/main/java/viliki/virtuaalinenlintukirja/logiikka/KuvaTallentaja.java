package viliki.virtuaalinenlintukirja.logiikka;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class KuvaTallentaja {

    public void tallennaKuva(String polku, String kuvanNimi, String formaatti) throws IOException {
        try {
            BufferedImage luettavaKuva = ImageIO.read(new File("c:\\test\\pr.jpg"));

            File tallennetteva = new File(this.getClass().getResource("/kuvat/").getPath() + kuvanNimi);
            ImageIO.write(luettavaKuva, formaatti, tallennetteva);

            BufferedImage kuvanTarkistus = ImageIO.read(new File(tallennetteva.getPath()));

            System.out.println(kuvanTarkistus.getHeight());


        } catch (IOException e) {

            ErrorPopUp.popUpErrori("Kuvan tallennus epäonnistui", "tallennaKuva");
        }


    }
}
