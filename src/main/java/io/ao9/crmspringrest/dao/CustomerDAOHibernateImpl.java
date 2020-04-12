// package io.ao9.crmspringrest.dao;

// import java.util.List;

// import javax.persistence.EntityManager;

// import org.hibernate.Session;
// import org.hibernate.query.Query;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;

// import io.ao9.crmspringrest.entity.Customer;

// @Repository
// public class CustomerDAOHibernateImpl implements CustomerDAO {
//     // constructor injection. Can choose any injection
//     private EntityManager entityManager;

//     @Autowired
//     public CustomerDAOHibernateImpl(EntityManager entityManager) {
//         this.entityManager = entityManager;
//     }

//     private Session getSession() {
//         Session theSession = null;
//         if (entityManager == null || (theSession = entityManager.unwrap(Session.class)) == null) {
//             throw new NullPointerException();
//         }
//         return theSession;
//     }

//     @Override
//     public List<Customer> findAll() {
//         Session theSession = getSession();
//         Query<Customer> theQuery = theSession.createQuery("from Customer order by lastName", Customer.class);
//         List<Customer> theCustomers = theQuery.getResultList();        
//         return theCustomers;
//     }

//     @Override
//     public Customer findById(int theCustomerId) {
//         Session theSession = getSession();
//         Customer theCustomer = theSession.get(Customer.class, theCustomerId);
//         return theCustomer;
//     }

//     @Override
//     public void save(Customer theCustomer) {
//         Session theSession = getSession();
//         // save() is insert, update() is update
//         theSession.saveOrUpdate(theCustomer);
//     }

//     @Override
//     public void deleteById(int theCustomerId) {
//         Session theSession = getSession();
//         // // cascade = CascadeType.ALL does NOT delete with query
//         // Query theQuery = theSession.createQuery("delete from Customer where id=:customerId");
//         // theQuery.setParameter("customerId", theCustomerId);
//         // theQuery.executeUpdate();
//         Customer theCustomer = theSession.get(Customer.class, theCustomerId);
//         theSession.delete(theCustomer);
//     }
// }