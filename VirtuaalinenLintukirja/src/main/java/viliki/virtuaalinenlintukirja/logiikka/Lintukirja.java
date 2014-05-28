/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Lintukirja {

    String lahde;
        
    private HashMap<String, Lintu> linnutMap = new HashMap<String, Lintu>();
    JsonAdapteri json;

    public Lintukirja(){
        json = new JsonAdapteri();
        File lahdeTiedosto = new File(getClass().getResource("/JSON/linnut.json").getFile());
        this.lahde = lahdeTiedosto.getPath(); 
    }
    
    public HashMap<String, Lintu> palautaLinnutMap() {
        return linnutMap;
    }

    public ArrayList<Lintu> palautaLinnutArrayList() {
        ArrayList<Lintu> palautettavaLinnutArrayList = new ArrayList<>();

        for (String lintuKey : linnutMap.keySet()) {
            palautettavaLinnutArrayList.add(linnutMap.get(lintuKey));
        }
        return palautettavaLinnutArrayList;
    }

    public void tuoLinnutJsonTiedostosta() throws Exception {
        this.linnutMap = json.tuoLinnuistaHashMap(lahde);
    }

    public void lisaaLintuJsonTiedostoon(Lintu lintu) throws Exception {
        json.lisaaLintuTiedostoon(lintu, lahde);
    }
}
