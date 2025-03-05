package bank.services;

import javax.swing.*;
import java.awt.*;

public class TellerServiceGui extends ServiceGui{
    private final TellerServices tellerService;

    public TellerServiceGui(TellerServices tellerService) {
        super("TellerService");
        this.tellerService = tellerService;
    }

    @Override
    public void handleRequest() {
        boolean result = tellerService.requestForAnotherCustomer(tellerService.screen);
        String message = result ? "Request successful." : "There are no customers right now.";
        JOptionPane.showMessageDialog(frame, message);
    }

    public static void main(String[] args) {
        TellerServices tellerService = new TellerServices() {};

        SwingUtilities.invokeLater(() -> new TellerServiceGui(tellerService));
    }

}
