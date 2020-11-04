package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MemoryCustomerRepository implements CustomerRepository{
    List<Customer> customers = new ArrayList<>();
    private CustomerLogger customerLogger;
    @Autowired
    public MemoryCustomerRepository(@Qualifier("DBLogger") CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public List<Customer> addCustomer(Customer customer) {
        customers.add(customer);
        customerLogger.log();
        return customers;
    }

    @Override
    public List<Customer> removeCustomer(Customer customer) {
        customers.remove(customer);
        customerLogger.log();
        return customers;
    }

    @Override
    public List<Customer> listCustomers() {
        customerLogger.log();
        return customers;
    }
}
