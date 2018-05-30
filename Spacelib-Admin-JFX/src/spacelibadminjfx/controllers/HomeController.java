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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import spacelibadminjfx.SpacelibAdminJFX;

/**
 * FXML Controller class
 *
 * @author Pierre
 */
public class HomeController implements Initializable {

    @FXML
    private Button addStation;
    @FXML
    private ListView<?> lesStations;
    @FXML
    private TextField position;
    @FXML
    private Button delStation;
    @FXML
    private Button saveStation;
    @FXML
    private Button addNavette;
    @FXML
    private ListView<?> lesNavettes;
    @FXML
    private Label noNavette;
    @FXML
    private Label etatRevision;
    @FXML
    private ListView<?> lesOperations;
    @FXML
    private Label nomArrimage;
    @FXML
    private Label QuaiArrimage;
    @FXML
    private Label positionArrimage;
    @FXML
    private Button delNavette;
    @FXML
    private Button saveNavette;

    private SpacelibAdminJFX mainApp;

    public void setMainApp(SpacelibAdminJFX mainApp) {
	this.mainApp = mainApp;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    private void nouvelleStation(ActionEvent event) {
        mainApp.showAjouterStation();
    }
    
}
