package com.company;

import java.util.Scanner;

public class tic_tac_toe_game {
    private int[][] show_x;
    private int[][] show_o;
    private int[][] show_non;
    private boolean x_turn;
    private boolean o_turn;
    private String firstplayer;
    public final int length = 3;
    Scanner keyboard = new Scanner(System.in);

    public tic_tac_toe_game(String firstplayer) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            if (firstplayer.equalsIgnoreCase("X")) {
                x_turn = true;
                o_turn = false;
                break;
            } else if (firstplayer.equalsIgnoreCase("O")) {
                x_turn = false;
                o_turn = true;
                break;
            } else {
                System.out.println("only two player X and O, please enter again.");
                firstplayer = keyboard.next();
            }
        }

        show_o = new int[length][length];
        show_x = new int[length][length];
        show_non = new int[length][length];

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                show_x[x][y] = 0;
                show_o[x][y] = 0;
                show_non[x][y] = 1;
            }
        }
    }

    public void getinput() {
        int x = 0;
        int y = 0;

        if (x_turn) {
            System.out.println("Enter a row(0,1,or 2) for play X");
            x = keyboard.nextInt();
            System.out.println("Enter a column(0,1,or 2) for play X");
            y = keyboard.nextInt();
        }

        if (o_turn) {
            System.out.println("Enter a row(0,1,or 2) for play O");
            x = keyboard.nextInt();
            System.out.println("Enter a column(0,1,or 2) for play O");
            y = keyboard.nextInt();
        }

        while (x < 0 || x > 2) {
            System.out.println("please enter a row to mark again! ranging from 0 to 2");
            x = keyboard.nextInt();
        }
        while (y < 0 || y > 2) {
            System.out.println("please enter a column to mark again! ranging from 0 to 2");
            y = keyboard.nextInt();
        }

        while (true) {
            // if available?
            if (show_non[x][y] == 0 && show_x[x][y] == 0) {
                System.out.println("It already be marked, please enter again");
                System.out.println("Enter a row(0,1,or 2)");
                x = keyboard.nextInt();
                System.out.println("Enter a column(0,1,or 2)");
                y = keyboard.nextInt();
                while (x < 0 || x > 2) {
                    System.out.println("please enter a row to mark again! ranging from 0 to 2");
                    x = keyboard.nextInt();
                }
                while (y < 0 || y > 2) {
                    System.out.println("please enter a column to mark again! ranging from 0 to 2");
                    y = keyboard.nextInt();
                }
            }
            // mark O
            if (show_non[x][y] == 1 && o_turn) {
                show_o[x][y] = 1;
                show_non[x][y] = 0;
                x_turn = true;
                o_turn = false;
                return;
            }
            // mark X
            if (show_non[x][y] == 1 && x_turn) {
                show_x[x][y] = 1;
                show_non[x][y] = 0;
                x_turn = false;
                o_turn = true;
                return;
            }
        }
    }


    public void print() {
        for (int x = 0; x < length; x++) {
            System.out.println("___________________");
            for (int y = 0; y < length; y++) {
                if (show_non[x][y] == 1 && show_x[x][y] == 0 && show_o[x][y] == 0) {
                    System.out.print("|     ");
                }
                if (show_x[x][y] == 1 && show_non[x][y] == 0 && show_o[x][y] == 0) {
                    System.out.print("|  X  ");
                }
                if (show_x[x][y] == 0 && show_non[x][y] == 0 && show_o[x][y] == 1) {
                    System.out.print("|  O  ");
                }
            }
            System.out.print("| \n");
        }
        System.out.println("___________________");
        System.out.println();

    }

    public boolean gameCompelate() {
        boolean start = true;
        int sum1_o = 0;// row for o
        int sum2_o = 0;// column for o
        int sum1_x = 0;// row for x
        int sum2_x = 0;// column for x
        int sum3_o = 0;// diagonal for o
        int sum3_x = 0; // diagonal for x
        int sum4_o = 0;// versed diagonal for o
        int sum4_x = 0;// versed diagonal for x
        // row and column
        for (int a = 0; a < length; a++) {
            for (int b = 0; b < length; b++) {
                sum1_o = sum1_o + show_o[a][b];
                sum2_o = sum2_o + show_o[b][a];
                sum1_x = sum1_x + show_x[a][b];
                sum2_x = sum2_x + show_x[b][a];
            }
            if (sum1_o == length || sum2_o == length) {
                System.out.println("O win! game completed. ");
                start = false;
                break;
            } else if (sum1_x == length || sum2_x == length) {
                System.out.println("X win! game completed. ");
                start = false;
                break;
            } else {
                sum1_o = 0;
                sum2_o = 0;
                sum1_x = 0;
                sum2_x = 0;
            }
        }

        // for diagonal
        for (int a = 0, b = length - 1; a < length && b > -1; a++, b--) {
            sum3_o = sum3_o + show_o[a][a];
            sum3_x = sum3_x + show_x[a][a];
            sum4_o = sum4_o + show_o[b][b];
            sum4_x = sum4_x + show_x[b][b];
        }
        if (sum3_o == length  || sum4_o == length ) {
            System.out.println("O win because the diagonal is O.");
            start = false;

        } else if (sum3_x == length  || sum4_x == length) {
            System.out.println("X win, because the diagonal is X.");
            start = false;
        } else
            {
            sum3_o = 0;
            sum3_x = 0;
            sum4_o = 0;
            sum4_x = 0;
        }
        return start;
    }

    public void start(){
        boolean complete = gameCompelate();
        while (complete) {
            if (x_turn && !o_turn) {
                System.out.println("---X turn---");
            } else {
                System.out.println("---O turn---");
            }
            getinput();
            print();
            complete = gameCompelate();
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("which player play first? X or O");
        tic_tac_toe_game play1 = new tic_tac_toe_game(keyboard.next());
        play1.start();
    }
}
