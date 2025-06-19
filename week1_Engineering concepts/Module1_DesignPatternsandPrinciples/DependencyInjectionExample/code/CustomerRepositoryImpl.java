package Module1_DesignPatternsandPrinciples.DependencyInjectionExample.code;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(int id) {
        // Normally, this would query a database. For now, we return dummy data.
        return new Customer(id, "Customer" + id);
    }
}

// This class implements the CustomerRepository interface.
// The method findCustomerById() returns a new dummy customer with a name like "Customer1", "Customer2", etc.
// Later on, this class will be injected into the service.
