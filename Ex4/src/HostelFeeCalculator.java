import java.util.*;

public class HostelFeeCalculator {
    private final RoomPriceCalculator roomPriceCalculator = new RoomPriceCalculator();
    private final AddOnPriceCalculator addOnPriceCalculator = new AddOnPriceCalculator();

    public HostelFeeCalculator() {}

    public BookingResult calculate(BookingRequest req) {
        int roomType = req.roomType();
        List<AddOn> addOns = req.addOns();
        double monthly = roomPriceCalculator.getMonthlyPrice(roomType);
        for (AddOn addOn : addOns) {
            monthly += addOnPriceCalculator.getMonthlyPrice(addOn);
        }
        double deposit = roomPriceCalculator.getDeposit(roomType);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        return new BookingResult(bookingId, req, new Money(monthly), new Money(deposit));
    }
}
