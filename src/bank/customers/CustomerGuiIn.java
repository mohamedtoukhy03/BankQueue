package bank.customers;

import javax.swing.*;
import java.awt.*;
public class CustomerGuiIn {
    public CustomerGuiIn() {
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Customer GUI In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton tellerButton = new JButton("Teller Service");
        tellerButton.addActionListener(e -> handleService(frame, 'T', "Teller Service"));

        JButton clientButton = new JButton("Client Service");
        clientButton.addActionListener(e -> handleService(frame, 'C', "Client Service"));

        buttonPanel.add(tellerButton);
        buttonPanel.add(clientButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleService(Component parentComponent, char serviceChar, String serviceName) {
        Customers customer = new Customers(serviceChar);
        JOptionPane.showMessageDialog(parentComponent,
                serviceName + " Called with service: " + serviceChar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerGuiIn::new);
    }
}
