package Module2_Algorithms_DataStructures.EcommercePlatformSearchFunction.Code;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Shoes", "Footwear"),
            new Product("P003", "Mobile", "Electronics"),
            new Product("P004", "Watch", "Accessories")
        };

        // Sort the array for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Linear Search Test
        Product foundProduct = Search.linearSearch(products, "Watch");
        if (foundProduct != null) {
            System.out.println("Found (Linear): " + foundProduct.getProductName());
        } else {
            System.out.println("Product not found (Linear).");
        }

        // Binary Search Test
        Product foundProductBinary = Search.binarySearch(products, "Watch");
        if (foundProductBinary != null) {
            System.out.println("Found (Binary): " + foundProductBinary.getProductName());
        } else {
            System.out.println("Product not found (Binary).");
        }
    }
}
