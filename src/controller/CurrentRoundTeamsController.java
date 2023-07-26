package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Season;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentRoundTeamsController extends Controller<Season> {

    @FXML
    public void exit() {
        stage.close();
    }
}







