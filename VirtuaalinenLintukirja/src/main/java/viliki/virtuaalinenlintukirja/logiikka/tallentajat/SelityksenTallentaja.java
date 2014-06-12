/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka.tallentajat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import viliki.virtuaalinenlintukirja.logiikka.TyokaluPakki;

/**
 *
 * @author Eeki
 */
public class SelityksenTallentaja {

    /**
     *
     * @param selitys
     * @param nimi
     * @param tallennuksenKohde
     * @return
     */
    public boolean tallennaSelitys(String selitys, String nimi) {
        try {
            File tallennusFilu = new File(this.getClass().getResource("/selitykset/").getPath() + TyokaluPakki.poistaSkandit(nimi) + ".txt");
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
