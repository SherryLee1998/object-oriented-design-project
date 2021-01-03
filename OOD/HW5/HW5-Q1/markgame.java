package com.company;

import javax.swing.*;
import java.util.Scanner;

public class markgame {
    private boolean[][] show_x;
    private boolean[][] show_o;
    private boolean[][] hide;
    private int[][] number;
    private boolean x_turn;
    private boolean o_turn;
    private String firstplayer;
    public final int total = 9;
    public final int length = 3;


    public markgame(String firstplayer) {
        Scanner keyboard = new Scanner(System.in);
        while (true){
            if(firstplayer.equalsIgnoreCase("X")){
                x_turn = true;
                o_turn = false;
                break;
            }
            else if(firstplayer.equalsIgnoreCase("O")){
                x_turn = false;
                o_turn = true;
                break;
            }
            else {
                System.out.println("only two player X and O, please enter again.");
                firstplayer = keyboard.next();
            }
        }

        show_o = new boolean[length][length];
        show_x = new boolean[length][length];
        hide = new boolean[length][length];
        number = new int [length][length];

        int i = 1;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                show_x[x][y] = false;
                show_o[x][y] = false;
                hide[x][y] = true;
                number[x][y] = i;
                i++;
            }
        }
    }
    public void getinput(){
        int position;
        System.out.println("please enter a number to mark, ranging from 1 to 9");
        Scanner keyboard = new Scanner(System.in);
        position = keyboard.nextInt();
        // check the input number until get right number
        while (position < 0 || position > 9){
            System.out.println("please enter a number to mark again! ranging from 1 to 9");
            position = keyboard.nextInt();
        }

        while (true){
            for (int x = 0; x < length; x++) {
                for (int y = 0; y < length; y++) {
                    // if it is marked as O
                    if(number[x][y] == position && !hide[x][y] && show_o[x][y] && !show_x[x][y]){
                        System.out.println("It already be marked as O, please enter again");
                        position = keyboard.nextInt();
                    }
                    // if it is marked as X
                    if(number[x][y] == position && !hide[x][y] && show_x[x][y] && !show_o[x][y]){
                        System.out.println("It already be marked as X, please enter again");
                        position = keyboard.nextInt();
                    }
                    // mark O
                    if(number[x][y] == position && hide[x][y] && o_turn){
                        show_o[x][y] = true;
                        hide[x][y] = false;
                        x_turn = true;
                        o_turn = false;
                        return;
                    }
                    // mark X
                    if(number[x][y] == position && hide[x][y] && x_turn){
                        show_x[x][y] = true;
                        hide[x][y] = false;
                        x_turn = false;
                        o_turn = true;
                        return;
                    }
                }
            }
        }
    }
    public void print(){
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if(hide[x][y] && !show_x[x][y] && !show_o[x][y] ){
                    System.out.print(number[x][y] + "   ");
                }
                if(show_x[x][y] && !hide[x][y] && !show_o[x][y] ){
                    System.out.print("X   ");
                }
                if(!show_x[x][y] && !hide[x][y] && show_o[x][y] ){
                    System.out.print("O   ");
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public void start(){
            int total_number = 9;
            while (total_number > 0){
                if(x_turn && !o_turn){
                    System.out.println("---X turn---");
                }
                else{
                    System.out.println("---O turn---");
                }
                getinput();
                print();
                total_number = total_number -1;
            }
            System.out.println("End game.");
        }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("which player play first? X or O");
        markgame play1 = new markgame(keyboard.next());
        play1.start();

    }
}
