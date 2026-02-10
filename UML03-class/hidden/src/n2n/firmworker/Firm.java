package n2n.firmworker;

import java.util.ArrayList;

public class Firm {
    String vat;
    String name;
    Address address;
    ArrayList<Worker> workers = new ArrayList<>();

    public Firm(String vat, String name, Address address) {
        this.vat = vat;
        this.name = name;
        this.address = address;
    }
}
