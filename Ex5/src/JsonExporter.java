public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest request) {
        if (request == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        String content = request.getContent();
        if (content == null) {
            return ExportResult.error("ERROR: Null request or content");
        }
        String json = "{\"data\":\"" + content.replace("\"", "\\\"") + "\"}";
        int bytes = 50 + json.length();
        return ExportResult.ok(bytes);
    }
}
