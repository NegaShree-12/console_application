package LoanManagementSystem.src;

import LoanManagementSystem.src.model.Customer;
import LoanManagementSystem.src.model.Loan;
import LoanManagementSystem.src.model.LoanType;
import LoanManagementSystem.src.model.Admin;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Neha", "6382345678", 750);
        Loan loan = new Loan(101, 10000, 5.5, 6, LoanType.HOME);
        customer.applyLoan(loan);
        Admin admin=new Admin(101,"admin1","Loan Manager");
        admin.reviewLoan(loan,customer);
        loan.getLoanSummary();
        customer.payEmi(101);
        loan.getLoanSummary();
        customer.payEmi(101);
        loan.getLoanSummary();
        System.out.println("\nPaying Principal...");
        customer.payPrincipal(101, 3000);
        loan.getLoanSummary();
    }
}
