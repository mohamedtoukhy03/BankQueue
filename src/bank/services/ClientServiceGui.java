package bank.services;

import javax.swing.*;
import java.awt.*;

public class ClientServiceGui extends ServiceGui{
    private final ClientsService clientService;

    public ClientServiceGui(ClientsService clientService) {
        super("ClientService");
        this.clientService = clientService;
    }

    @Override
    public void handleRequest() {
        boolean result = clientService.requestForAnotherCustomer(clientService.screen);
        String message = result ? "Request successful." : "There are no customers right now.";
        JOptionPane.showMessageDialog(frame, message);
    }

    public static void main(String[] args) {
        ClientsService clientService = new ClientsService();
        SwingUtilities.invokeLater(() -> new ClientServiceGui(clientService));
    }


}
