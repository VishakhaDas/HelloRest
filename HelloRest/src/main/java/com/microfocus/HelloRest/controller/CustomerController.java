package com.microfocus.HelloRest.controller;

import com.microfocus.HelloRest.model.Customer;
import com.microfocus.HelloRest.model.Customer1;
import com.microfocus.HelloRest.model.Customer2;
import com.microfocus.HelloRest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer",method = RequestMethod.GET)//,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Customer>> getAllCustomer()
    {
        List<Customer> allCustomerList= customerService.getAllCustomer();


        return  ResponseEntity.ok(allCustomerList);

    }

    @RequestMapping(value = "/v1/customer",method = RequestMethod.GET)
    public ResponseEntity<List<Customer1>> getv1AllCustomer()
    {
        List<Customer1> allCustomerList= customerService.getAllv1Customer();


        return  ResponseEntity.ok(allCustomerList);

    }

    @RequestMapping(value = "/v2/customer",method = RequestMethod.GET)
    public ResponseEntity<List<Customer2>> getv2AllCustomer()
    {
        List<Customer2> allCustomerList= customerService.getAllv2Customer();


        return  ResponseEntity.ok(allCustomerList);

    }

    @RequestMapping(value="/customer/{name}",method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String name)
    {
        System.out.println("Fetching Customer details for customer first name"+name);
        Customer customer=customerService.getCustomer(name);
        return customer;

    }

    @RequestMapping(value="/customer",method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer)
    {
        System.out.println("Adding Customer "+customer);
        return customerService.addCustomer(customer);

    }

    @RequestMapping(value="/customer/{firstName}",method = RequestMethod.PUT)
    public String updateCustomer(@RequestBody Customer existingCustomer,@PathVariable("firstName") String name)
    {
        System.out.println("Updating email id for customer first name"+name);
        return customerService.updateCustomer(name,existingCustomer);


    }

    @RequestMapping(value="/customer/{firstName}",method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable("firstName") String name)
    {
        System.out.println("deleting customer first name"+name);
        return customerService.deleteCustomer(name);


    }


}
