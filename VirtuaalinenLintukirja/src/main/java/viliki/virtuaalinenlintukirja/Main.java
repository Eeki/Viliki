package viliki.virtuaalinenlintukirja;

import viliki.virtuaalinenlintukirja.gui.AlkuvalikkoGui;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;
import viliki.virtuaalinenlintukirja.logiikka.TiedostojenKopioija;

/**
 *
 * @author Eeki
 */
public class Main {

    /**
     *  "/JSON/linnut.json"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Luodaan tiedostokopioija, joka luo lintukirjan Jar tiedostossa olevasta json tiedostosta
        TiedostojenKopioija siirtaja = new TiedostojenKopioija();
        siirtaja.luoKuvatSelityksetJaJsonKansiot();
        siirtaja.kopioiKuvaUlosJarResourcesTiedostosta("/JSON/linnut.json", "Resources/JSON/linnut.json");
        siirtaja.lataaJsonTiedotoKopioijaan();
        siirtaja.siirraKuvatUlosJarTiedostosta();
        siirtaja.siirraSelityksetUlosJarTiedostosta();
       
        Lintukirja kirja = new Lintukirja("Resources/JSON/linnut.json");
        kirja.tuoLinnutJsonTiedostosta();      
        AlkuvalikkoGui alku = new AlkuvalikkoGui(kirja);
        alku.run();
    }
}
