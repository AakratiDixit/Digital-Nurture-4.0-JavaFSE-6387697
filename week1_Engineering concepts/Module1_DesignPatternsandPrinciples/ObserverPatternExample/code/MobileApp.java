package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;

public class MobileApp implements Observer {

    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(float price) {
        System.out.println(appName + " received stock price update: " + price);
    }
}

// These are the actual apps that receive the stock price update and display it.
// (Same goes for WebApp, just another observer.)
