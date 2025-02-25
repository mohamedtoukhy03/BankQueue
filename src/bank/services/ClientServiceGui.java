package bank.services;

import javax.swing.*;
import java.awt.*;

public class ClientServiceGui {
    private final ClientsService clientService;

    public ClientServiceGui(ClientsService clientService) {
        this.clientService = clientService;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Client Service GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a button to request another customer.
        JButton requestButton = new JButton("Request Another Customer");
        requestButton.addActionListener(e -> {
            boolean result = clientService.requestForAnotherCustomer(
                    clientService.getEmployeeNumber(), clientService);
            String message = result ? "Request successful." : "There are no customers right now.";
            JOptionPane.showMessageDialog(frame, message);
        });

        frame.add(requestButton);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        ClientsService clientService = new ClientsService() {};
        SwingUtilities.invokeLater(() -> new ClientServiceGui(clientService));
    }
}
