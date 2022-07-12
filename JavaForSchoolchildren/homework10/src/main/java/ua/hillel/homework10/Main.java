package ua.hillel.homework10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    @Override
    public void start(Stage stage){

        AtomicInteger buttonClicks = new AtomicInteger();
        Label buttonLabel = new Label("The button was clicked " + buttonClicks + " times");
        Label boxLabel = new Label("""
                First checkBox is unselected
                Second checkBox is unselected
                Third checkBox is unselected""");
        Button button = new Button("Click me!");

        CheckBox checkBox1 = new CheckBox();
        CheckBox checkBox2 = new CheckBox();
        CheckBox checkBox3 = new CheckBox();

        checkBox1.setAllowIndeterminate(true);
        checkBox2.setAllowIndeterminate(true);
        checkBox3.setAllowIndeterminate(true);

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);
        root.setStyle("-fx-background-color: #00FFFF;");

        root.add(buttonLabel,0,0);
        root.add(button,0,1);
        root.add(checkBox1,1,0);
        root.add(checkBox2,2,0);
        root.add(checkBox3,3,0);
        root.add(boxLabel, 1,1,3,3);

        button.setOnAction(actionEvent -> {
            buttonClicks.getAndIncrement();
            buttonLabel.setText("The button was clicked " + buttonClicks + " times");
        });

        checkBox1.setOnAction(actionEvent -> setCheckBoxes(boxLabel,checkBox1,checkBox2,checkBox3));
        checkBox2.setOnAction(actionEvent -> setCheckBoxes(boxLabel,checkBox1,checkBox2,checkBox3));
        checkBox3.setOnAction(actionEvent -> setCheckBoxes(boxLabel,checkBox1,checkBox2,checkBox3));


        Scene scene = new Scene(root,450,150);
        stage.setScene(scene);
        stage.setTitle("Homework 10");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setCheckBoxes(Label boxLabel, CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3){
        boxLabel.setText("First checkBox is " + (checkBox1.isSelected() ? "selected" : checkBox1.isIndeterminate() ? "indeterminate" : "unselected") +
                "\nSecond checkBox is " + (checkBox2.isSelected() ? "selected" : checkBox2.isIndeterminate() ? "indeterminate" : "unselected") +
                "\nThird checkBox is " + (checkBox3.isSelected() ? "selected" : checkBox3.isIndeterminate() ? "indeterminate" : "unselected"));
    }
}