package pl.coderslab;

import java.util.List;

public interface CustomerRepository {
    List<Customer> addCustomer(Customer customer);
    List<Customer> removeCustomer(Customer customer);
    List<Customer> listCustomers();

}
