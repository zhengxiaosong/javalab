package cn.evilmoon.fxlab;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Program extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField();

        Label msgLabel = new Label();
        msgLabel.setStyle("-fx-text-fill: blue;");

        Button sayhelloButton = new Button("Say Hello");
        Button exitButton = new Button("Exit");

        sayhelloButton.setOnAction(event -> {
            String name = nameField.getText();
            if (name.trim().length() > 0) {
                msgLabel.setText("Hello " + name);
            }
            else {
                msgLabel.setText("Hello there");
            }
        });

        exitButton.setOnAction(event -> Platform.exit());

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(5);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(sayhelloButton, exitButton);

        VBox root = new VBox();

        root.setSpacing(5);
        root.getChildren().addAll(nameLabel, nameField, msgLabel, buttonBox);

        Scene scene = new Scene(root, 350, 120);
        primaryStage.setScene(scene);

        primaryStage.setTitle("This is a JavaFx Demo");
        primaryStage.show();
    }
}
