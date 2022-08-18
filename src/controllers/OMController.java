package controllers;

import entities.Shop;
import models.Order;
import models.OrderManager;

import java.util.List;

public class OMController {
    private OrderManager om;

    public OMController (OrderManager om){
        this.om = om;
    }
    //public Order createOrder(Shop shop){
    //    return om.createOrder(shop);
    //}

    public void addOrder(Order order) {
        om.addOrder(order);
    }
    public List<Order> getOrderList(){
        return om.getOrders();
    }

    public void printAllOrder() {
        om.printAllOrder();
    }
}
