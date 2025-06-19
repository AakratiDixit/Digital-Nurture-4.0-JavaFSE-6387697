package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;

public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("Mobile App");
        Observer webApp = new WebApp("Web App");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Stock price updates
        stockMarket.setStockPrice(120.5f);
        stockMarket.setStockPrice(135.0f);

        // Remove one observer
        stockMarket.removeObserver(mobileApp);

        // New stock price update
        stockMarket.setStockPrice(150.0f);
    }
}

// Creates the stock market.
// Registers apps.
// Updates stock prices.
// Removes apps.
// Shows how notification system works.

