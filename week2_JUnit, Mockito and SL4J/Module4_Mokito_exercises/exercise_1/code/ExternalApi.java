package exercise_1.code;

public interface ExternalApi {
    
    /**
     * Method that returns data from external source
     * This is the method we will mock in our tests
     */
    String getData();
}
