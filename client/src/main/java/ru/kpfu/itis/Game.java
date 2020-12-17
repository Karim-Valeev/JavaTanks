package ru.kpfu.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;

public class Game extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Canvas Test");
        window.setMinWidth(700);
        window.setMinHeight(700);
        window.setResizable(true);

        Group root = new Group();
        Scene gamingScene = new Scene(root);
        window.setScene(gamingScene);

//        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
//        Image image = new Image(iconStream);
//        window.getIcons().add(image);

//        Label helloWorldLabel = new Label("Hello world!");
//        helloWorldLabel.setAlignment(Pos.CENTER);
//        Scene primaryScene = new Scene(helloWorldLabel);
//        window.setScene(primaryScene);

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/fxml/main.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        window.setScene(new Scene(root));

        window.show();
    }
}
