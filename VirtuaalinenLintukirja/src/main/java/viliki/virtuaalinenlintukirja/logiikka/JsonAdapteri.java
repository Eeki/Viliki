package viliki.virtuaalinenlintukirja.logiikka;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonAdapteri {

//    public void kirjoita(String polku) {
//
//        JSONObject objekti = new JSONObject();
//        objekti.put("nimi", "Eeki");
//        objekti.put("ika", new Integer(100));
//
//        JSONArray lista = new JSONArray();
//        lista.add("moikkaus 1");
//        lista.add("moikkaus 2");
//        lista.add("moikkaus 3");
//
//        objekti.put("message", lista);
//        System.out.println(objekti);
//        try {
//            FileWriter file = new FileWriter(polku);
//            file.write(objekti.toJSONString());
//            file.flush();
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////       "src/testitiedosto.txt"
//    }
//
//    public void lue(String polku) throws Exception {
//
//        JSONParser parser = new JSONParser();
//
//        try {
//
//            Object obj = parser.parse(new FileReader(polku));
//
//            JSONObject jsonObject = (JSONObject) obj;
//
//            String name = (String) jsonObject.get("nimi");
//            System.out.println(name);
//
//            long age = (Long) jsonObject.get("ika");
//            System.out.println(age);
//
//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("message");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
    public String tuoLinnutTiedostosta(String mista) throws Exception {
        JSONParser parser = new JSONParser();
        String jsonTeksti ="Tiedostoa ei saatu haettua";
        try {
            Object kokoTiedosto = parser.parse(new FileReader(mista)); //"c:\\test\\linnut2.json"
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
        HashMap<String, Lintu> palautettava = new HashMap<String, Lintu>();
        JSONParser parser = new JSONParser();

        try {        
            Object kokoTiedosto = parser.parse(tuoLinnutTiedostosta(mista));
            JSONObject jsonObject = (JSONObject) kokoTiedosto;
            JSONArray linnutLista = (JSONArray) jsonObject.get("linnut");

            for (int i = 0; i < linnutLista.size(); i++) {
                JSONObject alaLista = (JSONObject) linnutLista.get(i);
                String nimi = (String) alaLista.get("nimi");
                String latina = (String) alaLista.get("latina");
                String heimo = (String) alaLista.get("heimo");
                String kuva = (String) alaLista.get("kuva");
                palautettava.put(nimi, new Lintu(nimi, latina, heimo, kuva));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return palautettava;
    }

    public void lisaaLintuTiedoston(Lintu lintu) {
        JSONObject lisattavaLintu = new JSONObject();
        lisattavaLintu.put("nimi", lintu.getNimi());
        lisattavaLintu.put("latina", lintu.getLatina());
        lisattavaLintu.put("heimo", lintu.getHeimo());
        lisattavaLintu.put("kuva", lintu.getKuva());
    }
}
