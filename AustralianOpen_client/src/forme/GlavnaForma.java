package forme;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class GlavnaForma extends javax.swing.JDialog {
    User ulogovani;
    LoginForma lf;
    
    public GlavnaForma(java.awt.Frame parent, boolean modal, User u) {
        super(parent, modal);
        lf = (LoginForma) parent;
        initComponents();
        ulogovani = u;
        jLabelIme.setText(u.getIme()+"!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelIme = new javax.swing.JLabel();
        jButtonPrijavaZaVol = new javax.swing.JButton();
        jButtonVidiPrijave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Zdravo");

        jLabelIme.setText("jLabel3");

        jButtonPrijavaZaVol.setText("Prijavi se za volontiranje");
        jButtonPrijavaZaVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrijavaZaVolActionPerformed(evt);
            }
        });

        jButtonVidiPrijave.setText("Vidi svoje prijave");
        jButtonVidiPrijave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVidiPrijaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVidiPrijave, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrijavaZaVol, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabelIme))
                .addGap(31, 31, 31)
                .addComponent(jButtonPrijavaZaVol)
                .addGap(27, 27, 27)
                .addComponent(jButtonVidiPrijave)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrijavaZaVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrijavaZaVolActionPerformed
        PrijavaForma pf = new PrijavaForma(lf, true, ulogovani);
        pf.setVisible(true);
    }//GEN-LAST:event_jButtonPrijavaZaVolActionPerformed

    private void jButtonVidiPrijaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVidiPrijaveActionPerformed
        try {
            PregledPrijavaForma ppf = new PregledPrijavaForma(lf, true, ulogovani);
            ppf.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVidiPrijaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrijavaZaVol;
    private javax.swing.JButton jButtonVidiPrijave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIme;
    // End of variables declaration//GEN-END:variables
}
