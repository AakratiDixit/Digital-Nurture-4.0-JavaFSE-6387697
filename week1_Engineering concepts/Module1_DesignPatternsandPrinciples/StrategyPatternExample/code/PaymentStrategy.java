package Module1_DesignPatternsandPrinciples.StrategyPatternExample.code;

public interface PaymentStrategy {
    void pay(double amount);
}

//This interface forces all payment types to have a pay method.


