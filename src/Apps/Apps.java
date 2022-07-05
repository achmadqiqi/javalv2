package Apps;

import controllers.PMController;
import entities.Product;
import entities.Shop;
import models.ProductManager;
import views.MainFrame;

public class Apps {
    public static void main(String[] args) {
        Shop shop = new Shop("Pizza Oke");
        ProductManager pm = new ProductManager();
        //inisialisasi
        pm.registerProduct(new Product("SKU10002","Pizza Chess",45));
        pm.registerProduct(new Product("SKU10003","Burger",35));
        PMController pmController = new PMController(pm);
        MainFrame mainFrame = new MainFrame("PDO Apps", pmController);
        mainFrame.setVisible(true);
    }
}
