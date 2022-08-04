package views;

import entities.Product;
import enums.ProductCategory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class RegisterProductDialog extends JDialog {
    private final MainFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputID;
    private JTextField inputName;
    private JTextField inputPrice;
    private JComboBox cbCategory;
    private JLabel imageIcon;
    private JButton uploadButton;
    private JTextField inputCategory;
    private ImageIcon defaultNoImageIcon;
    private ImageIcon imageFile;
    private ImageIcon imageProductFile;

    public RegisterProductDialog(MainFrame parent) {
        this.parent = parent;
        setLocation(parent.getX()+600,parent.getY());
        setSize(400,400);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        //initial
        cbCategory.setModel(new DefaultComboBoxModel<>(ProductCategory.values()));
        cbCategory.getSelectedItem();
        ImageIcon imageFile =new ImageIcon(getClass().getResource("../images/no_images.jpg"));
        Image image = imageFile.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        defaultNoImageIcon = new ImageIcon(image);
        imageIcon.setIcon(defaultNoImageIcon);
        buttonCancel.addActionListener(e -> dispose());
        buttonOK.addActionListener(e -> {
            registerProduct();

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
        uploadButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jpg,*.png,*.jpeg","JPG,PNG,JPEG");
//            chooser.setFileFilter(filter);
            chooser.showOpenDialog(this);
            File file = chooser.getSelectedFile();
            ImageIcon imgIcon = new ImageIcon(file.getAbsolutePath());
            imageProductFile = new ImageIcon(imgIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
            imageIcon.setIcon(imageProductFile);
        });
    }

    private void registerProduct() {
        Product product = new Product();
        product.setId(inputID.getText());
        product.setName(inputName.getText());
        product.setCategory(cbCategory.getSelectedItem().toString());
        product.setPrice(Double.parseDouble(inputPrice.getText()));
        if(imageProductFile!=null){
            product.setImageIcon(imageProductFile);
        }else{
            product.setImageIcon(defaultNoImageIcon);
        }
        parent.getPmController().registerProduct(product);
        dispose();
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
