package viliki.virtuaalinenlintukirja.logiikka;

import java.text.Normalizer;
import java.util.Comparator;

/**
 * Tämä luokka ilmentää lintua. Linnulla on aina nimi, tieteellinen nimi
 * (latinalainen nimi), heimo sekä kuva.
 *
 */
public class Lintu implements Comparator<Lintu> {

    private String nimi;
    private String latina;
    private String heimo;
    private String kuva;
    private String selitys;

    /**
     *
     * @param nimi
     * @param latina
     * @param heimo
     * @param kuva
     */
    public Lintu(String nimi, String latina, String heimo, String kuva) {
        this.nimi = nimi;
        this.latina = latina;
        this.heimo = heimo;
        this.kuva = kuva;
        this.selitys = TyokaluPakki.poistaSkandit(nimi);
    }

    //Setterit
    /**
     *
     * @param nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     *
     * @param latina
     */
    public void setlatina(String latina) {
        this.latina = latina;
    }

    /**
     *
     * @param heimo
     */
    public void setHeimo(String heimo) {
        this.heimo = heimo;
    }

    /**
     *
     * @param kuva
     */
    public void setKuva(String kuva) {
        this.kuva = kuva;
    }

    /**
     *
     * @param selitys
     */
    public void setSelitys(String selitys) {
        this.selitys = selitys;
    }

    //Getterit
    /**
     *
     * @return
     */
    public String getNimi() {
        if (this.nimi.isEmpty()) {
            return "Nimeä ei ole määritelty";
        } else {
            return this.nimi;
        }
    }

    /**
     *
     * @return
     */
    public String getLatina() {
        if (this.latina.isEmpty()) {
            return "Tieteellistä nimeä ei ole määritelty";
        } else {
            return this.latina;
        }
    }

    /**
     *
     * @return
     */
    public String getHeimo() {
        if (this.heimo.isEmpty()) {
            return "Heimoa ei ole määritelty";
        } else {
            return this.heimo;
        }
    }

    /**
     *
     * @return
     */
    public String getKuva() {
        if (this.kuva.isEmpty()) {
            return "Kuvaa ei ole määritelty";
        } else {
            return this.kuva;
        }
    }

    /**
     *
     * @return
     */
    public String getSelitys() {
        if (this.selitys.isEmpty()) {
            return "Selityksen polkua ei ole määritetty";
        } else {
            return this.selitys;
        }
    }

    @Override
    public String toString() {
        String palautus = this.getNimi() + " (" + this.getLatina() + ")";
        return palautus;
    }

    @Override
    public int compare(Lintu lintu1, Lintu lintu2) {
        return lintu1.getNimi().compareToIgnoreCase(lintu2.getNimi());
    }
}
