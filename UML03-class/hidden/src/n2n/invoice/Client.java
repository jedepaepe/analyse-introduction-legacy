package n2n.invoice;

import java.util.ArrayList;

public class Client {
    String nr;  // référence client
    String name;
    String email;
    String phone;
    String addresss;    // simplification: pas de classe Address
    ArrayList<Invoice> invoices = new ArrayList<>();

    public Client(String nr, String name, String email, String phone, String addresss) {
        this.nr = nr;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addresss = addresss;
    }
}
