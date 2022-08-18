package views;

import controllers.CMController;
import entities.Customer;
import entities.Product;
import models.Item;
import models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDialog extends JDialog {
    private MainFrame parent;
    private JPanel contentPane;
    private JButton buttonCheckOut;
    private JButton buttonCancel;
    private JTable tableItem;
    private JTextField findCustomer;
    private JButton addItemButton;
    private JButton customerButton;
    private JLabel totalItems;
    private JLabel customerFound;
    private JTextField InputId;
    private JTextField Inputjumlah;
    private final Order order = new Order();
    private Integer qty;
    private Integer orderId;
    private Customer customer;
    private CMController cmController;
    private Item item;
    public OrderDialog(MainFrame parent) {
        this.parent = parent;
        setLocation(600,350);
        setSize(600,250);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCheckOut);
        Integer orderId = null;
        order.setInvoice();
        showTableItems();

        buttonCheckOut.addActionListener(e -> {
                checkOut();

        });


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        addItemButton.addActionListener(e -> {
//            FindProductDialog dialog = new FindProductDialog(this);
//            dialog.setVisible(true);
            Item i = new Item();
            String id = JOptionPane.showInputDialog("Masukkan Id ?");
            Product p = parent.getPmController().findProductById(id);
            i.setProduct(p);
            parent.showDataShop();
            int jumlah = Integer.valueOf(JOptionPane.showInputDialog("Jumlah ? "));
            i.setJumlah(jumlah);
            order.addItem(i);
            showTableItems();
            parent.getShop().getOm().printAllOrder();
            totalItems.setText(""+order.getTotal());


        });
        customerButton.addActionListener(e ->  {
            Customer customer = parent.getCmController().findCustomerById(findCustomer.getText());
            order.setCustomer(customer);
            customerFound.setText("Name : "+customer.getName()+"  ditemukan");
        });
    }

    private void checkOut() {
        parent.getOmController().addOrder(order);
        parent.showOrderTable();
        dispose();
    }

    private void showTableItems() {
        Object [] colom = {"ID","Name","Category","Price","Jumlah","SubTotal"};
        DefaultTableModel model = new DefaultTableModel(null,colom);
        //render data
        for (Item i : order.getItems()){
            Object [] data = {
                    i.getProduct().getId(),i.getProduct().getName(),i.getProduct().getCategory(),
                    i.getProduct().getPrice(),i.getJumlah(),i.getSubtotal()
            };
            model.addRow(data);
        }
        tableItem.setModel(model);
    }


    @Override
    public MainFrame getParent() {
        return parent;
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
