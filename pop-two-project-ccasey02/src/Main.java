package fraction;

public class Main {

    public static void main(String[] args) {
        //Fraction test = new FractionImpl(10, 8) ;
        Fraction test = new FractionImpl(-1) ;
        //Fraction test2 = new FractionImpl(2);
        Fraction test2 = test.abs();
        System.out.println(test2);
    }
}
