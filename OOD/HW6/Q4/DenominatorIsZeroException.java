package com.company;


public class DenominatorIsZeroException extends Exception {
    public DenominatorIsZeroException(){
        super("Denominator should not be set to zero.");
    }
    public DenominatorIsZeroException(String message){
        super(message);
    }
}
