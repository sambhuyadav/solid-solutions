public class SmsSender implements NotificationSender {
    private AuditLog auditLog;

    public SmsSender(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    @Override
    public void send(Notification notification) {
        // Only use body, ignore subject
        System.out.println("SMS -> to=" + notification.getTo() + " body=" + notification.getBody());
        auditLog.add("SMS sent to " + notification.getTo());
    }
}
