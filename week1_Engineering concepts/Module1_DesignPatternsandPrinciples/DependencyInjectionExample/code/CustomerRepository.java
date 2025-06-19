package Module1_DesignPatternsandPrinciples.DependencyInjectionExample.code;

public interface CustomerRepository {
    Customer findCustomerById(int id);
}

//This is an interface that defines what a repository should do.
//This allows us to inject any class that implements this interface into another class (like CustomerService).