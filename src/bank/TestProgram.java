package bank;

import bank.customers.CustomerGuiIn;
import bank.customers.CustomerGuiOut;
import bank.services.ClientServiceGui;
import bank.services.TellerServiceGui;
import bank.services.ClientsService;
import bank.services.TellerServices;

import javax.swing.*;

public class TestProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomerGuiOut();
            new CustomerGuiIn();
        });

        Timer timer = new Timer(10000, e -> {
            SwingUtilities.invokeLater(() -> {
                TellerServices tellerService = new TellerServices() {};
                ClientsService clientService = new ClientsService() {};
                new TellerServiceGui(tellerService);
                new ClientServiceGui(clientService);
            });
        });
        timer.setRepeats(false);
        timer.start();
    }
}
