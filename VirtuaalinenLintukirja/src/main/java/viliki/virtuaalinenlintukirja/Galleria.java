/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja;

public class Galleria {

    Lintukirja lintukirja;

    public Galleria() {
        this.lintukirja = new Lintukirja();
        System.out.println("Galleria avattu");

    }

    public void printtaaLinnut() {
        for (Lintu lintu : lintukirja.noudaLintuja()) {
            System.out.println(lintu.getNimi());
        }
    }
}
