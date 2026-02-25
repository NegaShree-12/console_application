package LoanManagementSystem.src.model;
import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private double amount;
    private PaymentType paymentType;
    private LocalDate paymentDate;
    public Payment(int paymentId, double amount, PaymentType paymentType) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDate = LocalDate.now();
    }

     public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void processPayment(Loan loan)
    {
        loan.addPayment(this);
    }
}
