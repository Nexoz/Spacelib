/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.administrateurclient;

import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.toulouse.miage.administrateurclient.services.RMIAdminServiceManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pierreliaubet
 */
public class NewStation extends javax.swing.JPanel {

    private JFrame main;
    
    private Home origin;
    
    private RMIAdminServiceManager manager;
    
    private ObjStation newStation = new ObjStation();
    
    private DefaultListModel modelQuais;
    
    /**
     * Creates new form NewStation
     */
    public NewStation(JFrame main, Home origin) {
        this.main = main;
        this.origin = origin;
        initComponents();
        try {
            manager = new RMIAdminServiceManager();
        } catch (NamingException ex) {
            Logger.getLogger(NewStation.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelQuais = new DefaultListModel();
        listeQuai.setModel(modelQuais);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFNomStation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFPosition = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeQuai = new javax.swing.JList<>();
        btnDelQuai = new javax.swing.JButton();
        btnEnregistrer = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        btnAddQuai = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Nouvelle station");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Nom de station :");

        TFNomStation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        TFNomStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNomStationActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Position :");

        TFPosition.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        TFPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFPositionActionPerformed(evt);
            }
        });

        listeQuai.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listeQuai);

        btnDelQuai.setText("-");

        btnEnregistrer.setText("ENREGISTRER");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnAnnuler.setText("ANNULER");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        btnAddQuai.setText("+");
        btnAddQuai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFNomStation)
                                        .addComponent(TFPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(105, 105, 105)
                            .addComponent(btnAddQuai)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelQuai)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnregistrer)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNomStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelQuai)
                    .addComponent(btnAddQuai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnregistrer)
                    .addComponent(btnAnnuler))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFNomStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNomStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNomStationActionPerformed

    private void TFPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFPositionActionPerformed

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        newStation.setNom(TFNomStation.getText());
        newStation.setPosition(TFPosition.getText());
        try {
            manager.getAdminRemoteSvc().ajouterStation(newStation);
        } catch (StationInconnuException ex) {
            Logger.getLogger(NewStation.class.getName()).log(Level.SEVERE, null, ex);
        }
        origin.chargerDonnees();
        TFNomStation.setText("");
        TFPosition.setText("");
        listeQuai.setModel(new DefaultListModel<>());
        newStation = new ObjStation();
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        main.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnAddQuaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuaiActionPerformed
        NewQuai newQuai = new NewQuai();
        ObjQuai quai = NewQuai.openForm(newQuai);
        newStation.getQuais().add(quai);
        modelQuais.addElement(quai);
        listeQuai.setModel(modelQuais);
    }//GEN-LAST:event_btnAddQuaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFNomStation;
    private javax.swing.JTextField TFPosition;
    private javax.swing.JButton btnAddQuai;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnDelQuai;
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listeQuai;
    // End of variables declaration//GEN-END:variables
}
