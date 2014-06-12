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

/**
 *
 * @author Eeki
 */
public class TyokaluPakkiTest {
    
    public TyokaluPakkiTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void poistaSkanditTest() {
         assertEquals("ao", TyokaluPakki.poistaSkandit("äö"));
     }
     
     @Test
     public void kuvaFormaattiTest() {
         assertEquals("png", TyokaluPakki.kuvaFormaatti("kuva.png"));
         assertEquals("gif", TyokaluPakki.kuvaFormaatti("kuva.gif"));
         assertEquals("jpg", TyokaluPakki.kuvaFormaatti("kuva.jpg"));
         assertEquals("jpg", TyokaluPakki.kuvaFormaatti("kuva.xxx"));
         
     }
     
     @Test
     public void popUpViestiTest() {
         assertTrue(TyokaluPakki.popUpViesti("testiviesti... paina ok", "testit"));
     }
}
