package bank.services;

public class ClientsService extends Services {
    private static final String name = "ClientService";
    private static int clientServiceEmployees;
    Screen screen;

    public ClientsService(){
        screen = new Screen();
        clientServiceEmployees++;
        super.setEmployeeNumber(clientServiceEmployees);
    }

    public String toString(){
        return name;
    }
}
