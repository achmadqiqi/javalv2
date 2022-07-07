package models;

import entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customerList = new ArrayList<>();
    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }
    public Customer findCustomerById(String Id){
        for (Customer customer: customerList){
            if (customer.getId().equals(Id)){
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomerList() {  return customerList;    }
    public void addCustomer(Customer customer) { customerList.add(customer); }
}
