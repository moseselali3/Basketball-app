package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Players;
import model.Teams;
import model.Team;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTeamController extends Controller<Teams> {

    public Teams  getTeams() { return this.model; }
    @FXML
    private TextField teamName;





    @FXML
    public void addTeam() {
        String teamNameText = teamName.getText();
        if (!getTeams().hasTeam(teamNameText)) {
            Team newTeam = new Team(teamNameText);
            getTeams().addTeam(newTeam);
        } else {

            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/view/nba.png"));
                ViewLoader.showStage(getTeams(), "/view/error.fxml", "Error!", stage);
            } catch (IOException ex) {
                Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }
}