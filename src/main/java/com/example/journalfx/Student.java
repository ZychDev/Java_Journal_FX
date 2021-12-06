package com.example.journalfx;


import java.util.*;

public class Student implements java.lang.Comparable {

    Map<String, List<Integer>> oceny = new HashMap<>();


    void addOcena(String Subject, int ocena)
    {

        if(oceny.containsKey(Subject))
        {
            oceny.get(Subject).add(ocena);
        }
        else
        {
            List<Integer> list = new ArrayList<>();
            list.add(ocena);
            oceny.put(Subject, list);
        }

    }


    public String Name, Surname;
    public StudentCondition StudentStatus;
    public Integer BirthYear;
    double PointsNumber;

    public Student(String Name, String Surname, StudentCondition StudentStatus, Integer BirthYear, double  Points){

        this.Name = Name;
        this.Surname = Surname;
        this.StudentStatus = StudentStatus;
        this.BirthYear = BirthYear;
        this.PointsNumber = Points;

    }

    public void print(){
        System.out.println("\nStudent Info:");
        System.out.println(Name + " " + Surname);
        System.out.println("Year of birth: " + BirthYear);
        System.out.println("Lesson status: " + StudentStatus + ", Points: " + PointsNumber);
        System.out.println("\n");

    }

    String getStatus()
    {
        String tmp = "";
        if(this.StudentStatus == StudentCondition.Present)
        {
            tmp = "Present";
            return tmp;
        }
        else if(this.StudentStatus == StudentCondition.Absent)
        {
            tmp = "Absent";
            return tmp;
        }
        else
        {
            tmp = "Sick";
            return tmp;
        }

    }




    public int CompareTo(Student OtherStudent) {
        return Surname.equals(OtherStudent.Surname) ? 1 : 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
