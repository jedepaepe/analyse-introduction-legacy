package n2n.invoice;

import java.util.Date;

public class DemoInvoice {
    public static void main(String[] args) {
        Client cendrillon = new Client("client-1", "Cendrillon Ayot",
                "cendrillon@ayot.fre", "0033001", "69 rue des Nations, Paris");

        Article grand = new Article("AG-001", "grand",
                "Grand brun escargot pour manger", 100.00, "pièce");
        Article petit = new Article("AP-001", "petit",
                "Petit marinière uniforme bleu", 15.00, "pièce");
        Article facile = new Article("AF-001", "facile",
                "Facile à jouer accordéon", 5.00, "pièce");

        // crée la facture et toutes les associations
        Invoice fr001 = new Invoice("FR-001",
                new Date(2021, 4, 4),
                new Date(2021, 5, 4),
                cendrillon);
        InvoiceLine line1 = new InvoiceLine(1, fr001, grand);
        fr001.invoiceLines.add(line1);
        grand.invoiceLines.add(line1);
        InvoiceLine line2 = new InvoiceLine(2, fr001, petit);
        fr001.invoiceLines.add(line2);
        petit.invoiceLines.add(line2);
        InvoiceLine line3 = new InvoiceLine(3, fr001, facile);
        fr001.invoiceLines.add(line3);
        facile.invoiceLines.add(line3);
        cendrillon.invoices.add(fr001);
        // il est évident que ce code est trop complexe
        // et que nous avons tout intérêt à créer une fonction pour cela
        // => voir le pattern Factory
        // nous devrons aussi utiliser une autre classe que Date (obsolète, mais facile)
    }
}
