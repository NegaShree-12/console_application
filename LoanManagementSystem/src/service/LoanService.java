package LoanManagementSystem.src.service;

import LoanManagementSystem.src.model.*;

public class LoanService {

    public void applyLoan(Customer customer, Loan loan) {
        customer.applyLoan(loan);
    }

    public void approveLoan(Admin admin, Customer customer, Loan loan) {
        admin.reviewLoan(loan, customer);
    }

    public void payEmi(Customer customer, int loanId) {
        customer.payEmi(loanId);
    }

    public void payPrincipal(Customer customer, int loanId, double amount) {
        customer.payPrincipal(loanId, amount);
    }

    public void viewLoans(Customer customer) {
        customer.viewLoans();
    }
}