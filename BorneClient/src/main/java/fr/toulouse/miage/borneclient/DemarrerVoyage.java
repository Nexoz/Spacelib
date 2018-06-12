/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient;

import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.toulouse.miage.borneclient.services.RMIBorneServiceManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface pour démarrer un voyage
 * @author Fanny Mnt
 */
public class DemarrerVoyage extends javax.swing.JPanel {

    public BorneClient jframeAccueil;
    private RMIBorneServiceManager manager;
    private ObjStation selectedStation = null;
    
    /**
     * Constructeur d'un voyage
     * @param j jframe parente
     */
    public DemarrerVoyage(BorneClient j) {
        initComponents();
        this.manager = j.getManager();
        this.jframeAccueil = j;
        this.jLabelUsager.setText(j.getNomUsager() + " " + j.getPrenomUsager()+"    ");
        this.jLabelNomStation.setText("     Station " + j.getNomStation());
        
        this.jLabelDuQuai.setText(this.jLabelDuQuai.getText()+ " " + jframeAccueil.getNomQuaiReservation());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCenter = new javax.swing.JPanel();
        jLabelDuQuai = new javax.swing.JLabel();
        jButtonDeco = new javax.swing.JButton();
        jPanelBot = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNomStation = new javax.swing.JLabel();
        jLabelUsager = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setLayout(new java.awt.BorderLayout());

        jPanelCenter.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDuQuai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDuQuai.setText("Veuillez vous rendre au quai : ");

        jButtonDeco.setBackground(new java.awt.Color(0, 0, 51));
        jButtonDeco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDeco.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeco.setText("Déconnexion");
        jButtonDeco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonDeco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDecoMouseClicked(evt);
            }
        });
        jButtonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCenterLayout = new javax.swing.GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDuQuai, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButtonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelDuQuai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButtonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        add(jPanelCenter, java.awt.BorderLayout.CENTER);

        jPanelBot.setBackground(new java.awt.Color(255, 255, 255));
        add(jPanelBot, java.awt.BorderLayout.PAGE_END);

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

    private void jButtonDecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDecoMouseClicked
        try {
            manager.getBorneRemoteSvc().demarrerVoyage(jframeAccueil.getIdReservation());
            jframeAccueil.setIdClient(null);
            jframeAccueil.setIdReservation(null);
            jframeAccueil.setIdStation(null);
            jframeAccueil.changerJpanel(this, new SelectionStation(jframeAccueil));
            jframeAccueil.setNomUsager(null);
            jframeAccueil.setPrenomUsager(null);
            jframeAccueil.setNomStation(null);
            jLabelNomStation.setText("");
            jLabelUsager.setText("");
        } catch (ReservationInconnuException ex) {
            Logger.getLogger(DemarrerVoyage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDecoMouseClicked

    private void jButtonDecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecoActionPerformed
        
    }//GEN-LAST:event_jButtonDecoActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDuQuai;
    private javax.swing.JLabel jLabelNomStation;
    private javax.swing.JLabel jLabelUsager;
    private javax.swing.JPanel jPanelBot;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
