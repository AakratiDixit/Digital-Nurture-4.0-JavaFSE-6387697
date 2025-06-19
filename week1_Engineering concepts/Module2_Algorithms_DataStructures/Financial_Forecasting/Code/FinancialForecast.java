package Module2_Algorithms_DataStructures.Financial_Forecasting.Code;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if no more years, return present value
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: calculate next year's value
        double nextValue = presentValue * (1 + growthRate / 100);
        return calculateFutureValue(nextValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000; // Example: 10,000 INR
        double growthRate = 5;       // 5% annual growth
        int years = 5;               // Predict for 5 years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f rupees\n", years, futureValue);
    }
}

