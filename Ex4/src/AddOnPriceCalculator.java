public class AddOnPriceCalculator implements PriceCalculator<AddOn> {
    @Override
    public double getMonthlyPrice(AddOn addOn) {
        return switch (addOn) {
            case MESS, LAUNDRY -> 2000.0;
            case GYM -> 1000.0;
            default -> 0.0;
        };
    }

    @Override
    public double getDeposit(AddOn addOn) {
        // AddOns do not require a deposit
        return 0.0;
    }
}