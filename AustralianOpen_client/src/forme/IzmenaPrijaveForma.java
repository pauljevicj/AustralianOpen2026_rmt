package forme;

import clientcontroller.KlijentskiKontroler;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Smena;
import model.Pozicija;
import model.Prijava;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class IzmenaPrijaveForma extends javax.swing.JDialog {
    Prijava pzi;
    public IzmenaPrijaveForma(java.awt.Frame parent, boolean modal, Prijava prijavaZaIzmenu) {
        super(parent, modal);
        initComponents();
        pzi = prijavaZaIzmenu;
        jTextFieldDatum.setText(String.valueOf(pzi.getDatum()));
        jComboBoxSmena.setSelectedItem(pzi.getSmena());
        jComboBoxPozicija.setSelectedItem(pzi.getPozicija());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDatum = new javax.swing.JTextField();
        jComboBoxSmena = new javax.swing.JComboBox<>();
        jComboBoxPozicija = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum volontiranja:");

        jLabel2.setText("Smena:");

        jLabel3.setText("Pozicija:");

        jComboBoxSmena.setModel(new DefaultComboBoxModel<>(Smena.values()));

        jComboBoxPozicija.setModel(new DefaultComboBoxModel<>(Pozicija.values()));

        jButton1.setText("Sacuvaj izmene");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldDatum)
                    .addComponent(jComboBoxSmena, 0, 159, Short.MAX_VALUE)
                    .addComponent(jComboBoxPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addComponent(jComboBoxSmena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            LocalDate datum = LocalDate.parse(jTextFieldDatum.getText());
            if (datum.isBefore(LocalDate.now().plusDays(1)) || datum.isAfter(LocalDate.of(2026, 2, 1)))
                JOptionPane.showMessageDialog(this,"Datum nije u dozvoljenom opsegu.");
            pzi.setDatum(datum);
            pzi.setSmena(Smena.valueOf(jComboBoxSmena.getSelectedItem().toString()));
            pzi.setPozicija(Pozicija.valueOf(jComboBoxPozicija.getSelectedItem().toString()));
            try {
                KlijentskiKontroler.getInstance().izmeniPrijavu(pzi);
                JOptionPane.showMessageDialog(this,"Uspešno ste izmenili prijavu.");
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(IzmenaPrijaveForma.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Greška pri dodavanju prijave",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(IzmenaPrijaveForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Pozicija> jComboBoxPozicija;
    private javax.swing.JComboBox<Smena> jComboBoxSmena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldDatum;
    // End of variables declaration//GEN-END:variables
}
