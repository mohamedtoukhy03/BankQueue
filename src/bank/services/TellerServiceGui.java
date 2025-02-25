package bank.services;

import javax.swing.*;
import java.awt.*;

public class TellerServiceGui {

    private final TellerServices tellerService;

    public TellerServiceGui(TellerServices tellerService) {
        this.tellerService = tellerService;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Teller Service GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton requestButton = new JButton("Request Another Customer");
        requestButton.addActionListener(e -> {
            boolean result = tellerService.requestForAnotherCustomer(
                    tellerService.getEmployeeNumber(), tellerService);
            String message = result ? "Request successful." : "There are no customers right now.";
            JOptionPane.showMessageDialog(frame, message);
        });

        frame.add(requestButton);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TellerServices tellerService = new TellerServices() {};

        SwingUtilities.invokeLater(() -> new TellerServiceGui(tellerService));
    }
}
