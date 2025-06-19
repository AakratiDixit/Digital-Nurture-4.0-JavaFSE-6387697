package Module2_Algorithms_DataStructures.Inventory_Management_System.Code;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding Products
        Product p1 = new Product("P001", "Laptop", 10, 75000.0);
        Product p2 = new Product("P002", "Smartphone", 20, 25000.0);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        // Display all products
        inventory.displayProducts();

        // Update Product
        inventory.updateProduct("P001", "Gaming Laptop", 8, 85000.0);

        // Display updated inventory
        inventory.displayProducts();

        // Delete Product
        inventory.deleteProduct("P002");

        // Display final inventory
        inventory.displayProducts();
    }
}

