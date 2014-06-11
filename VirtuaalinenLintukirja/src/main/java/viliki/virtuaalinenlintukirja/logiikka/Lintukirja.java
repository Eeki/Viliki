/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lintukirja luokka käyttää JsonAdapteria hakeakseen ja tallentaakseen lintujen
 * tietoja JSON tiedostosta. Toimii JsonAdapterin ja muiden luokkien adapterina
 *
 */
public class Lintukirja {

    String lahde;
    private HashMap<String, Lintu> linnutMap = new HashMap<>();
    JsonAdapteri json;
    KuvaTallentaja kuvaTallentaja;

    /**
     *
     * @param lahde
     */
    public Lintukirja(String lahde) {
        json = new JsonAdapteri();
        File lahdeTiedosto = new File(getClass().getResource(lahde).getFile());
        this.lahde = lahdeTiedosto.getPath();
        this.kuvaTallentaja = new KuvaTallentaja();
    }

    /**
     *
     * @return
     */
    public HashMap<String, Lintu> palautaLinnutMap() {
        return linnutMap;
    }

    /**
     *
     * @return
     */
    public ArrayList<Lintu> palautaLinnutArrayList() {
        ArrayList<Lintu> palautettavaLinnutArrayList = new ArrayList<>();

        for (String lintuKey : linnutMap.keySet()) {
            palautettavaLinnutArrayList.add(linnutMap.get(lintuKey));
        }
        return palautettavaLinnutArrayList;
    }

    /**
     *
     * @throws Exception
     */
    public void tuoLinnutJsonTiedostosta() throws Exception {
        this.linnutMap = json.tuoLinnuistaHashMap(lahde);
    }

    /**
     *
     * @param lintu
     * @throws Exception
     */
    public void lisaaLintuJsonTiedostoon(Lintu lintu, String lahde) throws Exception {
        kuvaTallentaja.tallennaKuva(lahde, lintu.getKuva(), "jpg");
        json.lisaaLintuTiedostoon(lintu, lahde);
    }
}
