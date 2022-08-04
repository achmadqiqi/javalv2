package views;

import entities.Product;
import models.Item;
import models.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class OrderDialog extends JDialog {
    private final MainFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tableItem;
    private JTextField textField1;
    private JButton addItemButton;
    private JButton customerButton;
    private JTextField InputId;
    private JTextField Inputjumlah;
    private final Order order = new Order();
    private Integer qty;
    public OrderDialog(MainFrame parent) {
        this.parent = parent;
        setLocation(600,250);
        setSize(400,150);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        
        showTableItems();

        buttonOK.addActionListener(e -> {



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
//        addItemButton.addActionListener(new ActionListener() {
//        });
        addItemButton.addActionListener(e -> {
//            Item i = new Item();
//            String id = JOptionPane.showInputDialog("Masukkan Id :");
//            Product p = parent.getPmController().findProductById(id);
//            i.setProduct(p);
//            int jumlah = Integer.valueOf(JOptionPane.showInputDialog("Jumlah :"));
//            i.setJumlah(jumlah);
//            order.addItem(i);
//
        FindProductDialog dialog = new FindProductDialog(this);
        dialog.setVisible(true);

        });
    }

    private void showTableItems() {
        Object [] colom = {"ID","Name","Category","Price","Jumlah","SubTotal"};
        DefaultTableModel model = new DefaultTableModel(null,colom );
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
