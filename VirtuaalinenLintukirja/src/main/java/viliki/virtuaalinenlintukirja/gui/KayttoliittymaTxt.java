/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.gui;

import java.util.Scanner;
import viliki.virtuaalinenlintukirja.logiikka.Galleria;
import viliki.virtuaalinenlintukirja.logiikka.Peli;

public class KayttoliittymaTxt {

    private Scanner lukija = new Scanner(System.in);

    public void aloita() {
        System.out.println("Virtuaalinen lintukirja\nkäytettävissä olevat komennot:\n 1 Galleria\n 2 Peli\n x lopeta");
        String komento = "KomentoError";
        while (true) {
            System.out.print("komento: ");
            komento = lukija.nextLine();

            if (komento.equals("1")) {
                aloitaGalleria();
            } else if (komento.equals("2")) {
                aloitaPeli();
            } else if (komento.equals("x")) {
                System.out.println("Moido");
                break;
            }
        }
    }

    public void aloitaGalleria() {
        Galleria galleria = new Galleria();
        System.out.println("Galleria\nkäytettävissä olevat komennot:\n 1 Hae kaikki linnut\n 2 Hae linnun tiedot\n x takaisin");
        String komento = "KomentoError";
        while (true) {
            System.out.print("komento: ");
            komento = lukija.nextLine();

            if (komento.equals("1")) {
                haeLintujenNimet(galleria);
            } else if (komento.equals("2")) {
                haeLinnunTiedot();
            } else if (komento.equals("x")) {
                System.out.println("Virtuaalinen lintukirja\nkäytettävissä olevat komennot:\n 1 Galleria\n 2 Peli\n x lopeta");
                break;
            }
        }
    }

    public void haeLintujenNimet(Galleria galleria) {
        galleria.printtaaLinnut();
    }
    
    public void haeLinnunTiedot(){
        System.out.println("Testing a-haha");
    }

    public void aloitaPeli() {
        Peli peli = new Peli();
    }
}
