/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viliki.virtuaalinenlintukirja.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import viliki.virtuaalinenlintukirja.logiikka.LinnunTietojenLatain;
import viliki.virtuaalinenlintukirja.logiikka.Lintu;
import viliki.virtuaalinenlintukirja.logiikka.PeliLogiikka;

public class PeliGui extends javax.swing.JFrame {

    PeliLogiikka logiikka;
    ArrayList<Lintu> linnut;
    int pisteet;
    int kierrokset;
    ArrayList<String> kierroksenLinnut;
    LinnunTietojenLatain latain;

    public PeliGui(ArrayList<Lintu> linnut) throws IOException {
        initComponents();
        this.logiikka = new PeliLogiikka();
        this.linnut = linnut;
        this.latain = new LinnunTietojenLatain();
        alustaPeli();
    }

    private void alustaPeli() throws IOException {
        this.pisteet = 0;
        this.kierrokset = 0;
        paivitaKierroksetPisteetJaKuva();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arvattavaLintuKuva = new javax.swing.JLabel();
        kierroksetTeksti = new javax.swing.JLabel();
        pisteetTeksti = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        vastausKentta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arvattavaLintuKuva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuvat/alli.png"))); // NOI18N

        kierroksetTeksti.setText("Kierrokset:");

        pisteetTeksti.setText("Pisteet: ");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        vastausKentta.setText("Kirjoita vastaus tähän ja klikkaa OK...");
        vastausKentta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vastausKenttaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kierroksetTeksti)
                    .addComponent(arvattavaLintuKuva, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pisteetTeksti)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(OKButton))
                    .addComponent(vastausKentta, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arvattavaLintuKuva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vastausKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(pisteetTeksti)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(kierroksetTeksti))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        try {
            tarkistaOikeaVastaus();
        } catch (IOException ex) {
            Logger.getLogger(PeliGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OKButtonActionPerformed

    private void vastausKenttaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vastausKenttaMouseClicked
        if(this.vastausKentta.getText().equals("Kirjoita vastaus tähän ja klikkaa OK...")) {
            this.vastausKentta.setText("");
        }
    }//GEN-LAST:event_vastausKenttaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel arvattavaLintuKuva;
    private javax.swing.JLabel kierroksetTeksti;
    private javax.swing.JLabel pisteetTeksti;
    private javax.swing.JTextField vastausKentta;
    // End of variables declaration//GEN-END:variables

    private void tarkistaOikeaVastaus() throws IOException {
        String vastaus;
        vastaus = this.vastausKentta.getText();
        System.out.println(linnut.get(this.kierrokset).getNimi());

        if (vastaus.equals(linnut.get(this.kierrokset).getNimi())) {
            oikeaVastaus();
        } else {
            vaaraVastaus();
        }
    }

    private void oikeaVastaus() throws IOException {
        System.out.println("oikea vastaus");
        this.kierrokset++;
        this.pisteet++;
        this.vastausKentta.setText("");
        paivitaKierroksetPisteetJaKuva();
    }

    private void vaaraVastaus() throws IOException {
        System.out.println("Väärä vastaus");
        this.kierrokset++;
        this.vastausKentta.setText("");
        paivitaKierroksetPisteetJaKuva();
    }

    private void paivitaKierroksetPisteetJaKuva() throws IOException {
        if (this.kierrokset < this.linnut.size()) {
            this.pisteetTeksti.setText("Pisteet: " + this.pisteet);
            this.kierroksetTeksti.setText("Kierrokset: " + this.kierrokset + "/" + this.linnut.size());
            this.arvattavaLintuKuva.setIcon(new ImageIcon(latain.lataaKuva(linnut.get(this.kierrokset))));
        } else {
            lopetaPeli();
        }
    }

    
    private void lopetaPeli() throws IOException{
        alustaPeli();
    }
}