package com.company;

public class NegativeException extends Exception {
    public NegativeException(){
        super("Sorry, the amount should be greater than 0.");
    }
    public NegativeException(String message){
        super(message);
    }
}
