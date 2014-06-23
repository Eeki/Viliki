///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package viliki.virtuaalinenlintukirja.logiikka.jarjestajat;
//
//import java.util.ArrayList;
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
//public class LinnutHeimojarjestykseenTest {
//
//    LinnutHeimojarjestykseen jarjestaja;
//
//    public LinnutHeimojarjestykseenTest() {
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
//        jarjestaja = new LinnutHeimojarjestykseen();
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void LinnutHeimojarjestykseenTest() {
//        ArrayList<Lintu> linnut1 = new ArrayList<Lintu>();
//        ArrayList<Lintu> linnut2 = new ArrayList<Lintu>();
//
//        linnut1.add(new Lintu("Alli", "allitus", "Allilinnut", "alli.png"));
//        linnut1.add(new Lintu("Pikkulokki", "lokitus pikkutus", "Pikut", "pikkulokki.npg"));
//        linnut1.add(new Lintu("Punarinta", "Punkutus", "Punarintaiset", "pr.npg"));
//        linnut1.add(new Lintu("Naurulokki", "lokitus naurutus", "Lokit", "naurulokki.npg"));
//
//        linnut2.add(new Lintu("Punarinta", "Punkutus", "Punarintaiset", "pr.npg"));
//        linnut2.add(new Lintu("Naurulokki", "lokitus naurutus", "Lokit", "naurulokki.npg"));
//        linnut2.add(new Lintu("Pikkulokki", "lokitus pikkutus", "Pikut", "pikkulokki.npg"));
//        linnut2.add(new Lintu("Alli", "allitus", "Allilinnut", "alli.png"));
//
//        Collections.sort(linnut1,jarjestaja);
//        Collections.sort(linnut2,jarjestaja);
//        assertEquals(linnut1.toString(), linnut2.toString());
//    }
//}
