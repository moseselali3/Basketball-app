package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Player;
import model.Players;
import model.Validator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerUpdateController extends Controller<Players> {


    public Players getPlayers() { return this.model; }



    @FXML
    TextField playerNameTF;

    @FXML
    TextField  playerCreditTF;

    @FXML
    TextField  playerAgeTF;

    @FXML
    TextField  playerNumberTF;



    @FXML
    Button updateButton;

    @FXML
    Button addButton;

    @FXML
    Button closeButton;

    @FXML
    public void initialize() {
    updateButton.setDisable(true);
    addButton.setDisable(false);
    closeButton.setDisable(false);

    }

    @FXML
    public void addPlayer() {

        String playerName = playerNameTF.getText();
        String playerCredit = playerCreditTF.getText();
        String playerAge = playerAgeTF.getText();
        String playerNumber = playerNumberTF.getText();



        Validator validator = new Validator();


        validator.generateErrors(playerName, playerCredit, playerAge, playerNumber);


        if (validator.errors().isEmpty()) {
            Player player = new Player(playerName, Double.parseDouble(playerCredit), Integer.parseInt(playerAge), Integer.parseInt(playerNumber));
            System.out.println(player.getName());
            System.out.println(player.getNo());
            System.out.println(player.getCredit());

            getPlayers().addPlayer(player);

            playerNameTF.clear();
            playerCreditTF.clear();
            playerAgeTF.clear();
            playerNumberTF.clear();
            validator.clear();

        } else {

            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/view/error.png"));
                ViewLoader.showStage(getPlayers(), "/view/error.fxml", "Error!", stage);
            } catch (IOException ex) {
                Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }



        }




    }

    @FXML
    public void exit() {
        stage.close();
    }
}

