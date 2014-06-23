/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

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
     * Lintukirja luokan konstruktori
     * @param lahde ladattavan json tiedsoton sijainti
     */
    public Lintukirja(String lahde) {
        json = new JsonAdapteri();
        this.lahde = lahde;
        this.kuvaTallentaja = new KuvaTallentaja();
        this.selityksenTallentaja = new SelityksenTallentaja();
    }

    /**
     * Palauttaa kaikki linnut sisältävän HashMap:in, jossa avaimena on linnun nimi ja arvona lintu-olio
     * @return linnut sisältävä HashMap
     */
    public HashMap<String, Lintu> palautaLinnutMap() {
        return linnutMap;
    }

    /**
     * Palauttaa kaikki linntu-oliot sisältävän ArrayList:in
     * @return linnut sisältävä ArrayList
     */
    public ArrayList<Lintu> palautaLinnutArrayList() {
        ArrayList<Lintu> palautettavaLinnutArrayList = new ArrayList<>();

        for (String lintuKey : linnutMap.keySet()) {
            palautettavaLinnutArrayList.add(linnutMap.get(lintuKey));
        }
        return palautettavaLinnutArrayList;
    }

    /**
     *Hakee linnut HashMap:in luokalta JsonAdapteri ja tallentaa sen Lintukirja luokalle.
     * @throws Exception
     */
    public void tuoLinnutJsonTiedostosta() throws Exception {
        this.linnutMap = json.tuoLinnuistaHashMap(lahde);
    }

    /**
     *Lisää linnun kuvan haluttuun kansioon, lisäksi tallentaa uuden linnun json tiedsotoon ja selityksen tekstitiedostoon 
     * @param lintu tallennettava lintu-olio
     * @param kuvanLahde linnun kuvan lähde levyllä
     * @param selitys tallennettava selitys linnulle
     * @return palauttaa totuusarvon true jos tallennus onnistui, false jos ei
     * @throws Exception
     */
    public boolean lisaaLintuTiedostoon(Lintu lintu, String kuvanLahde, String selitys) throws Exception {
        // tämä metodi lisää JSON tiedostoon linnun parametrit + /kuvat/ kansioon linnun kuvan ja /selitykset/ kansioon linnun selityksen
        if (kuvaTallentaja.tallennaKuva(kuvanLahde, lintu.getKuva(),"Resources/kuvat/")) {
            if (json.lisaaLintuTiedostoon(lintu, "Resources/JSON/linnut.json")) {
                this.selityksenTallentaja.tallennaSelitys(selitys, lintu.getNimi(),"Resources/selitykset/");
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
