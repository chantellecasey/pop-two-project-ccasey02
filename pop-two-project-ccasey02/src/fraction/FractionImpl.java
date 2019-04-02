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
            num = num*-1;
            denom = denom*-1;
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

    // Implement object where wholeNumber is the numerator and the denominator is 1
    public FractionImpl(int wholeNumber) {
        numerator = wholeNumber;
        denominator = 1;
        fraction = wholeNumber + "/1";
    }

    /**Implement where object argument is the string representation of a fraction
     * Firstly pick out the numerator and denominator from the string (separated by a '/')
     * Then, create a new fraction using the implementation above (with two arguments: numerator and denominator)
    **/
    public FractionImpl(String frac) {
        int index = frac.indexOf('/');
        String str_numerator = frac.substring(0,index);
        String str_denominator = frac.substring(index+1, frac.length());
        int int_num = Integer.parseInt(str_numerator), int_denom = Integer.parseInt(str_denominator);
        Fraction result = new FractionImpl(int_num, int_denom);
        numerator = ((FractionImpl) result).numerator;
        denominator = ((FractionImpl) result).denominator;
        fraction = ((FractionImpl) result).fraction;
    }

    /** Method to calculate the greatest common divisor between two integers
     * @param a - integer
     * @param b - integer
     * @return gcd - integer, greatest common divisor
     */
    public int gcd(int a,int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    // Method to calculate the sum of two fraction objects
    public Fraction add(Fraction f) {
        // define the variables for numerator and denominator of f
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the sum = ad + bc
        int num = (this.numerator)*f_denom + f_num*this.denominator;
        // Calculate denominator of the sum - bd
        int denom = this.denominator*f_denom;
        Fraction result = new FractionImpl(num, denom);
        ((FractionImpl) result).numerator = numerator;
        ((FractionImpl) result).denominator = denominator;
        return result;
    }

    // Method to calculate the difference of two fractions
    public Fraction subtract(Fraction f) {
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the subtraction - ad - bc
        int num = (this.numerator)*f_denom - f_num*this.denominator;
        // Calculate denominator of the subtraction - bd
        int denom = this.denominator*f_denom;
        Fraction result = new FractionImpl(num, denom);
        return result;
    }

    // Method to calculate the product of two fractions
    public Fraction multiply(Fraction f) {
        int f_num = ((FractionImpl) f).numerator, f_denom = ((FractionImpl) f).denominator;
        // Calculate numerator of the subtraction - ac
        numerator = (this.numerator)*f_num;
        // Calculate denominator of the subtraction - bd
        denominator = this.denominator*f_denom;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    // Method to calculate the division of two fractions
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

        // Method to calculate the absolute value of a fraction
    public Fraction abs() {
        if (numerator < 0) {
            numerator = numerator*-1;
        }
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    // Method to calculate a fraction multipled by minus 1
    public Fraction negate() {
        numerator = numerator*-1;
        Fraction result = new FractionImpl(numerator, denominator);
        return result;
    }

    // Method that returns a boolean determined by whether two fractions are equal
    public boolean equals(Object o) {
        boolean result = false;
        int o_num = ((FractionImpl) o).numerator, o_denom  =((FractionImpl) o).denominator;
        int this_num = this.numerator, this_denom = this.denominator;
        if (o_num == this_num && o_denom == this_denom) {
            result = true;
        }
        return result;
    }

    // Method that returns a fraction which swaps around the numerator and denominator of the original fraction
    public Fraction inverse() {
        Fraction inverse = new FractionImpl(denominator, numerator);
        return inverse;
    }

    // Method which returns 1, -1, or 0 depending on whether this is greater than, less than, or equal to fraction o
    public int compareTo(Fraction o) {
        int result = 0;
        float result_this = this.numerator/this.denominator;
        float result_o = ((FractionImpl) o).numerator/((FractionImpl) o).denominator;
        if (result_o == result_this) {
            result = 0;
        } else if (result_this < result_o){
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }

    // Method that reurns a string rperesentation of the fraction
    public String toString() {
        if (this. denominator == 1) {
            return Integer.toString(this.numerator);
        } else {
            return fraction;
        }

    }
}