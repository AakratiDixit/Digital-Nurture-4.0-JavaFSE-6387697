package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;
import java.util.*;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }
}

// Keeps a list of all observers (subscribers).
// Notifies all when stock price changes.

