package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

//third party - Adaptee

public class Stripe {
    public void stripePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via Stripe.");
    }
}
