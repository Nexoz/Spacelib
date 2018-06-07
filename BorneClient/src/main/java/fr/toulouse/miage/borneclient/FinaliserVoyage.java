/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient;

import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.toulouse.miage.borneclient.services.RMIBorneServiceManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fanny Mnt
 */
public class FinaliserVoyage extends javax.swing.JPanel {

    public BorneClient jframeAccueil;
    private RMIBorneServiceManager manager;
    
    /**
     * Creates new form FinaliserVoyage
     */
    public FinaliserVoyage(BorneClient j) {
        initComponents();
        this.jframeAccueil = j;
        this.manager = j.getManager();
        this.jLabelUsager.setText(j.getNomUsager() + " " + j.getPrenomUsager()+"    ");
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

        jPanelBot = new javax.swing.JPanel();
        jPanelCenter = new javax.swing.JPanel();
        jLabelStationA = new javax.swing.JLabel();
        jLabelStationD = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DecoButton = new javax.swing.JButton();
        jPanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNomStation = new javax.swing.JLabel();
        jLabelUsager = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanelBot.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanelBot, java.awt.BorderLayout.PAGE_END);

        jPanelCenter.setBackground(new java.awt.Color(255, 255, 255));

        jLabelStationA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelStationA.setText("Station d'arrivée");

        jLabelStationD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelStationD.setText("Station de départ");

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

        jLabelTitre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitre.setText("Finalisation du voyage");

        jLabel2.setText("Départ le :");

        jLabel3.setText("Arrivée le :");

        DecoButton.setBackground(new java.awt.Color(0, 0, 51));
        DecoButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DecoButton.setForeground(new java.awt.Color(255, 255, 255));
        DecoButton.setText("Déconnexion");
        DecoButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DecoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DecoButtonMouseClicked(evt);
            }
        });
        DecoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCenterLayout = new javax.swing.GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelCenterLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStationD)
                            .addGroup(jPanelCenterLayout.createSequentialGroup()
                                .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DecoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelStationA))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addComponent(jLabelStationD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabelStationA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        add(jPanelCenter, java.awt.BorderLayout.CENTER);

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
        jPanelTop.add(jLabel5);

        jLabelNomStation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNomStation.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTop.add(jLabelNomStation);

        jLabelUsager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsager.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsager.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanelTop.add(jLabelUsager);

        add(jPanelTop, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonValiderMouseClicked
        try {
            manager.getBorneRemoteSvc().finaliserVoyage(jframeAccueil.getIdReservation());
            jframeAccueil.changerJpanel(this, new ReserverNavette(jframeAccueil,""));
        } catch (NavetteInconnuException ex) {
            Logger.getLogger(FinaliserVoyage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ReservationInconnuException ex) {
            Logger.getLogger(FinaliserVoyage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (QuaiInconnuException ex) {
            Logger.getLogger(FinaliserVoyage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonValiderMouseClicked

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed

    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void DecoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DecoButtonMouseClicked
        jframeAccueil.setIdClient(null);
        jframeAccueil.setIdReservation(null);
        jframeAccueil.setIdStation(null);
        jframeAccueil.changerJpanel(this, new SelectionStation(jframeAccueil));
        jframeAccueil.setNomUsager(null);
        jframeAccueil.setPrenomUsager(null);
        jframeAccueil.setNomStation(null);
        jLabelNomStation.setText("");
        jLabelUsager.setText("");
    }//GEN-LAST:event_DecoButtonMouseClicked

    private void DecoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecoButton;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNomStation;
    private javax.swing.JLabel jLabelStationA;
    private javax.swing.JLabel jLabelStationD;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelUsager;
    private javax.swing.JPanel jPanelBot;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
