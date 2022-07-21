package views;

import Apps.Apps;
import Utilities.FileServices;
import controllers.CMController;
import controllers.OMController;
import controllers.PMController;
import entities.Customer;
import entities.Product;
import entities.Shop;
import models.Order;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame{
    private Shop shop;
    private PMController pmController;
    private OMController omController;
    private CMController cmController;

    //builder
    private JPanel mainPanel;
    private JPanel Product;
    //private JTextArea displayProduct;
    private JLabel messageTxt;
    private JTabbedPane OrderManager;
    private JLabel jam;
    private JComboBox cbAction;
    private JButton doButton;
    private JTextArea displayAllCustomer;
    private JButton addCustomerBtn;
    private JButton showAllCustomer;
    private JButton removeCustomerButton;
    private JButton findCustomerButton;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel product;
    private JTextArea displayAllProduct;
    private JButton regProductButton;
    private JButton showAllProduct;
    private JButton findProductButton;
    private JPanel orderProduct;
    private JButton removeProductButton;

    public MainFrame(String title, Shop shop){
        super(title);
        this.shop = shop;
        pmController = new PMController(shop.getPm());
        omController = new OMController(shop.getOm());
        cmController = new CMController(shop.getCm());
        initComponents();
        doButton.addActionListener(e -> {
            switch (cbAction.getSelectedIndex()){
                case 0 : emptyData(); break;
                case 1 : importDataProduct(); break;
                case 2 : saveData(); break;
                case 3 : backupData(); break;
                case 4 : restoreData(); break;
            }
        });
//        EmpyData
//                ImportData
//        SaveData
//                BackupData
//        RestoreData
    }

    public Shop getShop() {
        return shop;
    }
    public PMController getPmController() {
        return pmController;
    }

    public CMController getCmController() {
        return cmController;
    }

    private void initComponents() {

        //Listener
        showAllProduct.addActionListener(e -> {
            showAllProducts();
        });
        findProductButton.addActionListener(e -> {
            findProductAction();
        });
        regProductButton.addActionListener(e -> {
            registerProduct();
        });

        addCustomerBtn.addActionListener(e -> {
            registerCustomer();
        });
        showAllCustomer.addActionListener(e -> {
            showAllCustomer();
        });
        findCustomerButton.addActionListener(e -> {
            findCustomer();
        });
        getContentPane().add(mainPanel);
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    private void removeProduct() {
//        removeProduct();
//    }

    private void findCustomer() {
        String id = JOptionPane.showInputDialog("Masukkan Id Customer ? ");
        Customer customer = cmController.findCustomerById(id);
        displayAllCustomer.append(customer+"\n");
        showMessage("Customer Name : "+customer.getId()+"  ditemukan");
    }

    //doAction - presistence operation
    private void importDataProduct(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =new FileNameExtensionFilter("TXT file", "txt");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(this);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        List<Product> data = FileServices.readFileTxt(filename);
        shop.getPm().setProductList(data);
    }
//    private void backupData() {
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter =new FileNameExtensionFilter("TXT file", "txt");
//        chooser.setFileFilter(filter);
//        chooser.showOpenDialog(this);
//        String fileName = "src/product.txt";
//        List<Product> data = pmController.getAllProducts();
//
//        try {
//            FileWriter fileWriter = new FileWriter(fileName);
//            fileWriter.write(data.toString());
//            fileWriter.close();
//        } catch (IOException e){
//            System.out.println(("Terjadi kesalahan karena: "+ e.getMessage()));
//        }
//
//    }
    private void backupData() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDO files","pdo");
        chooser.setFileFilter(filter);
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        String fileAbsolutePath = file.getAbsolutePath();
        FileServices.saveObjectToFile(shop,fileAbsolutePath);
        showMessage("Object shop tersimpan");
    }
    private void emptyData() {
        shop = new Shop("PDO Store");
        pmController = new PMController(shop.getPm());
        displayAllProduct.setText("");
    }
    private void restoreData() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDO files","pdo");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(this);
        String fileAbsolutePath = chooser.getSelectedFile().getAbsolutePath();
        shop = (Shop) FileServices.readObjectFromFile(fileAbsolutePath);
    }

    private void saveData() {
    }

    public void Clock() {
        while (true) {
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formatDateTime = now.format(formatter);
                jam.setText(formatDateTime);
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void registerProduct() {
        Dialog dialog = new RegisterProductDialog(this);
        dialog.setVisible(true);
    }
    private void findProductAction() {
        String id = JOptionPane.showInputDialog("Masukkan Id Product ? ");
        Product p = pmController.findProductById(id);
        displayAllProduct.append(p+"\n");
        showMessage("Product "+p.getId()+"  ditemukan");
    }
    private void registerCustomer(){
        Dialog dialog = new RegisterCustomerDialog(this);
        dialog.setVisible(true);
    }
    private void showAllCustomer(){
        for (Customer customer : cmController.getAllCustomer()){
            displayAllCustomer.append(customer.toString()+"\n");
        }
    }
    private void showAllProducts() {
        for(Product p : pmController.getAllProducts()){
            displayAllProduct.append(p.toString()+"\n");
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
