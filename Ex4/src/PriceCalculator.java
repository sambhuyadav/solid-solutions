public interface PriceCalculator<T> {
    double getMonthlyPrice(T type);
    double getDeposit(T type);
}