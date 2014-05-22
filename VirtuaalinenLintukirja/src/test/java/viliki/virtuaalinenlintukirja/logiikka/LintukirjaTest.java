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
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

/**
 *
 * @author Eeki
 */
public class LintukirjaTest {
    
    public LintukirjaTest() {
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
     public void lataaLintujaJsonista() throws Exception {
         Lintukirja kirja = new Lintukirja();
         kirja.tuoLinnutJsonTiedostosta();
         assertTrue(0<kirja.palautaLinnut().size());
         
     }
     
     
}
