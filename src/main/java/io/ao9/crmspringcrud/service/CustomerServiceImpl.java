package io.ao9.crmspringcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ao9.crmspringcrud.dao.CustomerDAO;
import io.ao9.crmspringcrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theCustomerId) {        
        return customerDAO.getCustomer(theCustomerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theCustomerId) {     
        customerDAO.deleteCustomer(theCustomerId);
    }

}