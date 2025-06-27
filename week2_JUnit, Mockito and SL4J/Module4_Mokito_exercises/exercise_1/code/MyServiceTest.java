package exercise_1.code;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Exercise 1: Mocking and Stubbing
 * Test class demonstrating basic Mockito concepts
 * 
 * This follows the exact solution code provided in the exercise
 */
public class MyServiceTest {
    
    /**
     * Test case exactly as provided in the exercise
     * Demonstrates the 3 key steps of Mockito testing:
     * 1. Create a mock object
     * 2. Stub the methods 
     * 3. Write test case using the mock
     */
    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        
        // Step 2: Stub the methods to return predefined values
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Step 3: Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        
        // Verify the result
        assertEquals("Mock Data", result);
        
        // Print success message for intern learning
        System.out.println("✅ Test passed! Mocked API returned: " + result);
    }
    
    
}
