package parking;

public class Main {
    public static void main(String[] args) {
        ParkingService service = new ParkingService(
                new FileReceiptLog("parking.log"), new TextReportFormatter());

        Vehicle car = new Vehicle("12345-A-6", "CAR",new HourlyTariff(5));
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE",new HourlyTariff(2));
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK",new FlatPlusHourlyTariff(20, 10));

        CardPayment card = new CardPayment("4242");
        CashPayment cash = new CashPayment();

        service.checkout(car,3,card);
        service.checkout(bike,2,cash);
        service.checkout(truck,4,card);

        service.refundAtDesk(bike,2);
        service.cancel(truck,4,card);

        System.out.println(service.dailyReport());
    }
}
