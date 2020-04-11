package io.ao9.crmspringcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.ao9.crmspringcrud.entity.Customer;

// @RepositoryRestResource(path = "cstm")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    public List<Customer> findAllByOrderByLastNameAsc();
}