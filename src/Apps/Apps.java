package Apps;

import Utilities.FileServices;
import controllers.PMController;
import entities.Product;
import entities.Shop;
import models.Item;
import models.Order;
import models.ProductManager;
import views.MainFrame;

import java.io.FileOutputStream;
import java.util.List;

public class Apps {
    private static Shop shop;
    private static MainFrame mainFrame;
    private static final String DEFAULT_FILENAME = "shop.pdo";
    public static void main(String[] args) {
        //inisialisasi
        shop = (Shop) FileServices.readObjectFromFile(Apps.DEFAULT_FILENAME);
        if (shop == null ){
         shop = new Shop("Pizza Oke");
        }

        //Data import dari file product.txt
        //backup and restore -> object shop
//        Product product = new Product("1","Juice Leci","Drink",15);
//        shop.getPm().registerProduct(product);
//        shop.getPm().registerProduct(new Product("2","Pizza Cheese","Pizza",45));
//
//        FileServices.saveObjectToFile(shop,Apps.DEFAULT_FILENAME);
//        shop = (Shop) FileServices.readObjectFromFile(Apps.DEFAULT_FILENAME);
//        shop.getPm().printAllProduct();

        //        ProductManager pm = new ProductManager();
//        pm.registerProduct(product);
//        FileServices.saveObjectToFile(pm,"product.obj");
//        Object obj = FileServices.readObjectFromFile("product.obj");
//        //casting
//        ProductManager objPM = (ProductManager) obj;
//        objPM.printAllProduct();

        mainFrame = new MainFrame("PDO Apps", shop);
        mainFrame.setVisible(true);
        mainFrame.Clock();
    }
}
