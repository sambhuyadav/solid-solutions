import java.util.*;


//checkpoint B
public class PricingCalculator {
    public static double subtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }

    public static double tax(String customerType, double subtotal) {
        double taxPct = TaxRules.taxPercent(customerType);
        return subtotal * (taxPct / 100.0);
    }

    public static double discount(String customerType, double subtotal, int numItems) {
        return DiscountRules.discountAmount(customerType, subtotal, numItems);
    }
}