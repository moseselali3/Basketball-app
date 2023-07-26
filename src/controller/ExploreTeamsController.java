package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.ViewLoader;
import model.Association;
import model.Players;
import model.Team;
import model.Teams;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExploreTeamsController extends Controller<Teams> {


    @FXML
    private ImageView nbaImage;

    @FXML
    private Button teamMenu;

    @FXML
    private Button close;

    @FXML
    private Button viewPlayers;

    public Teams  getTeams() { return this.model; }


    public void initialize() {
        Image image = new Image("view/NBA_Back.jpg");
        nbaImage.setImage(image);

//        teamMenu.getStyleClass().add("text-out");
//        close.getStyleClass().add("text-out");
//        viewPlayers.getStyleClass().add("text-out");

    }

    @FXML
    public void teamsMenu() {


        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(getTeams(), "/view/TeamsTable.fxml", "Team Menu", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

        public void viewPlayersMenu () {


            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/view/nba.png"));
                ViewLoader.showStage(getTeams(), "/view/ViewPlayers.fxml", "View Players", stage);
            } catch (IOException ex) {
                Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }








    @FXML
    public void exit() {
        stage.close();
    }


}



