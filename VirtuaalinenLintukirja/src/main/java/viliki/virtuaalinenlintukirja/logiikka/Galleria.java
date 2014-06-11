/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import viliki.virtuaalinenlintukirja.logiikka.jarjestajat.LinnutAakkosjarjestykseen;
import viliki.virtuaalinenlintukirja.logiikka.jarjestajat.LinnutHeimojarjestykseen;

/**
 * Galleria on viela keskenerainen luokka. Talla hetkella se voi jarjastella
 * lintuja joko aakkosten tai heimon perusteella
 *
 *
 */
public class Galleria {

    /**
     *
     */
    public Galleria() {
    }

    /**
     *
     * @param linnutArray
     * @return
     */
    public ArrayList<Lintu> jarjestaGalleriaAakkos(ArrayList<Lintu> linnutArray) {
        LinnutAakkosjarjestykseen jarkkari = new LinnutAakkosjarjestykseen();
        ArrayList<Lintu> palautettavatLinnutArray = linnutArray;
        Collections.sort(palautettavatLinnutArray, jarkkari);
        return palautettavatLinnutArray;
    }

    /**
     *
     * @param linnutArray
     * @return
     */
    public ArrayList<Lintu> jarjestaGalleriaHeimo(ArrayList<Lintu> linnutArray) {
        LinnutHeimojarjestykseen jarkkari = new LinnutHeimojarjestykseen();
        ArrayList<Lintu> palautettavatLinnutArray = linnutArray;
        Collections.sort(palautettavatLinnutArray, jarkkari);
        return palautettavatLinnutArray;
    }
    
    public ArrayList<Lintu> etsiLintu() {
        return null;
    }
}
