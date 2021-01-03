package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("the initial amount? ");
            Scanner keyboard = new Scanner(System.in);
            Account test1 = new Account(keyboard.nextInt());

            System.out.println("for withdraw? ");
            test1.withdraw(keyboard.nextDouble());

            System.out.println("for deposit?");
            test1.deposit(keyboard.nextDouble());

            System.out.println(test1);
        }
            catch (NegativeException e){
                System.out.println(e.getMessage());
            }
            catch (InsufficientExceptional e){
                System.out.println(e.getMessage());
            }
            catch(InputMismatchException e){
                System.out.println("please input a double number.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
}

