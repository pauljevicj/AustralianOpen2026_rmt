package forme;

import clientcontroller.KlijentskiKontroler;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Gost;
import model.Smena;
import model.Pozicija;

public class GostPrijava extends javax.swing.JDialog {

    public GostPrijava(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonPrijavi = new javax.swing.JButton();
        jComboBoxSmena = new javax.swing.JComboBox<>();
        jComboBoxPozicija = new javax.swing.JComboBox<>();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPrezime = new javax.swing.JTextField();
        jTextFieldJMBG = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDatum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("JMBG:");

        jLabel4.setText("Email:");

        jLabel5.setText("Datum volontiranja:");

        jLabel6.setText("Smena:");

        jLabel7.setText("Pozicija:");

        jButtonPrijavi.setText("Prijavi");
        jButtonPrijavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrijaviActionPerformed(evt);
            }
        });

        jComboBoxSmena.setModel(new DefaultComboBoxModel<>(Smena.values()));

        jComboBoxPozicija.setModel(new DefaultComboBoxModel<>(Pozicija.values()));

        jTextFieldIme.setText("Filip");

        jTextFieldPrezime.setText("Tasic");

        jTextFieldJMBG.setText("1202002374859");

        jTextFieldEmail.setText("filip@filip");

        jTextFieldDatum.setText("2026-01-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(92, 92, 92))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(108, 108, 108))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(90, 90, 90)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIme)
                            .addComponent(jTextFieldPrezime)
                            .addComponent(jTextFieldJMBG)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldDatum)
                            .addComponent(jComboBoxSmena, 0, 176, Short.MAX_VALUE)
                            .addComponent(jComboBoxPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrijavi)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxSmena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonPrijavi)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrijaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrijaviActionPerformed
        try {                                               
            Gost g = null;
            String jmbg = jTextFieldJMBG.getText();
            String email = jTextFieldEmail.getText();
            LocalDate datum = LocalDate.parse(jTextFieldDatum.getText());
            if (datum.isBefore(LocalDate.now().plusDays(1)) || datum.isAfter(LocalDate.of(2026, 2, 1)))
                throw new Exception("Datum nije u dozvoljenom opsegu.");
            if(jmbg!=null && jmbg.length()==13 && email!=null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                g = new Gost(jmbg, jTextFieldIme.getText(), jTextFieldPrezime.getText(),
                    email, datum, (Smena) jComboBoxSmena.getSelectedItem(),
                        (Pozicija) jComboBoxPozicija.getSelectedItem() );
            }else
                JOptionPane.showMessageDialog(this, "Pogresan unos podataka!");
            try{
                KlijentskiKontroler.getInstance().prijaviSmenuGost(g);
                JOptionPane.showMessageDialog(this,"Uspešno ste dodali prijavu.");
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(GostPrijava.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(GostPrijava.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPrijaviActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrijavi;
    private javax.swing.JComboBox<Pozicija> jComboBoxPozicija;
    private javax.swing.JComboBox<Smena> jComboBoxSmena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldJMBG;
    private javax.swing.JTextField jTextFieldPrezime;
    // End of variables declaration//GEN-END:variables
}
