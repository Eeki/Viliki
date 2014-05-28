package viliki.virtuaalinenlintukirja;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.gui.KayttoliittymaTxt;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;
import viliki.virtuaalinenlintukirja.gui.Kayttoliittyma;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import viliki.virtuaalinenlintukirja.gui.Ruudukko;
import viliki.virtuaalinenlintukirja.logiikka.jarjestajat.LinnutAakkosjarjestykseen;
import viliki.virtuaalinenlintukirja.logiikka.jarjestajat.LinnutHeimojarjestykseen;

public class Main {

    public static void main(String[] args) throws Exception {
        Lintukirja kirja = new Lintukirja();
        kirja.tuoLinnutJsonTiedostosta();
        LinnutAakkosjarjestykseen jarkkariAakkos = new LinnutAakkosjarjestykseen();
        ArrayList<Lintu> tsti = new ArrayList<>();
        tsti = kirja.palautaLinnutArrayList();
        System.out.println(tsti);
        Collections.sort(tsti, jarkkariAakkos);
        System.out.println(tsti);
        LinnutHeimojarjestykseen jarkkariHeimo = new LinnutHeimojarjestykseen();
        Collections.sort(tsti, jarkkariHeimo);
        System.out.println(tsti);

        Ruudukko ruudukko = new Ruudukko(tsti);
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.pack();
        ruudukko.setVisible(true);

        kirja.lisaaLintuJsonTiedostoon(new Lintu("Pöllö","huhuu","pöllöt","pollo.jpg"));
        ArrayList<Lintu> tsti2 = new ArrayList<>();
        tsti2 = kirja.palautaLinnutArrayList();
        System.out.println(tsti2);
        
        //
//        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
//        SwingUtilities.invokeLater(kayttoliittyma);
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
