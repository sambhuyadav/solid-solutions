public class ExportResult {
    public final boolean success;
    public final int bytes;
    public final String message;

    public ExportResult(boolean success, int bytes, String message) {
        this.success = success;
        this.bytes = bytes;
        this.message = message;
    }

    public static ExportResult ok(int bytes) {
        return new ExportResult(true, bytes, "OK");
    }

    public static ExportResult error(String message) {
        return new ExportResult(false, 0, message);
    }
}
