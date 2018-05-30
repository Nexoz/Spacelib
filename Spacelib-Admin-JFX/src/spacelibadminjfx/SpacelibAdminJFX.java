/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacelibadminjfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import spacelibadminjfx.controllers.HomeController;
import spacelibadminjfx.controllers.NewStationController;

/**
 *
 * @author pierr
 */
public class SpacelibAdminJFX extends Application {
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SpacelibAdminJFX.class.getResource("/spacelibadminjfx/views/Home.fxml"));
			Scene scene = new Scene(loader.load());
			HomeController controller = loader.getController();
			controller.setMainApp(this);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Spacelib administrator");
			primaryStage.show();
			this.primaryStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean showAjouterStation(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SpacelibAdminJFX.class.getResource("/spacelibadminjfx/views/NewStation.fxml"));
            Stage ajouterStage = new Stage();
            ajouterStage.setTitle("Nouvelle station");
            ajouterStage.initModality(Modality.WINDOW_MODAL);
            ajouterStage.initOwner(primaryStage);
            Scene scene = new Scene(loader.load());
            ajouterStage.setScene(scene);
            NewStationController controller = loader.getController();
            controller.setDialogStage(ajouterStage);
            ajouterStage.showAndWait();
            //return controller.isClicked();
            return true;
        }catch (IOException e){
        	e.printStackTrace();
            return false;
        }
    }
    
}
