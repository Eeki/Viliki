package viliki.virtuaalinenlintukirja.logiikka;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GalleriaTest {

    Galleria galleria;
    Lintukirja kirja;
    ArrayList<Lintu> linnut;

    public GalleriaTest() {
        galleria = new Galleria();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        kirja = new Lintukirja("/testit/linnutTest.json");
        kirja.tuoLinnutJsonTiedostosta();
        linnut = kirja.palautaLinnutArrayList();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void jarjestaGalleriaAakkosTest() throws IOException {
        linnut = galleria.jarjestaGalleriaAakkos(linnut);
        assertEquals("[Alli (allitus), Naurulokki (lokitus naurutus), Pikkulokki (lokitus pikkutus), Punarinta (Punkutus)]", linnut.toString());

    }
    
    @Test
    public void jarjestaGalleriaHeimoTest() {
        linnut = galleria.jarjestaGalleriaHeimo(linnut);
        assertEquals("[Alli (allitus), Pikkulokki (lokitus pikkutus), Naurulokki (lokitus naurutus), Punarinta (Punkutus)]", linnut.toString());
    }
}
