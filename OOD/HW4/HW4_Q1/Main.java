package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variable declarations
        Question2MemoryGame game = new Question2MemoryGame();
        int temp;
        int x1,y1,x2,y2;
        int pairsleft = 8;
        Scanner scan = new Scanner(System.in);
        System.out.println("Find all the matching pairs on the board.");

        // Main loop, show the board
        while (pairsleft > 0)
        {
            game.ShowCards();
            System.out.println("Enter an x and y position of the first card to flip.");
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            System.out.println("Enter an x and y position of the second card to flip.");
            x2 = scan.nextInt();
            y2 = scan.nextInt();
            // Subtract one from the input, since our arrays start at 0
            // but the board displays start at 1
            x1--; y1--;
            x2--; y2--;
            if (game.CheckMatch(x1,y1,x2,y2)) pairsleft--;

        }
        System.out.println("You found all the matching pairs! Game over.");
        game.ShowCards();

        }
}
