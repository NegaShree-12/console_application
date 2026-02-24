package LoanManagementSystem.src.model;

import java.util.List;
import java.util.ArrayList;

public class Customer extends User {
    private String phonenumber; //private bcause customer id only needs phone number
    private int creditScore;
    private List<Loan> loans; //one customer can have multiple loans

    public Customer(int userId, String name, String phonenumber, int creditScore) {
        super(userId, name);
        this.phonenumber = phonenumber;
        this.creditScore = creditScore;
        this.loans = new ArrayList<>(); // prevents nullpointerexception
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void applyLoan(Loan loan)
    {
        loans.add(loan);
    }

    public void viewLoans()
    {
        for(Loan loan:loans)
        {
            Loan.viewSummary(loan);//this will be in Loan class
            
        }
    }
    
    public void payEmi(int loanId,double amount)
    {
        //implemented later
    }

    public void payPrincipal(int loanId,double amount)
    {
        //implemented later
    }
}
