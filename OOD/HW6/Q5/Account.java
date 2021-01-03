package com.company;

import java.util.InputMismatchException;

public class Account {
    private double balance;
    public Account(){
        balance = 0;
    }
    public Account(double initial) throws NegativeException{
        if(initial > 0) balance = initial;
        else throw new NegativeException();
    }
    public double getBalance(){
        return balance;
    }
    public double deposit(double amount) throws NegativeException{
        if(amount > 0) balance += amount;
        else throw new NegativeException();
        return balance;
    }
    public double withdraw(double amount) throws InsufficientExceptional,NegativeException
    {
        if(amount > balance && amount > 0) throw new InsufficientExceptional();
        else if(amount <= 0) throw new NegativeException();
        else balance -= amount;
        return balance;
    }

    public String toString(){
        return "the balance is: " + getBalance();
    }
}
