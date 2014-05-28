package viliki.virtuaalinenlintukirja.logiikka;

public class Lintu {

    private String nimi;
    private String latina;
    private String heimo;
    private String kuva;

    public Lintu(String nimi, String latina, String heimo, String kuva) {
        this.nimi = nimi;
        this.latina = latina;
        this.heimo = heimo;
        this.kuva = kuva;
    }

    //Setterit
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setlatina(String latina) {
        this.latina = latina;
    }

    public void setHeimo(String heimo) {
        this.heimo = heimo;
    }

    public void setKuva(String kuva) {
        this.kuva = kuva;
    }

    //Getterit
    public String getNimi() {
        if (this.nimi.isEmpty()) {
            return "Nimeä ei ole määritelty";
        } else {
            return this.nimi;
        }
    }

    public String getLatina() {
        if (this.latina.isEmpty()) {
            return "Latinalaista nimeä ei ole määritelty";
        } else {
            return this.latina;
        }
    }

    public String getHeimo() {
        if (this.heimo.isEmpty()) {
            return "Heimoa ei ole määritelty";
        } else {
            return this.heimo;
        }
    }

    public String getKuva() {
        if (this.kuva.isEmpty()) {
            return "Kuvaa ei ole määritelty";
        } else {
            return this.kuva;
        }
    }

    @Override
    public String toString() {
        String palautus = this.getNimi() + " (" + this.getLatina() + ")";
        return palautus;
    }
}
