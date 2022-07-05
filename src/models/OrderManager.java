package models;

import entities.Shop;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    public Order createOrder(Shop shop){
        return new Order(shop);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    public void printAllOrder(){
        for (Order o : orders){
            System.out.println(o);
        }
    }
}
