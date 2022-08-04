package models;

import entities.Shop;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Serializable {
    private List<Order> orders = new ArrayList<>();
    private Item item;
    public Order createOrder(Shop shop){
        return new Order();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    public void printAllOrder(){
        for (Order o : orders){
            System.out.println(o);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
