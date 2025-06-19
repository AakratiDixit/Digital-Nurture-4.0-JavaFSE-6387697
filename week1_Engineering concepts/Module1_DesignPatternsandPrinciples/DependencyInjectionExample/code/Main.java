package Module1_DesignPatternsandPrinciples.DependencyInjectionExample.code;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject it into the service
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.displayCustomer(1);
        service.displayCustomer(42);
    }
}

// What it does:
// This is the main method that runs the app.
// It manually creates an instance of CustomerRepositoryImpl.
// Then it injects that repository into the CustomerService via its constructor.
// Then it calls the service to display customers with IDs 1 and 42.

// A dependency is just an object that another object needs to do its work.
// Dependency Injection means:
// "Don't create your own dependencies — let someone else give them to you."
