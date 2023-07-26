package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Season;
import model.Team;
import model.Teams;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeasonController extends Controller<Season> {


    public Season getSeason() { return this.model; }
    @FXML
    Button round;

    @FXML
    Button current;

    @FXML
    Button game;

    @FXML
    Button result;

    @FXML
    Button close;

    @FXML
    ImageView nbaImage;



    @FXML
    public void arrangeRound () {

        try{
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(getSeason(), "/view/SeasonRoundView.fxml", "Arrange a Season", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void showCurrentRound () {


        try{
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(getSeason(), "/view/CurrentRoundTeams.fxml", "Current Round", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showGameResults () {

        Stage stage = new Stage();
        stage.setTitle("Game Results");
        stage.getIcons().add(new Image("/view/nba.png"));

        Label messageLabel = new Label("Message:");
        Font font = new Font(50);
        messageLabel.setFont(font);

        Button button = new Button("Okay");
        button.setOnAction(event -> {
            stage.close();
        });

        VBox vBox = new VBox(messageLabel,button);
        vBox.setAlignment(Pos.CENTER);
        vBox.getStyleClass().add("background");
        vBox.setPrefHeight(225);
        vBox.setPrefWidth(400);
        vBox.setSpacing(20);





        Scene scene = new Scene(vBox);
        scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

    }

    public void seasonResults () {

        try{
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(getSeason(), "/view/RecordView.fxml", "Arrange a Season", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




    public void initialize() {


                }


//        ObservableList<Team> teams = getSeason().getCurrentTeams();
//        playerListView.setItems(teams);




    @FXML
    public void exit() {
        stage.close();
    }

}

