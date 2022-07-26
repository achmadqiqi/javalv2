package entities;

import controllers.PMController;
import models.CustomerManager;
import models.OrderManager;
import models.ProductManager;

import java.io.Serial;
import java.io.Serializable;

public class Shop implements Serializable {
    @Serial
    private static final long serialVersionUID = 6925671169678302161L;
    private String name, npwp, alamat;
    private ProductManager pm = new ProductManager();
    private OrderManager om = new OrderManager();
    private CustomerManager cm = new CustomerManager();
    public Shop(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ProductManager getPm() {
        return pm;
    }
    public OrderManager getOm() {
        return om;
    }
    public CustomerManager getCm() {
        return cm;
    }
}

