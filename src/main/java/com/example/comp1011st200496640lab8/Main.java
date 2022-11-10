package com.example.comp1011st200496640lab8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("netflix-table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image("C:\\Users\\Ali\\IdeaProjects\\COMP1011-St200496640-lab8_2\\src\\main\\resources\\com\\example\\comp1011st200496640lab8\\icon.png"));
        stage.setTitle("Netflix!");
        stage.setScene(scene);
        stage.show();
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    public static void main(String[] args) {
        launch();
    }
}