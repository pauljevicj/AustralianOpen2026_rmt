package forme;

import clientcontroller.KlijentskiKontroler;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Pozicija;
import model.Smena;
import model.Prijava;
import model.User;
import javax.swing.DefaultComboBoxModel;

public class PrijavaForma extends javax.swing.JDialog {
    User ulogovan;
    public PrijavaForma(java.awt.Frame parent, boolean modal, User ulogovani) {
        super(parent, modal);
        initComponents();
        ulogovan = ulogovani;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDatumVolontiranja = new javax.swing.JTextField();
        jComboBoxSmena = new javax.swing.JComboBox<>();
        jComboBoxPozicija = new javax.swing.JComboBox<>();
        jButtonSacuvaj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum volontiranja (yyyy-mm-dd):");

        jLabel2.setText("Smena:");

        jLabel3.setText("Pozicija:");

        jComboBoxSmena.setModel(new DefaultComboBoxModel<>(Smena.values()));

        jComboBoxPozicija.setModel(new DefaultComboBoxModel<>(Pozicija.values()));

        jButtonSacuvaj.setText("Sacuvaj");
        jButtonSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(jComboBoxPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(jComboBoxSmena, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 173, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDatumVolontiranja)))
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDatumVolontiranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxSmena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButtonSacuvaj)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        try {
            LocalDate datum = LocalDate.parse(jTextFieldDatumVolontiranja.getText());
            if (datum.isBefore(LocalDate.now().plusDays(1)) || datum.isAfter(LocalDate.of(2026, 2, 1)))
                throw new Exception("Datum nije u dozvoljenom opsegu.");
            
            Smena smena = (Smena) jComboBoxSmena.getSelectedItem();
            Pozicija pozicija = (Pozicija) jComboBoxPozicija.getSelectedItem();
            Prijava p = new Prijava(-1,ulogovan, datum, smena, pozicija);
            try {
                KlijentskiKontroler.getInstance().prijaviSmenu(p);
                JOptionPane.showMessageDialog(this,"Uspešno ste dodali prijavu.");
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage(),"Greška pri dodavanju prijave",JOptionPane.ERROR_MESSAGE);
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JComboBox<Pozicija> jComboBoxPozicija;
    private javax.swing.JComboBox<Smena> jComboBoxSmena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldDatumVolontiranja;
    // End of variables declaration//GEN-END:variables
}
