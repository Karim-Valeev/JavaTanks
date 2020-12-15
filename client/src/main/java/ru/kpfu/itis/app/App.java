package ru.kpfu.itis.app;

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

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Hello world Application");
        window.setWidth(300);
        window.setHeight(200);

//        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
//        Image image = new Image(iconStream);
//        window.getIcons().add(image);

        Label helloWorldLabel = new Label("Hello world!");
        helloWorldLabel.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(helloWorldLabel);
        window.setScene(primaryScene);

//        FXMLLoader loader = new FXMLLoader();
//        URL xmlUrl = getClass().getResource("/home/walai_kami/Desktop/JavaTanks/client/src/main/resources/fxml/main.fxml");
//        loader.setLocation(xmlUrl);
//        Parent root = loader.load();

//        window.setScene(new Scene(root));
        window.show();

        window.show();
    }
}
