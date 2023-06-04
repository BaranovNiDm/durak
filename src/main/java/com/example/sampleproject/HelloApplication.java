package com.example.sampleproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EntranceWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
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
        int[] numbs = RandomArray.getRandomArray();
    }
}