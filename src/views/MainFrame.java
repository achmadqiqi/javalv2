package views;

import controllers.PMController;
import entities.Product;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private PMController pmController;
    //builder
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton addProductButton;
    private JButton printAllProductButton;
    private JButton findProductButton;
    private JTextArea displayProduct;
    private JLabel messageTxt;

    public MainFrame(String title,PMController pmController){
        super(title);
        this.pmController = pmController;
        initComponents();
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
}
