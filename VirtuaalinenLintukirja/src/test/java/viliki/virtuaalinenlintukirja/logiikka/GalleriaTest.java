package viliki.virtuaalinenlintukirja.logiikka;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GalleriaTest {

    Galleria galleria;
    Lintukirja kirja = new Lintukirja("/testit/linnutTestGalleria.json");

    public GalleriaTest() {
        galleria = new Galleria(kirja);
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
    public void avaaGalleriaNakyma() throws IOException {
        this.galleria.avaaGalleriaNakyma();
        assertEquals("", "");
        //tähän pitäisi sitten keksiä testejä...
    }
}
