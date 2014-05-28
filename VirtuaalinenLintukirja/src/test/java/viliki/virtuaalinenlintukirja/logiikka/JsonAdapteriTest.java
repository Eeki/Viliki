package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eeki
 */
public class JsonAdapteriTest {

    JsonAdapteri adapteri;

    public JsonAdapteriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        adapteri = new JsonAdapteri();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void tuoLinnutTiedostostaTest() throws Exception {
        String haettuJsonTeksti = adapteri.tuoLinnutTiedostosta(luotiedostoViite("/testit/linnutTest.json"));
        System.out.println(haettuJsonTeksti);
        assertEquals("{\"linnut\":[{\"heimo\":\"Allilinnut\",\"nimi\":\"Alli\",\"latina\":\"allitus\",\"kuva\":\"alli.npg\"},{\"heimo\":\"Lokit\",\"nimi\":\"Pikkulokki\",\"latina\":\"lokitus pikkutus\",\"kuva\":\"pikkulokki.npg\"},{\"heimo\":\"Punarintaiset\",\"nimi\":\"Punarinta\",\"latina\":\"Punkutus\",\"kuva\":\"pr.npg\"},{\"heimo\":\"Lokit\",\"nimi\":\"Naurulokki\",\"latina\":\"lokitus naurutus\",\"kuva\":\"naurulokki.npg\"}]}", haettuJsonTeksti);
    }

    @Test
    public void tuoLinnuistaHashmapTest() throws Exception {
        HashMap<String, Lintu> lintumappi = new HashMap<String, Lintu>();
        lintumappi = adapteri.tuoLinnuistaHashMap(luotiedostoViite("/testit/linnutTest.json"));
        assertEquals("[Punarinta, Pikkulokki, Alli, Naurulokki]", lintumappi.keySet().toString());
        assertEquals("Punkutus", lintumappi.get("Punarinta").getLatina());
    }
    
    @Test
    public void lisaaLintuTiedostoonTest() throws Exception {
        
        // Luodaan verrattavat int primitiivit
        int JSONTiedostonPituusEnnenLisaysta;
        int JSONTiedostonPituusLisayksenJalkeen;
        
        // Luodaan mappi
        HashMap<String,Lintu> lintuMappi = new HashMap<String,Lintu>();
        
        //Tuodaan JSON ennen lisäystä ja tallennetaan sen koko
        lintuMappi = adapteri.tuoLinnuistaHashMap(luotiedostoViite("/testit/linnutTestLisaaLintu.json"));
        System.out.println("Ennen lisäystä: "+lintuMappi);
        JSONTiedostonPituusEnnenLisaysta = lintuMappi.size();
        
        //Lisätään lintu. Nimeen tulee numero JSON tiedoston koon mukaan, joten voi tehdä useita testejä peräkkäin
        adapteri.lisaaLintuTiedostoon(new Lintu("Pulu"+lintuMappi.size(),"lentäväRotta","pulut","pulu"+lintuMappi.size()+".jpg"), luotiedostoViite("/testit/linnutTestLisaaLintu.json"));
        
        //Tuodaan JSON lisäyksen jälkeen ja tallennetaan sen koko
        lintuMappi = adapteri.tuoLinnuistaHashMap(luotiedostoViite("/testit/linnutTestLisaaLintu.json"));
        JSONTiedostonPituusLisayksenJalkeen = lintuMappi.size();
        System.out.println("Lisäyksen jälkeen: " + lintuMappi);
        
        //Testataan onko JSON isompi kun siihen on lisätty yksi lintu, jos on testi läpi.
        assertTrue(JSONTiedostonPituusEnnenLisaysta<JSONTiedostonPituusLisayksenJalkeen);
        
    }
    
    private String luotiedostoViite(String lahde) {
        File lahdeTiedosto = new File(getClass().getResource(lahde).getFile());
        return lahdeTiedosto.getPath();
    }
}
