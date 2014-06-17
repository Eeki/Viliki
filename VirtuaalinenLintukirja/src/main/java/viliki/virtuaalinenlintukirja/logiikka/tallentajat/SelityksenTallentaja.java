package viliki.virtuaalinenlintukirja.logiikka.tallentajat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import viliki.virtuaalinenlintukirja.logiikka.TyokaluPakki;

/**
 *
 * Tallentaa annetun String primitiivin .txt tiedostoksi valittuun resources/
 * kansioon
 */
public class SelityksenTallentaja {

    /**
     * Metodi tallentaa annetun String primitiivin .txt tiedostoksi valittuun
     * resources/ kansioon. Jos tallennus onnistuu palautetaan true, jos
     * epäonnistuu false.
     *
     * @param selitys
     * @param nimi
     * @param tallennuksenKohde
     * @return Boolean
     */
    public boolean tallennaSelitys(String selitys, String nimi, String kohde) {
        try {
            File tallennusFilu = new File(this.getClass().getResource("/" + kohde + "/").getPath() + TyokaluPakki.poistaSkandit(nimi) + ".txt");
            FileOutputStream os = new FileOutputStream(tallennusFilu);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            Writer w = new BufferedWriter(osw);
            w.write(selitys);
            w.close();
            return true;
        } catch (Exception e) {
            TyokaluPakki.popUpViesti("Linnun selityksen tallennus epäonnistui", "Selityksen tallentaja");
            System.out.println(e);
            return false;
        }
    }
}
