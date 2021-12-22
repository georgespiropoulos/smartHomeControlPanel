package smarthomecontrolpanel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class SmartHomeControlPanel extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("resources/img/smart-home.png"));
        Parent root = FXMLLoader.load(getClass().getResource("smarthome.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("smarthome.css").toExternalForm());
        stage.setTitle("SmartHouse Control Panel");
        stage.getIcons().add(icon);
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
