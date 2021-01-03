package com.company;

public class Rational2 {
    private int numerator;
    private int denominator;

    public Rational2 ()
    {
        numerator = 0;
        denominator = 1;
    }

    public Rational2(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational2 (int wholeNumber)
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

    public boolean equals(Rational2 other)
    {
        if ( other == null )
        {
            return false;
        } // end of if ()
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

    public static Rational2 add(Rational2 a, Rational2 b)
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

        return new Rational2(newNum, newDenom);
    }

    public static Rational2 subtract(Rational2 a, Rational2 b)
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

        return new Rational2(newNum, newDenom);
    }

    public static Rational2 multiply(Rational2 a, Rational2 b)
    {
        int newNum = a.getNumerator() * b.getNumerator();
        int newDenom= a.getDenominator() * b.getDenominator();
        return new Rational2(newNum, newDenom);
    }

    public static Rational2 divide(Rational2 a, Rational2 b)
    {
        Rational2 newRational2 = new Rational2(b.getDenominator(), b.getNumerator());
        return Rational2.multiply(a, newRational2);
    }

    public Rational2 add(Rational2 b)
    {
        int newNum, newDenom;

        if ( this.denominator == b.denominator )
        {
            newNum = this.numerator + b.getNumerator();
            newDenom = this.getDenominator();
        }
        else
        {
            newNum = this.getNumerator() * b.getDenominator() + b.getNumerator() * this.getDenominator();
            newDenom = this.getDenominator() * b.getDenominator();
        }
        return new Rational2(newNum, newDenom);
    }

    public Rational2 subtract(Rational2 b)
    {
        int newNum, newDenom;

        if ( this.denominator == b.denominator )
        {
            newNum = this.numerator - b.getNumerator();
            newDenom = this.getDenominator();
        }
        else
        {
            newNum = this.getNumerator() * b.getDenominator() - b.getNumerator() * this.getDenominator();
            newDenom = this.getDenominator()* b.getDenominator();
        }
        return new Rational2(newNum, newDenom);
    }

    public Rational2 multiply(Rational2 b)
    {
        int newNum = this.getNumerator() *b.getNumerator();
        int newDenom= this.getDenominator() * b.getDenominator();
        return new Rational2(newNum, newDenom);
    }

    public Rational2 divide(Rational2 b)
    {
        Rational2 newRational22 = new Rational2(b.getDenominator(), b.getNumerator());
        return this.multiply(newRational22);
    }

}
