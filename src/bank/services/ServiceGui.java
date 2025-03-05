package bank.services;

import javax.swing.*;
import java.awt.*;

public abstract class ServiceGui {
    public JFrame frame;
    public ServiceGui(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton requestButton = new JButton("Request Another Customer");
        requestButton.addActionListener(e -> handleRequest());

        frame.add(requestButton);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public abstract void handleRequest();
}
