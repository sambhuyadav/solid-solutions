public class RoomPriceCalculator implements PriceCalculator<Integer> {
    @Override
    public double getMonthlyPrice(Integer roomType) {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> 20000.0;
            case LegacyRoomTypes.DOUBLE -> 12000.0;
            case LegacyRoomTypes.TRIPLE -> 9000.0;
            case LegacyRoomTypes.DELUXE -> 30000.0;
            default -> 0.0;
        };
    }

    @Override
    public double getDeposit(Integer roomType) {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> 7000.0;
            case LegacyRoomTypes.DOUBLE -> 5000.0;
            case LegacyRoomTypes.TRIPLE -> 4000.0;
            case LegacyRoomTypes.DELUXE -> 10000.0;
            default -> 0.0;
        };
    }
}