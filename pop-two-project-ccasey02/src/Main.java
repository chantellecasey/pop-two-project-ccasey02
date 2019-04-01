package fraction;

public class Main {

    public static void main(String[] args) {
        /** The following code is written in order to test the implementation of the Fraction interface,
         * the creation of a Fraction object and the normalisation of the fraction. The following types of fractions will be tested:
         * Whole numbers (should return 1 as the denominator)
         * Negative fractions (negative denominators)
         * Fractions, already normalised
         * Fractions, not yet normalised
         * Fraction with the numerator as 0
         * Fractions with the denominator as 0 (should throw an ArithmeticError)
         */
        // Whole numbers
        Fraction whole_number_fraction = new FractionImpl(2);
        System.out.println(whole_number_fraction);
        // Test for negative fractions (negative denominator); !!!!!!!!!!!! FIX !!!!!!!!!!
        Fraction negative_fraction = new FractionImpl(1, -2);
        System.out.println(negative_fraction);
        // Test for positive unnormalised fractions
        Fraction not_normalised_fraction = new FractionImpl(20,25);
        System.out.println(not_normalised_fraction);

        // Test zero numerator
        Fraction zero_num_fraction = new FractionImpl(0,1);
        System.out.println(zero_num_fraction);


        /** The following code is written in order to test the implementation of the Fraction interface and the methods within it.
         * The following methods will be tested:
         *     add(Fraction f)
         *     subtract(Fraction f)
         *     multiply(Fraction f)
         *     divide(Fraction f)
         *     abs()
         *     negate()
         *     equals()
         *     inverse()
         *     compareTo(Fraction o)
         *     toString()
         *
         */

    }
}
