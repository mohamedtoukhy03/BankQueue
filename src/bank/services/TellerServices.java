package bank.services;

public class TellerServices extends Services {
    private static final String name = "TellerService";
    private static int tellerServiceEmployees;
    Screen screen;

    public TellerServices(){
        screen = new Screen();
        tellerServiceEmployees++;
        super.setEmployeeNumber(tellerServiceEmployees);
    }


    public String toString(){
        return name;
    }


}
