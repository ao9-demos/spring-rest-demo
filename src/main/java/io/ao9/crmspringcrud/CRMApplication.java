package io.ao9.crmspringcrud;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.ao9.crmspringcrud.entity.Customer;

@SpringBootApplication
public class CRMApplication {
   
   public static void main(String[] args) {
      SpringApplication.run(CRMApplication.class, args);

      try {
         ObjectMapper mapper = new ObjectMapper();
         Customer theCustomer = mapper.readValue(new File("data/input-lite.json"), Customer.class);

         System.out.println(theCustomer);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
}