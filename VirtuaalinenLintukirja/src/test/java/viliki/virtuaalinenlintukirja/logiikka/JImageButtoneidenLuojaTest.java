/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.logiikka;

import viliki.virtuaalinenlintukirja.gui.JImageButtoneidenLuoja;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class JImageButtoneidenLuojaTest {

    JImageButtoneidenLuoja luoja;

    public JImageButtoneidenLuojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luoja = new JImageButtoneidenLuoja();
    }

    @After
    public void tearDown() {
    }


    
    @Test
    public void luoImageButtoneitaTest() throws IOException{
        ArrayList<Lintu> linnut= new ArrayList<>();
        linnut.add(new Lintu("a","a","a","a"));
        linnut.add(new Lintu("b","b","b","b"));
       JButton[]  JNappaimet = this.luoja.luoImageButtoneita(linnut);
       assertEquals("a", JNappaimet[0].getActionCommand());
       assertEquals("b", JNappaimet[1].getActionCommand());
    }
}
