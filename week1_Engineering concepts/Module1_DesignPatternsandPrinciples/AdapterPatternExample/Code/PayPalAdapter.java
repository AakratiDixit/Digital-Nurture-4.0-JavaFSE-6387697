package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

//Adapter class for PayPal

public class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

//Main.java  →  PaymentProcessor Interface  →  PayPalAdapter  →  PayPal
//Tum sirf processPayment() method ko call karti ho →
// Adapter samajh jata hai ki PayPal ke liye makePayment() call karna hai ya Stripe ke liye stripePayment() call karna hai.