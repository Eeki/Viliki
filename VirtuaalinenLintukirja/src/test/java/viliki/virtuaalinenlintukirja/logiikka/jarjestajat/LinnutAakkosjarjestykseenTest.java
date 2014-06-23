///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package viliki.virtuaalinenlintukirja.logiikka.jarjestajat;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import viliki.virtuaalinenlintukirja.logiikka.Lintu;
//
///**
// *
// * @author Eeki
// */
//public class LinnutAakkosjarjestykseenTest {
//
//    LinnutAakkosjarjestykseen jarjestaja;
//
//    public LinnutAakkosjarjestykseenTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        jarjestaja = new LinnutAakkosjarjestykseen();
//    }
//
//    @After
//    public void tearDown() {
//    }
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//
//    @Test
//    public void LinnutAakkosjarjestykseenTest() {
//        ArrayList<Lintu> linnut1 = new ArrayList<Lintu>();
//        ArrayList<Lintu> linnut2 = new ArrayList<Lintu>();
//
//        linnut1.add(new Lintu("Alli", "allitus", "Allilinnut", "alli"));
//        linnut1.add(new Lintu("Pikkulokki", "lokitus pikkutus", "Lokit", "pikkulokki.npg"));
//        linnut1.add(new Lintu("Punarinta", "Punkutus", "Punarintaiset", "pr.npg"));
//        linnut1.add(new Lintu("Naurulokki", "lokitus naurutus", "Lokit", "naurulokki.npg"));
//
//        linnut2.add(new Lintu("Punarinta", "Punkutus", "Punarintaiset", "pr.npg"));
//        linnut2.add(new Lintu("Naurulokki", "lokitus naurutus", "Lokit", "naurulokki.npg"));
//        linnut2.add(new Lintu("Pikkulokki", "lokitus pikkutus", "Lokit", "pikkulokki.npg"));
//        linnut2.add(new Lintu("Alli", "allitus", "Allilinnut", "alli"));
//
//        Collections.sort(linnut1,jarjestaja);
//        Collections.sort(linnut2,jarjestaja);
//        assertEquals(linnut1.toString(), linnut2.toString());
//    }
//}
