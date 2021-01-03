package com.company;

public class Main {
    private static  final double cost = 1000;
    private static  final double rate = 0.015;

    public static void main(String[] args) {
	int count = 0;
	double interest = 0;
	double suminterest = 0;
	double remind = cost;
	double principal = 0;
	while (remind > 0){
	    interest = remind * rate;
	    if(remind >= 50){
	        principal = 50 - interest;
            }
        else{
            principal = remind;
        }
        suminterest = suminterest + interest;
        remind = remind - principal;
        count = count + 1;
    }
	System.out.println("Number of months needed to pay off the load: "+ count);
    System.out.printf("Total interested paid $%.2f\n", suminterest);

    }
}
