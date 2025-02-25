package bank.services;
import bank.systemOfTickets.Tickets;
import bank.systemOfTickets.TicketsManagement;

public class Services {
    private int employeeNumber;
    public boolean requestForAnotherCustomer(int employeeNumber, Services service) {
        Tickets ticket = TicketsManagement.displayTurn(service);
        if (ticket != null) {
                String output = String.format(
                        "------------------------------%n" +
                                "Employee Number: %d%n" +
                                "Service: %s%n" +
                                "Ticket: %s%n" +
                                "------------------------------",
                        employeeNumber, service, ticket
                );
                System.out.println(output);
                return true;
        }
        return false;
    }


    public void setEmployeeNumber(int number){
        employeeNumber = number;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    



}
