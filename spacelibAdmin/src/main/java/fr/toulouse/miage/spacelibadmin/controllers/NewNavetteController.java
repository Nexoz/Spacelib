/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.spacelibadmin.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pierreliaubet
 */
public class NewNavetteController implements Initializable {

    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField nbPlaces;

    private Stage dialogStage;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void enregistrer(ActionEvent event) {
    }
    
}
