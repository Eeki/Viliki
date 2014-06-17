package viliki.virtuaalinenlintukirja.gui;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

/**
 *
 * Luokka luo linnuista ruudukon jonka  
 */
public class RuudukkoGui extends javax.swing.JFrame {

    private Lintukirja kirja;
    private ArrayList<Lintu> linnut;
    private JImageButtoneidenLuoja JbuttonLuoja;

    /**
     *
     * @param kirja
     * @throws IOException
     */
    public RuudukkoGui(Lintukirja kirja) throws IOException {
        this.kirja = kirja;
        this.linnut = this.kirja.palautaLinnutArrayList();
        JbuttonLuoja = new JImageButtoneidenLuoja();

    }

    /**
     *
     * @throws IOException
     */
    public void luoRuudukko() throws IOException {
//        Container panel = getContentPane();
//        
//        panel.setLayout(new GridLayout(3, linnut.size()/3));
//        JScrollPane rullattava = new JScrollPane(panel);
//        for (JButton jButton : JbuttonLuoja.luoImageButtoneita(linnut)) {
//            panel.add(jButton);
//            revalidate();
//        }
//        validate();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, linnut.size() * 320/3));
        panel.setMinimumSize(new Dimension(1000, linnut.size() * 320/3));
        JScrollPane scrollFrame = new JScrollPane(panel);
        panel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(1000, 1000));
        this.add(scrollFrame);
        
        for (JButton jButton : JbuttonLuoja.luoImageButtoneita(linnut)) {
            panel.add(jButton);
            revalidate();
        }
        
        
        
    }
}