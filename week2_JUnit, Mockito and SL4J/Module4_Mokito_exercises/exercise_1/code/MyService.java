package exercise_1.code;
/**
 * Exercise 1: Mocking and Stubbing
 * Service class that depends on ExternalApi
 * This is the class we want to test using mocked dependencies
 */
public class MyService {
    
    private ExternalApi api;

    /**
     * Constructor injection - this makes testing easier
     * We can inject a mock object during testing
     */
    public MyService(ExternalApi api) {
        this.api = api;
    }

    /**
     * Method that fetches data using the external API
     * This is the method we will test using a mocked API
     */
    public String fetchData() {
        return api.getData();
    }
}
