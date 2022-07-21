package models;

import entities.Customer;
import entities.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements Serializable {
    private List<Customer> customerList = new ArrayList<>();
//    public void removeCustomer(Customer customer){
//        customerList.remove(customer);
//    }

    public void removeCustomer() {
        customerList.remove(customerList);
    }

    public Customer findCustomerById(String Id){
        for (Customer customer: customerList){
            if (customer.getId().equals(Id)){
                return customer;
            }
        }
        return null;
    }
    public void showAllCustomer(){
        for(Customer customer : customerList){
            System.out.println(customer);
        }
    }
    public List<Customer> getCustomerList() {  return customerList;    }
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    public void addCustomer(Customer customer) { customerList.add(customer); }
    public Customer findCustomerByID(String Id){
        for (Customer customer : customerList){
            if (customer.getId().equals(Id)){
                return customer;
            }
        }
        return null;
    }


}
