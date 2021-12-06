package com.example.journalfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class UserPanel {


    @FXML
    private Button ClassesInformation;

    @FXML
    private Button Grades;

    @FXML
    private Button StudentInfo;


    @FXML
    private Button Subject;

    @FXML
    private AnchorPane UserPanel;

    @FXML
    void AvailableClassesButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Classes.fxml")));
        UserPanel.getChildren().setAll(pane);

    }

    @FXML
    void GradesButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MojeOceny.fxml")));
        UserPanel.getChildren().setAll(pane);
    }

    @FXML
    void InformationButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StudentInformation.fxml")));
        UserPanel.getChildren().setAll(pane);
    }

    @FXML
    void SubjectSignButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SchiilSubjectSigned.fxml")));
        UserPanel.getChildren().setAll(pane);
    }



}
