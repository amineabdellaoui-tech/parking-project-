package parking;

public record FlatPlusHourlyTariff(double baseFee,double ratePerHour) implements Tariff {
    @Override
    public double fee(int hours) {
        return baseFee+ratePerHour*hours;
    }
}
