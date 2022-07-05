package views;

import controllers.PMController;
import entities.Product;

import javax.swing.*;
import java.awt.event.*;

public class RegisterProductDialog extends JDialog {
    private MainFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputID;
    private JTextField inputName;
    private JTextField inputPrice;

    public RegisterProductDialog(MainFrame parent) {
        this.parent = parent;
        setLocationRelativeTo(null);
        setSize(400,200);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener(e -> dispose());
        buttonOK.addActionListener(e -> {
            Product p = new Product(inputID.getText(),inputName.getText(),Double.parseDouble(inputPrice.getText()));
            parent.getPmController().registerProduct(p);
            parent.showMessage("Product "+p.getId()+" telah ditambahkan");
            dispose();
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
