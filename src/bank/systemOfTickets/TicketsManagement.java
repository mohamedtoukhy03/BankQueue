package bank.systemOfTickets;

import bank.services.Services;
import java.time.LocalTime;
import java.util.*;

public abstract class TicketsManagement {
    private static PriorityQueue<Pair> customerOut = new PriorityQueue<>();
    private static Queue<Tickets> customerInTeller = new LinkedList<>();
    private static Queue<Tickets> customerInClient = new LinkedList<>();
    private static Map<Character, Integer> availableNumber = new HashMap<>();

    public static String createTickets(char service) {
        int number;
        if (!availableNumber.containsKey(service)) {
            availableNumber.put(service, 1);
            number = 1;
        } else {
            availableNumber.put(service, availableNumber.get(service) + 1);
            number = availableNumber.get(service);
        }
        return service + "_" + number;
    }

    public static Tickets displayTurn(Services service) {
        Tickets ticket = null;
        LocalTime now = LocalTime.now();
        if (!customerOut.isEmpty() && !customerOut.peek().getScheduledTime().isAfter(now) &&
                Objects.requireNonNull(customerOut.peek()).getTicket().toString().charAt(0) == service.toString().charAt(0)) {
                return Objects.requireNonNull(customerOut.poll()).getTicket();
        }
        if (!customerInTeller.isEmpty() && service.toString().charAt(0) == 'T') {
            ticket = Objects.requireNonNull(customerInTeller.poll());
        }
        if (!customerInClient.isEmpty() && service.toString().charAt(0) == 'C') {
            ticket = Objects.requireNonNull(customerInClient.poll());
        }
        return ticket;
    }

    public static Tickets addTickets(char service, LocalTime time) {
        String tempTicket = createTickets(service);
        Tickets ticket = new Tickets(tempTicket);
        customerOut.add(new Pair(ticket, time));
        return ticket;
    }

    public static Tickets addTickets(char service) {
        String tempTicket = createTickets(service);
        Tickets ticket = new Tickets(tempTicket);
        if (service == 'T') {
            customerInTeller.add(ticket);
        } else {
            customerInClient.add(ticket);
        }
        return ticket;
    }

    public static Tickets getCustomerInTicketClient() {
        return customerInClient.isEmpty() ? null : customerInClient.poll();
    }

    public static Tickets getCustomerInTicketTeller() {
        return customerInTeller.isEmpty() ? null : customerInTeller.poll();
    }

    public static Pair getCustomerOutTicket() {
        return customerOut.isEmpty() ? null : customerOut.poll();
    }

    public static int getSizeCustomerOut() {
        return customerOut.size();
    }

    public static int getSizeCustomerInClient() {
        return customerInClient.size();
    }

    public static int getSizeCustomerInTeller() {
        return customerInTeller.size();
    }

    public static void addCustomer(Tickets ticket) {
        if (ticket.toString().charAt(0) == 'T')
            customerInTeller.add(ticket);
        else
            customerInClient.add(ticket);
    }

    public static void addCustomer(Pair value) {
        customerOut.add(value);
    }

    public static class Pair implements Comparable<Pair> {
        private Tickets ticket;
        private LocalTime time;

        public Pair(Tickets ticket, LocalTime time) {
            this.ticket = ticket;
            this.time = time;
        }

        @Override
        public int compareTo(Pair other) {
            return this.time.compareTo(other.time);
        }

        public LocalTime getScheduledTime() {
            return time;
        }

        public Tickets getTicket() {
            return ticket;
        }
    }
}
