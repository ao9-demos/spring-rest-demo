// package io.ao9.crmspringrest.dao;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.Query;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;

// import io.ao9.crmspringrest.entity.Customer;

// @Repository
// public class CustomerDAOJpaImpl implements CustomerDAO {
//     @Autowired
//     private EntityManager entityManager;

//     @Override
//     public List<Customer> findAll() {
//         Query theQuery = entityManager.createQuery("from Customer order by lastName");
//         List<Customer> customers = theQuery.getResultList();        
//         return customers;
//     }

//     @Override
//     public Customer findById(int theCustomerId) {
//         Customer theCustomer = entityManager.find(Customer.class, theCustomerId);
//         return theCustomer;
//     }

//     @Override
//     public void save(Customer theCustomer) {
//         Customer dbCustomer = entityManager.merge(theCustomer);
//         //set the id, so the rest api can return the updated object
//         theCustomer.setId(dbCustomer.getId());
//         theCustomer.getAddress().setId(dbCustomer.getAddress().getId());
//     }

//     @Override
//     public void deleteById(int theCustomerId) {
//         // // cascade = CascadeType.ALL does NOT delete with query
//         // Query theQuery = entityManager.createQuery("delete from Customer where id=:customerId");
//         // theQuery.setParameter("customerId", theCustomerId);
//         // theQuery.executeUpdate();
//         Customer theCustomer = entityManager.find(Customer.class, theCustomerId);
//         entityManager.remove(theCustomer);
//     }
// }