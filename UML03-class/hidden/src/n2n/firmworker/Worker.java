package n2n.firmworker;

import java.util.ArrayList;

public class Worker {
    String nr;
    String firstname;
    String lastname;
    String email;
    String phone;
    Address address;
    ArrayList<Firm> firms = new ArrayList<>();

    public Worker(String nr, String firstname, String lastname,
                  String email, String phone, Address address) {
        this.nr = nr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
