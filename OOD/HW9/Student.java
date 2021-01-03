package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {

    public void addEntry(){
        HashMap<Integer, ArrayList<String>> students = new HashMap<Integer, ArrayList<String>>();
        String course;
        int studentID;
        Scanner keyboard = new Scanner( System.in );
        System.out.println("Enter Student ID followed by course number, -1 for stop");
        while(true){
            String line = keyboard.nextLine();
            String[] split = line.split(" ");
            if(!split[0].equals( "-1" )){
                studentID = Integer.parseInt( split[0] );
                course = split[1];
                if(students.containsKey( studentID )){
                    students.get(studentID).add( course );
                }
                else{
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add( course );
                    students.put( studentID,temp );
                }
            }
            else break;
        }

        System.out.println("Course information: ");
        print(students);
    }

    private void print(HashMap<Integer, ArrayList<String>> students){
        for(Integer key: students.keySet()){
            System.out.print("Student ID: "+ key + "  courses：");
            for(String c: students.get( key )){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Student test = new Student();
        //test case:
        // "1 CS100", "2 MATH210", "2 CS105", "1 ENG203", "3 CS1023", "3 CS103", "3 CS104", "4 MATH101","4 ENG130","5 ACC210", "5 ACC220",  "5 ACC221", "5 ACC222", "-1 ACC102"
        test.addEntry();
        
    }
}
