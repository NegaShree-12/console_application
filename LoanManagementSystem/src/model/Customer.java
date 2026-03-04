package LoanManagementSystem.src.model;

import java.util.List;
import java.util.ArrayList;


public class Customer extends User {
    private String phonenumber; //private bcause customer id only needs phone number
    private int creditScore;
    private List<Loan> loans; //one customer can have multiple loans
    private int paymentCounter=1;

    public Customer(int userId, String name, String phonenumber, int creditScore) {
        super(userId, name);
        if (creditScore < 300 || creditScore > 900) {
        throw new IllegalArgumentException("Invalid credit score");
    }
        this.phonenumber = phonenumber;
        this.creditScore = creditScore;
        this.loans = new ArrayList<>(); // prevents nullpointerexception
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void applyLoan(Loan loan)
    {
        if(loan==null)
        {
            System.out.println("Invalid loan");
            return;
        }
        loans.add(loan);

        System.out.println("Loan applied successfully");
        System.out.println("Loan get Loan Id:"+loan.getLoanId());
        System.out.println("Loan status: "+ loan.getLoanStatus());
        
    }

    public void viewLoans()
    {
        for(Loan loan:loans)
        {
            loan.getLoanSummary();//this will be in Loan class
        }
    }
    
    public int generatepaymentcounter()
    {
        return paymentCounter++;
    }
    
    public void payEmi(int loanId)
{
    for(Loan loan : loans)
    {
        if(loan.getLoanId() == loanId)
        {
            if (loan.getLoanStatus() == LoanStatus.CLOSED)
            {
                System.out.println("Loan already closed. No further payments allowed.");
                return;
            }

            if (loan.getLoanStatus() != LoanStatus.APPROVED)
            {
                System.out.println("Loan is not approved");
                return;
            }

            double emiAmount = loan.calculateEMI();

            if (emiAmount > loan.getremainingBalance())
            {
                System.out.println("Amount exceeds remaining balance.");
                return;
            }

            Payment payment = new Payment(
                    generatepaymentcounter(),
                    emiAmount,
                    PaymentType.EMI
            );

            payment.processPayment(loan);

            System.out.println("EMI paid successfully");
            System.out.println("Remaining Amount: " + loan.getremainingBalance());

            return;
        }
    }

    System.out.println("Loan not found");
}

    public void payPrincipal(int loanId,double amount)
{
    for(Loan loan : loans)
    {
        if(loan.getLoanId() == loanId)
        {
            if (loan.getLoanStatus() == LoanStatus.CLOSED)
            {
                System.out.println("Loan already closed. No further payments allowed.");
                return;
            }

            if (loan.getLoanStatus() != LoanStatus.APPROVED)
            {
                System.out.println("Loan is not approved");
                return;
            }

            if (amount > loan.getremainingBalance())
            {
                System.out.println("Amount exceeds remaining balance.");
                return;
            }

            Payment payment = new Payment(
                    generatepaymentcounter(),
                    amount,
                    PaymentType.PRINCIPAL
            );

            payment.processPayment(loan);

            System.out.println("Principal paid successfully");
            System.out.println("Remaining Amount: " + loan.getremainingBalance());

            return;
        }
    }

    System.out.println("Loan not found");
}
}
