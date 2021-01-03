package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);

	int human_total = 0;
	int computer_total = 0;
	int computer_acc_20 = 0;
	int roll = 0;
	String choose = "r";
    boolean humanrun = true;
    boolean computer_run = true;
	while((100 > human_total) && (100 > computer_total)){
	    System.out.println("___Human turn___");
	    while (humanrun){
	        roll = 1 + rand.nextInt(6);
	        System.out.println("Human rolled "+ roll);
	        if(roll == 1){
	            System.out.println("Human score "+ human_total + " computer score: "+ computer_total);
	            humanrun = false;
            }
	        else {
                human_total = human_total + roll;
                System.out.println("Human score "+ human_total + " computer score: "+ computer_total);
                if(human_total > 100){
                    humanrun = false;
                }
                else {
                    System.out.print("r or h?");
                    choose = keyboard.next();
                    if(choose.equalsIgnoreCase("h")){
                        humanrun = false;
                    }
                }
            }
        }
	    if(human_total < 100){
            System.out.println("*****computer turn****");
            computer_acc_20 = 0;
            humanrun = true;
            computer_run = true;
            while ((computer_acc_20 < 20) && (computer_run)){
                roll = 1 + rand.nextInt(6);
                System.out.println("Computer rolled "+ roll);
                if(roll == 1){
                    System.out.println("Human score "+ human_total + " computer score: "+ computer_total);
                    computer_run = false;
                }
                else{
                    computer_total += roll;
                    computer_acc_20 += roll;
                    System.out.println("Human score "+ human_total + " computer score: "+ computer_total);
                    if(computer_acc_20 >=20){
                        computer_run = false;
                        humanrun = true;
                    }
                    if(computer_total >=100){
                        computer_run = false;
                        humanrun = true;
                    }
                }
            }
        }
    }
	if(human_total >=100){
	    System.out.println("Human wins");
    }
	else {
	    System.out.println("Computer wins");
    }

    }
}
