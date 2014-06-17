package viliki.virtuaalinenlintukirja.logiikka.jarjestajat;

import java.util.Comparator;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

/**
 *
 * Apuluokka joka järjestää lintu oliot aakkosjärjestykseen
 */
public class LinnutAakkosjarjestykseen implements Comparator<Lintu> {

    @Override
    public int compare(Lintu lintu1, Lintu lintu2) {
        return lintu1.getNimi().compareToIgnoreCase(lintu2.getNimi());
    }
}
