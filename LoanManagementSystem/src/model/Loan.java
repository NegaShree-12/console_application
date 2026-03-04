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

    public Loan(int loanId, double loanAmount, double interestRate, int tenure,  LoanType loanType) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.tenure = tenure;
        this.remainingBalance = loanAmount;
        this.loanType = loanType;
        this.loanStatus = LoanStatus.PENDING;
        this.payments = new ArrayList<>(); // prevents nullpointerexception
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

    public int reduceTenure()
    {
        return tenure--;
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
        if(this.loanStatus==LoanStatus.APPROVED)
        {
            System.out.println("Loan is not approved");
            return 0.0;
        }
        if (interestRate == 0)
        {
            return loanAmount / tenure;
        }
        double monthlyRate=(interestRate/12)/100;
        double emi=loanAmount*monthlyRate*Math.pow(1+monthlyRate,tenure)/(Math.pow(1+monthlyRate,tenure)-1);
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
}
