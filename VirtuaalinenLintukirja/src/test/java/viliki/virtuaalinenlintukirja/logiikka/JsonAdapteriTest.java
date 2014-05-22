
package viliki.virtuaalinenlintukirja.logiikka;

import java.io.File;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viliki.virtuaalinenlintukirja.logiikka.JsonAdapteri;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

/**
 *
 * @author Eeki
 */
public class JsonAdapteriTest {
    JsonAdapteri adapteri = new JsonAdapteri();
//    File lahde = new File(getClass().getResource("/viliki/virtuaalinenlintukirja/tiedostot/linnutTest.json").getFile());
    
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
    }

    @After
    public void tearDown() {
    }
   
    
    @Test
    public void tuoLinnutTiedostostaTest() throws Exception {     
        String haettuJsonTeksti = adapteri.tuoLinnutTiedostosta("c:\\test\\linnut2.json"); //lahde.getPath()
        assertEquals("{\"linnut\":[{\"heimo\":\"Allilinnut\",\"nimi\":\"Alli\",\"latina\":\"allitus\",\"kuva\":\"alli.npg\"},{\"heimo\":\"Lokit\",\"nimi\":\"Pikkulokki\",\"latina\":\"lokitus pikkutus\",\"kuva\":\"pikkulokki.npg\"},{\"heimo\":\"Punarintaiset\",\"nimi\":\"Punarinta\",\"latina\":\"Punkutus\",\"kuva\":\"pr.npg\"},{\"heimo\":\"Lokit\",\"nimi\":\"Naurulokki\",\"latina\":\"lokitus naurutus\",\"kuva\":\"naurulokki.npg\"}]}",haettuJsonTeksti);
    }
    
    @Test
    public void tuoLinnuistaHashmapTest() throws Exception {
        HashMap<String, Lintu> lintumappi = new HashMap<String,Lintu>();
        lintumappi = adapteri.tuoLinnuistaHashMap("c:\\test\\linnut2.json");
        assertEquals("[Punarinta, Pikkulokki, Alli, Naurulokki]",lintumappi.keySet().toString());
        assertEquals("Punkutus", lintumappi.get("Punarinta").getLatina());
    }
}
