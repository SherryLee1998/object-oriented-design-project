package com.company;

public class Messy {
    static double distance = 6.21;
    public static void main(String[] args)
    {
        double time, pace;
        System.out.println("This program calculates your pace given a time and distance traveled.");
        time = 35.5;
        pace= time / distance;
        System.out.println("Your pace is " + pace + " miles per hour.");
    }
}
