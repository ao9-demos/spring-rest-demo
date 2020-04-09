package io.ao9.crmspringcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ao9.crmspringcrud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        Session theSession = null;
        if (entityManager == null || (theSession = entityManager.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }
        return theSession;
    }

    @Override
    public List<Customer> getCustomers() {
        Session theSession = getSession();
        Query<Customer> theQuery = theSession.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> theCustomers = theQuery.getResultList();        
        return theCustomers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session theSession = getSession();
        // save() is insert, update() is update
        theSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theCustomerId) {
        Session theSession = getSession();
        return theSession.get(Customer.class, theCustomerId);
    }

    @Override
    public void deleteCustomer(int theCustomerId) {
        Session theSession = getSession();
        Query theQuery = theSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theCustomerId);
        theQuery.executeUpdate();
        // Customer theCustomer = theSession.get(Customer.class, theCustomerId);
        // theSession.delete(theCustomer);
    }
}