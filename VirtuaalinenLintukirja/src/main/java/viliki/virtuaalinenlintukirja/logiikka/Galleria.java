/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.util.HashMap;

public class Galleria {

    private Lintukirja lintukirja;

    public Galleria() {
        this.lintukirja = new Lintukirja();
        System.out.println("Galleria avattu");

    }

    public void printtaaLinnut() {
         HashMap<String, Lintu> lintuset = lintukirja.palautaLinnut();
        for (String string : lintuset.keySet()) {
            System.out.println(lintuset.get(string).getNimi());
        }
        
    }
}
