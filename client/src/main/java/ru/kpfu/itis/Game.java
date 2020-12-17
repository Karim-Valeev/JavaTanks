package ru.kpfu.itis;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Game extends Application {
    static Stage window;
    Scene scene, scene1;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "/Users/musa/JavaTanks/client/src/main/resources/fxml/mainPage.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        HBox root = (HBox) loader.load(fxmlStream);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("A simple FXML Example");
        window.show();

//        FXMLLoader loader = new FXMLLoader();
//        URL xmlUrl = getClass().getResource("/fxml/main.fxml");
//        loader.setLocation(xmlUrl);
//        Parent roottt = loader.load();
////
////        window.setScene(new Scene(root));


    }
    @FXML
    private void exit(ActionEvent event) {
        event.consume();
        System.out.println("Hello, World!");
        Platform.exit();
    }
    @FXML
    private void newScene(ActionEvent event) throws IOException {
        event.consume();
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "/Users/musa/JavaTanks/client/src/main/resources/fxml/infoPage.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        HBox hBox = (HBox) loader.load(fxmlStream);
        Scene scene2 = new Scene(hBox,500,500);
        Game.window.setScene(scene2);
    }
}
