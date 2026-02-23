public class BookingResult {
    public final String bookingId;
    public final BookingRequest request;
    public final Money monthly;
    public final Money deposit;

    public BookingResult(String bookingId, BookingRequest request, Money monthly, Money deposit) {
        this.bookingId = bookingId;
        this.request = request;
        this.monthly = monthly;
        this.deposit = deposit;
    }
}