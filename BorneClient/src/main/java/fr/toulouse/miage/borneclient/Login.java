/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient;

import fr.miage.toulouse.spacelibshared.admin.ObjUsager;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import fr.toulouse.miage.borneclient.services.RMIBorneServiceManager;

/**
 *
 * @author pierreliaubet
 */
public class Login extends javax.swing.JPanel{

    public BorneClient jframeAccueil;
    private RMIBorneServiceManager manager;
    private Long idStation; 
    
    /**
     * Creates new form Login
     */
    public Login(BorneClient j, String message) {
        initComponents();
        this.jframeAccueil = j;
        this.manager=j.getManager();
        this.jLabelSuccès.setText(message);
        this.idStation = j.getIdStation();
        this.jLabelNomStation.setText("     Station " + j.getNomStation());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNomStation = new javax.swing.JLabel();
        jLabelUsager = new javax.swing.JLabel();
        jPanelCenter = new javax.swing.JPanel();
        jLabellogin = new javax.swing.JLabel();
        jTextFieldlogin = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonValider = new javax.swing.JButton();
        jLabelErreur = new javax.swing.JLabel();
        jButtonInscription = new javax.swing.JButton();
        jLabelSuccès = new javax.swing.JLabel();
        jPanelBot = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.BorderLayout());

        jPanelTop.setBackground(new java.awt.Color(0, 0, 51));
        jPanelTop.setMinimumSize(new java.awt.Dimension(168, 60));
        jPanelTop.setPreferredSize(new java.awt.Dimension(241, 90));
        jPanelTop.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("    WELCOME to Spacelib");
        jLabel1.setToolTipText("");
        jPanelTop.add(jLabel1);
        jPanelTop.add(jLabel2);

        jLabelNomStation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNomStation.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTop.add(jLabelNomStation);
        jPanelTop.add(jLabelUsager);

        add(jPanelTop, java.awt.BorderLayout.PAGE_START);

        jPanelCenter.setBackground(new java.awt.Color(255, 255, 255));

        jLabellogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabellogin.setText("Login");

        jTextFieldlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldloginActionPerformed(evt);
            }
        });

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPassword.setText("Password");

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jButtonValider.setBackground(new java.awt.Color(0, 0, 51));
        jButtonValider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonValider.setForeground(new java.awt.Color(255, 255, 255));
        jButtonValider.setText("Valider");
        jButtonValider.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonValiderMouseClicked(evt);
            }
        });
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jLabelErreur.setForeground(new java.awt.Color(255, 0, 0));

        jButtonInscription.setBackground(new java.awt.Color(0, 0, 51));
        jButtonInscription.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonInscription.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInscription.setText("S'inscrire");
        jButtonInscription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonInscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInscriptionMouseClicked(evt);
            }
        });
        jButtonInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscriptionActionPerformed(evt);
            }
        });

        jLabelSuccès.setForeground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanelCenterLayout = new javax.swing.GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addComponent(jLabelSuccès, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createSequentialGroup()
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCenterLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                                        .addComponent(jLabellogin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24))
                                    .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelCenterLayout.createSequentialGroup()
                                            .addComponent(jLabelPassword)
                                            .addGap(18, 18, 18)
                                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(147, 147, 147))))
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSuccès, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabellogin))
                .addGap(14, 14, 14)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        add(jPanelCenter, java.awt.BorderLayout.CENTER);

        jPanelBot.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanelBot, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldloginActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonValiderMouseClicked
        ObjUsager u;
        try {
            u = manager.getBorneRemoteSvc().authentifier(jTextFieldlogin.getText(),jPasswordField.getText());
            jframeAccueil.setIdClient(u.getId());
            jframeAccueil.setNomUsager(u.getNom());
            jframeAccueil.setPrenomUsager(u.getPrenom());
            ///////Vérifier si réservation en cours
            Long idres = manager.getBorneRemoteSvc().derniereReservation(u.getId());
            if(idres==null){
                jframeAccueil.changerJpanel(this, new ReserverNavette(jframeAccueil,""));
            } else {
                jframeAccueil.setIdReservation(idres);
                jframeAccueil.changerJpanel(this, new FinaliserVoyage(jframeAccueil));
            }
        } catch (UsagerInconnuException ex) {
            jLabelErreur.setText("Erreur : Vos identifiants sont incorrects");
            jLabelSuccès.setText("");
            this.repaint();
        }  
    }//GEN-LAST:event_jButtonValiderMouseClicked

    private void jButtonInscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInscriptionMouseClicked
        System.out.println("inscription");
        jframeAccueil.changerJpanel(this, new Inscription(jframeAccueil));
    }//GEN-LAST:event_jButtonInscriptionMouseClicked

    private void jButtonInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInscriptionActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInscription;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelErreur;
    private javax.swing.JLabel jLabelNomStation;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelSuccès;
    private javax.swing.JLabel jLabelUsager;
    private javax.swing.JLabel jLabellogin;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBot;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldlogin;
    // End of variables declaration//GEN-END:variables
}
