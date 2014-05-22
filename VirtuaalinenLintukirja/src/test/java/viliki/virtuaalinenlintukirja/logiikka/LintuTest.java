/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

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
public class LintuTest {
    Lintu lintu;
    
    public LintuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    lintu = new Lintu("Käki","Cuculus canorus","Käet","kaki.png");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // 
     @Test
     public void luoLintu() {
         assertEquals("Käki",lintu.getNimi());
         assertEquals("Cuculus canorus",lintu.getLatina());
         assertEquals("Käet",lintu.getHeimo());
         assertEquals("kaki.png",lintu.getKuva());
     }
     @Test
     public void muutaLinnunTietoja() {
         lintu.setNimi("Kalalokki");
         lintu.setlatina("Larus canus");
         lintu.setHeimo("Lokit");
         lintu.setKuva("kalalokki.png");
         assertEquals("Kalalokki",lintu.getNimi());
         assertEquals("Larus canus",lintu.getLatina());
         assertEquals("Lokit",lintu.getHeimo());
         assertEquals("kalalokki.png",lintu.getKuva());
     }
     
     @Test
     public void toStringMetodiToimii() {
         assertEquals("Käki (Cuculus canorus)",lintu.toString());
     }
}