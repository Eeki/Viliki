/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja;

import java.util.ArrayList;

public class Lintukirja {
    
    public ArrayList<Lintu> noudaLintuja(){
        ArrayList<Lintu> palautettava = new ArrayList<Lintu>();
        palautettava.add(new Lintu("Alli","Allitus pallitus","Allilinnut","alli.png"));
        palautettava.add(new Lintu("Lokki","Lokitus pokitus","Lokkilinnut","lokki.png"));
        palautettava.add(new Lintu("Pöllö","Pöölötys pällitys","Pöllölinnut","pollo.png"));
        palautettava.add(new Lintu("Pääsky","Pääskytys pallitus","pääskylinnut","paasky.png"));
        palautettava.add(new Lintu("Varis","Kraak kraak","varislinnut","varis.png"));
        return palautettava; 
}
}
