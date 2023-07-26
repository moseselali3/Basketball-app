package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Season;
import model.Team;
import model.Teams;

public class TeamsRoundController extends Controller<Season> {

    public Season getSeason() { return this.model; }

    private ObservableList<Team> team1AndTeam2List = FXCollections.observableArrayList();


    @FXML
    private TableColumn<Team, String> team1Column;

    @FXML
    private TableColumn<Team, String> team2Column;

    @FXML
    private TableColumn gameNumber;

    @FXML
    ListView<Team> teamListView;



    @FXML
    private TableView<Team> tableView;



    @FXML
    public void makeRound () {


        /* ObservableList<Team> team1AndTeam2List =  teamListView.getSelectionModel().getSelectedItems();

        if (teamListView.() % 2 != 0) {

            return;
        }
        tableView.setItems(team1AndTeam2List);

        team1Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        team2Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());*/

        }





    public void initialize () {

        teamListView.setItems(getSeason().getCurrentTeams());
        teamListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);




    }
}



