package io.ao9.crmspringcrud.dao;

import java.util.List;

import io.ao9.crmspringcrud.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);

	public void deleteCustomer(int theCustomerId);
}