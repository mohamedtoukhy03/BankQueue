package bank.services;
import bank.systemOfTickets.Tickets;
import bank.systemOfTickets.TicketsManagement;

public class Services {
    private int employeeNumber;

    public boolean requestForAnotherCustomer(Screen screen) {
        Tickets ticket = TicketsManagement.displayTurn(this);
        if (ticket != null) {
                screen.print(employeeNumber, this, ticket);
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
