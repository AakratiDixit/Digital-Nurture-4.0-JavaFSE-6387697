package Module1_DesignPatternsandPrinciples.DependencyInjectionExample.code;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// represents a Customer
// It has a constructor to set those fields and getter methods to access them.

