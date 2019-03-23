package fraction;

import java.io.FileReader;
import java.util.Scanner;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the numerator and the denominator.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are (8, -12), create a Fraction with numerator
     * -2> and denominator 3.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     @param numerator
     @param denominator
     */
    public int numerator, denominator;
    public String fraction;

    public FractionImpl(int num, int denom) {
        /** Normalise fraction using gcd and return string representation of the fraction in the toString() method
         * Define rule for zero values of numerator (fraction is zero) and denominator (throw an Arithmetic Exception)
         * Format fraction so that if denominator is negative, the numerator changes to a negative value and the denominator changes to positive
         * The gcd is calculated using the absolute value's of numerator and denominator and the gcd method
         * The fraction is then formatted for the string output - divide each of the numerator and denominator by their gcd.
         */
        if (num == 0) {
            denominator = 0;
            numerator = 0;
        }
        else if (denom == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        else if (denom < 0){
            numerator = num*-1;
            denominator = denom*-1;
        }
        // Normalise the fraction
        if (num!=0) {
            int gcd = gcd(Math.abs(num), Math.abs(denom));
            String norm_num = Integer.toString(num/gcd);
            String norm_denom = Integer.toString(denom/gcd);
            numerator = Integer.parseInt(norm_num);
            denominator = Integer.parseInt(norm_denom);
            fraction = norm_num + "/" + norm_denom;
        } else {
            fraction = "0";
            numerator = 0;
            denominator = 0;
        }
    }

    public FractionImpl(int wholeNumber) {
        // TODO
        // implement logic where wholeNumber is the numerator and the denominator is 1
        numerator = wholeNumber;
        denominator = 1;
        fraction = wholeNumber + "/1";
    }

    public FractionImpl(String frac) {
        // TODO
        int index = frac.indexOf('/');
        String str_numerator = frac.substring(0,index);
        String str_denominator = frac.substring(index, fraction.length()-1);
        numerator = Integer.parseInt(str_numerator);
        denominator = Integer.parseInt(str_denominator);
        fraction = frac;
    }

    // Method to calculate the greatest common divisior between two integers
    public int gcd(int a,int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    // Method to calculate the sum of two fraction objects
    public Fraction add(Fraction f) {
        // define the variables for numerator and denominator of f
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the sum = ad + bc
        numerator = (this.numerator)*f_denom + f_num*this.denominator;
        // Calculate denominator of the sum - bd
        denominator = this.denominator*f_denom;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public Fraction subtract(Fraction f) {
        // (ad - bc)/bd
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the subtraction - ad - bc
        numerator = (this.numerator)*f_denom - f_num*this.denominator;
        // Calculate denominator of the subtraction - bd
        denominator = this.denominator*f_denom;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public Fraction multiply(Fraction f) {
        //(a*c)/(b*d)
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the subtraction - ac
        numerator = (this.numerator)*f_num;
        // Calculate denominator of the subtraction - bd
        denominator = this.denominator*f_denom;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public Fraction divide(Fraction f) {
        //(a*d)/(b*c)
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the subtraction - ad
        numerator = (this.numerator)*f_denom;
        // Calculate denominator of the subtraction - bc
        denominator = this.denominator*f_num;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public Fraction abs() {
        if (numerator < 0) {
            numerator = numerator*-1;
        }
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public Fraction negate() {
        numerator = numerator*-1;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object o) {
        //if
        // this.fraction =
        return super.equals(o);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Fraction inverse() {
        return null;
    }


    public int compareTo(Fraction o) {
        return 0;
    }


    public String toString() {
        return fraction;
    }
}