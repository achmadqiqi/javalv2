package controllers;

import entities.Customer;
import models.CustomerManager;

public class CMController {
    // mempunyai models
    private CustomerManager customerManager;

    public CMController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }
    public void addCustomer(Customer customer){
        customerManager.addCustomer(customer);
    }
}
