package com.anita.helloworld;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

import com.sun.javafx.css.PseudoClassState;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new StackPane());
        Locale.setDefault(Locale.ENGLISH);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/MainUI.fxml"));
        scene.setRoot(loader.load());
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Concert+One");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Luckiest+Guy");
        primaryStage.setTitle("HELLO.WORLD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    Button menu_button_hello,menu_button_list,menu_button_chat,menu_button_game,menu_button_setting,menu_button_logout;
    @FXML
    Pane pane_hello,pane_list,pane_game,pane_setting,pane_chat;


    public void initialize() {
        menu_button_hello.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), true);
        menu_button_hello.setOnAction(e -> choice(0));
        menu_button_list.setOnAction(e -> choice(1));
        menu_button_chat.setOnAction(e -> choice(2));
        menu_button_game.setOnAction(e -> choice(3));
        menu_button_setting.setOnAction(e -> choice(4));
        menu_button_logout.setOnAction(e -> choice(5));

        pane_hello.setVisible(true);
        pane_list.setVisible(false);
        pane_chat.setVisible(false);
        pane_game.setVisible(false);
        pane_setting.setVisible(false);
    }

    public void choice(int num) {
        switch(num) {
            case 0:
                setColor(menu_button_hello);
                setPane(pane_hello);
                break;
            case 1:
                setColor(menu_button_list);
                setPane(pane_list);
                break;
            case 2:
                setColor(menu_button_chat);
                setPane(pane_chat);
                break;
            case 3:
                setColor(menu_button_game);
                setPane(pane_game);
                break;
            case 4:
                setColor(menu_button_setting);
                setPane(pane_setting);
                break;
            case 5:
                setColor(menu_button_logout);
                break;
        }
    }
    public void setColor(Button choice) {
        menu_button_hello.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);
        menu_button_list.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);
        menu_button_chat.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);
        menu_button_game.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);
        menu_button_setting.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);
        menu_button_logout.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), false);

        choice.pseudoClassStateChanged(PseudoClassState.getPseudoClass("bgc"), true);
    }
    public void setPane(Pane choice) {
        pane_hello.setVisible(false);
        pane_list.setVisible(false);
        pane_chat.setVisible(false);
        pane_game.setVisible(false);
        pane_setting.setVisible(false);

        choice.setVisible(true);
    }
}
