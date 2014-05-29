/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import viliki.virtuaalinenlintukirja.logiikka.jarjestajat.LinnutAakkosjarjestykseen;


/**
 *
 * @author Eeki
 */
public class LintukirjaTest {
    Lintukirja kirja;
    public LintukirjaTest() {
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
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void lataaLintujaJsonistaTest() throws Exception {       
         kirja.tuoLinnutJsonTiedostosta();
         //Testataan että palautettava Mappi ei ole tyhjä
         assertTrue(0<kirja.palautaLinnutMap().size());
     }
     
     @Test
     public void palautaLinnutAarrayListTest() {
         //Haetaan lintukirjasta ArrayList jossa lintuoliot
         ArrayList<Lintu> lintulista = kirja.palautaLinnutArrayList();
         
         //Luodaan verrattava lintulista
         ArrayList<Lintu> lintulistaVerrattava = new ArrayList<>();
         lintulistaVerrattava.add(new Lintu("Alli","allitus","Allilinnut","alli"));
         lintulistaVerrattava.add(new Lintu("Pikkulokki","lokitus pikkutus","Lokit","pikkulokki.npg"));
         lintulistaVerrattava.add(new Lintu("Punarinta","Punkutus","Punarintaiset","pr.npg"));
         lintulistaVerrattava.add(new Lintu("Naurulokki","lokitus naurutus","Lokit","naurulokki.npg"));
         
         //Varmistetaan että listat ovat samassa järjestyksessä
         LinnutAakkosjarjestykseen järjestäjä = new LinnutAakkosjarjestykseen();
         Collections.sort(lintulista, järjestäjä);
         Collections.sort(lintulistaVerrattava, järjestäjä);
     
         //Verrataan ArrayListoista tehtyjä String primitiiejä keskenään
         assertEquals(lintulistaVerrattava.toString(), lintulista.toString());
     }
     
     
}
