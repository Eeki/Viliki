package viliki.virtuaalinenlintukirja.logiikka;

import java.util.ArrayList;
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
public class PeliLogiikkaTest {

    ArrayList<Lintu> linnut;
    Lintukirja kirja;
    PeliLogiikka pelilogiikka;

    public PeliLogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        pelilogiikka = new PeliLogiikka();
        kirja = new Lintukirja("/testit/linnutTest.json");
        kirja.tuoLinnutJsonTiedostosta();
        linnut = kirja.palautaLinnutArrayList();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void sekoitaKierroksenLinnutTest() {
        ArrayList<String> alku = new ArrayList<>();
        for (Lintu lintu : linnut) {
            alku.add(lintu.getNimi());
        }
        ArrayList<String> sekoitettu = pelilogiikka.sekoitaKierroksenLinnut(linnut);
        assertNotSame(sekoitettu, alku);
    }
}
