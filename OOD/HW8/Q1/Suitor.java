package com.company;

import java.util.Scanner;


public class Suitor {

    Scanner keyboard =  new Scanner( System.in );
    int numSuitor;
    SuitorNode current = null;
    SuitorNode tail = null;
    SuitorNode prev = null;

    public void start(int numSuitor){
        if(numSuitor > 0) {
            current = new SuitorNode( 1 );
            current.setNext( current ); // form a circle
            tail = current;
            for(int i = 1; i < numSuitor; i++){
                add(i+1);
            }
            getPosition();
        }
        else if(numSuitor < 0){
            System.out.println("No enough suitors");
        }
        else {
            System.out.println("You would stand first in the line.");
        }
    }

    public void add(int addNum){
        SuitorNode temp = new SuitorNode( addNum );
        temp.setNext( tail.getNext() );
        tail.setNext( temp );
        tail = temp;
    }

    public void getPosition(){

        while (current.getNext() != current){ // only has one element
            skipTwo_delete();
        }
        System.out.println("To win the princess, you should stand in position " + current.getNum());
    }

    public void skipTwo_delete()
    {
        for (int i = 0; i < 2; i++) { // skip two
            prev = current;
            current = current.getNext();
        }
        prev.setNext( current.getNext() ); // delete current
        current = prev.getNext();
    }

    public static void main(String[] args) {
        Scanner keyboard =  new Scanner( System.in );
        System.out.println("please enter number of suitors");

        Suitor test1 = new Suitor();
        int numSuitors = keyboard.nextInt();
        test1.start( numSuitors );

    }
}
