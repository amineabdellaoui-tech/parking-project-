package parking;

public interface PaymentMethod {
    String name();

    void pay(double amount);
}
