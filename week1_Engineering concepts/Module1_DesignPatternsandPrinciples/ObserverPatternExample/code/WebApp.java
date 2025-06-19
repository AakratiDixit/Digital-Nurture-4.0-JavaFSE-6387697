package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;

public class WebApp implements Observer {

    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(float price) {
        System.out.println(appName + " received stock price update: " + price);
    }
}

