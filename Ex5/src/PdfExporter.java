public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest request) {
        if (request == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        String content = request.getContent();
        if (content == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        if (content.length() > 20) {
            return ExportResult.error("ERROR: PDF cannot handle content > 20 chars");
        }
        int bytes = 10 + content.length();
        return ExportResult.ok(bytes);
    }
}
