package io.ao9.crmspringcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.ao9.crmspringcrud.entity.Customer;
import io.ao9.crmspringcrud.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerService.getCustomers();        
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/add")
    public String addCustomer(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "form-customer";
    }

    @GetMapping("/update")
    public String updateCustomer(Model theModel, @RequestParam("customerId") int theCustomerId) {
        Customer theCustomer = customerService.getCustomer(theCustomerId);
        theModel.addAttribute("customer", theCustomer); 
        return "form-customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(Model theModel, @RequestParam("customerId") int theCustomerId) {
        customerService.deleteCustomer(theCustomerId);
        return "redirect:/customer/list";
    }
}