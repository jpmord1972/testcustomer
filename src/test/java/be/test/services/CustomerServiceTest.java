package be.test.services;

import be.test.model.Customer;
import be.test.services.interfaces.CustomerService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by jp on 22/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testInsertCustomerService() {
        assertNotNull(customerService);
        Customer c = generateCustomer();
        c = customerService.insert(c);
        assertNotNull(c);
        assertNotNull(c.getId());

       Customer found = customerService.find(c);
       assertNotNull(found);
    }

    private Customer generateCustomer() {
        Customer c = new Customer();

        c.setFirstName("Jean-Pierre");
        c.setLastName("Mordenga");
        c.setAddress("Route de Lennik 788 1070 Bruxelles");
        c.setBirthDate(new Date(System.currentTimeMillis()));
        c.setStart(new Date(System.currentTimeMillis()));
        c.setEnd(new Date(System.currentTimeMillis()));
        c.setComment("Comment");

        return c;
    }
}
