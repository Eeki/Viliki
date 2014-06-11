package viliki.virtuaalinenlintukirja;

import viliki.virtuaalinenlintukirja.gui.AlkuvalikkoGui;
import viliki.virtuaalinenlintukirja.logiikka.KuvaTallentaja;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
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
        kirja.lisaaLintuJsonTiedostoon(new Lintu("Eeki","peeki","juh","eeki.jpg"), "c:\\test\\pollo.jpg");
        kirja.tuoLinnutJsonTiedostosta();   
        AlkuvalikkoGui alku = new AlkuvalikkoGui(kirja);
        alku.run();
    }
}
