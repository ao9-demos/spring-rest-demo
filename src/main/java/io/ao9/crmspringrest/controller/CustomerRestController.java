// package io.ao9.crmspringrest.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import io.ao9.crmspringrest.entity.Customer;
// import io.ao9.crmspringrest.service.CustomerService;

// @RestController
// @RequestMapping("/api")
// public class CustomerRestController {
//     @Autowired
//     private CustomerService theCustomerService;

//     @GetMapping("/customers")
//     public List<Customer> getCustomers() {
//         List<Customer> customers = theCustomerService.findAll();
//         return customers;
//     }

//     @GetMapping("/customers/{customer_id}")
//     public Customer getCustomer(@PathVariable int customer_id) {
//         Customer theCustomer = theCustomerService.findById(customer_id);
//         if(theCustomer == null) {
//             throw new CustomerNotFoundException("Customer id not found - " + customer_id);
//         }
//         return theCustomer;
//     }

//     @PostMapping("/customers")
//     public Customer addCustomer(@RequestBody Customer theCustomer) {
//         theCustomer.setId(0);
//         theCustomer.getAddress().setId(0);
//         theCustomerService.save(theCustomer);
//         return theCustomer;
//     }

//     @PutMapping("/customers")
//     public Customer updateCustomer(@RequestBody Customer theCustomer) {
//         theCustomerService.save(theCustomer);
//         return theCustomer;
//     }

//     @DeleteMapping("/customers/{customer_id}")
//     public String deleteCustomer(@PathVariable int customer_id) {
//         Customer theCustomer = theCustomerService.findById(customer_id);
//         if(theCustomer == null) {
//             throw new CustomerNotFoundException("Customer id not found - " + customer_id);
//         }
//         theCustomerService.deleteById(customer_id);
//         return "Deleted customer id - " + customer_id;
//     }
// }