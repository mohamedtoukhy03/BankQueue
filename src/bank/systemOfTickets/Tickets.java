package bank.systemOfTickets;

import java.util.HashMap;
import java.util.Map;

public class Tickets {
    private String ticket;

    public Tickets(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String toString(){
        return ticket;
    }
}
