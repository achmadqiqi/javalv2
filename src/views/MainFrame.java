package views;

import controllers.OMController;
import controllers.PMController;
import entities.Customer;
import entities.Product;
import entities.Shop;
import models.Order;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame{
    private Shop shop;
    private PMController pmController;
    private OMController omController;

    //builder
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton addProductButton;
    private JButton printAllProductButton;
    private JButton findProductButton;
    //private JTextArea displayProduct;
    private JLabel messageTxt;
    private JTabbedPane tabbedPane1;
    private JTextArea DisplayProduct;
    private JLabel jam;

    public MainFrame(String title, Shop shop){
        super(title);
        this.shop = shop;
        pmController = new PMController(shop.getPm());
        omController = new OMController(shop.getOm());
        initComponents();
    }

    public Shop getShop() {
        return shop;
    }
    public PMController getPmController() {
        return pmController;
    }
    private void initComponents() {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = now.format(formatter);
            jam.setText(formatDateTime);
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Listener
        printAllProductButton.addActionListener(e -> {
            showAllProducts();
        });
        findProductButton.addActionListener(e -> {
            findProductAction();
        });
        addProductButton.addActionListener(e -> {
            registerProduct();
        });
        getContentPane().add(mainPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void registerProduct() {
        Dialog dialog = new RegisterProductDialog(this);
        dialog.setVisible(true);
    }

    private void findProductAction() {
        String id = JOptionPane.showInputDialog("Masukkan Id Product ? ");
        Product p = pmController.findProductById(id);
        DisplayProduct.append(p+"\n");
        showMessage("Product "+p.getId()+"  ditemukan");
    }

    private void showAllProducts() {
        for(Product p : pmController.getAllProducts()){
            DisplayProduct.append(p.toString()+"\n");
        }
    }
    public void showMessage(String message){
        messageTxt.setText(message);
    }
    public void showDataShop(){
        System.out.println(" Data Product :");
        for (Product p : shop.getPm().getProductList()){
            System.out.println(p);
        }
        System.out.println(" Data Order :");
        for (Order o : shop.getOm().getOrders()){
            System.out.println(o);
        }
        System.out.println(" Data Customer :");
        for (Customer c : shop.getCm().getCustomerList()){
            System.out.println(c);
        }
    }
}
