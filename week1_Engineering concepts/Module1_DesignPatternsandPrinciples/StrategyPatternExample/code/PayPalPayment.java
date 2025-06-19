package Module1_DesignPatternsandPrinciples.StrategyPatternExample.code;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}

//Each payment method has its own way of processing payment.
