public class EmailSender implements NotificationSender {
    private AuditLog auditLog;

    public EmailSender(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    @Override
    public void send(Notification notification) {
        // Truncate body to 50 chars for demo, but do not throw or fail
        String body = notification.getBody();
        if (body.length() > 50) {
            body = body.substring(0, 50);
        }
        System.out.println("EMAIL -> to=" + notification.getTo() + " subject=" + notification.getSubject() + " body=" + body);
        auditLog.add("EMAIL sent to " + notification.getTo());
    }
}
