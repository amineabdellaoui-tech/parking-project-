package parking;

public interface RefundablePayment extends PaymentMethod {
    void refund(double amount);
}
