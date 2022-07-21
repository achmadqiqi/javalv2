package views;

import entities.Customer;

import javax.swing.*;
import java.awt.event.*;

public class RegisterCustomerDialog extends JDialog {
    private MainFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputID;
    private JTextField inputName;
    private JTextField inputAddress;
    private JTextField inputLongtitude;
    private JTextField inputLatitude;
    private JTextField inputPhone;
    private JTextField inputEmail;

    public RegisterCustomerDialog(MainFrame parent) {
        this.parent = parent;
        setLocation(500,200);
        setSize(400,400);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
//        Product p = new Product(inputID.getText(),inputName.getText(),inputCategory.getText(),Double.parseDouble(inputPrice.getText()));
//        parent.getPmController().registerProduct(p);
//        parent.showMessage("Product "+p.getId()+" telah ditambahkan");
        buttonOK.addActionListener(e -> {
            Customer customer = new Customer(inputID.getText(),inputName.getText(),inputAddress.getText(),
                    inputLongtitude.getText(),inputLatitude.getText(),inputPhone.getText(),inputPhone.getText(),
                    inputEmail.getText());

            parent.getCmController().addCustomer(customer);
            parent.showMessage("Customer "+customer.getName()+" telah diregister");
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
