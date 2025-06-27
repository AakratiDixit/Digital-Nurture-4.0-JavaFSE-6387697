package code;
/**
 * Exercise 2: Verifying Interactions
 * Service class that interacts with ExternalApi
 * We will verify that this service calls the API methods correctly
 */
public class MyService {
    
    private ExternalApi api;

    /**
     * Constructor injection for easy testing
     */
    public MyService(ExternalApi api) {
        this.api = api;
    }

    /**
     * Method that fetches data from API
     * We will verify that getData() is called
     */
    public String fetchData() {
        return api.getData();
    }
    
    /**
     * Method that saves data using API
     * We will verify that saveData() is called with correct argument
     */
    public void storeData(String information) {
        api.saveData(information);
    }
    
    /**
     * Method that processes user information
     * We will verify that processUser() is called with specific arguments
     */
    public String handleUser(int userId, String userName) {
        return api.processUser(userId, userName);
    }
    
    /**
     * Method that performs multiple API calls
     * We will verify multiple interactions
     */
    public void performMultipleOperations() {
        api.getData();
        api.saveData("processed data");
        api.processUser(123, "John Doe");
    }
}
