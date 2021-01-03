package com.company;

public class Main {
    public static void main(String[] args) {
        Rational2 rational1 = new Rational2();
        System.out.println("Number is: " + rational1);

        Rational2 rational2 = new Rational2(9);
        System.out.println("Number is: " + rational2);

        Rational2 rational3 = new Rational2(2, 4);
        System.out.println("Number is: " + rational3);

        System.out.println("Rational1's numerator is: " + rational1.getNumerator());
        System.out.println("RatioRnal1's denominator is: " + rational1.getDenominator());

        System.out.println("Changing rational1's numerator.");
        rational1.setNumerator(3);
        System.out.println("Rational1 is : " + rational1);

        System.out.println("Chaning rational1's denominator.");
        rational1.setDenominator(4);
        System.out.println("Rational1 is: " + rational1);

        System.out.println("rational1 is equal to rational2: " + rational1.equals(rational2));

        Rational2 rational2copy = new Rational2(rational2.getNumerator(), rational2.getDenominator());
        System.out.println("Rational2 is equal to a copy of rational2: " + rational2.equals(rational2copy));

        Rational2 nonNormal = new Rational2(10, -25);
        System.out.println("A non-normalized number (10, -25)," + " should normalize before printing: " + nonNormal);

        System.out.println();
        System.out.println("Rational1 is: " + rational1);
        System.out.println("Rational2 is: " + rational2);
        System.out.println("Rational3 is: " + rational3);
        System.out.println();
        System.out.println( rational1+ " + " + rational3 + " = " + Rational2.add(rational1, rational3));
        System.out.println( rational1+ " + " + rational2 + " = " + Rational2.add(rational1, rational2));
        System.out.println( rational1+ " - " + rational3 + " = " + Rational2.subtract(rational1, rational3));
        System.out.println( rational2+ " - " + rational1 + " = " + Rational2.subtract(rational2, rational1));
        System.out.println( rational1+ " * " + rational3 + " = " + Rational2.multiply(rational1, rational3));
        System.out.println( rational2+ " divide " + "1/2" + " = " +Rational2.divide(rational2, new Rational2(1,2)));
        System.out.println();
        System.out.println( rational1+ " + " + rational3 + " = " + rational1.add(rational3));
        System.out.println( rational1+ " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println( rational1+ " - " + rational3 + " = " + rational1.subtract(rational3));
        System.out.println( rational2+ " - " + rational1 + " = " + rational2.subtract(rational1));;
        System.out.println( rational1+ " * " + rational3 + " = " +rational1.multiply(rational3));
        System.out.println( rational2+ " divide " + "1/2" + " = " +rational2.divide(new Rational2(1,2)));


    }
}
