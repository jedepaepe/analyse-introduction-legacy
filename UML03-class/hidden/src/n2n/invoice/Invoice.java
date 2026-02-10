package n2n.invoice;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    String nr;  // référence facture
    Date date;
    Date dueDate;
    Client client;
    ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();

    public Invoice(String nr, Date date, Date dueDate, Client client) {
        this.nr = nr;
        this.date = date;
        this.dueDate = dueDate;
        this.client = client;
    }
}
