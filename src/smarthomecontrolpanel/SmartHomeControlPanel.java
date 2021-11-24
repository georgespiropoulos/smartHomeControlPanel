/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package smarthomecontrolpanel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.image.Image;

/**
 *
 * @author spyro
 */
public class SmartHomeControlPanel extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("smarthome.fxml"));
        String geotom = "Hello geotom test!";
        Scene scene = new Scene(root);
//        Image icon = new Image(getClass().getResourceAsStream("/resources/img/smart-home.png"));
//        stage.getIcons().add(icon);
        stage.setTitle("SmartHouse Control Panel");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
