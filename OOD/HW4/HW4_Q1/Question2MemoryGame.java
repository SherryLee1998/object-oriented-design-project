package com.company;

import java.util.Scanner;

public class Question2MemoryGame {
    public static final int LENGTH = 4;
    public static final int NUM_SWAPS = 10000;

    private int[][] cards;			// Number for each card
    private boolean[][] faceup;		// If a card is face up or not

    /**
     * Default constructor;  Initialize array of cards.
     * Place pair of numbers in the 2D array and then
     * randomly shuffle them.
     */
    public Question2MemoryGame()
    {
        cards = new int[LENGTH][LENGTH];	// A better design would create a class
        faceup = new boolean[LENGTH][LENGTH]; // encapsulating both cards and faceup

        // Initialize faceup boolean array
        for (int y=0; y<LENGTH; y++)
            for (int x=0; x<LENGTH;x++)
            {
                faceup[x][y]=false;
            }

        int x1,y1,x2,y2;
        int temp;

        // Place pairs in known locations
        cards[0][0]=1; cards[0][1]=1;
        cards[0][2]=2; cards[0][3]=2;
        cards[1][0]=3; cards[1][1]=3;
        cards[1][2]=4; cards[1][3]=4;
        cards[2][0]=5; cards[2][1]=5;
        cards[2][2]=6; cards[2][3]=6;
        cards[3][0]=7; cards[3][1]=7;
        cards[3][2]=8; cards[3][3]=8;

        // Randomly swap pairs 10000 times to shuffle
        for (int i=0; i<NUM_SWAPS; i++)
        {
            x1 = (int) (Math.random() * LENGTH);
            y1 = (int) (Math.random() * LENGTH);
            x2 = (int) (Math.random() * LENGTH);
            y2 = (int) (Math.random() * LENGTH);
            temp = cards[x1][y1];
            cards[x1][y1]=cards[x2][y2];
            cards[x2][y2] = temp;
        }
    }

    /**
     * ShowCards
     * Generates a display on the screen.  If faceup=false,
     * an * is output, otherwise the card in that slot is output.
     */
    public void ShowCards()
    {
        int x,y;

        System.out.println("    1 2 3 4");
        System.out.println("   =========");
        for (y=0; y < LENGTH; y++)
        {
            System.out.print(y+1 + " | ");
            for (x=0; x< LENGTH; x++)
            {
                if (faceup[x][y])
                {
                    System.out.print(cards[x][y] + " ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   =========");
    }

    /**
     * Checks to see if two cards match.
     *
     * @param x1 x coordinate of card 1
     * @param y1 y coordinate of card 1
     * @param x2 x coordinate of card 2
     * @param y2 y coordinate of card 2
     *
     * @return boolean true if the cards match, false if they do not.
     */
    public boolean CheckMatch(int x1, int y1, int x2, int y2)
    {
        Scanner scan = new Scanner(System.in);
        int temp;
        String s;

        // Check if we found a match
        if (cards[x1][y1]==cards[x2][y2])
        {
            System.out.println("Match found!");
            faceup[x1][y1]=true;
            faceup[x2][y2]=true;
            return true;
        }
        else
        {
            // No match, but temporarily show the cards
            faceup[x1][y1]=true;
            faceup[x2][y2]=true;
            ShowCards();
            System.out.println("Hit enter to continue.");
            s = scan.nextLine();
            // Hide the revealed board by scrolling it off
            faceup[x1][y1]=false;
            faceup[x2][y2]=false;
            for (temp=0; temp<30; temp++)
            {
                System.out.println();
            }
        }
        return false;
    }
}
