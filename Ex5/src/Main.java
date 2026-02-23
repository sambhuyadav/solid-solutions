public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");
        ExportRequest req = new ExportRequest("Alice,90\nBob,85\nCharlie,95");
        Exporter[] exporters = { new PdfExporter(), new CsvExporter(), new JsonExporter() };
        String[] names = { "PDF", "CSV", "JSON" };
        for (int i = 0; i < exporters.length; i++) {
            ExportResult result = exporters[i].export(req);
            if (result.success) {
                System.out.println(names[i] + ": OK bytes=" + result.bytes);
            } else {
                System.out.println(names[i] + ": " + result.message);
            }
        }
    }
}
