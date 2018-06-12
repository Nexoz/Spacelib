/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient;

import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import fr.toulouse.miage.borneclient.renderer.StationRenderer;
import fr.toulouse.miage.borneclient.services.RMIBorneServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Fanny Mnt
 */
public class ReserverNavette extends javax.swing.JPanel {

    BorneClient jframeAccueil;
    ObjStation s;
    private RMIBorneServiceManager manager;
    private long idClient;
    private long idStation;
    
    /**
     * Creates new form ReserverNavette
     */
    public ReserverNavette(BorneClient j,String message) {
        initComponents();
        this.manager = j.getManager();
        this.jframeAccueil = j;
        this.idClient = j.getIdClient();
        this.idStation = j.getIdStation();
        this.initialiserListStation();
        this.jLabelUsager.setText(j.getNomUsager() + " " + j.getPrenomUsager()+"    ");
        this.jLabelNomStation.setText("     Station " + j.getNomStation());
        SpinnerModel model = new SpinnerNumberModel(1, 1,8,1);
        jSpinnerNb.setModel(model);
        //jSpinnerNb = new JSpinner(model); 
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerNb = new javax.swing.JSpinner();
        jButtonReserver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListStation = new javax.swing.JList();
        jLabelErreur = new javax.swing.JLabel();
        DecoButton = new javax.swing.JButton();
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

        jLabel2.setText("Nombre de personnes ");

        jLabel3.setText("Sélectionner la station d'arrivée");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Réservation d'un voyage");

        jSpinnerNb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinnerNb.setRequestFocusEnabled(false);
        jSpinnerNb.setVerifyInputWhenFocusTarget(false);

        jButtonReserver.setBackground(new java.awt.Color(0, 0, 51));
        jButtonReserver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReserver.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReserver.setText("Réserver");
        jButtonReserver.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonReserver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonReserverMouseClicked(evt);
            }
        });
        jButtonReserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReserverActionPerformed(evt);
            }
        });

        jListStation.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListStation);

        jLabelErreur.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGap(29, 29, 29)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCenterLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(jSpinnerNb, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DecoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jButtonReserver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 147, Short.MAX_VALUE))
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCenterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DecoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerNb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButtonReserver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
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

    private void jButtonReserverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReserverMouseClicked
        ObjStation selectedStation = (ObjStation) jListStation.getSelectedValue();
        if(selectedStation==null){
            jLabelErreur.setText("Veuillez sélectionner une station d'arrivée !");
        } else {
            int nbParticipant = Integer.parseInt(jSpinnerNb.getValue().toString());
            System.out.println("fr.toulouse.miage.borneclient.ReserverNavette.jButtonReserverMouseClicked()   nbParticipant"  + nbParticipant);
            try {
                long idReservation = manager.getBorneRemoteSvc().reserverVoyage(this.idStation, selectedStation.getId(),nbParticipant,this.idClient, this.aujourdhui());
                jframeAccueil.setIdReservation(idReservation);
                String nomQuaiD = manager.getBorneRemoteSvc().quaiReservation(idReservation);
                jframeAccueil.setNomQuaiReservation(nomQuaiD);
                jframeAccueil.changerJpanel(this, new DemarrerVoyage(jframeAccueil));
            } catch (NavetteInconnuException ex) {
                jLabelErreur.setText("La navette n'existe pas.");
            } catch (StationInconnuException ex) {
                jLabelErreur.setText("La station n'existe pas.");
            } catch (PasNavetteDisponibleException ex) {
                jLabelErreur.setText("Pas de navette disponible aujourd'hui.");
            } catch (PasQuaiDisponibleException ex) {
                jLabelErreur.setText("Pas de quai disponible pour le jour de votre arrivée.");
            } catch (UsagerInconnuException ex) {
                jLabelErreur.setText("Vous n'existez pas");
            } catch (ReservationInconnuException ex) {
                Logger.getLogger(ReserverNavette.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonReserverMouseClicked

    private void jButtonReserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReserverActionPerformed
        
    }//GEN-LAST:event_jButtonReserverActionPerformed

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

    public Date aujourdhui() {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd" ); 
        Date dateD = new Date(); 
        return dateD;
    }
    
    public void initialiserListStation(){
        jListStation.removeAll();
        List<ObjStation> stations = manager.getBorneRemoteSvc().consulterStation();
        DefaultListModel modelStations = new DefaultListModel<>();
        for (ObjStation station : stations) {
            if(!station.getNom().equals(jframeAccueil.getNomStation())){
                modelStations.addElement(station);
            }
        }
        jListStation.setModel(modelStations);
        jListStation.setCellRenderer(new StationRenderer());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecoButton;
    private javax.swing.JButton jButtonReserver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelErreur;
    private javax.swing.JLabel jLabelNomStation;
    private javax.swing.JLabel jLabelUsager;
    private javax.swing.JList jListStation;
    private javax.swing.JPanel jPanelBot;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinnerNb;
    // End of variables declaration//GEN-END:variables
}
