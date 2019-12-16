package caffeinateme.steps;

public class UserRegistrationClient {

    long customerId = 1;

    public void registerUser(Customer newCustomer) {
        newCustomer.hasACustomerIdOf(customerId);

    }
}
