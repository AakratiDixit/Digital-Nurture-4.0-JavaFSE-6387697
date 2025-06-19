package Module2_Algorithms_DataStructures.Financial_Forecasting.Code;

public class OptimizedVersion {

    // Recursive method to calculate future value
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;

        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate / 100);
        }

        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 10000; // Example: 10,000 INR
        double growthRate = 5;       // 5% annual growth
        int years = 5;               // Predict for 5 years

        double futureValue = calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f rupees\n", years, futureValue);
    }    
}

