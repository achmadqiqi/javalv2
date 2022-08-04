package views;

import entities.Product;
import models.Item;
import models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class FindProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputId;
    private JButton SearchItem;
    private JTable tableProduct;
    private JTextField inputJumlah;
    private OrderDialog parent;

    public FindProductDialog(OrderDialog parent) {
        this.parent = parent;
        setLocation(600,250);
        setSize(400,450);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        showProductTable();


        buttonOK.addActionListener(e ->  {
            int row = tableProduct.getSelectedRow();
            String iDProduct = (String) tableProduct.getValueAt(row,0);
            int jumlah = Integer.parseInt(inputJumlah.getText());
            Item item = new Item(parent.getParent().getPmController().findProductById(iDProduct),jumlah);
            Order order = new Order();
            order.addItem(item);
            parent.getParent().getOmController().addOrder(order);

            dispose();
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

    }

    private void showProductTable() {
        List<Product> products = parent.getParent().getPmController().getAllProducts();
        Object [] colom = {"ID","Name","Price"};
        DefaultTableModel model = new DefaultTableModel(null,colom);
        for (Product p : products){
            Object [] data = {p.getId(),p.getName(),p.getPrice()};
            model.addRow(data);
        }
        tableProduct.setModel(model);
        tableProduct.getColumnModel().getColumn(1).setPreferredWidth(350);
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
