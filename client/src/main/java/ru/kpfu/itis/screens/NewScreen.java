package ru.kpfu.itis.screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.kpfu.itis.SceneMaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class NewScreen implements SceneMaker {
    private FXMLLoader loader;
    private String fxmlDocPath;
    private Scene scene;
    private Stage stage;
    private Pane pane;
    public NewScreen(String path, Stage stage) throws FileNotFoundException {
        this.stage = stage;
        this.fxmlDocPath = path;
        loader = new FXMLLoader();
        fxmlDocPath = path;
    }

    public void newScene() throws IOException {
        URL xmlUrl = getClass().getResource(fxmlDocPath);
        loader.setLocation(xmlUrl);
        pane = loader.load();
        //VBox box = (VBox)loader.load();
        scene = new Scene(pane, 700, 700);
        stage.setScene(scene);
    }
}
