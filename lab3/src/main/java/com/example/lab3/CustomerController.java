package com.example.lab3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        customers = new ArrayList<Customer>();
        customers.add(new Customer("1010", "John", "Male", 25));
        customers.add(new Customer("1080", "Peter", "Male", 24));
        customers.add(new Customer("1019", "Sara", "Female", 23));
        customers.add(new Customer("1110", "Rose", "Female", 23));
        customers.add(new Customer("1001", "Emma", "Female", 30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return this.customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String id){
        for( int i = 0; i < customers.size(); i++){
            if (this.customers.get(i).getID().equals(id)) {
                return customers.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("name") String name){
        for( int i = 0; i < customers.size(); i++){
            if (this.customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String id){
        for( int i = 0; i < customers.size(); i++){
            if (this.customers.get(i).getID().equals(id)) {
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByName/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByname(@PathVariable("n") String n){
        for( int i = 0; i < customers.size(); i++){
            if (this.customers.get(i).getName().equals(n)) {
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID,@RequestParam("name") String n,@RequestParam("sex") String s,@RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }

    @RequestMapping(value = "/addcustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID,@RequestParam("name") String n,@RequestParam("sex") String s,@RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }

}

