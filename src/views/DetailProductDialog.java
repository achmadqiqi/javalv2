package views;

import entities.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class DetailProductDialog extends JDialog {
    private MainFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idProduct;
    private JTextField nameProduct;
    private JTextField categoryProduct;
    private JTextField priceProduct;
    private JButton uploadButton;
    private JLabel imageProduct;
    private JComboBox cbCategory;
    private ImageIcon imgPd;
    private ImageIcon imagePd;
    private Product product;
    private ImageIcon defaultNoImage;


    public DetailProductDialog(MainFrame mainFrame, Product product) {
        this.parent = mainFrame;
        this.product = product;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocation(parent.getX()+600,parent.getY());
        setSize(450,300);



        buttonOK.addActionListener(e -> {
            parent.getShop().getPm().remove(product);
//            Product product = new Product();
            product.setId(idProduct.getText());
            product.setName(nameProduct.getText());
            product.setCategory(cbCategory.getSelectedItem().toString());
            product.setPrice((Double.parseDouble(priceProduct.getText())));
//            if (imagePd != null){
//                product.setImageIcon(imagePd);
//            } else {
//                imageProduct.setIcon(defaultNoImages);
//                product.setImageIcon(defaultNoImage);
//            }
//            parent.getPmController().registerProduct(product);
//            parent.showMessage("Product "+product.getId()+" telah ditambahkan");
//            dispose();
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

    private void showProduct() {
        idProduct.setText(product.getId());
        nameProduct.setText(product.getName());
        categoryProduct.setText(product.getCategory());
        priceProduct.setText(String.valueOf(product.getPrice()));
        imageProduct.setIcon(product.getImageIcon());

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
