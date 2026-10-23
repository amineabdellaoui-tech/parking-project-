package parking;

public record HourlyTariff(double ratePerHour) implements Tariff {
    @Override
    public double fee(int hours) {
        return ratePerHour*hours;
    }
}
