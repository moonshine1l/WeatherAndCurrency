package ru.moonshine1l.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 702, 588);
        stage.getIcons().add(new Image("ru/moonshine1l/weather/WeatherCat.png"));
        stage.setTitle("Погода");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}