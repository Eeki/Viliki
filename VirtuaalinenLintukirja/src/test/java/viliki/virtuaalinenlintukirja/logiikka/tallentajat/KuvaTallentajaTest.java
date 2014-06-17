/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka.tallentajat;

import java.io.IOException;
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
public class KuvaTallentajaTest {

    KuvaTallentaja tallentaja;

    public KuvaTallentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tallentaja = new KuvaTallentaja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tallennaKuvaTest() throws IOException {
        assertEquals(true, this.tallentaja.tallennaKuva(this.getClass().getResource("/testit/alliTest.png").getPath(), "kuvaxxx","kuvat"));
    }
}
