package com.company;

import javax.print.Doc;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Date date1 = new Date(1,20,1998);
        Doctor doctor1 = new Doctor("sherry",date1,5000, "pediatrician",100);
        System.out.println(doctor1.toString());
        Date date2 = new Date();
        Doctor doctor2 = new Doctor();

        System.out.println("the name is?");
        doctor2.setName(keyboard.next());
        System.out.println("the hire date? year?");
        date2.setYear(keyboard.nextInt());
        System.out.println("the hire date? month?");
        date2.setMonth(keyboard.nextInt());
        System.out.println("the hire date? day?");
        date2.setDay(keyboard.nextInt());

        doctor2.setHireDate(date2);
        System.out.println("based salary?");
        doctor2.setSalary(keyboard.nextInt());
        System.out.println("specially?");
        doctor2.setSpecialty(keyboard.next());
        System.out.println("visit fee?");
        doctor2.setFee(keyboard.nextInt());

        System.out.println(doctor2.toString());


    }
}
