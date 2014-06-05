package viliki.virtuaalinenlintukirja;

import viliki.virtuaalinenlintukirja.gui.AlkuvalikkoGui;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

/**
 *
 * @author Eeki
 */
public class Main {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Lintukirja kirja = new Lintukirja("/JSON/linnut.json");
        kirja.tuoLinnutJsonTiedostosta();
        AlkuvalikkoGui alku = new AlkuvalikkoGui(kirja);
        alku.run();
    }
}
