package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class Sieve {
    public void start(){
        System.out.println("How many number do you want? ");
        Scanner keyboard = new Scanner( System.in );
        int total = keyboard.nextInt();
        ArrayList<Integer> number = new ArrayList<Integer>();

        // add number;
        for(int i = 2; i <= total; i++){
            number.add( i );
        }
        skip( number );
        print( number );

    }
    private void skip(ArrayList a){
        for(int i =0; i < a.size()-1; i ++){
            int current = (int) a.get( i );
            Iterator<Integer> scan = a.listIterator(i+1);

            while (scan.hasNext()){
                int candidateValue = scan.next();
                if(candidateValue % current == 0){
                    scan.remove();
                }
            }
        }
    }
    private void print(ArrayList a){
        System.out.println("the prime number is: ");

        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get( i ) + " ");
        }
    }
    public static void main(String[] args) {
        Sieve test1 = new Sieve();
        test1.start();
    }


}
