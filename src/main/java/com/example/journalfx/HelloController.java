package com.example.journalfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;




public class HelloController {


    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button Button_LogIn;

    @FXML
    private TextField Password;

    @FXML
    private TextField Username;

    @FXML
    void Button_Log(ActionEvent event) throws IOException {
        System.out.println("Username: " + Username.getText());
        System.out.println("Password: " + Password.getText());




        if(Username.getText().equals("Admin") & Password.getText().equals("admin"))
        {
            System.out.println("Admin Here");
            System.out.println(HelloApplication.getMyVariable().summaryNames());
        }
        else
        {

            if( HelloApplication.getMyVariable().FindByNameStudent(Username.getText(), Password.getText()) != null )
            {
                HelloApplication.setMyVariableStudent(HelloApplication.getMyVariable().FindByNameStudent(Username.getText(), Password.getText()));
                AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
                rootPane.getChildren().setAll(pane);
            }
            else
            {

                Alert alert = new Alert(Alert.AlertType.ERROR, "You entered the wrong data, try again! ", ButtonType.YES);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES)
                {
                    AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                    rootPane.getChildren().setAll(pane);
                }
            }




            // otwarcie nowego wygladu okna
            //AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-view.fxml")));
            //rootPane.getChildren().setAll(pane);
            


        }
    }

    @FXML
    void PasswordField(ActionEvent event) {

    }

    @FXML
    void UsernameField(ActionEvent event) {

    }


}
