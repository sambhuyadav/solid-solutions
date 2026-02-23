public class WhatsAppSender implements NotificationSender {
    private AuditLog auditLog;

    public WhatsAppSender(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    @Override
    public void send(Notification notification) {
        // Accept any phone, but print error if not E.164
        if (notification.getTo() == null || !notification.getTo().startsWith("+")) {
            System.out.println("WA ERROR: phone must start with + and country code");
            auditLog.add("WA ERROR for " + notification.getTo());
            return;
        }
        System.out.println("WA -> to=" + notification.getTo() + " body=" + notification.getBody());
        auditLog.add("WA sent to " + notification.getTo());
    }
}
