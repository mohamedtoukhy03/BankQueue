package bank.services;

public class TellerServices extends Services {
    private static final String name = "TellerService";
    private static int tellerServiceEmployees;

    public TellerServices(){
        tellerServiceEmployees++;
        setEmployeeNumber(tellerServiceEmployees);
    }


    public String toString(){
        return name;
    }


}
