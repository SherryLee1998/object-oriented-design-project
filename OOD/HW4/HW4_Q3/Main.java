package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    Person tom = new Person("Tom");
	Truck truck1 = new Truck("Sherry_maker",5,tom,90,10);
	System.out.println(truck1.toString());

	Truck truck2 = new Truck();
	System.out.println("The manufacture is: ");
	truck2.setMaker(keyboard.next());
    System.out.println("The cylinders are: ");
    truck2.setCylinders(keyboard.nextInt());
    System.out.println("The owner is: ");
    truck2.setName(keyboard.next());
    System.out.println("The tons is: ");
    truck2.setLoad_tons(keyboard.nextInt());
    System.out.println("The pounds is: ");
    truck2.setLoad_pounds(keyboard.nextInt());

    System.out.println(truck2.toString());
    boolean output= truck1.equals(truck2);
    if(output)
        System.out.println("same");
    else{
            System.out.println("not same");
        }

    }
}
