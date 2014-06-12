package viliki.virtuaalinenlintukirja.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import viliki.virtuaalinenlintukirja.logiikka.JImageButtoneidenLuoja;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.logiikka.Lintukirja;

public class RuudukkoGui extends javax.swing.JFrame {

    private Lintukirja kirja;
    private ArrayList<Lintu> linnut;
    private JImageButtoneidenLuoja JbuttonLuoja;

    public RuudukkoGui(Lintukirja kirja) throws IOException {
        this.kirja = kirja;
        this.linnut = this.kirja.palautaLinnutArrayList();
        JbuttonLuoja = new JImageButtoneidenLuoja();

    }

    public void luoRuudukko() throws IOException {
        Container panel = getContentPane();
        panel.setLayout(new GridLayout(3, linnut.size()/3));

        for (JButton jButton : JbuttonLuoja.luoImageButtoneita(linnut)) {
            panel.add(jButton);
        }
        validate();
    }
}