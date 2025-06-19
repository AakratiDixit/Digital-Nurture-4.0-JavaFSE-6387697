package Module1_DesignPatternsandPrinciples.SingletonPatternExample.Code;

public class Logger{

    // Create a private static instance of Logger
    private static Logger singleInstance = null;

    // Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger instance created");
    }

    // Public method to provide the single instance
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
    
}

