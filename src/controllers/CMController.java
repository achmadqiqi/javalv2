package controllers;

import entities.Customer;
import entities.Product;
import models.CustomerManager;

import java.util.ArrayList;
import java.util.List;

public class CMController {
    // mempunyai models
    private CustomerManager customerManager;
//    private List<Customer> customerList = new ArrayList<>();
//
//    public CMController(List<Customer> customerList) {
//        this.customerList = customerList;
//    }

    public CMController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }
    public void addCustomer(Customer customer){
        customerManager.addCustomer(customer);
    }
    public List<Customer> getAllCustomer() { return customerManager.getCustomerList();}
    public Customer findCustomerById(String Id){
        return customerManager.findCustomerByID(Id);
    }
    public void removeCustomer(Customer customer){
        customerManager.removeCustomer();
    }
}
