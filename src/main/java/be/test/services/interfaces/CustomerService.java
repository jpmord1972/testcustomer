package be.test.services.interfaces;

import be.test.model.Customer;

/**
 * Created by jp on 22/01/17.
 */
public interface CustomerService {

    Customer insert(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);

    Customer find(Customer customer);

    String displayCustomer(Customer customer);

}
