package Module1_DesignPatternsandPrinciples.ObserverPatternExample.code;

public interface Observer {
    void update(float price);
}

//It says: "I will listen for updates."
//Defines what an observer should do when it gets an update (like show price on screen).