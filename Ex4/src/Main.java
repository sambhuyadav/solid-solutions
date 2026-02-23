import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator();
        BookingResult result = calc.calculate(req);

        ReceiptPrinter.print(result.request, result.monthly, result.deposit);
        FakeBookingRepo repo = new FakeBookingRepo();
        repo.save(result.bookingId, result.request, result.monthly, result.deposit);
        System.out.println("Saved booking: " + result.bookingId);

        System.out.println();
        System.out.println();
    }
}
