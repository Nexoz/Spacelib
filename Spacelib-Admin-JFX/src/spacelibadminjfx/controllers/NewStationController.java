/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacelibadminjfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pierreliaubet
 */
public class NewStationController implements Initializable {

    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private ListView<?> lesQuais;
    @FXML
    private Button btnAddQuai;
    @FXML
    private Button btnDelQuai;
    @FXML
    private TextField nomStation;
    @FXML
    private TextField position;

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

    @FXML
    private void addQuai(ActionEvent event) {
    }

    @FXML
    private void delQuai(ActionEvent event) {
    }
    
}
