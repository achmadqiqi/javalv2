package Apps;

import controllers.PMController;
import entities.Product;
import entities.Shop;
import models.Item;
import models.Order;
import models.ProductManager;
import views.MainFrame;

public class Apps {
    private static Shop shop = null;
    public static void main(String[] args) {
        //inisialisasi
        if (shop == null ){
        shop = new Shop("Pizza Oke");
        }
        shop.getPm().registerProduct(new Product("SKU10012","PIZZA DOUBLE CHEESE",26));
        Order order = new Order();
        order.addItem(new Item(shop.getPm().findProductById("SKU10002"),3));
        shop.getOm().addOrder(order);
        MainFrame mainFrame = new MainFrame("PDO Apps", shop);
        mainFrame.setVisible(true);
    }
}
