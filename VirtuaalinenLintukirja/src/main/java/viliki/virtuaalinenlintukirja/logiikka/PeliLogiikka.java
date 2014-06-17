/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Vielä keskeneräinen luokka joka tulee ottamaan vastuuta luokalta PeliGUI.
 *
 */
public class PeliLogiikka {

    public PeliLogiikka() {
        
    }
    List<Lintu> questionList = new ArrayList<Lintu>();

    /**
     *
     * @param linnut
     * @return
     */
    public List<Lintu> sekoitaKierroksenLinnut(ArrayList<Lintu> linnut) {
        List<Lintu> palautettava = linnut;
        Collections.shuffle(palautettava);
        return palautettava;
    }
}
