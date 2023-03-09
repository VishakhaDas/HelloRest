package com.microfocus.HelloRest.service;

import com.microfocus.HelloRest.model.Customer;
import com.microfocus.HelloRest.model.Customer1;
import com.microfocus.HelloRest.model.Customer2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    ArrayList<Customer1> allCustomerList1;
    ArrayList<Customer2> allCustomerList2;

    Customer c1=new Customer("Bill","Gates",267893,"bill.gates@msn.com");
    Customer c2=new Customer("John","Britto",457893,"John.Britto@yahoo.com");
    Customer c3=new Customer("Sam","samson",344893,"Sam.samson@gmail.com");
    Customer c4=new Customer("Harry","Potter",787893,"Harry.Potter@msn.com");
    Customer c5=new Customer("James","Potter",787893,"James.Potter@msn.com");
    Customer c6=new Customer("Lily","Evans",787893,"Lily.Potter@msn.com");
    Customer c7=new Customer("Ron","Weasly",787893,"Ron@msn.com");
    Customer c8=new Customer("abc","Weasly",787893,"abc@msn.com");


    List<Customer> list= Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8);
    ArrayList<Customer> allCustomerList= new ArrayList<>(list);
    public CustomerService()
    {
        System.out.println("Customer service is created by IOC");

        //Building v1 customer
        Customer1 c1=new Customer1("Bill","Gates",267893,"bill.gates@msn.com");
        Customer1 c2=new Customer1("John","Britto",457893,"John.Britto@yahoo.com");
        Customer1 c3=new Customer1("Sam","samson",344893,"Sam.samson@gmail.com");
        Customer1 c4=new Customer1("Harry","Potter",787893,"Harry.Potter@msn.com");
        Customer1 c5=new Customer1("James","Potter",787893,"James.Potter@msn.com");
        Customer1 c6=new Customer1("Lily","Evans",787893,"Lily.Potter@msn.com");
        Customer1 c7=new Customer1("Ron","Weasly",787893,"Ron@msn.com");
        Customer1 c8=new Customer1("abc","Weasly",787893,"abc@msn.com");
        allCustomerList1=new ArrayList<Customer1>();
        allCustomerList1.add(c1);
        allCustomerList1.add(c2);
        allCustomerList1.add(c3);
        allCustomerList1.add(c4);
        allCustomerList1.add(c5);
        allCustomerList1.add(c6);
        allCustomerList1.add(c7);
        allCustomerList1.add(c8);

        //Building v2 customer
        Customer2 c21=new Customer2("Bill","Gates",267893,"bill.gates@msn.com","US");
        Customer2 c22=new Customer2("John","Britto",457893,"John.Britto@yahoo.com","US");
        Customer2 c23=new Customer2("Sam","samson",344893,"Sam.samson@gmail.com","US");
        Customer2 c24=new Customer2("Harry","Potter",787893,"Harry.Potter@msn.com","UK");
        Customer2 c25=new Customer2("James","Potter",787893,"James.Potter@msn.com","UK");
        Customer2 c26=new Customer2("Lily","Evans",787893,"Lily.Potter@msn.com","UK");
        Customer2 c27=new Customer2("Ron","Weasly",787893,"Ron@msn.com","UK");
        Customer2 c28=new Customer2("abc","Weasly",787893,"abc@msn.com","US");
        allCustomerList2=new ArrayList<Customer2>();
        allCustomerList2.add(c21);
        allCustomerList2.add(c22);
        allCustomerList2.add(c23);
        allCustomerList2.add(c24);
        allCustomerList2.add(c25);
        allCustomerList2.add(c26);
        allCustomerList2.add(c27);
        allCustomerList2.add(c28);

    }

    public List<Customer> getAllCustomer()
    {

        System.out.println("Fetching customer list from service");

        return  allCustomerList;

    }
    public List<Customer1> getAllv1Customer()
    {

        System.out.println("Fetching v1 customer list from service");

        return  allCustomerList1;

    }
    public List<Customer2> getAllv2Customer()
    {

        System.out.println("Fetching v2 customer list from service");

        return  allCustomerList2;

    }

    public Customer getCustomer(String name)
    {
        Customer cust=null;
        for(Customer customer:allCustomerList)
        {
            if(customer.getFirstName().equalsIgnoreCase(name))
            {
                cust= customer;
            }
        }
        return cust;
    }

    public String addCustomer(Customer customer)
    {
        allCustomerList.add(customer);
        return "Customer "+customer.getFirstName()+" added successfully";
    }

    public String updateCustomer(String name,Customer existingCustomer)
    {
        String msg="No Customer exist";
        for(Customer customer:allCustomerList)
        {
            if(customer.getFirstName().equalsIgnoreCase(name))
            {
                if(existingCustomer.getLastName()!=null)
                {
                    customer.setLastName(existingCustomer.getLastName());
                }
                if(existingCustomer.getEmailId()!=null)
                {
                    customer.setEmailId(existingCustomer.getEmailId());
                }
                if(existingCustomer.getPhoneNumber()>0)
                {
                    customer.setPhoneNumber(existingCustomer.getPhoneNumber());
                }
                msg="Customer updated successfully";
            }
        }
        return msg;
    }

    public String deleteCustomer(String name)
    {
        String msg="No Customer exist";
        for(Customer customer:allCustomerList)
        {
            if(customer.getFirstName().equalsIgnoreCase(name))
            {
                allCustomerList.remove(customer);
                msg="Customer deleted successfully";
                break;
            }
        }
        return msg;
    }

}
