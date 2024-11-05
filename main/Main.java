/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Student;
import java.util.ArrayList;
import utility.MenuFunc;
import utility.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> ls= new ArrayList<>();
        Validation getInput=new Validation();
        MenuFunc getMenu=new MenuFunc();
        ls.add(new Student("a1","luong","FA24","java"));
        ls.add(new Student("a1","luong","FA24","c/c++"));
        ls.add(new Student("a1","luong","FA25","java"));
        ls.add(new Student("a2","phuong","FA24","java"));
        ls.add(new Student("a2","phuong","FA25","java"));
        ls.add(new Student("a2","phuong","FA26","java"));
        ls.add(new Student("a3","cuong","FA24","java"));
        ls.add(new Student("a3","cuong","FA25","java"));
        ls.add(new Student("a3","cuong","FA26","java"));
        ls.add(new Student("a4","muong","FA24","c/c++"));
        
        boolean check=false;
        int choice;
        while(check==false){
            getMenu.menuChoice();
            System.out.println("your choice:");
            choice= getInput.checkInputChoice();
            switch(choice){
                case 1:
                    System.out.println("create:");
                    getMenu.createStu( ls);
                    getMenu.displayrs(ls);
                    break;
                case 2:
                    System.out.println("Find N Sort");
                    getMenu.findNSort(ls);
                    break;
                case 3:
                    System.out.println("Update and Delete");
                    getMenu.upgradeNDelete(ls);
                    break;
                case 4: 
                    System.out.println("Report:");
                    getMenu.printReport(ls);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, your choice not match any funtion in menu we have. Try again!");
            }      
        }
    }
}
