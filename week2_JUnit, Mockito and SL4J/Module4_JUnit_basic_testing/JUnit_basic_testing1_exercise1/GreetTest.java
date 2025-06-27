package JUnit_basic_testing1_exercise1;

import org.junit.*;

public class GreetTest {
    
    @Test
    public void test() {
        Greet greet = new Greet();
        Assert.assertEquals("Hello", greet.says());
    }
}
