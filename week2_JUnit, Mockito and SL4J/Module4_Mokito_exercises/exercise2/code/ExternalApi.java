package code;

public interface ExternalApi {
    
    /**
     * Method that returns data from external source
     * We will verify this method is called during testing
     */
    String getData();
    
    /**
     * Method that saves data with specific arguments
     * We will verify this method is called with correct parameters
     */
    void saveData(String data);
    
    /**
     * Method that processes user data
     * We will verify this method is called with specific user ID
     */
    String processUser(int userId, String userName);
}
