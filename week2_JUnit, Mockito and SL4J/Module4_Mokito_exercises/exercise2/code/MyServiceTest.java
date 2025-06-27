package code;
import static org.mockito.Mockito.*;
// import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;


public class MyServiceTest {
    
    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Step 2: Call the method with specific arguments
        MyService service = new MyService(mockApi);
        service.fetchData();
        
        // Step 3: Verify the interaction
        verify(mockApi).getData();
        
        System.out.println("Basic verification test passed! getData() was called.");
    }
    
    /**
     * Test verifying method call with specific arguments
     * Shows how to verify methods called with particular parameters
     */
    @Test
    public void testVerifyInteractionWithArguments() {
        // Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Call method with specific argument
        MyService service = new MyService(mockApi);
        service.storeData("test data");
        
        // Verify method was called with exact argument
        verify(mockApi).saveData("test data");
        
        System.out.println("Argument verification test passed! saveData() called with 'test data'.");
    }
    
}