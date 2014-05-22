/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.util.HashMap;

public class Lintukirja {
//    File lahde = new File(getClass().getResource("/viliki/virtuaalinenlintukirja/tiedostot/linnut.json").getFile());
    private HashMap<String,Lintu> linnut = new HashMap<String, Lintu>();
    JsonAdapteri json = new JsonAdapteri();
    public HashMap<String,Lintu> palautaLinnut(){
        return linnut;
}
    public void tuoLinnutJsonTiedostosta() throws Exception {
        json = new JsonAdapteri();
        this.linnut = json.tuoLinnuistaHashMap("c:\\test\\linnut2.json");
    }
    
    public void lisaaLintuJsonTiedostoon() {
        
    }
}
