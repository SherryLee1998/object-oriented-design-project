package com.company;

public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }
    public Fraction(int num,int denom)throws DenominatorIsZeroException
    {
            numerator = num;
            if(denom == 0) throw new DenominatorIsZeroException();
            denominator = denom;
    }

    private int gcd(){
        int g;
        g = Math.min(denominator,numerator);
        while (g>1){
            if (((numerator % g)==0) && ((denominator % g)==0))
                return g;
            g--;
        }
        return 1;
    }
    public void setNumerator(int n){
        numerator = n;
    }
    public void setDenominator(int d) throws DenominatorIsZeroException{
        if(d==0) throw new DenominatorIsZeroException();
        denominator = d;
    }
    public double getDouble(){
        return (double)numerator/denominator;
    }
    public void DisplayFraction(){
        System.out.println(numerator+ "/" + denominator);
    }
    public boolean equals(Fraction other){
        int gcdMe,gcdOther;
        gcdMe = gcd();
        gcdOther = other.gcd();
        return (((numerator/gcdMe) == (other.numerator/gcdOther)) && (denominator/gcdMe) == (other.denominator/gcdOther));
    }
    public void outputReduced(){
        int g;
        g = gcd();
        System.out.println(numerator/g + "/" + denominator/g);
    }

}
