package be.test.dao.impl;

import be.test.dao.interfaces.CustomerDao;
import be.test.model.Customer;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by jp on 24/01/17.
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    public Customer insert(Customer customer) {
        em.persist(customer);

        return customer;
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    public void delete(Customer customer) {
        em.remove(customer);
    }

    public Customer find(Customer customer) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> cRoot = cq.from(Customer.class);

        ParameterExpression<String> pFirstName = cb.parameter(String.class);
        ParameterExpression<String> pLastName = cb.parameter(String.class);

        cq.select(cRoot).where(cb.and(
                cb.equal(cRoot.get("firstName"), pFirstName),
                cb.equal(cRoot.get("lastName"), pLastName)
        ));

        TypedQuery<Customer> query = em.createQuery(cq);
        query.setParameter(pFirstName, customer.getFirstName());
        query.setParameter(pLastName, customer.getLastName());
        List<Customer> results = query.getResultList();

        if (results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    public String displayCustomer(Customer customer) {
        StringBuffer buf = new StringBuffer();

        buf.append("ID: " + customer.getId() + "\n")
                .append("FIRSTNAME: " + customer.getFirstName() + "\n")
                .append("LASTNAME: " + customer.getLastName() + "\n")
                .append("ADDRESS: " + customer.getAddress() + "\n")
                .append("BIRTHDATE: " + customer.getBirthDate() + "\n")
                .append("START: " + customer.getStart())
                .append("END: " + customer.getEnd() + "\n");

        return buf.toString();
    }

}
