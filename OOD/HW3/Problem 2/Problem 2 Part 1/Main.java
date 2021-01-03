package com.company;

public class Main {

    public static void main(String[] args) {
        Rational rational1 = new Rational();
        System.out.println("Number is: " + rational1);

        Rational rational2 = new Rational(6);
        System.out.println("Number is: " + rational2);

        Rational rational3 = new Rational(2, 4);
        System.out.println("Number is: " + rational3);

        System.out.println("Rational1's numerator is: " + rational1.getNumerator());
        System.out.println("Rational1's denominator is: " + rational1.getDenominator());

        System.out.println("Changing rational1's numerator.");
        rational1.setNumerator(5);
        System.out.println("Rational1 is : " + rational1);

        System.out.println("Chaning rational1's denominator.");
        rational1.setDenominator(10);
        System.out.println("Rational1 is: " + rational1);

        System.out.println("rational1 is equal to rational2: " + rational1.equals(rational2));

        Rational rational2copy = new Rational(rational2.getNumerator(), rational2.getDenominator());
        System.out.println("Rational is equal to a copy of rational2: " + rational2.equals(rational2copy));

        Rational nonNormal = new Rational(10, -25);
        System.out.println("A non-normalized number (10, -25)," + " should normalize before printing: " + nonNormal);

        System.out.println();
        System.out.println("Rational1 is: " + rational1);
        System.out.println("Rational2 is: " + rational2);
        System.out.println("Rational3 is: " + rational3);

        System.out.println( rational1+ " + " + rational3 + " = " + Rational.add(rational1, rational3));
        System.out.println( rational1+ " + " + rational2 + " = " + Rational.add(rational1, rational2));

        System.out.println( rational1+ " - " + rational3 + " = " + Rational.subtract(rational1, rational3));
        System.out.println( rational2+ " - " + rational1 + " = " + Rational.subtract(rational2, rational1));
        System.out.println( rational1+ " * " + rational3 + " = " + Rational.multiply(rational1, rational3));

        System.out.println( rational2+ " divide " + "1/2" + " = " +Rational.divide(rational2, new Rational(1,2)));
    }
}
