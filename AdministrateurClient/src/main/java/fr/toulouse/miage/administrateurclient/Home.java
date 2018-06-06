/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.administrateurclient;

import fr.miage.toulouse.spacelibshared.admin.ObjMecanicien;
import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.toulouse.miage.administrateurclient.services.RMIAdminServiceManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author pierreliaubet
 */
public class Home extends javax.swing.JPanel {

    private RMIAdminServiceManager manager;
    
    /**
     * Creates new form Home
     */
    public Home() {
        try {
            manager = new RMIAdminServiceManager();
        } catch (NamingException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        
        listeStations.removeAll();
        listeNavettes.removeAll();
        
        chargerDonnees();
    }
    
    private void chargerDonnees(){
        List<ObjStation> stations = manager.getAdminRemoteSvc().consulterStation();
        DefaultListModel<String> modelStations = new DefaultListModel<>();
        for (ObjStation station : stations) {
            modelStations.addElement(station.toString());
        }
        lesStations.setModel(modelStations);
        
        List<ObjNavette> navettes = manager.getAdminRemoteSvc().getLesNavettes();
        DefaultListModel<String> modelNavettes = new DefaultListModel<>();
        for (ObjNavette navette : navettes){
            modelNavettes.addElement(navette.toString());
        }
        listeNavettes.setModel(modelNavettes);
        
        List<ObjMecanicien> mecanos = manager.getAdminRemoteSvc().getlesMecanos();
        DefaultListModel<String> modelMecanos = new DefaultListModel<>();
        for (ObjMecanicien mecano : mecanos){
            modelMecanos.addElement(mecano.toString());
        }
        listeMecaniciens.setModel(modelMecanos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        listeStations = new javax.swing.JScrollPane();
        lesStations = new javax.swing.JList<>();
        btnAddStation = new javax.swing.JButton();
        labelNomStation = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFPositionStation = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listeQuaiStation = new javax.swing.JList<>();
        btnDelQuai = new javax.swing.JButton();
        btnEnregistrerStation = new javax.swing.JButton();
        btnDelStation = new javax.swing.JButton();
        btnAddQuai = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeNavettes = new javax.swing.JList<>();
        btnAddNavette = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelNumNavette = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        labelEtatRevision = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelNomStationNavette = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelQuaiNavette = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listOperations = new javax.swing.JList<>();
        btnEnregistrerNavette = new javax.swing.JButton();
        btnDelNavette = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeMecaniciens = new javax.swing.JList<>();
        btnAddMecanicien = new javax.swing.JButton();
        labelPrenomMecano = new javax.swing.JLabel();
        labelNomMecano = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFLogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TFPassword = new javax.swing.JPasswordField();
        btnEnregistrerMecano = new javax.swing.JButton();

        lesStations.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listeStations.setViewportView(lesStations);

        btnAddStation.setText("+");
        btnAddStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStationActionPerformed(evt);
            }
        });

        labelNomStation.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelNomStation.setText("NomStation");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Position : ");

