package com.example.sampleproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class CardController {
	Pane cardPane;
	
	GameWindowController gameWindow;

    @FXML
    private Text nominal;

    private int index=0;

    @FXML
    private Text mask;

    @FXML
    private ImageView imgBuffer;

    @FXML
    private Pane imgPane;

    boolean yourside;



   // @FXML
   // private Text smth;
    public int get_index(){
        return index;
    }

    public void set_index(int previousIndex){
        index=previousIndex+1;
    }
    public void setCardParameters(String nominal, String mask, GameWindowController gameWindow, Pane cardPane, boolean yourside) throws FileNotFoundException {
    	this.nominal.setText(nominal);
    	this.mask.setText(mask);
    	this.gameWindow = gameWindow;
    	this.cardPane = cardPane;
        this.yourside=yourside;


        //File img = new File("C:\\Users\\Boris\\eclipse-workspace\\Durak_0.1\\img\\EntrancePicture.jpg");
    	//InputStream isImage = (InputStream) new FileInputStream(img);
    	//imgBuffer = new ImageView(new Image(isImage));
    	//imgBuffer.setFitWidth(100);
    	//imgBuffer.setPreserveRatio(true);
    	//imgBuffer.setSmooth(true);
    	//cardPane.getChildren().add(imgBuffer);
    	
    	//imgPane = new Pane();
    	imgPane.getChildren().setAll(imgBuffer);
    	
    }
    
    public String getNominal() {
    	return this.nominal.getText();
    }
    
    public String getMask() {
    	return this.mask.getText();
    }

    @FXML
    void replaceCardToTable(MouseEvent event) throws IOException {
    	gameWindow.addCardOnTable(this);
    	cardPane.setVisible(false);
    	//FlowPane firstPlayerPane = (FlowPane) cardPane.getParent();
    	//firstPlayerPane.getChildren().remove(cardPane);
    }
}
