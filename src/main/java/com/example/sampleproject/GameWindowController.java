package com.example.sampleproject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GameWindowController {



    @FXML
    private Button addCardButton;

    private Button CreateDeckButton;

    private Button addCardButton2;

    int[] numbs = new int[36];

    int index=0;

    @FXML
    private GridPane deskAttackCardPane;

    @FXML
    private GridPane deskAnswerCardPane;
    
    @FXML
    private ScrollPane firstPlayerScroll;

    @FXML
    private ScrollPane secondPlayerScroll;

    @FXML
    private FlowPane firstPlayerPane;

    @FXML
    private FlowPane secondPlayerPane;

    @FXML
    void addCardtoFirst(ActionEvent event) throws IOException, InterruptedException {
    	for(int a=0;a<6;a++) {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            CardController cardController = loader.getController();

            String[] result = new String[2];

            result = CardPicking.CardPicker.getNextCard(numbs, index);






            cardController.setCardParameters(result[0], result[1], this, newPane, true);

            index++;

            firstPlayerPane.getChildren().add(newPane);

            firstPlayerScroll = new ScrollPane();
            firstPlayerScroll.setContent(firstPlayerPane);
        }
    }

    @FXML
    void Create_a_Deck(ActionEvent event) throws IOException, InterruptedException{
        int[] nums = new int[36];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(nums.length);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        numbs=nums;

    }
    @FXML
    void addCardtoSecond(ActionEvent event) throws IOException, InterruptedException {
        for(int a=0;a<6;a++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            CardController cardController = loader.getController();

            String[] result = new String[2];

            result = CardPicking.CardPicker.getNextCard(numbs, index);






            cardController.setCardParameters(result[0], result[1], this, newPane, false);

            index++;

            secondPlayerPane.getChildren().add(newPane);

            secondPlayerScroll = new ScrollPane();
            secondPlayerScroll.setContent(secondPlayerPane);
        }
    }

    public void addCardOnTable(CardController card) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Card.fxml"));
        
    	Pane newPane = (Pane)loader.load();
    	
    	CardController cardController = loader.getController();
        if (card.yourside==true) {
            cardController.setCardParameters(card.getNominal(), card.getMask(), this, newPane, true);

            deskAttackCardPane.add(newPane, deskAttackCardPane.getChildren().size(), 0);
        }else{
            cardController.setCardParameters(card.getNominal(), card.getMask(), this, newPane, true);

            deskAnswerCardPane.add(newPane, deskAnswerCardPane.getChildren().size(), 0);
        }
    }
}
