package com.company;

public class InsufficientExceptional extends Exception {
    public InsufficientExceptional(){
        super("Sorry, the balance is not sufficient.");
    }
    public InsufficientExceptional(String message){
        super(message);
    }

}
