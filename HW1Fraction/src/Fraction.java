import java.lang.Math;


/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */

public class Fraction implements FractionInterface, Comparable<Fraction>{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public int setNumerator(int numerator){
        return this.numerator;
    }

    public void setDenominator(int denominator) throws IllegalArgumentException{
        if (denominator <= 0){
            throw new IllegalArgumentException("Denominator should be positive!");
        }
        this.denominator = denominator;
    }

    @Override
    public Fraction reciprocal() throws IllegalArgumentException{
        if (this.numerator == 0) {
            throw new IllegalArgumentException("Numerator should not be zero");
        }
        if (this.numerator < 0){
            int newNumerator = this.denominator * (-1);
            int newDenominator = this.numerator * (-1);
            return new Fraction(newNumerator, newDenominator);
        } else {
            return new Fraction(this.denominator, this.numerator);
        }
    }

    @Override
    public double toDouble(Fraction fraction){
        return (double) this.numerator / this.denominator;
    }

    @Override
    public Fraction add(FractionInterface otherFraction){
        Fraction other = (Fraction) otherFraction;
        int newNumerator = (this.numerator * other.denominator + this.denominator * other.numerator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public int compareTo(Fraction other){
        if (this.numerator * other.denominator < this.denominator * other.numerator){
            return -1;
        }
        else if (this.numerator * other.denominator > this.denominator * other.numerator){
            return 1;
        }
        return 0;
    }

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String toString(){
        int gcdValue = gcd(Math.abs(this.numerator), this.denominator);
        return (this.numerator / gcdValue) + " / " + (this.denominator / gcdValue) ;
    }
}

