package bank.customers;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import bank.services.ClientsService;
import bank.services.TellerServices;

public class CustomerGuiOut {
    private final TellerServices tellerService;
    private final ClientsService clientService;

    public CustomerGuiOut() {
        tellerService = new TellerServices() {};
        clientService = new ClientsService() {};
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Customer GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Select Pickup Time:");
        DefaultComboBoxModel<LocalTime> comboBoxModel = new DefaultComboBoxModel<>();

        for (LocalTime time : AvailableTimes.getAvailableTimes()) {
            comboBoxModel.addElement(time);
        }
        JComboBox<LocalTime> comboBox = new JComboBox<>(comboBoxModel);

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof LocalTime) {
                    renderer.setText(((LocalTime) value).format(AvailableTimes.getTimeFormatter()));
                }
                return renderer;
            }
        });

        selectionPanel.add(label);
        selectionPanel.add(comboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton tellerButton = new JButton("Teller Service");
        tellerButton.addActionListener(e -> handleService(frame, comboBox, comboBoxModel, 'T', "Teller Service"));

        JButton clientButton = new JButton("Client Service");
        clientButton.addActionListener(e -> handleService(frame, comboBox, comboBoxModel, 'C', "Client Service"));

        buttonPanel.add(tellerButton);
        buttonPanel.add(clientButton);

        frame.add(selectionPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleService(Component parent, JComboBox<LocalTime> comboBox,
                               DefaultComboBoxModel<LocalTime> model, char serviceChar, String serviceName) {
        LocalTime selectedTime = (LocalTime) comboBox.getSelectedItem();
        if (selectedTime != null) {
            boolean removed = AvailableTimes.removeTime(selectedTime);
            if (removed) {
                Customers customer = new Customers(serviceChar, selectedTime);
                String message = String.format("%s Called at %s%nCustomer created with service: %s",
                        serviceName, selectedTime.format(AvailableTimes.getTimeFormatter()), serviceChar);
                JOptionPane.showMessageDialog(parent, message);
                model.removeElement(selectedTime);
            } else {
                JOptionPane.showMessageDialog(parent, "This time slot is no longer available.",
                        "Booking Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(parent, "Please select a pickup time.",
                    "No Time Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerGuiOut::new);
    }
}
