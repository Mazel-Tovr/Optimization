package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Form extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private AnchorPane mainPanel;
    @Override
    public void start(Stage primaryStage)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FormConfig.fxml"));
        primaryStage.setTitle("Программа поиска точек перегиба функций");
        primaryStage.setScene(new Scene(root, 450,400));
        primaryStage.show();
    }
}
