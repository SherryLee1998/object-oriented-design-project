package com.company;

public class Main {
    public static void main(String[] args) {
	// for case test
        System.out.println("——————————————test for movies and other classes ————————————————");

        Action action1 = new Action("PG-13","A001","Terminator");
        Comedy comedy2 = new Comedy("R","C002","Titanic");
        Drama drama3 = new Drama("G","D002","Phantom of the Opera");

        System.out.println(action1);
        System.out.println("the late fee is " + action1.calculateFees(10) + "\n");


        System.out.println(comedy2);
        System.out.println("the late fee is " + comedy2.calculateFees(1)+ "\n");

        System.out.println(drama3);
        System.out.println("the late fee is " + drama3.calculateFees(10)+ "\n");

    }
}
