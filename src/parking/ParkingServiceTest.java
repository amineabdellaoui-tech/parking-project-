package parking;

public class ParkingServiceTest {
    public static void main(String[] args) {
        InMemoryReceiptLog fakeLog=new InMemoryReceiptLog();
        ParkingService s=new ParkingService(fakeLog,new TextReportFormatter());

        Vehicle car = new Vehicle("12345-A-6", "CAR", new HourlyTariff(5));
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE", new HourlyTariff(2));
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK", new FlatPlusHourlyTariff(20, 10));

        check(s.fee(car, 3)==15.0,"car fee");
        check(s.fee(bike, 2)==4.0,"motorbike fee");
        check(s.fee(truck, 4)==60.0,"truck fee");

        s.checkout(car,3,new CashPayment());
        s.checkout(bike,2,new CashPayment());
        s.checkout(truck,4,new CashPayment());

        check(s.dailyReport().endsWith("Total: 79.0 MAD"), "report total");
        check(fakeLog.lines.size() == 3, "3 receipts logged");
        System.out.println("All tests passed");
    }

    private static void check(boolean ok, String message) {
        if (!ok) throw new AssertionError("FAILED: "+message);
    }
}
