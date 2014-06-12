/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka.Lataajat;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

/**
 *
 * @author Eeki
 */
public class LinnunTietojenLatainTest {
    LinnunTietojenLatain latain;
    public LinnunTietojenLatainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        latain = new LinnunTietojenLatain();
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void lataaKuvaTest() throws IOException {
         Lintu lintu = new Lintu("Alli","aaa","aaa","alliTest.png");
         BufferedImage kuva = latain.lataaKuva(lintu, "testit");
         assertTrue(kuva.getHeight() == 240);    
     }
     
     @Test
     public void lataaSelitysTest() throws IOException {
         assertEquals("", latain.lataaSelitys(new Lintu("testiTXT", "", "", "alli.png"), "testit"));
     }
     @Test
     public void lataaSitysVaarinTest() throws IOException {
         assertEquals("Linnulla ei selitystä", latain.lataaSelitys(new Lintu("asasasas", "", "", ""), "testit"));
     }
}
