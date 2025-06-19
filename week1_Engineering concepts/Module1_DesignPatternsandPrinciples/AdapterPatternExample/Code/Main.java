package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

public class Main {
    public static void main(String[] args) {

        // Using PayPal through Adapter
        PayPal payPal = new PayPal();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        payPalProcessor.processPayment(500);

        // Using Stripe through Adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(1000);
    }
}

//Adapter actes like a bridge to connect two systems that are directly compatible
// Humari system sirf PaymentProcessor interface samajhti hai.
// Lekin third party PayPal aur Stripe ke methods alag alag naam ke hain.
// PayPal → makePayment()
// Stripe → stripePayment()
// Lekin hum chahte hain ki common method se sab chalu ho: processPayment()
// Hum nahi chahte ki har baar PayPal ya Stripe ki alag alag methods yaad karein.


// PayPalAdapter banaya jo PayPal ki language ko PaymentProcessor ki language me convert karta h.
// StripeAdapter banaya jo Stripe ki language ko PaymentProcessor ki language me convert karta h.
