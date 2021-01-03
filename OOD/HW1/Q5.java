package com.company;

public class Main {

    public static void main(String[] args) {
    double grams = 1000;
    double cola = 34;
    double coffe = 160;
    double coladrink, coffedrink;
    coladrink = 10.0 * grams / cola;
    coffedrink = 10.0 * grams / coffe;
    System.out.print("The number of cola drinks to kill a person consumed at once: ");
    System.out.printf("%.2f",coladrink);
    System.out.println();
    System.out.println("The number of coffedrink drinks to kill a person consumed at once: " + coffedrink);
    }
}
