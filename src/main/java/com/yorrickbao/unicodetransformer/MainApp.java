package com.yorrickbao.unicodetransformer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("rootView.fxml"));
        primaryStage.setTitle("unicode转换工具 v0.1.0");
        primaryStage.setScene(new Scene(root, 300, 160));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
