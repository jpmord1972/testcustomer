package be.test.dao.interfaces;

import be.test.model.Customer;

/**
 * Created by jp on 24/01/17.
 */
public interface CustomerDao {

    Customer insert(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);

    Customer find(Customer customer);

    String displayCustomer(Customer customer);

}
