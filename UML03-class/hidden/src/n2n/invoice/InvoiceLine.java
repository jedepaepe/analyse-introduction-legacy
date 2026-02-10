package n2n.invoice;

public class InvoiceLine {
    double quantity;
    Invoice invoice;
    Article article;

    public InvoiceLine(double quantity, Invoice invoice, Article article) {
        this.quantity = quantity;
        this.invoice = invoice;
        this.article = article;
    }
}
