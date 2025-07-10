import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

// Simple JWT generator without external dependencies
public class GenerateToken {
    private static final String SECRET_KEY = "secretkey123";
    
    public static void main(String[] args) {
        // Generate a fresh token
        String token = generateSimpleJWT("user");
        System.out.println("Fresh JWT Token:");
        System.out.println("{\"token\":\"" + token + "\"}");
        
        // Also show the secret info
        System.out.println("\nSecret key: " + SECRET_KEY);
        System.out.println("Secret key (Base64): " + Base64.getEncoder().encodeToString(SECRET_KEY.getBytes(StandardCharsets.UTF_8)));
        
        // Show current timestamp for reference
        long currentTime = System.currentTimeMillis() / 1000;
        System.out.println("Current timestamp: " + currentTime);
        System.out.println("Token expires at: " + (currentTime + 600)); // 10 minutes from now
    }
    
    // Simple JWT generation (header.payload.signature)
    private static String generateSimpleJWT(String username) {
        long currentTime = System.currentTimeMillis() / 1000;
        long expirationTime = currentTime + 600; // 10 minutes from now
        
        // Header
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes(StandardCharsets.UTF_8));
        
        // Payload
        String payload = "{\"sub\":\"" + username + "\",\"iat\":" + currentTime + ",\"exp\":" + expirationTime + "}";
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
        
        // For demonstration, we'll create a mock signature
        // In a real implementation, you'd use HMAC-SHA256
        String data = encodedHeader + "." + encodedPayload;
        String signature = "MOCK_SIGNATURE_" + Math.abs(data.hashCode());
        String encodedSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(signature.getBytes(StandardCharsets.UTF_8));
        
        return encodedHeader + "." + encodedPayload + "." + encodedSignature;
    }
}
