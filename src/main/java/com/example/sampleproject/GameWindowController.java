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
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameWindowController {



    @FXML
    private Button addCardButton;

    private Button addCardButton2;

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

    class RandomArray {
        public static int[] getRandomArray() {
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
            return nums;
        }
    }

    @FXML
    void addCardtoFirst(ActionEvent event) throws IOException, InterruptedException {
    	for(int a=0;a<6;a++) {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            CardController cardController = loader.getController();

            CardPicking.CardPicker.getNextCard();

            cardController.setCardParameters("6", "bubi", this, newPane, true);

            firstPlayerPane.getChildren().add(newPane);

            firstPlayerScroll = new ScrollPane();
            firstPlayerScroll.setContent(firstPlayerPane);
        }
    }

    @FXML
    void addCardtoSecond(ActionEvent event) throws IOException, InterruptedException {
        for(int a=0;a<6;a++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            CardController cardController = loader.getController();

            cardController.setCardParameters("6", "bubi", this, newPane, false);

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
