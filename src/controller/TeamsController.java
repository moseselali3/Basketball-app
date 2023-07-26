package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Team;
import model.Teams;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamsController extends Controller<Teams> {

    public static Team selectedTeam;

//    @FXML
//    private TableView tableView;

    @FXML
    private Label teamTitle;

    @FXML
    private TableView<Team> tableView;

    @FXML
    private TableColumn<Team, String> teamNameColumn;

    @FXML
    private TableColumn<Team, Integer> numPlayersColumn;

    @FXML
    private TableColumn<Team, Double> avgPlayerCreditColumn;

    @FXML
    private TableColumn<Team, Double> avgAgeColumn;

    @FXML
    private Button add;
    @FXML
    private Button manage;
    @FXML
    private Button  delete;
    @FXML
    private Button close;

    public Teams  getTeams() { return this.model; }


    @FXML
    public void initialize() {
        tableView.setItems(getTeams().currentTeams());
        teamNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numPlayersColumn.setCellValueFactory(cellData -> cellData.getValue().countPlayerProperty().asObject());
        avgPlayerCreditColumn.setCellValueFactory(cellData -> cellData.getValue().countAvgCreditProperty().asObject());
        avgAgeColumn.setCellValueFactory(cellData -> cellData.getValue().countAvgAgeProperty().asObject());
        add.setDisable(false);
        manage.setDisable(true);
        delete.setDisable(true);
        close.setDisable(false);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                manage.setDisable(false);
                delete.setDisable(false);
            } else {
                manage.setDisable(true);
                delete.setDisable(true);
            }
        });
    }



    public void addMenu () {

        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(getTeams(), "/view/AddTeam.fxml", "Add Menu", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void manageMenu () {
        selectedTeam = tableView.getSelectionModel().getSelectedItem();
        if(selectedTeam != null)
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(selectedTeam, "/view/ManageTeamView.fxml", "Managing Team: " + selectedTeam.getName(), stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void deleteTeam() {
        selectedTeam = tableView.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            getTeams().remove(selectedTeam);
        }

    }
    @FXML
    public void exit() {
        stage.close();
    }


}

