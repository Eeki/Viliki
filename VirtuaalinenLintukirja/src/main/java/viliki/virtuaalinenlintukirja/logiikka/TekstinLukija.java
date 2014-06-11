package viliki.virtuaalinenlintukirja.logiikka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Tekstinlukija lukee .txt tiedostoja ja palauttaa siitä String:in
 *
 */
public class TekstinLukija {

    /**
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String lueTeksti(String file) throws IOException {
        try {
            File lahdeTiedosto = new File(getClass().getResource(file).getFile());
            BufferedReader reader = new BufferedReader(new FileReader(lahdeTiedosto.getPath()));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();

        } catch (NullPointerException ex) {
            return "Linnulla ei selitystä";
        }
    }
}
