package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

//Third party class - Adaptee
public class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via PayPal.");
    }
}
