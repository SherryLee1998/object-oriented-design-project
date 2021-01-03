package com.company;

public class Rational
{
    private int numerator;
    private int denominator;

    public Rational ()
    {
        numerator = 0;
        denominator = 1;
    }

    public Rational(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational (int wholeNumber)
    {
        numerator = wholeNumber;
        denominator = 1;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator)
    {
        if ( denominator == 0 ) {
            System.out.println("Fatal error.");
            System.exit(1);
        }
        this.denominator = denominator;
    }

    public boolean equals(Rational other)
    {
        if ( other == null )
        {
            return false;
        }
        else
        {
            this.normalize();
            other.normalize();
            return numerator * other.denominator == denominator * other.numerator;
        }
    }

    public String toString()
    {
        this.normalize();
        return "" + numerator + "/" + denominator;
    }

    public void normalize()
    {
        if ( denominator < 0 ) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    public static Rational add(Rational a, Rational b)
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

        return new Rational(newNum, newDenom);
    }

    public static Rational subtract(Rational a, Rational b)
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

        return new Rational(newNum, newDenom);
    }

    public static Rational multiply(Rational a, Rational b)
    {
        int newNum = a.getNumerator() * b.getNumerator();

        int newDenom= a.getDenominator() * b.getDenominator();

        return new Rational(newNum, newDenom);
    }

    public static Rational divide(Rational a, Rational b)
    {
        Rational newRational2 = new Rational(b.getDenominator(), b.getNumerator());
        return Rational.multiply(a, newRational2);
    }

}

