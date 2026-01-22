package forme;

import clientcontroller.KlijentskiKontroler;
import model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Prijava;
import model.StatusPrijave;

public class PregledPrijavaForma extends javax.swing.JDialog {
    User u;
    List<Prijava> lista;
    LoginForma lg;
    ModelTabelePrijave mtp;
    public PregledPrijavaForma(java.awt.Frame parent, boolean modal, User ulogovani) throws Exception {
        super(parent, modal);
        initComponents();
        lg = (LoginForma) parent;
        u = ulogovani;
        lista = KlijentskiKontroler.getInstance().vratiListuPrijava(u);
        mtp = new ModelTabelePrijave(lista);
        jTablePrijave.setModel(mtp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrijave = new javax.swing.JTable();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTablePrijave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablePrijave);

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("Obriši");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIzmeni)
                    .addComponent(jButtonObrisi))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButtonIzmeni)
                .addGap(34, 34, 34)
                .addComponent(jButtonObrisi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        int selektovaniRed = jTablePrijave.getSelectedRow();
        if(selektovaniRed == -1)
            JOptionPane.showMessageDialog(this, "Morate izabrati prijavu.");
        Prijava prijavaZaIzmenu = lista.get(selektovaniRed);
        if(prijavaZaIzmenu.getStatus()==StatusPrijave.ZAKLJUCANA || prijavaZaIzmenu.getStatus()==StatusPrijave.ZAVRSENA)
            JOptionPane.showMessageDialog(this, "Ne mozete izmeniti zakljucanu/zavrsenu smenu.");
        else{
            IzmenaPrijaveForma ipf = new IzmenaPrijaveForma(lg, true, prijavaZaIzmenu);
            ipf.setVisible(true);
            mtp.osveziTabelu();
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        int selektovaniRed = jTablePrijave.getSelectedRow();
        if(selektovaniRed == -1){
            JOptionPane.showMessageDialog(this, "Morate izabrati prijavu.");
            return;
        }
        Prijava prijavaZaBrisanje = lista.get(selektovaniRed);
        if(prijavaZaBrisanje.getStatus()==StatusPrijave.ZAKLJUCANA || prijavaZaBrisanje.getStatus()==StatusPrijave.ZAVRSENA){
            JOptionPane.showMessageDialog(this, "Ne mozete obrisati zakljucanu/zavrsenu smenu.");
            return;
        }
        else{
            try {
                KlijentskiKontroler.getInstance().obrisiPrijavu(prijavaZaBrisanje);
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali prijavu!");
                mtp.obrisiRed(selektovaniRed);
            } catch (Exception ex) {
                Logger.getLogger(PregledPrijavaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrijave;
    // End of variables declaration//GEN-END:variables

}
