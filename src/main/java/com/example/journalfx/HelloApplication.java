package com.example.journalfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {





    private static ClassContainer All_Classes;

    public static ClassContainer getMyVariable() {
        return All_Classes;
    }


    public void setMyVariable(ClassContainer myVariable) {
        this.All_Classes = myVariable;
    }




    public static Student Actual_Student;

    public static Student getMyVariableStudent() {
        return Actual_Student;
    }

    public static void setMyVariableStudent(Student myVariable) {
        Actual_Student = myVariable;
    }







    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // dodawanie studentow
        Student student1 = new Student("Szymon", "Zych", StudentCondition.Absent, 2000, 10.0);
        Student student2 = new Student("Jan", "Zych", StudentCondition.Absent, 1999, 5.0);
        Student student3 = new Student("Mateusz", "Matczak", StudentCondition.Absent, 1998, 2.0);
        Student student4 = new Student("Szymon", "Entyk", StudentCondition.Present, 1997, 15.0);
        Student student5 = new Student("Jan", "Rapowanie", StudentCondition.Present, 2001, 5.0);
        Student student6 = new Student("Mateusz", "Ksyrejowicz", StudentCondition.Present, 1999, 13.0);

        // dodawanie ocen
        student1.addOcena("Math", 5);
        student1.addOcena("Math", 4);
        student1.addOcena("Math", 5);
        student1.addOcena("Math", 1);
        student1.addOcena("Physics", 2);
        student1.addOcena("Physics", 3);
        student1.addOcena("Math", 2);

        // stworzenie klasy uczniow
        Class ClassA = new Class("Class A", 15, "Math");
        ClassA.addStudent(student1);
        ClassA.addStudent(student2);

        Class ClassB = new Class("Class B", 10, "Physics");
        ClassB.addStudent(student4);
        ClassB.addStudent(student5);
        ClassB.addStudent(student6);
        ClassB.addStudent(student1);

        Class ClassC = new Class("Class C", 10, "Biology");
        ClassC.addStudent(student3);


        // tworzenie miejsca na klasy
        ClassContainer Group = new ClassContainer();
        Group.addClass(ClassA.group, ClassA);
        Group.addClass(ClassB.group, ClassB);
        Group.addClass(ClassC.group, ClassC);

        // przypisanie klas do zmiennej
        setMyVariable(Group);
        //HelloController test  = new HelloController(student1);

    }



    public static void main(String[] args) {
        launch();
    }
}