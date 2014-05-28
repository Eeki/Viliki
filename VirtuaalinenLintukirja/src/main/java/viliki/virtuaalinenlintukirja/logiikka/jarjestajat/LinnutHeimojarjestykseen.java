package viliki.virtuaalinenlintukirja.logiikka.jarjestajat;

import java.util.Comparator;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;

public class LinnutHeimojarjestykseen implements Comparator<Lintu> {

    @Override
    public int compare(Lintu lintu1, Lintu lintu2) {
        return lintu1.getHeimo().compareToIgnoreCase(lintu2.getHeimo());
    }
}
