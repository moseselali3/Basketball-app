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
import model.Validator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewPlayersController  extends Controller<Player> {

    public Player getPlayer() { return this.model; }

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
        updateButton.setDisable(false);
        addButton.setDisable(true);
        closeButton.setDisable(false);

    }

    public void updatePlayer() {

        String playerName = playerNameTF.getText();
        String playerCredit = playerCreditTF.getText();
        String playerAge = playerAgeTF.getText();
        String playerNumber = playerNumberTF.getText();

        Validator validator = new Validator();


        validator.generateErrors(playerName, playerCredit, playerAge, playerNumber);


        if (!validator.errors().isEmpty()) {

            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/view/error.png"));
                ViewLoader.showStage(getPlayer(), "/view/error.fxml", "Error!", stage);
            } catch (IOException ex) {
                Logger.getLogger(ExploreTeamsController.class.getName()).log(Level.SEVERE, null, ex);
            }

            validator.clear();
            return;
        }

        Player player = new Player(playerName, Double.parseDouble(playerCredit), Integer.parseInt(playerAge), Integer.parseInt(playerNumber));
        getPlayer().update(player.getName(),player.getCredit(),player.getAge(),player.getNo());


        playerNameTF.clear();
        playerCreditTF.clear();
        playerAgeTF.clear();
        playerNumberTF.clear();
    }

    @FXML
    public void exit() {
        stage.close();
    }


}

