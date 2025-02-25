package bank.customers;

import bank.systemOfTickets.Tickets;
import bank.systemOfTickets.TicketsManagement;

import java.time.LocalTime;

public class Customers {
    private Tickets ticket;


    public Customers(char service, LocalTime time){
        this.ticket = TicketsManagement.addTickets(service, time);
    }

    public Customers(char service){
        this.ticket = TicketsManagement.addTickets(service);

    }

    public Tickets getTicket() {
        return ticket;
    }

}
