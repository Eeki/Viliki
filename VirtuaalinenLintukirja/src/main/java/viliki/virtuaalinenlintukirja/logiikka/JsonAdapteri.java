package viliki.virtuaalinenlintukirja.logiikka;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonAdapteri {

    public String tuoLinnutTiedostosta(String mista) throws Exception {

        JSONParser parser = new JSONParser();
        String jsonTeksti = "Tiedostoa ei saatu haettua";
        try {
            Object kokoTiedosto = parser.parse(new FileReader(mista));
            JSONObject jsonObject = (JSONObject) kokoTiedosto;
            StringWriter jsonKirjoittaja = new StringWriter();
            jsonObject.writeJSONString(jsonKirjoittaja);
            jsonTeksti = jsonKirjoittaja.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonTeksti;
    }

    public HashMap<String, Lintu> tuoLinnuistaHashMap(String mista) throws Exception {
        //Luodaan palautettava HashMap joka sisältää lintu olioita sekä haetaan JSONArray muodossa linnut JSON tiedostosta
        HashMap<String, Lintu> palautettava = new HashMap<String, Lintu>();
        JSONArray linnutLista = haeLinnutArray(mista);

        //haetaan linnutListalta kaikki linnut ja kirjoitetaan niiden parametrit yksikerrallaan lintu olioihin
        for (int i = 0; i < linnutLista.size(); i++) {
            JSONObject alaLista = (JSONObject) linnutLista.get(i);
            String nimi = (String) alaLista.get("nimi");
            String latina = (String) alaLista.get("latina");
            String heimo = (String) alaLista.get("heimo");
            String kuva = (String) alaLista.get("kuva");
            palautettava.put(nimi, new Lintu(nimi, latina, heimo, kuva));
        }

        return palautettava;
    }

    public void lisaaLintuTiedostoon(Lintu lintu, String lahde) throws Exception {
        //haetaan Linnut sisältävä JSON tiedosto ja tehdään JSONArray olio, jonne kirjoitetaan linnut sisällään pitävä lista
        JSONArray linnutLista = haeLinnutArray(lahde);

        //Luodaan lisattava lintu lintu olion parametreistä
        JSONObject lisattavaLintu = new JSONObject();
        lisattavaLintu.put("nimi", lintu.getNimi());
        lisattavaLintu.put("latina", lintu.getLatina());
        lisattavaLintu.put("heimo", lintu.getHeimo());
        lisattavaLintu.put("kuva", lintu.getKuva());
        linnutLista.add(lisattavaLintu);

        //Luodaan tyhjä JSON objekti jonne lisätäään luotu lista
        JSONObject valmisJSON = new JSONObject();
        valmisJSON.put("linnut", linnutLista);

        //Testaa onko lisattava lintu jo listalla
        if (onkoTalletettavaLintuJSONTiedostossa(lisattavaLintu, lahde)) {
            kirjoitaJSONTiedostoon(valmisJSON, lahde);
        } else {
            System.out.println("Antamasi linnun nimi tai kuvan nimi on jo käytössä. Anna toinen nimi tai uudelleen nimeä kuvasi");
        }

    }

    private void kirjoitaJSONTiedostoon(JSONObject JSONOlio, String lahde) {
        try {
            FileWriter file = new FileWriter(lahde);
            file.write(JSONOlio.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean onkoTalletettavaLintuJSONTiedostossa(JSONObject talletettavaJSON, String lahde) throws Exception {
        JSONArray linnutLista = haeLinnutArray(lahde);

        for (int i = 0; i < linnutLista.size(); i++) {
            JSONObject alaLista = (JSONObject) linnutLista.get(i);
            if (alaLista.get("nimi").equals(talletettavaJSON.get("nimi")) || alaLista.get("kuva").equals(talletettavaJSON.get("kuva"))) {
                return false;
            }
        }
        return true;
    }

    private JSONArray haeLinnutArray(String lahde) throws Exception {
        JSONArray linnutLista = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            Object kokoTiedosto = parser.parse(tuoLinnutTiedostosta(lahde));
            JSONObject jsonObject = (JSONObject) kokoTiedosto;
            linnutLista = (JSONArray) jsonObject.get("linnut");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return linnutLista;
    }
}
