package views;

import controllers.OMController;
import controllers.PMController;
import entities.Customer;
import entities.Product;
import entities.Shop;
import models.Order;

import javax.swing.*;
import java.awt.*;

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
    private JTextArea displayProduct;
    private JLabel messageTxt;

    public MainFrame(String title, Shop shop){
        super(title);
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
        displayProduct.append(p+"\n");
        showMessage("Product "+p.getId()+" ditemukan");
    }

    private void showAllProducts() {
        for(Product p : pmController.getAllProducts()){
            displayProduct.append(p.toString()+"\n");
        }
    }
    public void showMessage(String message){
        messageTxt.setText(message);
    }
    public void showDataShop{
        System.out.println(" Data Product :");
        for (Product p : shop.getPm().getAllProduct()){
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
