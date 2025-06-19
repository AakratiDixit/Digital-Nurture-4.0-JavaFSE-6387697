package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;

public interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// It says: "I am the one who will send updates."
//Allows apps (observers) to subscribe/unsubscribe.
