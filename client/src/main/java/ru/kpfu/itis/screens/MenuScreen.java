package ru.kpfu.itis.screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.kpfu.itis.SceneMaker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class MenuScreen implements SceneMaker {
    private FXMLLoader loader;
    private String fxmlDocPath;
    private Scene scene;
    private Stage stage;
    public MenuScreen(String path, Stage stage) throws FileNotFoundException {
        this.stage = stage;
        this.fxmlDocPath = path;
        loader = new FXMLLoader();
        fxmlDocPath = path;
    }
    @Override
    public void newScene() throws IOException {
        URL xmlUrl = getClass().getResource(fxmlDocPath);
        loader.setLocation(xmlUrl);
        VBox box = (VBox)loader.load();
        scene = new Scene(box, 300, 300);
        stage.setScene(scene);
    }
}
