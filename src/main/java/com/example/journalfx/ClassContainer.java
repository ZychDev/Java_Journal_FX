package com.example.journalfx;

import java.util.*;


public class ClassContainer {
    Map<String, Class> groups = new HashMap<String, Class>();

    void addClass(String group, Class newClass) {
        this.groups.put(group, newClass);
    }

    void removeClass(String group) {
        this.groups.remove(group);
    }

    ClassContainer remo(String name, ClassContainer gr)
    {

        gr.removeClass(name);

        return gr;
    }


    List<Class> findEmpty() {
        List<Class> emptyGroups = new ArrayList<>();
        for (Map.Entry<String, Class> entry : groups.entrySet()) {
            if (entry.getValue().getStudentCount() == 0) emptyGroups.add(entry.getValue());
        }
        return emptyGroups;
    }

    void summary() {
        for (Map.Entry<String, Class> entry : groups.entrySet()) {
            Class c = entry.getValue();
            System.out.printf("\n\nGroup: %s, Students number: %.2f%n",
                    c.group, (float)c.getStudentCount() );
        }
    }

    List<String> summaryNames()
    {
        List<String> GroupsNames = new ArrayList<>();
        for (Map.Entry<String, Class> entry : groups.entrySet())
        {
            Class c = entry.getValue();
            GroupsNames.add(c.getGroupName());
        }

        return GroupsNames;

    }

    List<String> summaryNamesPrzemiot()
    {
        List<String> GroupsNames = new ArrayList<>();
        for (Map.Entry<String, Class> entry : groups.entrySet())
        {
            Class c = entry.getValue();
            GroupsNames.add(c.getPrzedmiot());
        }

        return GroupsNames;

    }


    Student FindByNameStudent(String Name, String Surname)
    {

        for (Map.Entry<String, Class> entry : groups.entrySet())
        {
            Class c = entry.getValue();
            for(Student student : c.students)
            {
                if(student.Name.equals(Name) & student.Surname.equals(Surname))
                {
                    return student;
                }

            }

        }

        return null;
    }

    List<String> WchichClassesAttend(String name, String surname)
    {
        List<String> klasy = new ArrayList<>(Collections.emptyList());
        for (Map.Entry<String, Class> entry : groups.entrySet())
        {
            Class c = entry.getValue();
            for(Student student : c.students)
            {
                if(student.Name.equals(name) & student.Surname.equals(surname))
                {
                    String key = entry.getKey();
                    klasy.add(key + "   " + entry.getValue().przedmiot);
                }

            }

        }
        return klasy;
    }







    Class GetClass(String name)
    {
        for (Map.Entry<String, Class> entry : groups.entrySet())
        {
            Class c = entry.getValue();
            if(c.getGroupName() == name)
            {
                System.out.println(c.group);
                return c;
            }

        }
        return null;
    }







}

