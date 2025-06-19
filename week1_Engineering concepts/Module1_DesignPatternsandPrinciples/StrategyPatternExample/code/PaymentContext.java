package Module1_DesignPatternsandPrinciples.StrategyPatternExample.code;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the payment strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Process the payment using selected strategy
    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

//This is where you select the payment method and call its pay method.
