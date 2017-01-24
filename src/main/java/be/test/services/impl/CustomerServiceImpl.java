package be.test.services.impl;

import be.test.dao.interfaces.CustomerDao;
import be.test.model.Customer;
import be.test.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jp on 22/01/17.
 */
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public Customer insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Transactional
    public Customer update(Customer customer) {
        return customerDao.update(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Transactional(readOnly = true)
    public Customer find(Customer customer) {
        return customerDao.find(customer);
    }

    public String displayCustomer(Customer customer) {
        return displayCustomer(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
