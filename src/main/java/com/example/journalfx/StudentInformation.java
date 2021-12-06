package com.example.journalfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentInformation implements Initializable {


    @FXML
    private AnchorPane UserPanel;

    @FXML
    private Text Classes;

    @FXML
    private ListView<String> GradeList;

    @FXML
    private Button BackButton;

    @FXML
    private Text Date;

    @FXML
    private Text NameStudentInfo;

    @FXML
    private AnchorPane StudentInformation;

    @FXML
    private Text SurnameStudenInfo;

    public static double roundToHalf(double d) {
        return Math.round(d * 2) / 2.0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student AktualnyStudent = HelloApplication.getMyVariableStudent();
        NameStudentInfo.setText("Name: " + AktualnyStudent.Name);
        SurnameStudenInfo.setText("Surname: " + AktualnyStudent.Surname);
        Date.setText(String.valueOf("Birth Date: " + AktualnyStudent.BirthYear));
        Classes.setText(String.valueOf("Status: " + AktualnyStudent.StudentStatus));


        // srednia ocen
        Map<String, List<Integer>> oceny = HelloApplication.getMyVariableStudent().oceny;

        for(Map.Entry<String, List<Integer>> entry : oceny.entrySet())
        {
            double sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
            double sizelist = entry.getValue().size();
            double dzielenie = sum/sizelist;

            GradeList.getItems().add("Subject: " + entry.getKey() + "     Average: " + roundToHalf(dzielenie));



        }



    }

    @FXML
    void BackButton(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
        StudentInformation.getChildren().setAll(pane);

    }
}
