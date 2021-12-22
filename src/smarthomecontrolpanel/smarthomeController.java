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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;


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
    private Pane tempInnerPanel;
    
    @FXML
    private ImageView thermometer;
    
    @FXML
    private ImageView thermalMainHall1;
    private boolean tMH1State = false;
    
    @FXML
    private ImageView thermalMainHall2;
    private boolean tMH2State = false;
    
    @FXML
    private ImageView thermalLivingRoom;
    private boolean tLRState = false;
    
    @FXML
    private ImageView thermalKitchen;
    private boolean tKState = false;
    
    @FXML
    private ImageView thermalStorage;
    private boolean tSState = false;
    
    @FXML
    private ImageView thermalBathroom;
    private boolean tBthState = false;
    
    @FXML
    private ImageView thermalBedroom;
    private boolean tBdState = false;
    
    @FXML
    private ToggleButton tempOnOff;
    private boolean onOffState = false;
    
    @FXML
    private Button tempPlusButton;
    
    @FXML 
    private Button tempMinusButton;
    
    @FXML
    private Label temperature;
    
    @FXML
    private ImageView bedroomLight;
    private boolean bdLightState = false;
    
    @FXML
    private ImageView livingRoomLight;
    private boolean lrLightState = false;
    
    @FXML
    private ImageView gardenLight;
    private boolean grdLightState = false;
    
    @FXML
    private ImageView kitchenLight;
    private boolean kLightState = false;
    
    @FXML
    private ImageView bathroomLight;
    private boolean bthLightState = false;
    
    @FXML
    private ImageView storageLight;
    private boolean sLightState = false;
    
    @FXML
    private ImageView backYardLight;
    private boolean byLightState = false;
    
    @FXML
    private ToggleButton lockUnlock;
    private boolean lockUnlockState = false;
    
    @FXML
    private Ellipse mainHallWindow;
    
    @FXML
    private Ellipse livingRoomWindow;
    
    @FXML
    private Ellipse bedroomWindow;
    
    @FXML
    private Ellipse storageWindow;
    
    @FXML
    private Ellipse bathroomWindow;
    
    @FXML 
    private Rectangle mainDoor;
    
    @FXML 
    private Rectangle backDoor;
    
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

    private void setTempIcons(int i){
        
        Image thermo;
        Image thermal;
        
        if (i == 1){
            thermo = new Image(getClass().getResource("resources/img/thermometer.png").toString(), true);
            thermal = new Image(getClass().getResource("resources/img/thermal-off.png").toString(), true);
        }else{
            thermo = new Image(getClass().getResource("resources/img/thermometerDisabled.png").toString(), true);
            thermal = new Image(getClass().getResource("resources/img/thermal-disabled.png").toString(), true);
        }
        
        thermometer.setImage(thermo);
        thermalMainHall1.setImage(thermal);
        thermalMainHall2.setImage(thermal);
        thermalLivingRoom.setImage(thermal);
        thermalKitchen.setImage(thermal);
        thermalStorage.setImage(thermal);
        thermalBathroom.setImage(thermal);
        thermalBedroom.setImage(thermal);
    }
    
    @FXML
    public void thermalMainHall1Clicked(){
        changeThermalIcon(thermalMainHall1, tMH1State);
        tMH1State = changeState(tMH2State);
    }
    
    @FXML
    public void thermalMainHall2Clicked(){
        changeThermalIcon(thermalMainHall2, tMH2State);
        tMH2State = changeState(tMH2State);
    }
    
    @FXML
    public void thermalLivingRoomClicked(){
        changeThermalIcon(thermalLivingRoom, tLRState);
        tLRState = changeState(tLRState);
    }
    
    @FXML
    public void thermalKitchenClicked(){
        changeThermalIcon(thermalKitchen, tKState);
        tKState = changeState(tKState);
    }
    @FXML
    public void thermalStorageClicked(){
        changeThermalIcon(thermalStorage, tSState);
        tSState = changeState(tSState);
    }
    @FXML
    public void thermalBathroomClicked(){
        changeThermalIcon(thermalBathroom, tBthState);
        tBthState = changeState(tBthState);
    }
    @FXML
    public void thermalBedroomClicked(){
        changeThermalIcon(thermalBedroom, tBdState);
        tBdState = changeState(tBdState);
    }
    
    private void changeThermalIcon(ImageView img, boolean state){
        Image on = new Image(getClass().getResource("resources/img/thermal-on.png").toString(), true);
        Image off = new Image(getClass().getResource("resources/img/thermal-off.png").toString(), true);
        
        if (state) img.setImage(off);
        else img.setImage(on);
    }
    
    @FXML
    public void lightBedroomClicked(){
        changeLightIcon(bedroomLight, bdLightState);
        bdLightState = changeState(bdLightState);
    }
    
    @FXML
    public void lightBathroomClicked(){
        changeLightIcon(bathroomLight, bthLightState);
        bthLightState = changeState(bthLightState);
    }
    
    @FXML
    public void lightLivingRoomClicked(){
        changeLightIcon(livingRoomLight, lrLightState);
        lrLightState = changeState(lrLightState);
    }
    
    @FXML
    public void lightKitchenClicked(){
        changeLightIcon(kitchenLight, kLightState);
        kLightState = changeState(kLightState);
    }
    
    @FXML
    public void lightStorageClicked(){
        changeLightIcon(storageLight, sLightState);
        sLightState = changeState(sLightState);
    }
    
    @FXML
    public void lightGardenClicked(){
        changeLightIcon(gardenLight, grdLightState);
        grdLightState = changeState(grdLightState);
    }
    
    @FXML
    public void lightBackyardClicked(){
        changeLightIcon(backYardLight, byLightState);
        byLightState = changeState(byLightState);
    }
    
    private void changeLightIcon(ImageView img, boolean state){
        Image on = new Image(getClass().getResource("resources/img/lightbulb-on.png").toString(), true);
        Image off = new Image(getClass().getResource("resources/img/lightbulb-off.png").toString(), true);
        
        if (state) img.setImage(off);
        else img.setImage(on);
    }
    
    private boolean changeState(boolean state){
        state = !state;
        return state;
    }
    
    @FXML
    public void tempButtonClicked(){
        if (!onOffState){
            onOffState = changeState(onOffState);
            tempOnOff.setText("Off");
            tempInnerPanel.setDisable(false);
            setTempIcons(1);
        }else{
            onOffState = changeState(onOffState);
            tempOnOff.setText("On");
            tempInnerPanel.setDisable(true);
            setTempIcons(0);
        }                   
    }
    
    @FXML
    public void plusTemp(){
        if (Integer.parseInt(temperature.getText()) < 39){
            temperature.setText(String.valueOf(Integer.parseInt(temperature.getText()) +1));
            tempMinusButton.setDisable(false);
        }else{
            temperature.setText(String.valueOf(Integer.parseInt(temperature.getText()) +1));
            tempPlusButton.setDisable(true);
        }
    }
    
    @FXML
    public void minusTemp(){
        if (Integer.parseInt(temperature.getText()) > 11){
            temperature.setText(String.valueOf(Integer.parseInt(temperature.getText()) -1));
            tempPlusButton.setDisable(false);
        }else{
            temperature.setText(String.valueOf(Integer.parseInt(temperature.getText()) -1));
            tempMinusButton.setDisable(true);
        }
    }
    
    @FXML
    public void LockUnlockClicked(){
        if (!lockUnlockState){
            lockUnlockState = changeState(lockUnlockState);
            lockUnlock.setText("Unlock");
            setLockIcons(Color.web("#ff0505"));
        }else{
            lockUnlockState = changeState(lockUnlockState);
            lockUnlock.setText("Lock");
            setLockIcons(Color.web("#20cf27"));
        }                   
    }
    
    private void setLockIcons(Color color){
        mainDoor.setFill(color);
        mainDoor.setStroke(color);
        
        backDoor.setFill(color);
        backDoor.setStroke(color);
        
        mainHallWindow.setFill(color);
        mainHallWindow.setStroke(color);
        
        livingRoomWindow.setFill(color);
        livingRoomWindow.setStroke(color);
        
        storageWindow.setFill(color);
        storageWindow.setStroke(color);
        
        bathroomWindow.setFill(color);
        bathroomWindow.setStroke(color);
        
        bedroomWindow.setFill(color);
        bedroomWindow.setStroke(color);
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDateTime();
    }
    
    private void setDateTime(){
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