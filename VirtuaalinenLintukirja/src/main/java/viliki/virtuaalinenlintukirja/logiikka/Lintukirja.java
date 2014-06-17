/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import viliki.virtuaalinenlintukirja.logiikka.tallentajat.KuvaTallentaja;
import viliki.virtuaalinenlintukirja.logiikka.tallentajat.SelityksenTallentaja;

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
    SelityksenTallentaja selityksenTallentaja;

    /**
     *
     * @param lahde
     */
    public Lintukirja(String lahde) {
        json = new JsonAdapteri();
        File lahdeTiedosto = new File(this.getClass().getResource(lahde).getFile());
        this.lahde = lahdeTiedosto.getPath();
        System.out.println(this.lahde);
        this.kuvaTallentaja = new KuvaTallentaja();
        this.selityksenTallentaja = new SelityksenTallentaja();
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
    public boolean lisaaLintuTiedostoon(Lintu lintu, String kuvanLahde, String selitys) throws Exception {
        // tämä metodi lisää JSON tiedostoon linnun parametrit + /kuvat/ kansioon linnun kuvan ja /selitykset/ kansioon linnun selityksen
        if (kuvaTallentaja.tallennaKuva(kuvanLahde, lintu.getKuva(),"kuvat")) {
            if (json.lisaaLintuTiedostoon(lintu, this.lahde)) {
                this.selityksenTallentaja.tallennaSelitys(selitys, lintu.getNimi(),"selitykset");
                tuoLinnutJsonTiedostosta(); // ladataan linnut uudelleen
                TyokaluPakki.popUpViesti("Lintu lisättiin lintukirjaan", "Lintukirja");
                return true;
            } else {
                TyokaluPakki.popUpViesti("Lintua ei lisätty lintukirjaan", "Lintukirja");
                return false;
            }
        }
        return false;


    }
}
