/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkInputChoice() {
        boolean check = false;
        int rs = 0;
        while (check == false) {
            try {
                rs = sc.nextInt();
                if (rs > 0 && rs < 6) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Try again");
                sc.nextLine();
            }
        }
        return rs;
    }

    public String checkInputSearch() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                check = true;
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
        return rs;
    }

    public boolean checkInputYN() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                if (rs.equalsIgnoreCase("Y")) {
                    return true;
                } else if (rs.equalsIgnoreCase("N")) {
                    return false;
                }

            } catch (Exception e) {
                System.out.println("Try again");
                sc.nextLine();
            }
        }
        return false;
    }

    public String checkInputUD() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();

                if (rs.equalsIgnoreCase("U")) {
                    return rs;
                }
                if (rs.equalsIgnoreCase("D")) {
                    return rs;
                }
                if (rs.equalsIgnoreCase("N")) {
                    return rs;
                }
                if (rs.equalsIgnoreCase("E")) {
                    return rs;
                }

            } catch (Exception e) {
                System.out.println("Try again");

            }
        }
        return null;
    }

    public String checkInputId(ArrayList<Student> ls) {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                check = true;
            } catch (Exception e) {
                System.out.println("Try again");
                sc.nextLine();
            }
        }
        return rs;
    }

    public String checkInputName() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                check = true;
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
        return rs;
    }

    public String checkInputSemester() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                check = true;
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
        return rs;
    }

    public String checkInputCourse() {
        boolean check = false;
        String rs = null;
        while (check == false) {
            try {
                rs = sc.nextLine().trim();
                if (rs.equalsIgnoreCase("Java")
                        || rs.equalsIgnoreCase("C/C++")
                        || rs.equalsIgnoreCase("LAB")) {
                    check = true;
                } else {
                    System.out.println("Not match. Try again");
                }
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
        return rs;
    }
//-------------------------------------------------------------------------------------------------------------
//ID check all

    public boolean checkSameId(ArrayList<Student> ls, String idCheck, String nameCheck) {
        for (Student student : ls) {
       
            if (idCheck.equalsIgnoreCase(student.getId())//NEW ID == LS.GETID, NEW NAME== LS.GETNAME
                    && nameCheck.equalsIgnoreCase(student.getStudentName())) {
                return true;
            }
            if (idCheck.equalsIgnoreCase(student.getId())//NEW ID == LS.GETID, NEW NAME != LS.GETNAME
                    && nameCheck.equalsIgnoreCase(student.getStudentName()) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSameCourse(ArrayList<Student> ls, String idCheck, String nameCheck, String semesterCheck, String courseCheck) {
        for (Student student : ls) {
            if (idCheck.equalsIgnoreCase(student.getId())
                    && nameCheck.equalsIgnoreCase(student.getStudentName())
                    && semesterCheck.equalsIgnoreCase(student.getSemester())
                    && courseCheck.equalsIgnoreCase(student.getCourseName())) {
                return true;
            }
        }
        return false;

    }
//-------------------------------------------------------------------------------------------------------------

    //---------------------------------------------
    public boolean checkReport(ArrayList<Report> rp, String checkName, String checkCourse, int count) {
        if (rp.isEmpty()) {
            return true;
        }
        boolean check = false;
        for (Report r : rp) {
            if (checkName.equalsIgnoreCase(r.getStudentName())
                    && checkCourse.equalsIgnoreCase(r.getCourseName())) {
                check = false;
                break;
            }
            if ((checkName.equalsIgnoreCase(r.getStudentName())
                    && !checkCourse.equalsIgnoreCase(r.getCourseName()))) {
                check = true;
            }
            if (!checkName.equalsIgnoreCase(r.getStudentName())) {
                check = true;
            }

        }
        return check;
    }
}
