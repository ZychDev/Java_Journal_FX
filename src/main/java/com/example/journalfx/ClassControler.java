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

public class ClassControler implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private ListView<String> ClassesList;

    @FXML
    private AnchorPane rootPane;

    @FXML
    void BackButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ClassContainer klasy = HelloApplication.getMyVariable();
        List<String> nazwyKlas =  klasy.summaryNames();
        List<String> nazwyPrzemiotow = klasy.summaryNamesPrzemiot();
        for(int i = 0; i < nazwyKlas.size(); i++)
        {
            ClassesList.getItems().add("Nazwa Klasy: " + nazwyKlas.get(i) + " Przedmiot: " + nazwyPrzemiotow.get(i));
        }


    }
}
