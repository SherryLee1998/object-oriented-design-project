package com.company;

public class Rational2Alternate {
    private int numerator;
    private int denominator;

    public Rational2Alternate() {
        numerator = 0;
        denominator = 1;
    }

    public Rational2Alternate(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational2Alternate(int wholeNumber) {
        numerator = wholeNumber;
        denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.println("Fatal error.");
            System.exit(1);
        }
        this.denominator = denominator;
    }

    public boolean equals(Rational2Alternate other) {
        if (other == null) {
            return false;
        } // end of if ()
        else {
            this.normalize();
            other.normalize();
            return numerator * other.denominator == denominator * other.numerator;
        }
    }

    public String toString() {
        this.normalize();
        return "" + numerator + "/" + denominator;
    }

    public void normalize() {
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    public static Rational2Alternate add(Rational2Alternate a, Rational2Alternate b)
    {
        int newNum, newDenom;
        if ( a.denominator == b.denominator )
        {
            newNum = a.numerator + b.getNumerator();
            newDenom = a.getDenominator();
        }
        else
        {
            newNum = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
            newDenom = a.getDenominator() * b.getDenominator();
        }

        return new Rational2Alternate(newNum, newDenom);
    }

    public static Rational2Alternate subtract(Rational2Alternate a, Rational2Alternate b)
    {
        int newNum, newDenom;

        if ( a.denominator == b.denominator )
        {
            newNum = a.numerator - b.getNumerator();
            newDenom = a.getDenominator();
        }
        else
        {
            newNum = a.getNumerator() *b.getDenominator() - b.getNumerator() * a.getDenominator();
            newDenom = a.getDenominator() * b.getDenominator();
        }

        return new Rational2Alternate(newNum, newDenom);
    }

    public static Rational2Alternate multiply(Rational2Alternate a, Rational2Alternate b)
    {
        int newNum = a.getNumerator() * b.getNumerator();
        int newDenom= a.getDenominator() * b.getDenominator();
        return new Rational2Alternate(newNum, newDenom);
    }

    public static Rational2Alternate divide(Rational2Alternate a, Rational2Alternate b)
    {
        Rational2Alternate newRational2 = new Rational2Alternate(b.getDenominator(), b.getNumerator());
        return Rational2Alternate.multiply(a, newRational2);
    }

    public void add(Rational2Alternate a) {
        int newNum, newDenom;

        if (this.denominator == a.denominator) {
            newNum = this.numerator + a.getNumerator();
            newDenom = this.getDenominator();
        }
        else {
            newNum = this.getNumerator() * a.getDenominator() + a.getNumerator() * this.getDenominator();
            newDenom = this.getDenominator() * a.getDenominator();
        }
        this.numerator = newNum;
        this.denominator = newDenom;
    }

    public void subtract(Rational2Alternate a) {
        int newNum, newDenom;
        if (this.denominator == a.denominator) {
            newNum = this.numerator - a.getNumerator();
            newDenom = this.getDenominator();
        }
        else {
            newNum = this.getNumerator() * a.getDenominator() - a.getNumerator() * this.getDenominator();
            newDenom = this.getDenominator() * a.getDenominator();
        }
        this.numerator = newNum;
        this.denominator = newDenom;
    }

    public void multiply(Rational2Alternate a) {
        int newNum = this.getNumerator() * a.getNumerator();
        int newDenom = this.getDenominator() * a.getDenominator();
        this.numerator = newNum;
        this.denominator = newDenom;
    }

    public void divide(Rational2Alternate a) {
        Rational2Alternate newRational22 = new Rational2Alternate(a.getDenominator(), a.getNumerator());
        this.multiply(newRational22);
    }
}