        TFPositionStation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        TFPositionStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFPositionStationActionPerformed(evt);
            }
        });

        listeQuaiStation.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listeQuaiStation);

        btnDelQuai.setText("-");

        btnEnregistrerStation.setText("ENREGISTRER");
        btnEnregistrerStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerStationActionPerformed(evt);
            }
        });

        btnDelStation.setText("-");

        btnAddQuai.setText("+");
        btnAddQuai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listeStations, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNomStation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                                .addComponent(btnDelStation))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFPositionStation, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnAddQuai)
                                .addGap(31, 31, 31)
                                .addComponent(btnDelQuai))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnAddStation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnregistrerStation)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listeStations, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomStation)
                            .addComponent(btnDelStation))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TFPositionStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelQuai)
                            .addComponent(btnAddQuai))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStation)
                    .addComponent(btnEnregistrerStation))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        tabs.addTab("Stations", jPanel1);

        listeNavettes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listeNavettes);

        btnAddNavette.setText("+");
        btnAddNavette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNavetteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("#");

        labelNumNavette.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelNumNavette.setText("NumNavette");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Places à bord : ");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Prochaine révision dans : ");

        jSpinner1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        labelEtatRevision.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelEtatRevision.setText("EtatRevision");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Arrimée à :");

        labelNomStationNavette.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelNomStationNavette.setText("Nom station");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Quai : ");

        labelQuaiNavette.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelQuaiNavette.setText("AZ-1254");

        listOperations.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listOperations);

        btnEnregistrerNavette.setText("ENREGISTRER");
        btnEnregistrerNavette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerNavetteActionPerformed(evt);
            }
        });

        btnDelNavette.setText("-");
        btnDelNavette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelNavetteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(labelQuaiNavette, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(labelNomStationNavette, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel5))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelEtatRevision))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 35, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNumNavette)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelNavette))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAddNavette)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnregistrerNavette)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(labelNumNavette)
                            .addComponent(btnDelNavette))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelEtatRevision))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelNomStationNavette)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelQuaiNavette)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNavette)
                    .addComponent(btnEnregistrerNavette))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        tabs.addTab("Navettes", jPanel2);

        listeMecaniciens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listeMecaniciens);

        btnAddMecanicien.setText("+");
        btnAddMecanicien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMecanicienActionPerformed(evt);
            }
        });

        labelPrenomMecano.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelPrenomMecano.setText("Prénom");

        labelNomMecano.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelNomMecano.setText("NOM");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel7.setText("Login :");

        TFLogin.setEditable(false);
        TFLogin.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        TFLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFLoginActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel8.setText("Password : ");

        TFPassword.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        TFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFPasswordActionPerformed(evt);
            }
        });

        btnEnregistrerMecano.setText("ENREGISTRER");
        btnEnregistrerMecano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerMecanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelPrenomMecano)
                        .addGap(18, 18, 18)
                        .addComponent(labelNomMecano))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFPassword))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(TFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAddMecanicien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnregistrerMecano)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrenomMecano)
                            .addComponent(labelNomMecano))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMecanicien)
                    .addComponent(btnEnregistrerMecano))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        tabs.addTab("Mecaniciens", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStationActionPerformed
        JFrame newStation = new JFrame();
        newStation.add(new NewStation(newStation));
        newStation.pack();
        newStation.setVisible(true);
    }//GEN-LAST:event_btnAddStationActionPerformed

    private void btnAddNavetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNavetteActionPerformed
        JFrame newNavette = new JFrame();
        newNavette.add(new NewNavette(newNavette));
        newNavette.pack();
        newNavette.setVisible(true);
    }//GEN-LAST:event_btnAddNavetteActionPerformed

    private void btnAddMecanicienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMecanicienActionPerformed
        JFrame newMecano = new JFrame();
        newMecano.add(new NewMecano(newMecano));
        newMecano.pack();
        newMecano.setVisible(true);
    }//GEN-LAST:event_btnAddMecanicienActionPerformed

    private void TFPositionStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFPositionStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFPositionStationActionPerformed

    private void btnEnregistrerStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnregistrerStationActionPerformed

    private void btnEnregistrerNavetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerNavetteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnregistrerNavetteActionPerformed

    private void btnDelNavetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelNavetteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelNavetteActionPerformed

    private void TFLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFLoginActionPerformed

    private void TFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFPasswordActionPerformed

    private void btnEnregistrerMecanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerMecanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnregistrerMecanoActionPerformed

    private void btnAddQuaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuaiActionPerformed
        JFrame newQuai = new JFrame();
        newQuai.add(new NewQuai((newQuai)));
        newQuai.pack();
        newQuai.setVisible(true);
    }//GEN-LAST:event_btnAddQuaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFLogin;
    private javax.swing.JPasswordField TFPassword;
    private javax.swing.JTextField TFPositionStation;
    private javax.swing.JButton btnAddMecanicien;
    private javax.swing.JButton btnAddNavette;
    private javax.swing.JButton btnAddQuai;
    private javax.swing.JButton btnAddStation;
    private javax.swing.JButton btnDelNavette;
    private javax.swing.JButton btnDelQuai;
    private javax.swing.JButton btnDelStation;
    private javax.swing.JButton btnEnregistrerMecano;
    private javax.swing.JButton btnEnregistrerNavette;
    private javax.swing.JButton btnEnregistrerStation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labelEtatRevision;
    private javax.swing.JLabel labelNomMecano;
    private javax.swing.JLabel labelNomStation;
    private javax.swing.JLabel labelNomStationNavette;
    private javax.swing.JLabel labelNumNavette;
    private javax.swing.JLabel labelPrenomMecano;
    private javax.swing.JLabel labelQuaiNavette;
    private javax.swing.JList<String> lesStations;
    private javax.swing.JList<String> listOperations;
    private javax.swing.JList<String> listeMecaniciens;
    private javax.swing.JList<String> listeNavettes;
    private javax.swing.JList<String> listeQuaiStation;
    private javax.swing.JScrollPane listeStations;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
