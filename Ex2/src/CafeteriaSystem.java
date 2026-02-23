import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        //Checkpoint B
        double subtotal = PricingCalculator.subtotal(lines, menu);
        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = PricingCalculator.discount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;
        

        //checkpoint C
        Invoice invoice = new Invoice(invId, lines, subtotal, taxPct, tax, discount, total);
        String printable = InvoiceFormatter.format(invoice, menu);
        System.out.print(printable);

        store.save(invoice, menu);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
