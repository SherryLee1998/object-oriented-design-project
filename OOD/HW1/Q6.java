package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    // item 1
    System.out.println("Input name of item 1: ");
    String item1 = keyboard.nextLine();
    System.out.println("Input quantity of item 1: ");
    double item1_quantity = keyboard.nextDouble();
    System.out.println("Input price of item 1:  ");
    double item1_prince = keyboard.nextDouble();
    keyboard.nextLine();
    // item 2
    System.out.println("Input name of item 2: ");
    String item2 = keyboard.nextLine();
    System.out.println("Input quantity of item 2: ");
    double item2_quantity = keyboard.nextDouble();
    System.out.println("Input price of item 2:  ");
    double item2_prince = keyboard.nextDouble();
    keyboard.nextLine();
    // item 3
    System.out.println("Input name of item 3: ");
    String item3 = keyboard.nextLine();
    System.out.println("Input quantity of item 3: ");
    double item3_quantity = keyboard.nextDouble();
    System.out.println("Input price of item 3:  ");
    double item3_prince = keyboard.nextDouble();
    keyboard.nextLine();
    String item = "Item";
    String quan = "Quantity";
    String price = "Price";
    String total = "Total";

    System.out.println("Your bill:");
    System.out.printf("%-30s %-10s %-10s %-10s\n",item, quan,price,total);
    System.out.printf("%-30s %-10.0f %-10.2f %-10.2f\n",item1, item1_quantity,item1_prince,(item1_quantity * item1_prince));
    System.out.printf("%-30s %-10.0f %-10.2f %-10.2f\n",item2, item2_quantity,item2_prince,(item2_quantity * item2_prince));
    System.out.printf("%-30s %-10.0f %-10.2f %-10.2f\n",item3, item3_quantity,item3_prince,(item3_quantity * item3_prince));


    String sub = "Subtotal";
    String tax = "6.25% sales tax";
    String block = " ";
    double beforetax = item1_quantity * item1_prince + item2_quantity * item2_prince + item3_quantity * item3_prince;
    System.out.printf("%-30s %10s %10s %-10.2f\n",sub, block,block,beforetax);
    System.out.printf("%-30s %10s %10s %-10.2f\n",tax, block,block,beforetax * 0.0625);
    System.out.printf("%-30s %10s %10s %-10.2f\n",total, block,block,beforetax * 1.0625);

    }
}
