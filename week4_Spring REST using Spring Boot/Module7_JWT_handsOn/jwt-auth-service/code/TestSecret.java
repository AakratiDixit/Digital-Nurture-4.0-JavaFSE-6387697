import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TestSecret {
    public static void main(String[] args) {
        String secret = "secretkey123";
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
        
        System.out.println("Secret: " + secret);
        System.out.println("Bytes: " + java.util.Arrays.toString(bytes));
        System.out.println("Base64: " + Base64.getEncoder().encodeToString(bytes));
        System.out.println("Hex: " + bytesToHex(bytes));
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
