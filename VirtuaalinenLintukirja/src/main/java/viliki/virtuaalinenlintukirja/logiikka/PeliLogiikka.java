/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;


import java.util.ArrayList;
import java.util.Collections;
/**
 * Vielä keskeneräinen luokka joka tulee ottamaan vastuuta luokalta PeliGUI. 
 * 
 */
public class PeliLogiikka {

    /**
     *
     * @param linnut
     * @return
     */
    public ArrayList<String> sekoitaKierroksenLinnut(ArrayList<Lintu> linnut) {
        ArrayList<String> palautettavatLinnut = new ArrayList<>();
        
        for (Lintu lintu : linnut) {
            palautettavatLinnut.add(lintu.getNimi());
        }
        
        Collections.shuffle(linnut);
        return palautettavatLinnut;
    }
}
