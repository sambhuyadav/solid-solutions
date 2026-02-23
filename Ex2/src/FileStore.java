import java.util.*;

public class FileStore {
    private final Map<String, String> store = new HashMap<>();
    
    // Checkpoint D
    public void save(Invoice invoice, Map<String, MenuItem> menu) {
        String printable = InvoiceFormatter.format(invoice, menu);
        store.put(invoice.id, printable);
    }

    public int countLines(String invId) {
        String printable = store.get(invId);
        if (printable == null) return 0;
        return printable.split("\n").length;
    }
}
