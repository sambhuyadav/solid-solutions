

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest request) {
        if (request == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        String content = request.getContent();
        if (content == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        String csv = content.replace(",", ";").replace("\n", " ");
        int bytes = 30 + csv.length();
        return ExportResult.ok(bytes);
    }
}
