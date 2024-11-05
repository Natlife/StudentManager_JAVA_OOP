/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class MenuFunc {

    Validation checkVar = new Validation();

    public void menuChoice() {
        System.out.println("=====Menu=====");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("Input your choice:");

    }

    public void createStu(ArrayList<Student> ls) {
        boolean check = false;
        int count = 0;
        String idStu;
        String nameStu;
        String semesterStu;
        String courseStu;
        //Count so attribute
        if (!ls.isEmpty()) {
            for (Student st : ls) {
                count++;
            }
        }
        while (check == false) {
            System.out.println("Current student info: " + count);
            if (count >= 10) {
                System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                if (!checkVar.checkInputYN()) {
                    System.out.println("Return to the main menu");
                    break;
                }
                System.out.print("Input id: ");
                idStu = checkVar.checkInputId(ls);
                System.out.println("");
                System.out.print("Input Name: ");
                nameStu = checkVar.checkInputName();
                System.out.println("");
                if (checkVar.checkSameId(ls, idStu, nameStu) == true) {
                    while (check == false) {
                        System.out.print("Input Semester: ");
                        semesterStu = checkVar.checkInputSemester();
                        System.out.println("");
                        System.out.print("Input course");
                        courseStu = checkVar.checkInputCourse();
                        if (checkVar.checkSameCourse(ls, idStu, nameStu, semesterStu, courseStu) == false) {
                            ls.add(new Student(idStu, nameStu, semesterStu, courseStu));
                            check = true;
                            System.out.println("Success");
                            count++;
                        } else {
                            System.out.println("Try Again");
                        }
                    }
                } else {
                    System.out.println("Try again.");
                }

            }
        }
        //Collections.sort(ls, Comparator.comparing(Student::getId));
    }

    public void findNSort(ArrayList<Student> ls) {
        ArrayList<Student> searchStu = new ArrayList<>();
        //Find
        System.out.println("Search by Name: ");
        String rs = checkVar.checkInputSearch();
        for (Student st : ls) {
            if (st.getStudentName().contains(rs)) {
                searchStu.add(st);
            }
        }
        if (searchStu.isEmpty()) {
            System.out.println("nothing");
        } else {
            Collections.sort(searchStu, Comparator.comparing(Student::getStudentName));
            System.out.println("====Student info=====");
            for (Student st : searchStu) {
                
                System.out.printf("%-10s%-10s%-20s%-10s%-10s%-10s%-10s\n",st.getId(),"|",st.getStudentName(),"|",st.getSemester(),"|",st.getCourseName());
                
            }
        }

        //Sort
    }

    public void upgradeNDelete(ArrayList<Student> ls) {
        //Find
        ArrayList<Student> removeLs = new ArrayList<>();
        int numberOfChange = 1;
        String newID = null;
        String newName = null;
        String newSemester;
        String newCourse;
        System.out.println("Search by ID: ");
        String rs = checkVar.checkInputSearch();
        for (Student st : ls) {
            //PRINT INFO
            boolean check = false;
            if (st.getId().equalsIgnoreCase(rs)) {
                System.out.println("====Student info=====");
                System.out.println("id: " + st.getId());
                System.out.println("name: " + st.getStudentName());
                System.out.println("-semester: " + st.getSemester());
                System.out.println("-course: " + st.getCourseName());

                System.out.println("Do you want to update(U) or delete(D) student?");
                System.out.println("Go to next student info(N) or return to the main menu(E)");
                String choice = checkVar.checkInputUD();
                newID=st.getId();
                newName=st.getStudentName();
                
                if (choice.equalsIgnoreCase("U")) {
                    //update
                    
                    while (check == false) {
                        if (numberOfChange == 1) {
                            System.out.print("Input new id: ");
                            newID = checkVar.checkInputId(ls);
                            System.out.println("");
                            System.out.print("Input new Name: ");
                            newName = checkVar.checkInputName();
                            System.out.println("");
                            if (!newID.equalsIgnoreCase(st.getId())) {
                                //NEU CHANGE ID THI CHECK ID DA CO USER CHUA:
                                //NEU CHUA THI ADD
                                //NEU CO THI NAME==LS.GETNAME
                                if (checkVar.checkSameId(ls, newID, newName) == true) {
                                    break;
                                } else {
                                    System.out.println("Your new id have been created with another name so you cant use your new name. Try again");
                                }
                            } else {
                                //NEU CHANGE NAME MA VAN GIU ID GOC
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                    //-----------
                    while (check == false) {
                        if (numberOfChange != 1) {
                            System.out.println("The new ID will be auto replace by: " + newID);
                            System.out.println("The new Name will be auto replace by: " + newName);
                        }
                        System.out.print("Input new Semester: ");
                        newSemester = checkVar.checkInputSemester();
                        System.out.println("");
                        System.out.print("Input new course:");
                        newCourse = checkVar.checkInputCourse();
                        //CHECK THE SAME BETWEEN THE NEW AND OLD DATA
                        //true is not change
                        //false is change and must check same course in the ls
                        if (newID.equalsIgnoreCase(st.getId())
                                && newName.equalsIgnoreCase(st.getStudentName())
                                && newSemester.equalsIgnoreCase(st.getSemester())
                                && newCourse.equalsIgnoreCase(st.getCourseName())) {
                            System.out.println("There are nothing change!");
                            check = true;

                        } else {
                            if (checkVar.checkSameCourse(ls, newID, newName, newSemester, newCourse) == false) {
                                st.setId(newID);
                                st.setStudentName(newName);
                                st.setSemester(newSemester);
                                st.setCourseName(newCourse);
                                check = true;
                                System.out.println("Update success");
                                numberOfChange++;
                            } else {
                                System.out.println("Try Again");
                            }
                        }

                    }
                } else if (choice.equalsIgnoreCase("D")) {
                    //delete
                    removeLs.add(st);

                    System.out.println("Delete success");

                } else if (choice.equalsIgnoreCase("N")) {
                    if (numberOfChange != 1) {
                        System.out.println("The new ID will be auto replace by: " + newID);
                        System.out.println("The new Name will be auto replace by: " + newName);
                        
                        st.setId(newID);
                        st.setStudentName(newName);
                    }
                    else{
                        numberOfChange++;
                    }
                    System.out.println("Next");
                } else if (choice.equalsIgnoreCase("E")) {
                    System.out.println("return to main menu");
                    break;
                }

            }

            //-------------
        }
        ls.removeAll(removeLs);
    }

    public void printReport(ArrayList<Student> ls) {
        ArrayList<Report> rp = new ArrayList<>();
        String newID;
        String newName;
        String newCourse;
        int count = 0;
        Collections.sort(ls, Comparator.comparing(Student::getStudentName));
        if (ls.isEmpty()) {
            System.out.println("nothing inside");
        }
        
        System.out.printf("%-20s%-10s\n","Student name","Course");
        for (Student st : ls) {
            count = 0;
            newID = st.getId();
            newName = st.getStudentName();
            newCourse = st.getCourseName();
            System.out.printf("  %-20s%-10s \n",st.getStudentName(),st.getCourseName());
            for (Student stCount : ls) {
                if (newID.equalsIgnoreCase(stCount.getId())
                        && newCourse.equalsIgnoreCase(stCount.getCourseName())) {
                    count++;

                }
            }

            if (checkVar.checkReport(rp, newName, newCourse, count)) {

                rp.add(new Report(newName, newCourse, count));
            }
        }

        for (Report r : rp) {
            System.out.println(r.getStudentName() + "|" + r.getCourseName() + "|" + r.getTotalCourse());
        }

    }

    public void displayrs(ArrayList<Student> ls) {
        for (Student st : ls) {
            System.out.println("-------------------------------------------");
            System.out.println(st.getId());
            System.out.println(st.getStudentName());
            System.out.println(st.getSemester());
            System.out.println(st.getCourseName());

        }
    }
}
