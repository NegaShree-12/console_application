package LoanManagementSystem.src;

import java.util.Scanner;

import LoanManagementSystem.src.model.*;
import LoanManagementSystem.src.service.LoanService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LoanService loanService = new LoanService();

        Customer customer = new Customer(1, "Neha", "6382345678", 750);
        Admin admin = new Admin(101, "admin1", "Loan Manager");

        Loan loan = null;

        int choice;

        do {

            System.out.println("\n===== Loan Management System =====");
            System.out.println("1 Apply Loan");
            System.out.println("2 Approve Loan");
            System.out.println("3 Pay EMI");
            System.out.println("4 Pay Principal");
            System.out.println("5 View Loan Summary");
            System.out.println("6 View Payment History");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Loan ID: ");
                    int loanId = scanner.nextInt();

                    System.out.print("Enter Loan Amount: ");
                    double amount = scanner.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double rate = scanner.nextDouble();

                    System.out.print("Enter Tenure (months): ");
                    int tenure = scanner.nextInt();

                    loan = new Loan(loanId, amount, rate, tenure, LoanType.HOME);

                    loanService.applyLoan(customer, loan);

                    break;

                case 2:

                    if (loan != null)
                        loanService.approveLoan(admin, customer, loan);
                    else
                        System.out.println("No loan applied yet.");

                    break;

                case 3:

                    if (loan != null)
                        loanService.payEmi(customer, loan.getLoanId());
                    else
                        System.out.println("No loan available.");

                    break;

                case 4:

                    if (loan != null) {

                        System.out.print("Enter Principal Amount: ");
                        double principal = scanner.nextDouble();

                        loanService.payPrincipal(customer, loan.getLoanId(), principal);
                    } else
                        System.out.println("No loan available.");

                    break;

                case 5:

                    if (loan != null)
                        loan.getLoanSummary();
                    else
                        System.out.println("No loan available.");

                    break;

                case 6:

                    if (loan != null)
                        loan.printPaymentHistory();
                    else
                        System.out.println("No loan available.");

                    break;

                case 7:

                    System.out.println("Exiting system...");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        } while (choice != 7);

        scanner.close();
    }
}