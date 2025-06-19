package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

//Adapter class for Stripe

public class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.stripePayment(amount);
    }
}
