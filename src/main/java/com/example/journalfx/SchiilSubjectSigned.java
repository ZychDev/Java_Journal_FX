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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class SchiilSubjectSigned implements Initializable {

    @FXML
    private Button Backby;

    @FXML
    private ListView<String> ListaNazw;

    @FXML
    private AnchorPane NowyPanel;

    @FXML
    void BackButton(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
        NowyPanel.getChildren().setAll(pane);
    }

    @FXML
    void Nazwy(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String name = HelloApplication.getMyVariableStudent().Name;
        String surname = HelloApplication.getMyVariableStudent().Surname;

        List<String> mojeZajecia =  HelloApplication.getMyVariable().WchichClassesAttend(name, surname);

        for(String zajecia : mojeZajecia)
        {
            ListaNazw.getItems().add(zajecia);
        }
    }

}
