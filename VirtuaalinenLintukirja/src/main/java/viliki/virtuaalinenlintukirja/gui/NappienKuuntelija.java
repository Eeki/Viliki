
package viliki.virtuaalinenlintukirja.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class NappienKuuntelija implements ActionListener {
    
    private ArrayList<JButton> napit;
    
    public NappienKuuntelija(ArrayList<JButton> napit) {
    this.napit = napit;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
