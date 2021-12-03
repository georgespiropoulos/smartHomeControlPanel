package smarthomecontrolpanel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class SmartHomeControlPanel extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("smarthome.fxml"));
        
        Scene scene = new Scene(root);
//        stage.getIcons().add(new Image(SmartHomeControlPanel.class.getResourceAsStream("/resources/img/smart-home.png")));
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
