
package viliki.virtuaalinenlintukirja.logiikka;

import javax.swing.JOptionPane;

public class ErrorPopUp {
    
    public static void popUpErrori(String viesti, String sijainti)
    {
        JOptionPane.showMessageDialog(null, viesti, "ErrorBox: " + sijainti, JOptionPane.INFORMATION_MESSAGE);
    }
}
    

