import controllers.CMController;
import controllers.OMController;
import controllers.OutManagerController;
import controllers.PMController;
import entities.Customer;
import entities.Outlet;
import entities.Product;
import entities.Shop;
import models.*;

import javax.xml.namespace.QName;

public class TestUnit {
    public static void main(String[] args) {
        Shop shop = new Shop("Pizza Oke");
        ProductManager pm = new ProductManager();
        PMController pmController = new PMController(pm);
        //Use case register product --> toko
        Product p = new Product("SKU100002","Pizza Meet Lover",20000);
        pmController.registerProduct(p);
        pm.registerProduct(new Product("SKU100034","Salad buah",15000));
        //use case Order
        OrderManager om = new OrderManager();
        OMController omController = new OMController(om);
       Order order = omController.createOrder(shop);
        //loop
       order.addItem(new Item(pm.findProductById("SKU100002"),3));
       order.addItem(new Item(pm.findProductById("SKU100034"),6));
       order.cetakInvoice();
       omController.addOrder(order);
       omController.printAllOrder();
       //customer manager + controller
        CustomerManager cm = new CustomerManager();
        CMController cmController = new CMController(cm);
        cmController.addCustomer(new Customer("1","Qiqi"));
        //Outlet Manager + Controller
        OutletManager otm = new OutletManager();
        OutManagerController otmController = new OutManagerController(otm);
        otmController.addOutlet(new Outlet("1","Jl.Dr Saharjo No.58"));

    }
}
