package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
	// code is 062011
        int[] realcode = {0,6,2,0,1,1};
        int[] random_nums = new int[10];
        int[] inputcode = new int[realcode.length];

        for(int i = 0; i < 10 ;i++){
            random_nums[i] = (int)(Math.random()*3)+1;
        }

        System.out.print("PIN: 0,1,2,3,4,5,6,7,8,9\n");
        System.out.print("NUM: ");
        for(int i = 0; i< 10;i++){
            if(i == 9){
                System.out.print(random_nums[i]);
                break;
            }
            System.out.print(random_nums[i] + ",");
        }

        System.out.print("\n");
        int[] correctcode = new int[realcode.length];
        for(int i  = 0 ;i< realcode.length ; i++) {
            correctcode[i] = random_nums[realcode[i]];
        }

        System.out.print("your code is:\n");
        for(int i = 0; i<realcode.length;i++){
            System.out.print(" ");
            inputcode[i] = keyboard.nextInt();
        }

        int count = 0;
        for(int i = 0; i<realcode.length;i++){
            if(inputcode[i] == correctcode[i])
                count++;
        }

        if(count == realcode.length){
            System.out.print("Yes, you are correct!");
        }
        else System.out.print("Sorry, you are not correct!");
    }
}
