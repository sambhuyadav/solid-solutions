public interface NotificationSender {
    // Sends a notification. Implementations must not throw exceptions for invalid input; instead, handle gracefully (e.g., log error, skip, etc.).
    // All senders must accept any Notification and process as appropriate for their channel.
    void send(Notification notification);
}
