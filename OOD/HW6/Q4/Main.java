package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fraction test1 = new Fraction();
        int num,den;
        String s;
        Scanner keyboard = new Scanner(System.in);
        do{
            try{
                System.out.println("Please enter a numerator: ");
                num = keyboard.nextInt();
                System.out.println("Please enter a denominator: ");
                den = keyboard.nextInt();
                test1.setNumerator(num);
                test1.setDenominator(den);
                System.out.print("this fraction reduced is: ");
                test1.outputReduced();

            } catch (DenominatorIsZeroException e) {
                System.out.println("The denominator should not be set to zero");
            }
            catch (InputMismatchException e){
                System.out.print("Your must enter an integer. Try again");
            }
            catch (Exception e){
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println();
            keyboard.nextLine();
            System.out.println("Enter Y to try again, anything else to exit");
            s = keyboard.nextLine();
        }while (s.equalsIgnoreCase("Y"));
    }
}
