package Module1_DesignPatternsandPrinciples.AdapterPatternExample.Code;

public interface PaymentProcessor {
    void processPayment(double amount);
}

//Ye humari system ki language hai.
//Hum processPayment() bolte hain → Adapter PayPal ki language me bol deta hai.
