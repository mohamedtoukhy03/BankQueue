package bank.services;

import bank.systemOfTickets.Tickets;


public class Screen {
    public void print(int employeeNumber, Services service, Tickets ticket){
        String output = String.format(
                "------------------------------%n" +
                        "Employee Number: %d%n" +
                        "Service: %s%n" +
                        "Ticket: %s%n" +
                        "------------------------------",
                employeeNumber, service, ticket
        );
        System.out.println(output);
    }
}
