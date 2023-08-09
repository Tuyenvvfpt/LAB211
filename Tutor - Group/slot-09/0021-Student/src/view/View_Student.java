/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Student {

    ManageStudent manage = new ManageStudent();

    void inputStudent() {
        //check list size is 10
        if (manage.getList().size() >= 10) {
            System.out.println("List student is: " + manage.getList().size());
            if (checkYesNo() == false) {
                return;
            }
        }

        //input student
        String id = getId();

        //find record have id in list
        String name = manage.getStudentNameByID(id);
        //if name == null => (input name ) 
        if (name == null) {
            name = getName();
        } else {
            System.out.println("Enter name: " + name);
        }

        int semester = getSemester();
        int course = getCourse();

        //add to list
        boolean result = manage.checkCreateStudent(id, name, semester, course);
        if (result == false) {
            System.out.println("Duplicate !!!");
        }

    }

    private String getId() {
        String id = Utility.getString("Enter id: ", Utility.REGEX_STRING, "Wrong");
        return id;
    }

    private String getName() {
        String name = Utility.getString("Enter name: ", Utility.REGEX_STRING, "Wrong");
        return name;
    }

    private int getSemester() {
        int semester = Utility.getInt("Enter semester: ", "Wrong", "Wrong", "Wrong", 1, 10);
        return semester;
    }

    private int getCourse() {
        int course = Utility.getInt("Enter course\n (1.Java || 2. .Net || 3. C/C++): ",
                "Wrong", "Wrong", "Wrong", 1, 3);
        return course;
    }

    private boolean checkYesNo() {
        String input = Utility.getString("Do you want to continue? (y/n)? ", Utility.REGEX_YN, "Wrong");
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    void findAndSort() {
        //input name
        String name = getName();
        //search by name
        List<Student> listSearch = manage.getStudentByName(name);

        //if listsearch empty => not found
        if (listSearch.isEmpty()) {
            System.out.println("NOT FOUND");
            return;
        }

        //sort by name
        Collections.sort(listSearch, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        //display
        System.out.printf("%-10s %-15s %-5s %-10s\n", "ID", "Name", "Semester", "Course");
        for (Student student : listSearch) {
            System.out.println(student);
        }
    }

    void updateOrDelete() {
        //input id
        String id = getId();

        //find students by ID
        List<Student> listFoundByID = manage.getStudentByID(id);
        if (listFoundByID.isEmpty()) {
            System.out.println("NOT FOUND !!!");
        } else {
            // check update or delete
            //U = true || D = false
            if (checkUpdateOrDelete()) {
                updateStudent(listFoundByID);
            } else {
                deleteStudent(listFoundByID);
            }
        }
    }

    private void deleteStudent(List<Student> listFoundByID) {
        displayListFoundByID(listFoundByID);

        int choice = Utility.getInt("Enter record you want to delete: ",
                "Must be greater than min", "Must be less than min", "Wrong", 1,
                listFoundByID.size());

        Student student = listFoundByID.get(choice - 1);

        manage.removeStudent(student);
        System.out.println("Delete successfull !!!");
    }

    private void updateStudent(List<Student> listFoundByID) {
        displayListFoundByID(listFoundByID);

        int choice = Utility.getInt("Enter record you want to delete: ",
                "Must be greater than min", "Must be less than min", "Wrong", 1,
                listFoundByID.size());

        Student student = listFoundByID.get(choice - 1);

        //get properties of student
        String idUpdate = student.getId();
        String nameUpdate = student.getName();
        int semesterUpdate = student.getSemester();
        int courseUpdate = student.getCourse();

        //check user want to update ?
        if (checkWantUpdate("id")) {
            idUpdate = getId();
        }
        if (checkWantUpdate("name")) {
            nameUpdate = getName();
        }
        if (checkWantUpdate("semester")) {
            semesterUpdate = getSemester();
        }
        if (checkWantUpdate("course")) {
            courseUpdate = getCourse();
        }

        //check not update
        if (manage.checkNotUpdate(idUpdate, nameUpdate, semesterUpdate, courseUpdate, student)) {
            System.out.println("You not update !!!");
        } // check duplicate
        else if (manage.checkDuplicate(idUpdate, student.getName(), semesterUpdate, courseUpdate)) {
            System.out.println("Duplicate !!!");
        } else {
            //update
            student.setId(idUpdate);
            manage.updateAllName(nameUpdate, idUpdate);
            student.setSemester(semesterUpdate);
            student.setCourse(courseUpdate);
        }

    }

    private boolean checkUpdateOrDelete() {
        String input = Utility.getString("Do you want to update ( U ) or delte (D)? ",
                Utility.REGEX_UD, "Wrong");
        return input.equalsIgnoreCase("u") ? true : false;
    }

    private void displayListFoundByID(List<Student> listFoundByID) {
        System.out.printf("%-5s %-10s %-15s %-10s %-10s\n", "No", "ID", "Name", "Semester", "Course");

        for (int i = 0; i < listFoundByID.size(); i++) {
            System.out.printf("%-5s %s\n", i + 1, listFoundByID.get(i));
        }
    }

    void hienthi() {
        displayListFoundByID(manage.getList());
    }

    private boolean checkWantUpdate(String message) {
        String input = Utility.getString("Do you want to update " + message + " ? (y/n)? ",
                Utility.REGEX_YN, "Wrong");
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    void report() {
        manage.getListReport().clear();

        for (Student first : manage.getList()) {
            if (manage.checkExistReport(first) == false) {
                int total = 0;

                for (Student second : manage.getList()) {
                    if (first.getId().equalsIgnoreCase(second.getId())
                            && first.getCourse() == second.getCourse()) {
                        total++;
                    }
                }

                manage.getListReport().add(new Report(first.getId(), first.getName(),
                         first.getCourse(), total));
            }

        }
        System.out.printf("%-20s | %-10s | %-10s\n", "Name", "Course", "Total Course");
        for (Report report : manage.getListReport()) {
            System.out.println(report);
        }
    }

}
