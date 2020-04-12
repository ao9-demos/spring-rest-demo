package io.ao9.crmspringrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import io.ao9.crmspringrest.dao.CustomerDAO;
import io.ao9.crmspringrest.dao.CustomerRepository;
import io.ao9.crmspringrest.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    // @Autowired
    // @Qualifier("customerDAOJpaImpl")
    // private CustomerDAO theCustomerDAO;

    // @Override
    // @Transactional
    // public List<Customer> findAll() {
    //     return theCustomerDAO.findAll();
    // }

    // @Override
    // @Transactional
    // public void save(Customer theCustomer) {
    //     theCustomerDAO.save(theCustomer);
    // }

    // @Override
    // @Transactional
    // public Customer findById(int theCustomerId) {        
    //     return theCustomerDAO.findById(theCustomerId);
    // }

    // @Override
    // @Transactional
    // public void deleteById(int theCustomerId) {     
    //     theCustomerDAO.deleteById(theCustomerId);
    // }

    @Autowired
    private CustomerRepository theCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return theCustomerRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Customer findById(int theCustomerId) {
        Customer theCustomer = null;    
        Optional<Customer> result = theCustomerRepository.findById(theCustomerId);
        if(result.isPresent()) {
            theCustomer = result.get();
        }
        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        theCustomerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theCustomerId) {     
        theCustomerRepository.deleteById(theCustomerId);
    }
}