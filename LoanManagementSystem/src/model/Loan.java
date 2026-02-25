package LoanManagementSystem.src.model;
import java.util.List;
import java.util.ArrayList;

public class Loan {
    private int loanId;
    private double loanAmount;
    private double interestRate;
    private int tenure;
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

    public void approve()
    {
        this.loanStatus=LoanStatus.APPROVED;
    }

    public void reject()
    {
        this.loanStatus=LoanStatus.REJECTED;
    }

    public double calculateEMI()
    {
        //implemented later
        return 0.0;
    }
    public void updateBalance(double amount)
    {
        this.remainingBalance-=amount;
        if(remainingBalance<=0)
        {
            remainingBalance=0;
            this.loanStatus=LoanStatus.CLOSED;
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
