package n2n.invoice;

import java.util.ArrayList;

public class Article {
    String nr;  // référence article
    String label;
    String description;
    double price;
    String unit;
    ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();

    public Article(String nr, String label, String description, double price, String unit) {
        this.nr = nr;
        this.label = label;
        this.description = description;
        this.price = price;
        this.unit = unit;
    }
}
