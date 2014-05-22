package viliki.virtuaalinenlintukirja;

import java.io.File;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.gui.KayttoliittymaTxt;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;
import viliki.virtuaalinenlintukirja.gui.Kayttoliittyma;
import java.util.HashMap;


public class Main 
{
    public static void main( String[] args ) throws Exception
    {
Lintukirja kirja = new Lintukirja();
kirja.tuoLinnutJsonTiedostosta();
        System.out.println(kirja.palautaLinnut());
        
        
        //    String path = new File("src\\viliki\\virtuaalinenlintukirja\\tiedostot\\linnut.json").getAbsolutePath();
//    System.out.println(path);
////        JsonAdapteri jSon = new JsonAdapteri();
////        jSon.perusTesti();
////        jSon.kirjoita("src/test.json");
////        jSon.lue("src/test.json");
////        String polku = "VirtuaalinenLintukirja/tiedostot/Linnut.json";
//        Lintukirja kirja = new Lintukirja();
//        kirja.tuoLinnutJsonTiedostosta();
//        HashMap<String, Lintu> lintuset = kirja.palautaLinnut();
//        for (String string : lintuset.keySet()) {
//            System.out.println(lintuset.get(string).getNimi());
//            System.out.println(lintuset.get(string).getLatina());
//            System.out.println(lintuset.get(string).getHeimo());
//            System.out.println(lintuset.get(string).getKuva());
//        }
//        KayttoliittymaTxt kayttis = new KayttoliittymaTxt();
//        kayttis.aloita();
//        Kayttoliittyma gKayttis = new Kayttoliittyma();
//        gKayttis.run();
    }
}
