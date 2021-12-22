/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package smarthomecontrolpanel;

import java.net.URL;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;


/**
 *
 * @author spyro
 */
public class smarthomeController implements Initializable {
    
    @FXML
    private Label day;
    
    @FXML
    private Label date;
    
    @FXML
    private Label time;
        
    @FXML
    private Button homeButton;
    
    @FXML
    private Button tempButton;
    
    @FXML
    private Button lightsButton;
    
    @FXML
    private Button doorsButton;
    
    @FXML
    private Pane homePanel;
    
    @FXML
    private Pane tempPanel;
    
    @FXML
    private Pane lightsPanel;
    
    @FXML
    private Pane doorsPanel;
    
    @FXML
    public void homeClicked(){
        homeButton.setDisable(true);
        homePanel.setVisible(true);
        tempButton.setDisable(false);
        tempPanel.setVisible(false);
        lightsButton.setDisable(false);
        lightsPanel.setVisible(false);
        doorsButton.setDisable(false);
        doorsPanel.setVisible(false);        
    }
    
    @FXML
    public void tempClicked(){
        homeButton.setDisable(false);
        homePanel.setVisible(false);
        tempButton.setDisable(true);
        tempPanel.setVisible(true);
        lightsButton.setDisable(false);
        lightsPanel.setVisible(false);
        doorsButton.setDisable(false);
        doorsPanel.setVisible(false);        
    }
    
    @FXML
    public void lightsClicked(){
        homeButton.setDisable(false);
        homePanel.setVisible(false);
        tempButton.setDisable(false);
        tempPanel.setVisible(false);
        lightsButton.setDisable(true);
        lightsPanel.setVisible(true);
        doorsButton.setDisable(false);
        doorsPanel.setVisible(false);        
    }
    
    @FXML
    public void doorsClicked(){
        homeButton.setDisable(false);
        homePanel.setVisible(false);
        tempButton.setDisable(false);
        tempPanel.setVisible(false);
        lightsButton.setDisable(false);
        lightsPanel.setVisible(false);
        doorsButton.setDisable(true);
        doorsPanel.setVisible(true);        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clock();
        setDate();
        setDay();
    }
    
    private void setDay(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ENGLISH);
            day.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    
    private void setDate(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void clock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            time.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}