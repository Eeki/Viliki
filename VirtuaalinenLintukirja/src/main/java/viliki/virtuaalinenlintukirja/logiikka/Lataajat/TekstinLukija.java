package viliki.virtuaalinenlintukirja.logiikka.Lataajat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tekstinlukija lukee .txt tiedostoja ja palauttaa siitä String:in
 *
 */
public class TekstinLukija {

    /**
     *
     * @param tiedostonimi 
     * @param String tiedostonimi
     * @return String .txt tiedoston siältö
     * @throws IOException jos metodi heittää virheen, se palauttaa string:n
     * "Linnulla ei selitystä"
     */
    public String lueTeksti(String tiedostonimi) throws IOException {
        try {
            File lahdeTiedosto = new File(tiedostonimi);
//            BufferedReader reader = new BufferedReader(new FileReader(lahdeTiedosto.getPath()));
            BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(lahdeTiedosto), "UTF-8"));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();

        } catch (Exception ex) {
            return "Linnulla ei selitystä";
        }
    }
}
