package LoanManagementSystem.src.model;
import java.util.List;
import java.util.ArrayList;

public class Loan {
    private int loanId;
    private double loanAmount;
    private double interestRate;
    private int tenure; //in months
    private double remainingBalance;
    private LoanType loanType;
    private LoanStatus loanStatus;
    private List<Payment> payments;
    private int originalTenure;

    public Loan(int loanId, double loanAmount, double interestRate, int tenure,  LoanType loanType) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.tenure = tenure;
        this.remainingBalance = loanAmount;
        this.loanType = loanType;
        this.loanStatus = LoanStatus.PENDING;
        this.payments = new ArrayList<>(); // prevents nullpointerexception
        this.originalTenure=tenure;
    }

    public int getLoanId() {
        return loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void reduceTenure()
    {
        if(tenure>0)
        {
            tenure--;
        }
    }

    public void approve()
    {
        this.loanStatus=LoanStatus.APPROVED;
    }

    public void reject()
    {
        this.loanStatus=LoanStatus.REJECTED;
    }

    public double getremainingBalance()
    {
        return remainingBalance;
    }

    public double calculateEMI()
    {
        if (this.loanStatus == LoanStatus.CLOSED)
        {
            System.out.println("Loan already closed. No further payments allowed.");
            return 0.0;
        }
        if(this.loanStatus!=LoanStatus.APPROVED)
        {
            System.out.println("Loan is not approved");
            return 0.0;
        }
        if (interestRate == 0)
        {
            return loanAmount / originalTenure;
        }
        double monthlyRate=(interestRate/12)/100;
        double emi=loanAmount*monthlyRate*Math.pow(1+monthlyRate,originalTenure)/(Math.pow(1+monthlyRate,originalTenure)-1);
        return emi;
    }
    private void updateBalance(double amount) // because other methods can access publicly 
    {
        this.remainingBalance-=amount;
        if(remainingBalance<=0)
        {
            remainingBalance=0;
            this.loanStatus=LoanStatus.CLOSED;
        }
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        updateBalance(payment.getAmount());
        if(payment.getPaymentType()==PaymentType.EMI)
        {
            reduceTenure();
        }
        
    }

    public void getLoanSummary()
    {
        System.out.println("Loan ID: "+loanId);
        System.out.println("Loan Amount: "+loanAmount);
        System.out.println("Interest Rate: "+interestRate);
        System.out.println("Tenure: "+tenure);
        System.out.println("Remaining Balance: "+remainingBalance);
        System.out.println("Loan Type: "+loanType);
        System.out.println("Loan Status: "+loanStatus);
    }

    public void printPaymentHistory() {

    if (payments.isEmpty()) {
        System.out.println("No payments made for this loan.");
        return;
    }

    System.out.println("\nPayment History for Loan " + loanId);
    System.out.println("--------------------------------------------");
    System.out.printf("%-10s %-12s %-10s %-12s\n", "ID", "TYPE", "AMOUNT", "DATE");

    for (Payment payment : payments) {
        System.out.printf(
            "%-10d %-12s %-10.2f %-12s\n",
            payment.getPaymentId(),
            payment.getPaymentType(),
            payment.getAmount(),
            payment.getPaymentDate()
        );
    }
}
}
