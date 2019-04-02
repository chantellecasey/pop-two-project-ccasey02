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
         * Fraction represented as a string
         */
        // Whole numbers
        Fraction whole_number_fraction = new FractionImpl(2);
        //System.out.println(whole_number_fraction);
        // Test for negative fractions (negative denominator);
        Fraction negative_fraction = new FractionImpl(1, -2);
        //System.out.println(negative_fraction);
        // Test for positive unnormalised fractions
        Fraction not_normalised_fraction = new FractionImpl(20,25);
        //System.out.println(not_normalised_fraction);
        // Test zero numerator
        Fraction zero_num_fraction = new FractionImpl(0,1);
        //System.out.println(zero_num_fraction);
        // Test zero denominator
        //Fraction zero_denom_fraction = new FractionImpl(1,0);
        //System.out.println(zero_denom_fraction);
        // Test for fraction represented as a string
        Fraction string_fraction = new FractionImpl("0/4");
        //System.out.println(string_fraction);
        Fraction string_fraction_2 = new FractionImpl("20/25");
        //System.out.println(string_fraction_2);
        //Fraction string_fraction_3 = new FractionImpl("5/0");
        //System.out.println(string_fraction_3);

        // Test fraction objects for method tests
        Fraction test1 = new FractionImpl("1/4");
        Fraction test2 = new FractionImpl(1, 4);
        Fraction test3 = new FractionImpl("5/1");
        Fraction test4 = new FractionImpl(-1);


        /** The following code is written in order to test the implementation of the Fraction interface and the methods within it.
         * The following methods will be tested:
         *     add()
         *     subtract()
         *     multiply()
         *     divide()
         *     abs()
         *     negate()
         *     equals()
         *     inverse()
         *     compareTo()
         *     toString()
         */

        // Test for add() method
        Fraction add_test = test1.add(test2);
        System.out.println(add_test);
        Fraction add_test2 = test3.add(test4);
        System.out.println(add_test2);

        // Tests for subtract() method
        Fraction subtract_test = test1.subtract(test2);
        System.out.println(subtract_test);
        Fraction subtract_test2 = test3.subtract(test4);
        System.out.println(subtract_test2);


        // Tests for multiply() method
        Fraction multiply_test = test1.multiply(test2);
        System.out.println(multiply_test);
        Fraction multiply_test2 = test3.multiply(test4);
        System.out.println(multiply_test2);

        // Tests for divide() method
        Fraction divide_test = test1.divide(test2);
        System.out.println(divide_test);
        Fraction divide_test2 = test3.multiply(test4);
        System.out.println(divide_test2);

         // Tests for abs() method
        Fraction abs_test = test1.abs();
        System.out.println(abs_test);
        Fraction abs_test2 = test4.abs();
        System.out.println(abs_test2);

        // Tests for negate() method
        Fraction negate_test = test1.negate();
        System.out.println(negate_test);
        Fraction negate_test2 = test4.negate();
        System.out.println(negate_test2);


        // Tests for equals() method
        Boolean equals_test = test1.equals(test2);
        System.out.println(equals_test);
        Boolean equals_test2 = test4.equals(test3);
        System.out.println(equals_test2);

        // Tests for inverse() method
        Fraction inverse_test = test1.inverse();
        System.out.println(inverse_test);
        Fraction inverse_test2 = test4.inverse();
        System.out.println(inverse_test2);

        // Tests for compareTo() method
        int compareTo_test = test1.compareTo(test2);
        System.out.println(compareTo_test);
        int compareTo_test2 = test4.compareTo(test3);
        System.out.println(compareTo_test2);
        int compareTo_test3 = test3.compareTo(test4);
        System.out.println(compareTo_test3);

        // Tests for toString() method
        String string_test = test2.toString();
        System.out.println(string_test);
        String string_test2 = test4.toString();
        System.out.println(string_test2);

    }
}
