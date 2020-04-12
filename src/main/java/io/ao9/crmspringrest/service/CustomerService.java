package io.ao9.crmspringrest.service;

import java.util.List;

import io.ao9.crmspringrest.entity.Customer;

public interface CustomerService {
    public List<Customer> findAll();

	public Customer findById(int theCustomerId);

	public void save(Customer theCustomer);

	public void deleteById(int theCustomerId);
}