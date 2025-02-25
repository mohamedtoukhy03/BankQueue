package bank.services;

public class ClientsService extends Services {
    private static final String name = "ClientService";
    private static int clientServiceEmployees;

    public ClientsService(){
        clientServiceEmployees++;
        setEmployeeNumber(clientServiceEmployees);
    }

    public String toString(){
        return name;
    }
}
