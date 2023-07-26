package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Player;
import model.Players;
import model.Team;
import model.Teams;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageTeamController extends Controller<Team> {

    public Team getTeam() { return this.model; }
    @FXML
    private TableView<Player> tableView;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableColumn<Player, Double> playerCredit;

    @FXML
    private TableColumn<Player, Integer> playerAge;

    @FXML
    private TableColumn<Player, Integer> playerNo;
    @FXML
    public static Player selectedTeam;

    @FXML
    private TextField teamTF;

    @FXML
    Button add;

    @FXML
    Button update;

    @FXML
    Button delete;

    @FXML
    Button saveAndClose;



    @FXML
    public void initialize() {
        tableView.setItems(getTeam().getCurrentPlayers());

        playerName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        playerCredit.setCellValueFactory(cellData -> cellData.getValue().getPlayerCreditProperty().asObject());
        playerAge.setCellValueFactory(cellData -> cellData.getValue().getPlayerAgeProperty().asObject());
        playerNo.setCellValueFactory(cellData -> cellData.getValue().getPlayerNoProperty().asObject());

        add.setDisable(false);
        update.setDisable(true);
        delete.setDisable(true);
        saveAndClose.setDisable(false);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                update.setDisable(false);
                delete.setDisable(false);
            } else {
                update.setDisable(true);
                delete.setDisable(true);
            }
        });
    }




    @FXML
    public void addPlayer() {
        try {
            selectedTeam = tableView.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(selectedTeam.getTeam().getPlayers(), "/view/PlayerUpdateView.fxml", "Adding New Player", stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void updatingPlayer() {

        try {
            selectedTeam = tableView.getSelectionModel().getSelectedItem();
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(selectedTeam, "/view/PlayersView.fxml", "Managing Player: " + selectedTeam.getName(), stage);
        } catch (IOException ex) {
            Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @FXML
    public void deletePlayer() {
        selectedTeam = tableView.getSelectionModel().getSelectedItem();
        if (selectedTeam != null) {
            getTeam().getCurrentPlayers().remove(selectedTeam);
        }

    }
    @FXML
    public void exit() {

        String teamName = teamTF.getText();
        selectedTeam = tableView.getSelectionModel().getSelectedItem();
        getTeam().setName(teamName);
        stage.close();
    }



}
