package viliki.virtuaalinenlintukirja.logiikka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Luokka TiedostojenKopijoija kopioi tiedostoja
 *
 * @author Eeki
 */
public class TiedostojenKopioija {

    Lintukirja lintukirja;

    /**
     * Luo tyhjiä kansioita
     *
     * @param polku luotavan kansion nimi ja sijainti
     */
    public void luotyhjatKansiotJuureen(String polku) {
        File resKansio = new File(polku);

        // Jos kansiota ei ole, se luodaan
        if (!resKansio.exists()) {
            System.out.println("Luodaan tiedostoa: " + resKansio);
            boolean onkoKansiotaOlemassa = false;

            try {
                resKansio.mkdir();
                onkoKansiotaOlemassa = true;
            } catch (SecurityException se) {
            }
            if (onkoKansiotaOlemassa) {
                System.out.println(resKansio + " kansio luotu");
            }
        }
    }

    public void lataaJsonTiedotoKopioijaan() throws Exception {
        lintukirja = new Lintukirja("Resources/JSON/linnut.json");
        lintukirja.tuoLinnutJsonTiedostosta();
    }

    /**
     * Luo Jar tiedston juureen tyhjiä kansioita, joihin tallennetaan kuvat,
     * selitykset ja json
     */
    public void luoKuvatSelityksetJaJsonKansiot() {
        luotyhjatKansiotJuureen("Resources");
        luotyhjatKansiotJuureen("Resources/kuvat");
        luotyhjatKansiotJuureen("Resources/selitykset");
        luotyhjatKansiotJuureen("Resources/JSON");
    }

    /**
     * kopioi Jar tiedoston resources kansioon tallennetut lintujen kuvat Jar
     * tiedsoton sijaintikansioon luotuihin alakansioihin
     */
    public void siirraKuvatUlosJarTiedostosta() {
        ArrayList<Lintu> linnut = new ArrayList<>();
        linnut = lintukirja.palautaLinnutArrayList();

        for (Lintu lintu : linnut) {
            try {
                System.out.println(lintu);
                kopioiKuvaUlosJarResourcesTiedostosta("/kuvat/" + lintu.getKuva(), "Resources/kuvat/" + lintu.getKuva());
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Linnun kuvaa " + lintu.getKuva() + " ei tallennettu " + ",koska: " + e);
            }
        }
        //Lopuksi lisätään kuvat-kansioon Helmipöllön suuri kuva jota käytetään alkuvalikossa. Onhan tämä tapa vähän kökkö mutta ajan loppuessa nopea.
        Lintu varpuspollo = new Lintu("varpuspolloAlku", "", "", "varpuspolloAlku.png");
        kopioiKuvaUlosJarResourcesTiedostosta("/kuvat/" + varpuspollo.getKuva(), "Resources/kuvat/" + varpuspollo.getKuva());
    }

    /**
     * Kopioi Jar tiedoston resources kansioon tallennetut lintujen selitykset
     * Jar tiedsoton sijaintikansioon luotuihin alakansioihin
     */
    public void siirraSelityksetUlosJarTiedostosta() {
        ArrayList<Lintu> linnut = new ArrayList<>();
        linnut = lintukirja.palautaLinnutArrayList();

        for (Lintu lintu : linnut) {
            try {
                kopioiTekstiUlosJarResourcesTiedostosta("/selitykset/" + lintu.getNimi() + ".txt", "Resources/selitykset/" + lintu.getNimi() + ".txt");
            } catch (Exception e) {
                System.out.println("Linnun selitystä " + lintu.getNimi() + " ei tallennettu" + " ,koska: " + e);
            }
        }

    }

    /**
     * Hoitaa tiedostojen kopioimisen
     *
     * @param lahde kopioitavan tiedsoton sijainti
     * @param maaranpaa minne kopioitava tiedosto tallennetaan
     */
    public void kopioiKuvaUlosJarResourcesTiedostosta(String lahde, String maaranpaa) {
        File kohdeTiedosto = new File(maaranpaa);
        if (kohdeTiedosto.exists()) {
            System.out.println("Tiedosto " + kohdeTiedosto.getPath() + " on jo tallennettuna");
        } else {

            try {
                OutputStream ulosTallennus;
                try (InputStream sisaanVirta = this.getClass().getResourceAsStream(lahde)) {
                    ulosTallennus = new FileOutputStream(kohdeTiedosto);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = sisaanVirta.read(buf)) > 0) {
                        ulosTallennus.write(buf, 0, len);
                    }
                }
                System.out.println("Tiedosto " + ulosTallennus.toString());
                ulosTallennus.close();
                System.out.print(" tallennettu");
            } catch (FileNotFoundException ex) {
                TyokaluPakki.popUpViesti("Json tiedostoa ei saatu siirrettyä ulos jar tiedostosta. Kokeile siirrää Jar tiedosto henkilökohtaiseen kansioon ja avaa uudelleen", "Json tiedoston siirto");
            } catch (IOException e) {
                TyokaluPakki.popUpViesti("Json tiedostoa ei saatu siirrettyä ulos jar tiedostosta. Kokeile siirrää Jar tiedosto henkilökohtaiseen kansioon ja avaa uudelleen", "Json tiedoston siirto");
            }
        }
    }

    public void kopioiTekstiUlosJarResourcesTiedostosta(String lahde, String kohde) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        File kohdeTiedosto = new File(kohde);
        System.out.println("lahde: " + lahde);
        System.out.println("kohde: " + kohde);

        BufferedReader sisaan = null;
        BufferedWriter ulos = null;
        try (InputStream sisaanVirta = this.getClass().getResourceAsStream(lahde)) {
            // Avaa kopioitavan tiedoston 
            sisaan = new BufferedReader(new InputStreamReader(sisaanVirta, "UTF8"));
            // kopioi sen kohteeseen
            ulos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(kohdeTiedosto, true), "UTF8"));
                String line = null;
        while ((line = sisaan.readLine()) != null) {
            ulos.write(line);
            ulos.newLine();
        
        }
        }
        sisaan.close();
        ulos.close();
    }
}
