/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

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
public class TekstinLukijaTest {
    TekstinLukija lukija = new TekstinLukija();
    public TekstinLukijaTest() {
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
     public void lueTekstiTest() throws IOException {
     String teksti = this.lukija.lueTeksti("/testit/testiTXT.txt");
     String oikeaVastaus = "";
     assertEquals(oikeaVastaus, teksti);
     }
}
