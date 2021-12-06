package com.example.journalfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MojeOceny implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private ListView<String> GradesList;

    @FXML
    private AnchorPane Panel;

    @FXML
    void ButtonBack(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
        Panel.getChildren().setAll(pane);
    }

    @FXML
    void GradesList(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Map<String, List<Integer>> oceny = HelloApplication.getMyVariableStudent().oceny;

        for(Map.Entry<String, List<Integer>> entry : oceny.entrySet())
        {
            GradesList.getItems().add("Subject: " + entry.getKey() + "     Oceny: " + entry.getValue());
            //System.out.println("test      " + entry.getKey() + "       " + entry.getValue());
        }

    }
}
